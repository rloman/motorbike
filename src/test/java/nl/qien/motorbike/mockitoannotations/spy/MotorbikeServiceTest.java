package nl.qien.motorbike.mockitoannotations.spy;

import nl.qien.motorbike.model.Motorbike;
import nl.qien.motorbike.persistence.MotorbikeRepository;
import nl.qien.motorbike.services.MotorBikeRepoMock;
import nl.qien.motorbike.services.MotorbikeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MotorbikeServiceTest {

    private MotorbikeService motorbikeService ;

    @Spy // before we used @Mock here but now WE HAVE A REAL INSTANCE!!!
    private MotorbikeRepository motorbikeRepository = new MotorBikeRepoMock();


    @Before
    public void setup() {
        this.motorbikeService = new MotorbikeService(this.motorbikeRepository);
    }

    @Test
    public void testSave() {


        Motorbike b = new Motorbike();
        b.setColor("Black");
        b.setCc(500);

        // actie
        // when
        Motorbike resultFromSave = this.motorbikeService.save(b);

        // assert
        // then
        Assert.assertEquals(500, resultFromSave.getCc());
        Assert.assertEquals(0, resultFromSave.getId());
        Assert.assertEquals("Black", resultFromSave.getColor());

        // check the spy stuff
        Mockito.verify(this.motorbikeRepository).save(b);

    }

}
