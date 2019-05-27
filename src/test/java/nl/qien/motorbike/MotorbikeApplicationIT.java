package nl.qien.motorbike;

import nl.qien.motorbike.model.Motorbike;
import nl.qien.motorbike.services.MotorbikeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // runs with SpringRunner
@SpringBootTest // indicates this is a Spring Boot (integration) test
@ActiveProfiles("integrationtest") // reads the values of application-integrationtest.properties file AFTER reading the application.properties file!!!
public class MotorbikeApplicationIT {

    @Autowired
    private MotorbikeService service;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSaveAndFindAll() {

        {
            //given (arrange)
            Motorbike b = new Motorbike();
            b.setColor("Red");
            b.setCc(500);
            b.setBrand("Suzuki");


            // when (act)
            Motorbike resultFromService = service.save(b);

            // then (assert)
            Assert.assertEquals(1, resultFromService.getId());

            Assert.assertEquals("Red", resultFromService.getColor());

            Assert.assertEquals(1, this.service.findAll().size());
        }


        {
            //given (arrange)
            Motorbike b = new Motorbike();
            b.setColor("Red");
            b.setCc(500);
            b.setBrand("Suzuki");


            // when (act)
            Motorbike resultFromService = service.save(b);

            // then (assert)
            Assert.assertEquals(2, resultFromService.getId());

            Assert.assertEquals("Red", resultFromService.getColor());

            Assert.assertEquals(2, this.service.findAll().size());
        }





    }

}
