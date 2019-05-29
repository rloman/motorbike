package nl.qien.motorbike.spy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

//https://stackoverflow.com/questions/15052984/what-is-the-difference-between-mocking-and-spying-when-using-mockito
@RunWith(MockitoJUnitRunner.class)
public class ListSpyDemoTest {

    // a spy is a spy :-) It keeps tracks of the things that happen to it!
    @Spy
    private List list = new ArrayList<>();
    // and yes ... a Spy is also used and usable to Spy on an existing legacy code project

    @Test
    public void testAdd() {
        list.add("One");
        list.add("Two");

        Mockito.verify(this.list).add("One");
        Mockito.verify(this.list).add("Two");

        Assert.assertEquals(2, list.size());

//        Mockito.doReturn(100).when(list).size();

        Mockito.when(this.list.size()).thenReturn(100);
        Assert.assertEquals(100, list.size());
    }
}

/*


Explaination:
The list above is just a regular instance!!!
Why @Spy? Because we have a regular instance and ... we want to verify it and that is the only one reason
 */

/*

Assignment:
Create a Test
Add a Spy instance (e.g. List of HashMap or a Model of your choice (Motorbike)

Test it using the Mockito.verify statement

 */