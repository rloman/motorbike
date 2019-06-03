package nl.qien.motorbike.config;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;
import nl.qien.motorbike.api.CarEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("jersey")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CarEndpoint.class);

        BeanConfig swaggerConfig = new BeanConfig();
        swaggerConfig.setBasePath("/jersey");

        SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);

        packages(getClass().getPackage().getName(),
                ApiListingResource.class.getPackage().getName());
    }


}
