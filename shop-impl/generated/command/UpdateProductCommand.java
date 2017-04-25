package command;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import model.Product;

/**
 * Immutable implementation of {@link ProductCommand.AbstractUpdateProductCommand}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code UpdateProductCommand.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code UpdateProductCommand.of()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "ProductCommand.AbstractUpdateProductCommand"})
@Immutable
public final class UpdateProductCommand implements ProductCommand.AbstractUpdateProductCommand {
  private final Product product;

  private UpdateProductCommand(Product product) {
    this.product = Preconditions.checkNotNull(product, "product");
  }

  private UpdateProductCommand(UpdateProductCommand original, Product product) {
    this.product = product;
  }

  /**
   * @return The value of the {@code product} attribute
   */
  @Override
  public Product product() {
    return product;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ProductCommand.AbstractUpdateProductCommand#product() product} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for product
   * @return A modified copy of the {@code this} object
   */
  public final UpdateProductCommand withProduct(Product value) {
    if (this.product == value) return this;
    Product newValue = Preconditions.checkNotNull(value, "product");
    return new UpdateProductCommand(this, newValue);
  }

  /**
   * This instance is equal to all instances of {@code UpdateProductCommand} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof UpdateProductCommand
        && equalTo((UpdateProductCommand) another);
  }

  private boolean equalTo(UpdateProductCommand another) {
    return product.equals(another.product);
  }

  /**
   * Computes a hash code from attributes: {@code product}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + product.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code UpdateProductCommand} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("UpdateProductCommand")
        .omitNullValues()
        .add("product", product)
        .toString();
  }

  /**
   * Construct a new immutable {@code UpdateProductCommand} instance.
   * @param product The value for the {@code product} attribute
   * @return An immutable UpdateProductCommand instance
   */
  public static UpdateProductCommand of(Product product) {
    return new UpdateProductCommand(product);
  }

  /**
   * Creates an immutable copy of a {@link ProductCommand.AbstractUpdateProductCommand} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UpdateProductCommand instance
   */
  public static UpdateProductCommand copyOf(ProductCommand.AbstractUpdateProductCommand instance) {
    if (instance instanceof UpdateProductCommand) {
      return (UpdateProductCommand) instance;
    }
    return UpdateProductCommand.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link UpdateProductCommand UpdateProductCommand}.
   * @return A new UpdateProductCommand builder
   */
  public static UpdateProductCommand.Builder builder() {
    return new UpdateProductCommand.Builder();
  }

  /**
   * Builds instances of type {@link UpdateProductCommand UpdateProductCommand}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_PRODUCT = 0x1L;
    private long initBits = 0x1L;

    private @Nullable Product product;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AbstractUpdateProductCommand} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ProductCommand.AbstractUpdateProductCommand instance) {
      Preconditions.checkNotNull(instance, "instance");
      product(instance.product());
      return this;
    }

    /**
     * Initializes the value for the {@link ProductCommand.AbstractUpdateProductCommand#product() product} attribute.
     * @param product The value for product 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder product(Product product) {
      this.product = Preconditions.checkNotNull(product, "product");
      initBits &= ~INIT_BIT_PRODUCT;
      return this;
    }

    /**
     * Builds a new {@link UpdateProductCommand UpdateProductCommand}.
     * @return An immutable instance of UpdateProductCommand
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public UpdateProductCommand build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new UpdateProductCommand(null, product);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_PRODUCT) != 0) attributes.add("product");
      return "Cannot build UpdateProductCommand, some of required attributes are not set " + attributes;
    }
  }
}
