package nl.qien.motorbike;

import nl.qien.motorbike.api.MotorbikeController;
import nl.qien.motorbike.model.Motorbike;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("integrationtest")
public class MotorbikeControllerIT {


    @Autowired
    private MotorbikeController controller;


    @Test
    public void testCreate() {

        ResponseEntity<Iterable<Motorbike>> response = this.controller.list();
        Iterable<Motorbike> lijst = response.getBody();

        int oldSize = 0;
        for(Motorbike element: lijst) {
            oldSize++;
        }

        // Arrange
        Motorbike newOne = new Motorbike();
        newOne.setBrand("Suzuki");


        // Act
        this.controller.create(newOne);


        // Assert
       response = this.controller.list();
        lijst = response.getBody();


        int size = 0;
        for(Motorbike element: lijst) {
            size++;
        }

        Assert.assertEquals(oldSize+1, size);
    }
}
