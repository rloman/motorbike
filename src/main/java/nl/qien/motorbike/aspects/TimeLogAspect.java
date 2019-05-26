package nl.qien.motorbike.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimeLogAspect {

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

            log.info("{}.{} took {} ms",
                    proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName(),
                    proceedingJoinPoint.getSignature().getName(),
                    duration);
        }

        return value;
    }
}
