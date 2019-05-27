package nl.qien.motorbike.model;

import org.junit.Assert;
import org.junit.Test;

public class MotorbikeTest {


    private Motorbike motorbike = new Motorbike();

    @Test
    public void testGetAndSetForBrand() {

        this.motorbike.setBrand("BMW");


        Assert.assertEquals("BMW", this.motorbike.getBrand());

    }

    @Test
    public void testGetAndSetForType() {
        this.motorbike.setType("730I");

        Assert.assertEquals("730I", this.motorbike.getType());
    }

    @Test
    public void testGetAndSetForcc() {
        this.motorbike.setCC(500);

        Assert.assertEquals(500, this.motorbike.getCC());
    }
}
