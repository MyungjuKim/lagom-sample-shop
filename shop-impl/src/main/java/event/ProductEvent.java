package event;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lightbend.lagom.javadsl.immutable.ImmutableStyle;
import com.lightbend.lagom.javadsl.persistence.AggregateEvent;
import com.lightbend.lagom.javadsl.persistence.AggregateEventShards;
import com.lightbend.lagom.javadsl.persistence.AggregateEventTag;
import com.lightbend.lagom.serialization.Jsonable;
import model.Product;
import org.immutables.value.Value;

import java.time.Instant;

/**
 * Created by joshua on 2017. 4. 21..
 */
public interface ProductEvent extends Jsonable, AggregateEvent<ProductEvent> {

	@Override
	default AggregateEventShards<ProductEvent> aggregateTag() {
		return AggregateEventTag.sharded(ProductEvent.class, 1);
	}

	@Value.Immutable
	@ImmutableStyle
	@JsonDeserialize(as = ProductCreatedEvent.class)
	interface AbstractProductCreatedEvent extends ProductEvent {
		@Value.Default
		default Instant timestamp() {
			return Instant.now();
		}

		@Value.Parameter Product product();
	}

	@Value.Immutable
	@ImmutableStyle
	@JsonDeserialize(as = ProductUpdatedEvent.class)
	interface AbstractProductUpdatedEvent extends ProductEvent {
		@Value.Default
		default Instant timestamp() {
			return Instant.now();
		}

		@Value.Parameter Product product();
	}

	@Value.Immutable
	@ImmutableStyle
	@JsonDeserialize(as = ProductDeletedEvent.class)
	interface AbstractProductDeletedEvent extends ProductEvent {
		@Value.Default
		default Instant timestamp() {
			return Instant.now();
		}

		@Value.Parameter long id();
	}

}
