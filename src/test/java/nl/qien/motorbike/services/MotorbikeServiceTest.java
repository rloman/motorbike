package nl.qien.motorbike.services;

import nl.qien.motorbike.model.Motorbike;
import nl.qien.motorbike.persistence.MotorbikeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MotorbikeServiceTest {

    @InjectMocks
    private MotorbikeService motorbikeService ;

    @Mock
    private MotorbikeRepository motorbikeRepository;


    @Test
    public void testSave() {
        Motorbike b = new Motorbike();
        b.setColor("Black");

        // make the mock do what I want
        // given
        Mockito.when(this.motorbikeRepository.save(b)).thenReturn(b);

        // actie
        // when
        Motorbike resultFromSave = this.motorbikeService.save(b);

        // assert
        // then
        Assert.assertEquals(500, resultFromSave.getCC());
        Assert.assertEquals(0, resultFromSave.getId());
        Assert.assertEquals("Black", resultFromSave.getColor());

    }

}
