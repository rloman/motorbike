package nl.qien.motorbike.config;

import nl.qien.motorbike.api.CarEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("jersey")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CarEndpoint.class);
    }
}
