package entity;

import akka.NotUsed;
import com.google.common.collect.Lists;
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;
import command.*;
import event.ProductCreatedEvent;
import event.ProductDeletedEvent;
import event.ProductEvent;
import event.ProductUpdatedEvent;
import model.Product;
import state.ProductState;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by joshua on 2017. 4. 21..
 */
public class ProductEntity extends PersistentEntity<ProductCommand, ProductEvent, ProductState> {

	@Override
	public Behavior initialBehavior(Optional<ProductState> snapshotState) {
		BehaviorBuilder b = newBehaviorBuilder(snapshotState.orElse(ProductState.of(Optional.empty())));

		// query
		b.setReadOnlyCommandHandler(GetProductCommand.class, (cmd, ctx) -> ctx.reply(GetProductReply.of(state().product())));

		// create
		b.setCommandHandler(CreateProductCommand.class, (cmd, ctx) -> {
			Optional<Product> stateProduct = state().product();
			if (stateProduct.isPresent()) {
				ctx.invalidCommand(String.format("product(%d) is already created, failed to create product", stateProduct.get().id()));
				return ctx.done();
			}

			Date now = new Date();
			Product cmdProduct = cmd.product();
			cmdProduct = cmdProduct.withModDate(now);
			cmdProduct = cmdProduct.withRegDate(now);
			List<ProductCreatedEvent> events = Lists.newArrayList(ProductCreatedEvent.of(cmdProduct));
			return ctx.thenPersistAll(events, () -> ctx.reply(CreateProductReply.of(cmd.product().id())));
		});
		b.setEventHandler(ProductCreatedEvent.class, evt -> ProductState.of(Optional.of(evt.product())));

		// update
		b.setCommandHandler(UpdateProductCommand.class, (cmd, ctx) -> {
			if (!state().product().isPresent()) {
				ctx.invalidCommand(String.format("product(%d) is not exist, fail to update product", cmd.product().id()));
				return ctx.done();
			}

			Product cmdProduct = cmd.product();
			Product stateProduct = state().product().get();
			cmdProduct = cmdProduct.withModDate(new Date());
			cmdProduct = cmdProduct.withRegDate(stateProduct.regDate());
			ProductUpdatedEvent event = ProductUpdatedEvent.of(cmdProduct);
			return ctx.thenPersist(event, evt -> ctx.reply(NotUsed.getInstance()));
		});
		b.setEventHandler(ProductUpdatedEvent.class, evt -> ProductState.of(Optional.of(evt.product())));

		// delete
		b.setCommandHandler(DeleteProductCommand.class, (cmd, ctx) -> {
			if (!state().product().isPresent()) {
				ctx.invalidCommand(String.format("product(%d) is not exist, fail to delete product", cmd.id()));
			}

			ProductDeletedEvent event = ProductDeletedEvent.of(cmd.id());
			return ctx.thenPersist(event, evt -> ctx.reply(NotUsed.getInstance()));
		});
		b.setEventHandler(ProductDeletedEvent.class, evt -> ProductState.of(Optional.empty()));

		return b.build();
	}

}
