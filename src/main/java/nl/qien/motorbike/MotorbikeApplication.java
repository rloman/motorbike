package nl.qien.motorbike;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
public class MotorbikeApplication {


	private static final Logger logger = LoggerFactory.getLogger(MotorbikeApplication.class);

	public static void main(String[] args) {

		logger.info("Test zou ik niet moeten zijn want level if fatal");
		SpringApplication.run(MotorbikeApplication.class, args);
	}

}
