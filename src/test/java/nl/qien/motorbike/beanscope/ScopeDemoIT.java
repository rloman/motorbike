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
// mandatory read: https://www.tutorialspoint.com/spring/spring_bean_scopes.htm
public class ScopeDemoIT {

    @Autowired
    private Motorbike jeroen;

    @Autowired
    private Motorbike marjolijn;

    @Autowired
    private ScopeDemo scopeDemo;

    @Test
    public void testScopeDemoHisJeroenAndLocalJeroenShouldBeTheSame() {

        Assert.assertTrue(this.jeroen == scopeDemo.getJeroen());

    }

    // add now @Scope("prototype") to MyBeans::jeroen and it should fail // see MyBeans::marjolijn
    @Test
    public void testScopeDemoHisMarjolijnAndLocalMarjolijnShouldBeDifferentInstance() {

        Assert.assertTrue(this.marjolijn != scopeDemo.getMarjolijn());

    }
}

@Component
class ScopeDemo {

    @Autowired
    private Motorbike jeroen;

    @Autowired
    private Motorbike marjolijn;


    public Motorbike getJeroen() {
        return jeroen;
    }

    public Motorbike getMarjolijn() {
        return marjolijn;
    }
}