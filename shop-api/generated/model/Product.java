package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link AbstractProduct}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Product.builder()}.
 */
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AbstractProduct"})
@Immutable
public final class Product implements AbstractProduct {
  private final long id;
  private final String name;
  private final int price;
  private final int stock;
  private final @Nullable Date modDate;
  private final String modId;
  private final @Nullable Date regDate;
  private final String regId;

  private Product(
      long id,
      String name,
      int price,
      int stock,
      @Nullable Date modDate,
      String modId,
      @Nullable Date regDate,
      String regId) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.stock = stock;
    this.modDate = modDate;
    this.modId = modId;
    this.regDate = regDate;
    this.regId = regId;
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
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public String name() {
    return name;
  }

  /**
   * @return The value of the {@code price} attribute
   */
  @JsonProperty("price")
  @Override
  public int price() {
    return price;
  }

  /**
   * @return The value of the {@code stock} attribute
   */
  @JsonProperty("stock")
  @Override
  public int stock() {
    return stock;
  }

  /**
   * @return The value of the {@code modDate} attribute
   */
  @JsonProperty("modDate")
  @Override
  public Optional<Date> modDate() {
    return Optional.ofNullable(modDate);
  }

  /**
   * @return The value of the {@code modId} attribute
   */
  @JsonProperty("modId")
  @Override
  public String modId() {
    return modId;
  }

  /**
   * @return The value of the {@code regDate} attribute
   */
  @JsonProperty("regDate")
  @Override
  public Optional<Date> regDate() {
    return Optional.ofNullable(regDate);
  }

