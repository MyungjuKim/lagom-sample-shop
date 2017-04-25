package service;

import akka.NotUsed;
import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRef;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRegistry;
import com.lightbend.lagom.javadsl.persistence.ReadSide;
import com.lightbend.lagom.javadsl.persistence.cassandra.CassandraSession;
import command.*;
import entity.ProductEntity;
import model.Product;
import processor.ProductReadSideProcessor;

import java.util.Optional;
import java.util.concurrent.CompletionStage;

/**
 * Created by joshua on 2017. 4. 21..
 */
public class ProductServiceImpl implements ProductService {

	private final PersistentEntityRegistry persistentEntityRegistry;

	private final CassandraSession db;

	@Inject
	public ProductServiceImpl(PersistentEntityRegistry persistentEntityRegistry, ReadSide readSide, CassandraSession db) {
		this.persistentEntityRegistry = persistentEntityRegistry;
		this.db = db;
		persistentEntityRegistry.register(ProductEntity.class);
		readSide.register(ProductReadSideProcessor.class);
	}

	private PersistentEntityRef<ProductCommand> entityRef(long id) {
		return persistentEntityRegistry.refFor(ProductEntity.class, String.valueOf(id));
	}

	@Override
	public ServiceCall<NotUsed, Optional<Product>> getProduct(long id) {
		return request -> entityRef(id).
			<GetProductReply, GetProductCommand>ask(GetProductCommand.of(id))
			.thenApply(GetProductReply::product);
	}

	@Override
	public ServiceCall<NotUsed, Optional<Product>> getProductDB(long id) {
		return (req) -> {
			CompletionStage<Optional<Product>> result = db.selectOne("SELECT * FROM products WHERE id = ?", id)
				.thenApply(optRow ->
					optRow.map(row ->
						Product.builder().id(row.getLong("id"))
							.name(row.getString("name"))
							.price(row.getInt("price"))
							.stock(row.getInt("stock"))
							.modDate(row.getTimestamp("modDate"))
							.modId(row.getString("modId"))
							.regDate(row.getTimestamp("regDate"))
							.regId(row.getString("regId"))
							.build()));
			return result;
		};
	}

	@Override
	public ServiceCall<Product, Long> createProduct() {
		return request -> entityRef(request.id())
			.<CreateProductReply, CreateProductCommand>ask(CreateProductCommand.of(request))
			.thenApply(
				reply -> reply.id());
	}

	@Override
	public ServiceCall<Product, NotUsed> updateProduct() {
		return request -> entityRef(request.id())
			.ask(UpdateProductCommand.of(request))
			.thenApply(reply -> NotUsed.getInstance());
	}

	@Override
	public ServiceCall<NotUsed, NotUsed> deleteProduct(long id) {
		return request -> entityRef(id)
			.ask(DeleteProductCommand.of(id))
			.thenApply(reply -> NotUsed.getInstance());
	}

}
