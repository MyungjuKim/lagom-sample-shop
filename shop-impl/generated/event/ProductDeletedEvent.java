package event;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;
import java.time.Instant;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link ProductEvent.AbstractProductDeletedEvent}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ProductDeletedEvent.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code ProductDeletedEvent.of()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "ProductEvent.AbstractProductDeletedEvent"})
@Immutable
public final class ProductDeletedEvent implements ProductEvent.AbstractProductDeletedEvent {
  private final Instant timestamp;
  private final long id;

  private ProductDeletedEvent(long id) {
    this.id = id;
    this.timestamp = Preconditions.checkNotNull(ProductEvent.AbstractProductDeletedEvent.super.timestamp(), "timestamp");
  }

  private ProductDeletedEvent(ProductDeletedEvent.Builder builder) {
    this.id = builder.id;
    this.timestamp = builder.timestamp != null
        ? builder.timestamp
        : Preconditions.checkNotNull(ProductEvent.AbstractProductDeletedEvent.super.timestamp(), "timestamp");
  }

  private ProductDeletedEvent(Instant timestamp, long id) {
    this.timestamp = timestamp;
    this.id = id;
  }

  /**
   * @return The value of the {@code timestamp} attribute
   */
  @JsonProperty("timestamp")
  @Override
  public Instant timestamp() {
    return timestamp;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @JsonProperty("id")
  @Override
  public long id() {
    return id;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ProductEvent.AbstractProductDeletedEvent#timestamp() timestamp} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for timestamp
   * @return A modified copy of the {@code this} object
   */
  public final ProductDeletedEvent withTimestamp(Instant value) {
    if (this.timestamp == value) return this;
    Instant newValue = Preconditions.checkNotNull(value, "timestamp");
    return new ProductDeletedEvent(newValue, this.id);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ProductEvent.AbstractProductDeletedEvent#id() id} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final ProductDeletedEvent withId(long value) {
    if (this.id == value) return this;
    return new ProductDeletedEvent(this.timestamp, value);
  }

  /**
   * This instance is equal to all instances of {@code ProductDeletedEvent} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ProductDeletedEvent
        && equalTo((ProductDeletedEvent) another);
  }

  private boolean equalTo(ProductDeletedEvent another) {
    return timestamp.equals(another.timestamp)
        && id == another.id;
  }

  /**
   * Computes a hash code from attributes: {@code timestamp}, {@code id}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + timestamp.hashCode();
    h = h * 17 + Longs.hashCode(id);
    return h;
  }

  /**
   * Prints the immutable value {@code ProductDeletedEvent} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ProductDeletedEvent")
        .omitNullValues()
        .add("timestamp", timestamp)
        .add("id", id)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements ProductEvent.AbstractProductDeletedEvent {
    @Nullable Instant timestamp;
    long id;
    boolean idIsSet;
    @JsonProperty("timestamp")
    public void setTimestamp(Instant timestamp) {
      this.timestamp = timestamp;
    }
    @JsonProperty("id")
    public void setId(long id) {
      this.id = id;
      this.idIsSet = true;
    }
    @Override
    public Instant timestamp() { throw new UnsupportedOperationException(); }
    @Override
    public long id() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ProductDeletedEvent fromJson(Json json) {
    ProductDeletedEvent.Builder builder = ProductDeletedEvent.builder();
    if (json.timestamp != null) {
      builder.timestamp(json.timestamp);
    }
    if (json.idIsSet) {
      builder.id(json.id);
    }
    return builder.build();
  }

  /**
   * Construct a new immutable {@code ProductDeletedEvent} instance.
   * @param id The value for the {@code id} attribute
   * @return An immutable ProductDeletedEvent instance
   */
  public static ProductDeletedEvent of(long id) {
    return new ProductDeletedEvent(id);
  }

  /**
   * Creates an immutable copy of a {@link ProductEvent.AbstractProductDeletedEvent} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ProductDeletedEvent instance
   */
  public static ProductDeletedEvent copyOf(ProductEvent.AbstractProductDeletedEvent instance) {
    if (instance instanceof ProductDeletedEvent) {
      return (ProductDeletedEvent) instance;
    }
    return ProductDeletedEvent.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ProductDeletedEvent ProductDeletedEvent}.
   * @return A new ProductDeletedEvent builder
   */
  public static ProductDeletedEvent.Builder builder() {
    return new ProductDeletedEvent.Builder();
  }

  /**
   * Builds instances of type {@link ProductDeletedEvent ProductDeletedEvent}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private long initBits = 0x1L;

    private @Nullable Instant timestamp;
    private long id;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AbstractProductDeletedEvent} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ProductEvent.AbstractProductDeletedEvent instance) {
      Preconditions.checkNotNull(instance, "instance");
      timestamp(instance.timestamp());
      id(instance.id());
      return this;
    }

    /**
     * Initializes the value for the {@link ProductEvent.AbstractProductDeletedEvent#timestamp() timestamp} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link ProductEvent.AbstractProductDeletedEvent#timestamp() timestamp}.</em>
     * @param timestamp The value for timestamp 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder timestamp(Instant timestamp) {
      this.timestamp = Preconditions.checkNotNull(timestamp, "timestamp");
      return this;
    }

    /**
     * Initializes the value for the {@link ProductEvent.AbstractProductDeletedEvent#id() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder id(long id) {
      this.id = id;
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Builds a new {@link ProductDeletedEvent ProductDeletedEvent}.
     * @return An immutable instance of ProductDeletedEvent
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ProductDeletedEvent build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ProductDeletedEvent(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      return "Cannot build ProductDeletedEvent, some of required attributes are not set " + attributes;
    }
  }
}
