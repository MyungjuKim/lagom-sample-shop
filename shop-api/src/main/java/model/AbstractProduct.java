package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lightbend.lagom.javadsl.immutable.ImmutableStyle;
import org.immutables.value.Value;

import java.util.Date;
import java.util.Optional;

/**
 * Created by joshua on 2017. 4. 21..
 */
@Value.Immutable
@ImmutableStyle
@JsonDeserialize(as = Product.class)
public interface AbstractProduct {

	long id();

	String name();

	int price();

	int stock();

	Optional<Date> modDate();

	String modId();

	Optional<Date> regDate();

	String regId();

}
