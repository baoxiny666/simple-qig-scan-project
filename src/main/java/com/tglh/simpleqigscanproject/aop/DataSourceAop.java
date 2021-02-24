package com.tglh.simpleqigscanproject.aop;


import com.tglh.simpleqigscanproject.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.tglh.simpleqigscanproject.annotation.Master) " +
            "&& (execution(* com.tglh.simpleqigscanproject.service..*.select*(..)) " +
            "|| execution(* com.tglh.simpleqigscanproject.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.tglh.simpleqigscanproject.annotation.Master) " +
            "|| execution(* com.tglh.simpleqigscanproject.service..*.insert*(..)) " +
            "|| execution(* com.tglh.simpleqigscanproject.service..*.add*(..)) " +
            "|| execution(* com.tglh.simpleqigscanproject.service..*.update*(..)) " +
            "|| execution(* com.tglh.simpleqigscanproject.service..*.edit*(..)) " +
            "|| execution(* com.tglh.simpleqigscanproject.service..*.delete*(..)) " +
            "|| execution(* com.tglh.simpleqigscanproject.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }

}
