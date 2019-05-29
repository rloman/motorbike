package nl.qien.motorbike.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


// Credits NLJUG, from url: https://nljug.org/java-magazine/aspect-oriented-programming-met-spring-boot

//@Slf4j => can also be used to have the log statement below running (as the code example shows)


@Aspect
@Component
public class TimeLogAspect {


    private Logger logger = LoggerFactory.getLogger(TimeLogAspect.class);

    @Around("@annotation(nl.qien.motorbike.aop.Timed) && execution(public * *(..))")
    public Object time(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Object value;

        try {

            // please proceed with the REAL code
            value = proceedingJoinPoint.proceed();

        } catch (Throwable throwable) {

            throw throwable;

        } finally {

            // when done ...
            long duration = System.currentTimeMillis() - start;

            logger.info("{}.{} took {} ms",
                    proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName(),
                    proceedingJoinPoint.getSignature().getName(),
                    duration);
        }

        return value;
    }
}
