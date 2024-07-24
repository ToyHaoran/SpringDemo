package com.atguigu.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointCut {
    @Pointcut("execution(* com.atguigu.controller.StudentController.findAll(..))")
    public void pc(){}
    @Pointcut("execution(* com..impl.*.*(..))")
    public void myPc(){}

}
