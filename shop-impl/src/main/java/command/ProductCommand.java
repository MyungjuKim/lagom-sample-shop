package command;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.immutable.ImmutableStyle;
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;
import com.lightbend.lagom.serialization.Jsonable;
import model.Product;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * Created by joshua on 2017. 4. 21..
 */
public interface ProductCommand extends Jsonable {

	@Value.Immutable
	@ImmutableStyle
	interface AbstractGetProductCommand extends ProductCommand, PersistentEntity.ReplyType<GetProductReply> {
		@Value.Parameter long id();
	}

	@Value.Immutable
	@ImmutableStyle
	interface AbstractGetProductReply {
		@Value.Parameter Optional<Product> product();
	}

	@Value.Immutable
	@ImmutableStyle
	interface AbstractCreateProductCommand extends ProductCommand, PersistentEntity.ReplyType<CreateProductReply> {
		@Value.Parameter Product product();

		@Value.Immutable
		@ImmutableStyle interface AbstractCreateProductReply {
			@Value.Parameter long id();
		}
	}

	@Value.Immutable
	@ImmutableStyle
	interface AbstractUpdateProductCommand extends ProductCommand, PersistentEntity.ReplyType<NotUsed> {
		@Value.Parameter Product product();
	}

	@Value.Immutable
	@ImmutableStyle
	interface AbstractDeleteProductCommand extends ProductCommand, PersistentEntity.ReplyType<NotUsed> {
		@Value.Parameter long id();
	}
}