  /**
   * @return The value of the {@code regId} attribute
   */
  @JsonProperty("regId")
  @Override
  public String regId() {
    return regId;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractProduct#id() id} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final Product withId(long value) {
    if (this.id == value) return this;
    return new Product(value, this.name, this.price, this.stock, this.modDate, this.modId, this.regDate, this.regId);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractProduct#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final Product withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "name");
    return new Product(this.id, newValue, this.price, this.stock, this.modDate, this.modId, this.regDate, this.regId);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractProduct#price() price} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for price
   * @return A modified copy of the {@code this} object
   */
  public final Product withPrice(int value) {
    if (this.price == value) return this;
    return new Product(this.id, this.name, value, this.stock, this.modDate, this.modId, this.regDate, this.regId);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractProduct#stock() stock} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for stock
   * @return A modified copy of the {@code this} object
   */
  public final Product withStock(int value) {
    if (this.stock == value) return this;
    return new Product(this.id, this.name, this.price, value, this.modDate, this.modId, this.regDate, this.regId);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link AbstractProduct#modDate() modDate} attribute.
   * @param value The value for modDate
   * @return A modified copy of {@code this} object
   */
  public final Product withModDate(Date value) {
    @Nullable Date newValue = Preconditions.checkNotNull(value, "modDate");
    if (this.modDate == newValue) return this;
    return new Product(this.id, this.name, this.price, this.stock, newValue, this.modId, this.regDate, this.regId);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link AbstractProduct#modDate() modDate} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for modDate
   * @return A modified copy of {@code this} object
   */
  public final Product withModDate(Optional<Date> optional) {
    @Nullable Date value = optional.orElse(null);
    if (this.modDate == value) return this;
    return new Product(this.id, this.name, this.price, this.stock, value, this.modId, this.regDate, this.regId);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractProduct#modId() modId} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for modId
   * @return A modified copy of the {@code this} object
   */
  public final Product withModId(String value) {
    if (this.modId.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "modId");
    return new Product(this.id, this.name, this.price, this.stock, this.modDate, newValue, this.regDate, this.regId);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link AbstractProduct#regDate() regDate} attribute.
   * @param value The value for regDate
   * @return A modified copy of {@code this} object
   */
  public final Product withRegDate(Date value) {
    @Nullable Date newValue = Preconditions.checkNotNull(value, "regDate");
    if (this.regDate == newValue) return this;
    return new Product(this.id, this.name, this.price, this.stock, this.modDate, this.modId, newValue, this.regId);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link AbstractProduct#regDate() regDate} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for regDate
   * @return A modified copy of {@code this} object
   */
  public final Product withRegDate(Optional<Date> optional) {
    @Nullable Date value = optional.orElse(null);
    if (this.regDate == value) return this;
    return new Product(this.id, this.name, this.price, this.stock, this.modDate, this.modId, value, this.regId);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractProduct#regId() regId} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for regId
   * @return A modified copy of the {@code this} object
   */
  public final Product withRegId(String value) {
    if (this.regId.equals(value)) return this;
    String newValue = Preconditions.checkNotNull(value, "regId");
    return new Product(this.id, this.name, this.price, this.stock, this.modDate, this.modId, this.regDate, newValue);
  }

  /**
   * This instance is equal to all instances of {@code Product} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof Product
        && equalTo((Product) another);
  }

  private boolean equalTo(Product another) {
    return id == another.id
        && name.equals(another.name)
        && price == another.price
        && stock == another.stock
        && Objects.equal(modDate, another.modDate)
        && modId.equals(another.modId)
        && Objects.equal(regDate, another.regDate)
        && regId.equals(another.regId);
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code name}, {@code price}, {@code stock}, {@code modDate}, {@code modId}, {@code regDate}, {@code regId}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Longs.hashCode(id);
    h = h * 17 + name.hashCode();
    h = h * 17 + price;
    h = h * 17 + stock;
    h = h * 17 + Objects.hashCode(modDate);
    h = h * 17 + modId.hashCode();
    h = h * 17 + Objects.hashCode(regDate);
    h = h * 17 + regId.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Product} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Product")
        .omitNullValues()
        .add("id", id)
        .add("name", name)
        .add("price", price)
        .add("stock", stock)
        .add("modDate", modDate)
        .add("modId", modId)
        .add("regDate", regDate)
        .add("regId", regId)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements AbstractProduct {
    long id;
    boolean idIsSet;
    @Nullable String name;
    int price;
    boolean priceIsSet;
    int stock;
    boolean stockIsSet;
    Optional<Date> modDate = Optional.empty();
    @Nullable String modId;
    Optional<Date> regDate = Optional.empty();
    @Nullable String regId;
    @JsonProperty("id")
    public void setId(long id) {
      this.id = id;
      this.idIsSet = true;
    }
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("price")
    public void setPrice(int price) {
      this.price = price;
      this.priceIsSet = true;
    }
    @JsonProperty("stock")
    public void setStock(int stock) {
      this.stock = stock;
      this.stockIsSet = true;
    }
    @JsonProperty("modDate")
    public void setModDate(Optional<Date> modDate) {
      this.modDate = modDate;
    }
    @JsonProperty("modId")
    public void setModId(String modId) {
      this.modId = modId;
    }
    @JsonProperty("regDate")
    public void setRegDate(Optional<Date> regDate) {
      this.regDate = regDate;
    }
    @JsonProperty("regId")
    public void setRegId(String regId) {
      this.regId = regId;
    }
    @Override
    public long id() { throw new UnsupportedOperationException(); }
    @Override
    public String name() { throw new UnsupportedOperationException(); }
    @Override
    public int price() { throw new UnsupportedOperationException(); }
    @Override
    public int stock() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<Date> modDate() { throw new UnsupportedOperationException(); }
    @Override
    public String modId() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<Date> regDate() { throw new UnsupportedOperationException(); }
    @Override
    public String regId() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static Product fromJson(Json json) {
    Product.Builder builder = Product.builder();
    if (json.idIsSet) {
      builder.id(json.id);
    }
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.priceIsSet) {
      builder.price(json.price);
    }
    if (json.stockIsSet) {
      builder.stock(json.stock);
    }
    if (json.modDate != null) {
      builder.modDate(json.modDate);
    }
    if (json.modId != null) {
      builder.modId(json.modId);
    }
    if (json.regDate != null) {
      builder.regDate(json.regDate);
    }
    if (json.regId != null) {
      builder.regId(json.regId);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link AbstractProduct} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Product instance
   */
  public static Product copyOf(AbstractProduct instance) {
    if (instance instanceof Product) {
      return (Product) instance;
    }
    return Product.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link Product Product}.
   * @return A new Product builder
   */
  public static Product.Builder builder() {
    return new Product.Builder();
  }

  /**
   * Builds instances of type {@link Product Product}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private static final long INIT_BIT_PRICE = 0x4L;
    private static final long INIT_BIT_STOCK = 0x8L;
    private static final long INIT_BIT_MOD_ID = 0x10L;
    private static final long INIT_BIT_REG_ID = 0x20L;
    private long initBits = 0x3fL;

    private long id;
    private @Nullable String name;
    private int price;
    private int stock;
    private @Nullable Date modDate;
    private @Nullable String modId;
    private @Nullable Date regDate;
    private @Nullable String regId;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AbstractProduct} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AbstractProduct instance) {
      Preconditions.checkNotNull(instance, "instance");
      id(instance.id());
      name(instance.name());
      price(instance.price());
      stock(instance.stock());
      Optional<Date> modDateOptional = instance.modDate();
      if (modDateOptional.isPresent()) {
        modDate(modDateOptional);
      }
      modId(instance.modId());
      Optional<Date> regDateOptional = instance.regDate();
      if (regDateOptional.isPresent()) {
        regDate(regDateOptional);
      }
      regId(instance.regId());
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractProduct#id() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder id(long id) {
      this.id = id;
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractProduct#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder name(String name) {
      this.name = Preconditions.checkNotNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractProduct#price() price} attribute.
     * @param price The value for price 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder price(int price) {
      this.price = price;
      initBits &= ~INIT_BIT_PRICE;
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractProduct#stock() stock} attribute.
     * @param stock The value for stock 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder stock(int stock) {
      this.stock = stock;
      initBits &= ~INIT_BIT_STOCK;
      return this;
    }

    /**
     * Initializes the optional value {@link AbstractProduct#modDate() modDate} to modDate.
     * @param modDate The value for modDate
     * @return {@code this} builder for chained invocation
     */
    public final Builder modDate(Date modDate) {
      this.modDate = Preconditions.checkNotNull(modDate, "modDate");
      return this;
    }

    /**
     * Initializes the optional value {@link AbstractProduct#modDate() modDate} to modDate.
     * @param modDate The value for modDate
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder modDate(Optional<Date> modDate) {
      this.modDate = modDate.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractProduct#modId() modId} attribute.
     * @param modId The value for modId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder modId(String modId) {
      this.modId = Preconditions.checkNotNull(modId, "modId");
      initBits &= ~INIT_BIT_MOD_ID;
      return this;
    }

    /**
     * Initializes the optional value {@link AbstractProduct#regDate() regDate} to regDate.
     * @param regDate The value for regDate
     * @return {@code this} builder for chained invocation
     */
    public final Builder regDate(Date regDate) {
      this.regDate = Preconditions.checkNotNull(regDate, "regDate");
      return this;
    }

    /**
     * Initializes the optional value {@link AbstractProduct#regDate() regDate} to regDate.
     * @param regDate The value for regDate
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder regDate(Optional<Date> regDate) {
      this.regDate = regDate.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractProduct#regId() regId} attribute.
     * @param regId The value for regId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder regId(String regId) {
      this.regId = Preconditions.checkNotNull(regId, "regId");
      initBits &= ~INIT_BIT_REG_ID;
      return this;
    }

    /**
     * Builds a new {@link Product Product}.
     * @return An immutable instance of Product
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Product build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new Product(id, name, price, stock, modDate, modId, regDate, regId);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_PRICE) != 0) attributes.add("price");
      if ((initBits & INIT_BIT_STOCK) != 0) attributes.add("stock");
      if ((initBits & INIT_BIT_MOD_ID) != 0) attributes.add("modId");
      if ((initBits & INIT_BIT_REG_ID) != 0) attributes.add("regId");
      return "Cannot build Product, some of required attributes are not set " + attributes;
    }
  }
}
