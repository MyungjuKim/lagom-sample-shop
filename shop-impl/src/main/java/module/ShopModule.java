package module;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import play.Configuration;
import play.Environment;
import service.ProductService;
import service.ProductServiceImpl;

/**
 * Created by joshua on 2017. 4. 21..
 */
public class ShopModule extends AbstractModule implements ServiceGuiceSupport {
	private final Environment environment;
	private final Configuration configuration;

	public ShopModule(Environment environment, Configuration configuration) {
		this.environment = environment;
		this.configuration = configuration;
	}

	@Override
	protected void configure() {
		bindServices(
			serviceBinding(ProductService.class, ProductServiceImpl.class)
		);
	}
}