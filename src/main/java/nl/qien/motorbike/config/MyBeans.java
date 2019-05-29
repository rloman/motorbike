package nl.qien.motorbike.config;

import nl.qien.motorbike.model.Motorbike;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeans {

    @Bean
    public Motorbike jeroen() {
        Motorbike j = new Motorbike();
        j.setOwner("Jeroen");

        return j;
    }

    @Bean
    public Motorbike roy() {
        Motorbike j = new Motorbike();
        j.setOwner("Roy");

        return j;
    }

    @Bean
    public Motorbike jasper() {
        Motorbike j = new Motorbike();
        j.setOwner("Jasper");

        return j;
    }
}
