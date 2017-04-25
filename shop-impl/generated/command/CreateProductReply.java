package command;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link ProductCommand.AbstractCreateProductCommand.AbstractCreateProductReply}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code CreateProductReply.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code CreateProductReply.of()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "ProductCommand.AbstractCreateProductCommand.AbstractCreateProductReply"})
@Immutable
public final class CreateProductReply
    implements ProductCommand.AbstractCreateProductCommand.AbstractCreateProductReply {
  private final long id;

  private CreateProductReply(long id) {
    this.id = id;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @Override
  public long id() {
    return id;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ProductCommand.AbstractCreateProductCommand.AbstractCreateProductReply#id() id} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final CreateProductReply withId(long value) {
    if (this.id == value) return this;
    return new CreateProductReply(value);
  }

  /**
   * This instance is equal to all instances of {@code CreateProductReply} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof CreateProductReply
        && equalTo((CreateProductReply) another);
  }

  private boolean equalTo(CreateProductReply another) {
    return id == another.id;
  }

  /**
   * Computes a hash code from attributes: {@code id}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Longs.hashCode(id);
    return h;
  }

  /**
   * Prints the immutable value {@code CreateProductReply} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("CreateProductReply")
        .omitNullValues()
        .add("id", id)
        .toString();
  }

  /**
   * Construct a new immutable {@code CreateProductReply} instance.
   * @param id The value for the {@code id} attribute
   * @return An immutable CreateProductReply instance
   */
  public static CreateProductReply of(long id) {
    return new CreateProductReply(id);
  }

  /**
   * Creates an immutable copy of a {@link ProductCommand.AbstractCreateProductCommand.AbstractCreateProductReply} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CreateProductReply instance
   */
  public static CreateProductReply copyOf(ProductCommand.AbstractCreateProductCommand.AbstractCreateProductReply instance) {
    if (instance instanceof CreateProductReply) {
      return (CreateProductReply) instance;
    }
    return CreateProductReply.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link CreateProductReply CreateProductReply}.
   * @return A new CreateProductReply builder
   */
  public static CreateProductReply.Builder builder() {
    return new CreateProductReply.Builder();
  }

  /**
   * Builds instances of type {@link CreateProductReply CreateProductReply}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private long initBits = 0x1L;

    private long id;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AbstractCreateProductReply} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ProductCommand.AbstractCreateProductCommand.AbstractCreateProductReply instance) {
      Preconditions.checkNotNull(instance, "instance");
      id(instance.id());
      return this;
    }

    /**
     * Initializes the value for the {@link ProductCommand.AbstractCreateProductCommand.AbstractCreateProductReply#id() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder id(long id) {
      this.id = id;
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Builds a new {@link CreateProductReply CreateProductReply}.
     * @return An immutable instance of CreateProductReply
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public CreateProductReply build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new CreateProductReply(id);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      return "Cannot build CreateProductReply, some of required attributes are not set " + attributes;
    }
  }
}
