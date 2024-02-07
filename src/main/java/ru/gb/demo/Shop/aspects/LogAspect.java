package ru.gb.demo.Shop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class LogAspect {
    /**
     * Логирование вызова методов
     * @param joinPoint
     * @throws Throwable
     */
    @Around(value = "@annotation(TrackUserAction)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        //Подготовимся
        long start = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();
        //Выведем до
        System.out.println("Вызов метода: "+methodName);
        System.out.println("Передаваемые параметры: "+ Arrays.toString(arguments));
        //Вызовем сам метод
        Object returnedByMethod = joinPoint.proceed();
        //Соберем время выполнения
        long elapsedTime = System.currentTimeMillis() -start;
        //Выведем после
        System.out.println("Полученые данные:"+returnedByMethod);
        System.out.println("Время выполнения:"+elapsedTime+" милисекунд");
        return returnedByMethod;
    }
}
