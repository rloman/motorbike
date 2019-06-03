package nl.qien.motorbike.mockitoannotations.captor;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CaptorGarageDemoTest {

    @InjectMocks
    private Garage garage;

    @Mock
    List mockedList;

    @Captor
    ArgumentCaptor argCaptor;

    @Test
    public void whenUseCaptorAnnotation_thenTheSame() {
        garage.add("one");
        Mockito.verify(mockedList).add(argCaptor.capture());

        Assert.assertEquals("one", argCaptor.getValue());
    }
}


/*
Explaination
- we use the @Captor to *capture* the arguments we pass in to the Mock we are using

- Be aware that we are now testing the Garage and MOCKING the list
 */