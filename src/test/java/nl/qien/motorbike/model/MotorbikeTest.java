package nl.qien.motorbike.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(MockitoJUnitRunner.class)
public class MotorbikeTest {


    @Spy
    private Motorbike motorbike = new Motorbike();


    private static final Logger log = LoggerFactory.getLogger(MotorbikeTest.class);

    @Test
    public void testGetAndSetForBrand() {


        log.info("Entering testGetAndSetForBrand");

        this.motorbike.setBrand("BMW");

        Mockito.verify(this.motorbike).setBrand("BMW");

        Motorbike b = Motorbike.builder().brand("Suzuki").cc(500).color("Red").build();

        Assert.assertEquals("BMW", this.motorbike.getBrand());

        log.info("Leaving testGetAndSetForBrand");

        log.error("Dat ging fout, maar het ging goed :-)");

        log.warn("Pas op, dit is een ernstige fout");

        int a = 4;

        int b1  = 0;

        try {
            System.out.println(a/b1);
        }
        catch(ArithmeticException are) {
            log.error("Unable to divide by zero!");
        }

    }

    @Test
    public void testGetAndSetForType() {
        this.motorbike.setType("730I");

        Assert.assertEquals("730I", this.motorbike.getType());
    }

    @Test
    public void testGetAndSetForcc() {
        this.motorbike.setCc(500);

        Assert.assertEquals(500, this.motorbike.getCc());
    }
}
