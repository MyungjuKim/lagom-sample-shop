package command;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Optional;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import model.Product;

/**
 * Immutable implementation of {@link ProductCommand.AbstractGetProductReply}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code GetProductReply.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code GetProductReply.of()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "ProductCommand.AbstractGetProductReply"})
@Immutable
public final class GetProductReply implements ProductCommand.AbstractGetProductReply {
  private final @Nullable Product product;

  private GetProductReply(Optional<Product> product) {
    this.product = product.orElse(null);
  }

  private GetProductReply(GetProductReply original, @Nullable Product product) {
    this.product = product;
  }

  /**
   * @return The value of the {@code product} attribute
   */
  @Override
  public Optional<Product> product() {
    return Optional.ofNullable(product);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link ProductCommand.AbstractGetProductReply#product() product} attribute.
   * @param value The value for product
   * @return A modified copy of {@code this} object
   */
  public final GetProductReply withProduct(Product value) {
    @Nullable Product newValue = Preconditions.checkNotNull(value, "product");
    if (this.product == newValue) return this;
    return new GetProductReply(this, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link ProductCommand.AbstractGetProductReply#product() product} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for product
   * @return A modified copy of {@code this} object
   */
  public final GetProductReply withProduct(Optional<Product> optional) {
    @Nullable Product value = optional.orElse(null);
    if (this.product == value) return this;
    return new GetProductReply(this, value);
  }

  /**
   * This instance is equal to all instances of {@code GetProductReply} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof GetProductReply
        && equalTo((GetProductReply) another);
  }

  private boolean equalTo(GetProductReply another) {
    return Objects.equal(product, another.product);
  }

  /**
   * Computes a hash code from attributes: {@code product}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(product);
    return h;
  }

  /**
   * Prints the immutable value {@code GetProductReply} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("GetProductReply")
        .omitNullValues()
        .add("product", product)
        .toString();
  }

  /**
   * Construct a new immutable {@code GetProductReply} instance.
   * @param product The value for the {@code product} attribute
   * @return An immutable GetProductReply instance
   */
  public static GetProductReply of(Optional<Product> product) {
    return new GetProductReply(product);
  }

  /**
   * Creates an immutable copy of a {@link ProductCommand.AbstractGetProductReply} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable GetProductReply instance
   */
  public static GetProductReply copyOf(ProductCommand.AbstractGetProductReply instance) {
    if (instance instanceof GetProductReply) {
      return (GetProductReply) instance;
    }
    return GetProductReply.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link GetProductReply GetProductReply}.
   * @return A new GetProductReply builder
   */
  public static GetProductReply.Builder builder() {
    return new GetProductReply.Builder();
  }

  /**
   * Builds instances of type {@link GetProductReply GetProductReply}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private @Nullable Product product;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AbstractGetProductReply} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ProductCommand.AbstractGetProductReply instance) {
      Preconditions.checkNotNull(instance, "instance");
      Optional<Product> productOptional = instance.product();
      if (productOptional.isPresent()) {
        product(productOptional);
      }
      return this;
    }

    /**
     * Initializes the optional value {@link ProductCommand.AbstractGetProductReply#product() product} to product.
     * @param product The value for product
     * @return {@code this} builder for chained invocation
     */
    public final Builder product(Product product) {
      this.product = Preconditions.checkNotNull(product, "product");
      return this;
    }

    /**
     * Initializes the optional value {@link ProductCommand.AbstractGetProductReply#product() product} to product.
     * @param product The value for product
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder product(Optional<Product> product) {
      this.product = product.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link GetProductReply GetProductReply}.
     * @return An immutable instance of GetProductReply
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public GetProductReply build() {
      return new GetProductReply(null, product);
    }
  }
}
