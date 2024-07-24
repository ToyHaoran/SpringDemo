package com.haoran.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointCut {
    @Pointcut("execution(* com.haoran.controller.StudentController.findAll(..))")
    public void pc(){}
    @Pointcut("execution(* com..impl.*.*(..))")
    public void myPc(){}

}
