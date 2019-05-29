package nl.qien.motorbike.beanscope;

import nl.qien.motorbike.model.Motorbike;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScopeDemoIT {

    @Autowired
    private Motorbike jeroen;

    @Autowired
    private ScopeDemo scopeDemo;

    @Test
    // add
    public void testScopeDemoHisJeroenAndLocalJeroenShouldBeTheSame() {

        Assert.assertTrue(this.jeroen == scopeDemo.getJeroen());

    }




}

@Component
class ScopeDemo {
    @Autowired
    private Motorbike jeroen;


    public Motorbike getJeroen() {
        return jeroen;
    }
}