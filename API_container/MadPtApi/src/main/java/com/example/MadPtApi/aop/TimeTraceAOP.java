package com.example.MadPtApi.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component //이것도 가능함 but 스프링 빈에 직접 등록하는걸 선호함
public class TimeTraceAOP {

    @Around("execution(* com.example..*(..))") // 타겟 지정
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable { //예외는 다 던짐
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString()); // 메소드 이름을 받아올 수 있다
        try {
            return joinPoint.proceed(); // 다음 메소드로 진행
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }
    }
}
