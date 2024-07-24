package com.atguigu.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component  // 加入IoC容器
@Aspect  // 声明切面类
public class TxLogAdvice {
    // 环绕增强，自定义目标方法的执行!
    @Around("com.atguigu.pointcut.MyPointCut.pc()")
    public Object transaction(ProceedingJoinPoint joinPoint){
        //保证目标方法被执行即可
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("开启自定义事务");
            result = joinPoint.proceed(args);
            System.out.println("结束自定义事务");
        } catch (Throwable e) {
            System.out.println("自定义事务回滚");
            throw new RuntimeException(e);
        }finally {
            System.out.println("自定义事务结束统计");
        }
        return result;
    }

}
