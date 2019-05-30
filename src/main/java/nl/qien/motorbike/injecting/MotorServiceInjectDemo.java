package nl.qien.motorbike.injecting;

import lombok.extern.slf4j.Slf4j;
import nl.qien.motorbike.services.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class MotorServiceInjectDemo {

    @Autowired
    //@Inject (if using Java EE would result in the same result)
    /* read this:
    https://javarevisited.blogspot.com/2017/04/difference-between-autowired-and-inject-annotation-in-spring-framework.html
     */
    private MotorbikeService motorbikeService;

    @PostConstruct
    public void setup() {
        log.error("Starting findall");

        this.motorbikeService.findAll();
        log.error("ending findall");
    }
}
