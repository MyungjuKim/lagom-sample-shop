package service;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;
import model.Product;

import java.util.Optional;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

/**
 * Created by joshua on 2017. 4. 21..
 */
public interface ProductService extends Service {

	ServiceCall<NotUsed, Optional<Product>> getProduct(long id);

	ServiceCall<NotUsed, Optional<Product>> getProductDB(long id);

	ServiceCall<Product, Long> createProduct();

	ServiceCall<Product, NotUsed> updateProduct();

	ServiceCall<NotUsed, NotUsed> deleteProduct(long id);

	@Override
	default Descriptor descriptor() {
		return named("product-services")
			.withCalls(
				restCall(Method.GET, "/shop/product/:id", this::getProduct),
				restCall(Method.GET, "/shop/product/:id/db", this::getProductDB),
				restCall(Method.POST, "/shop/product", this::createProduct),
				restCall(Method.PUT, "/shop/product", this::updateProduct),
				restCall(Method.DELETE, "/shop/product/:id", this::deleteProduct)
			)
			.withAutoAcl(true);
	}
}
