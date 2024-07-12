package com.aspectannotation.aop;

import com.aspectannotation.util.ReadWriteUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReadWriteAspect {

    @After("@annotation(Write)")
    public void write(JoinPoint joinPoint) {
        var objectToWrite = joinPoint.getArgs()[0];
        ReadWriteUtil.write(objectToWrite);
    }

    @After("@annotation(Read)")
    public void read(JoinPoint joinPoint) {
        var indexKey = joinPoint.getArgs()[0];
        ReadWriteUtil.read(indexKey);
    }

    @Pointcut("@annotation(Write)")
    public void write2() {
    }

    @After("write2()")
    public void write2UsingPointcut(JoinPoint joinPoint) {
        var objectToWrite = joinPoint.getArgs()[0];
        ReadWriteUtil.write(objectToWrite);
    }

    @Pointcut("@annotation(Read)")
    public void read2() {
    }

    @After("read2()")
    public void read2UsingPointcut(JoinPoint joinPoint) {
        var indexKey = joinPoint.getArgs()[0];
        ReadWriteUtil.read(indexKey);
    }
}
