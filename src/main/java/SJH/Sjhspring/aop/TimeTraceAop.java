package SJH.Sjhspring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import  org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
//방법2.컴포넌트 스캔쓰기
@Component
public class TimeTraceAop {

    @Around("execution(* SJH.Sjhspring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{

        long start = System.currentTimeMillis();
        System.out.println("START :" + joinPoint.toString());
        try {
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END :" + joinPoint.toString()+" " + timeMs +
                    "ms");
        }
    }
}
