package processor;

import akka.Done;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.persistence.AggregateEventTag;
import com.lightbend.lagom.javadsl.persistence.ReadSideProcessor;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraReadSide;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import event.ProductCreatedEvent;
import event.ProductDeletedEvent;
import event.ProductEvent;
import event.ProductUpdatedEvent;
import model.Product;
import org.pcollections.PSequence;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created by joshua on 2017. 4. 21..
 */
public class ProductReadSideProcessor extends ReadSideProcessor<ProductEvent> {

	private final CassandraSession session;
	private final CassandraReadSide readSide;

	private Cluster cluster;

	private PreparedStatement pstmtCreate = null;
	private PreparedStatement pstmtUpdate = null;
	private PreparedStatement pstmtDelete = null;

	@Inject
	public ProductReadSideProcessor(CassandraSession session, CassandraReadSide readSide) {
		this.session = session;
		this.readSide = readSide;
	}

	@Override
	public ReadSideHandler buildHandler() {
		CassandraReadSide.ReadSideHandlerBuilder<ProductEvent> builder =
			readSide.builder(ProductReadSideProcessor.class.getName());
		builder.setGlobalPrepare(this::createTable);
		builder.setPrepare(a -> prepareCluster()
			.thenCompose(b -> prepareStatementCreate()
				.thenCompose(c -> prepareStatementUpdate()
					.thenCompose(d -> prepareStatementDelete()))));

		builder.<ProductCreatedEvent>setEventHandler(ProductCreatedEvent.class, this::createProduct);
		builder.<ProductUpdatedEvent>setEventHandler(ProductUpdatedEvent.class, this::updateProduct);
		builder.<ProductDeletedEvent>setEventHandler(ProductDeletedEvent.class, this::deleteProduct);
		return builder.build();
	}

	@Override public PSequence<AggregateEventTag<ProductEvent>> aggregateTags() {
		
		return AggregateEventTag.sharded(ProductEvent.class, 1).allTags();
	}

	private CompletionStage<Done> createTable() {
		return session.executeCreateTable(
			"CREATE TABLE products (" +
				"id bigint, " +
				"name text, " +
				"price int, " +
				"stock int, " +
				"modId TEXT, " +
				"modDate TIMESTAMP, " +
				"regId TEXT, " +
				"regDate TIMESTAMP, " +
				"primary key((id)) " +
				")"
		);
	}

	private CompletionStage<Done> prepareStatementCreate() {
		return session.prepare(
			"INSERT INTO products(id, name, price, stock, " +
				"modId, modDate, regId, regDate) " +
				"VALUES(?, ?, ?, ?, ?, ?, ?, ?)")
			.thenApply(ps -> {
				this.pstmtCreate = ps;
				return Done.getInstance();
			});
	}

	private CompletionStage<Done> prepareStatementUpdate() {
		return session.prepare(
			"UPDATE products set name=?, price=?, stock=?, " +
				"modId=?, modDate=? " +
				"WHERE id=?")
			.thenApply(ps -> {
				this.pstmtUpdate = ps;
				return Done.getInstance();
			});
	}

	private CompletionStage<Done> prepareStatementDelete() {
		return session.prepare(
			"DELETE FROM products WHERE id=?")
			.thenApply(ps -> {
				this.pstmtDelete = ps;
				return Done.getInstance();
			});
	}

	private CompletionStage<Done> prepareCluster() {
		return session.underlying().thenApply(s -> {
			cluster = s.getCluster();
			return Done.getInstance();
		});
	}

	private CompletionStage<List<BoundStatement>> createProduct(ProductCreatedEvent event) {
		Product product = event.product();
		BoundStatement bstmt = pstmtCreate.bind();
		int index = 0;
		bstmt.setLong(index++, product.id());
		bstmt.setString(index++, product.name());
		bstmt.setInt(index++, product.price());
		bstmt.setInt(index++, product.stock());
		bstmt.setString(index++, product.modId());
		bstmt.setTimestamp(index++, product.modDate().get());
		bstmt.setString(index++, product.regId());
		bstmt.setTimestamp(index++, product.regDate().get());
		System.err.println(String.format("ProductReadSideProcessor.createProduct(%s)", event.product().toString()));
		return CompletableFuture.completedFuture(Arrays.asList(bstmt));
	}

	private CompletionStage<List<BoundStatement>> updateProduct(ProductUpdatedEvent event) {
		Product product = event.product();
		BoundStatement bstmt = pstmtUpdate.bind();
		int index = 0;
		bstmt.setString(index++, product.name());
		bstmt.setInt(index++, product.price());
		bstmt.setInt(index++, product.stock());
		bstmt.setString(index++, product.modId());
		bstmt.setTimestamp(index++, product.modDate().get());
		bstmt.setLong(index++, product.id());
		System.err.println(String.format("ProductReadSideProcessor.updateProduct(%s)", event.product().toString()));
		return CompletableFuture.completedFuture(Arrays.asList(bstmt));
	}

	private CompletionStage<List<BoundStatement>> deleteProduct(ProductDeletedEvent event) {
		long id = event.id();
		BoundStatement bstmt = pstmtDelete.bind();
		int index = 0;
		bstmt.setLong(index++, id);
		System.err.println(String.format("ProductReadSideProcessor.deleteProduct(%d)", event.id()));
		return CompletableFuture.completedFuture(Arrays.asList(bstmt));
	}

}
