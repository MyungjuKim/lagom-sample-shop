package state;

import com.lightbend.lagom.javadsl.immutable.ImmutableStyle;
import com.lightbend.lagom.serialization.Jsonable;
import model.Product;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * Created by joshua on 2017. 4. 21..
 */
@Value.Immutable
@ImmutableStyle
public interface AbstractProductState extends Jsonable {
	@Value.Parameter Optional<Product> product();
}