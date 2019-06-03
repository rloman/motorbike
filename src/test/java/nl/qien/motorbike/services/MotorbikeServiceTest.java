package nl.qien.motorbike.services;

import nl.qien.motorbike.model.Motorbike;
import nl.qien.motorbike.persistence.MotorbikeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.repository.CrudRepository;

@RunWith(MockitoJUnitRunner.class)
public class MotorbikeServiceTest {

    @InjectMocks
    private MotorbikeService motorbikeService ;

//    @Spy
    @Mock
    private CrudRepository<Motorbike, Long> motorbikeRepository = new MotorBikeRepoMock();


    @Test
    public void testSave() {
        Motorbike b = new Motorbike();
        b.setColor("Black");
        b.setCc(500);

        // make the mock do what I want
        // given
        Mockito.when(this.motorbikeRepository.save(b)).thenReturn(b);

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
