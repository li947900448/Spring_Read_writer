package com.lsf.test.handler;

import com.lsf.test.config.DBContextHolder;
import com.lsf.test.utils.DBTypeEnum;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2020/3/11.
 */

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.lsf.test.handler.Master)" +
        "&& (execution(* com.lsf.test.service..*.select*(..)) "+
        "|| execution(* com.lsf.test.service..*.get*(..)))"
     )
    public void readPointcut(){

    }

    @Pointcut("@annotation(com.lsf.test.handler.Master) " +
            "|| execution(* com.lsf.test.service..*.insert*(..)) " +
            "|| execution(* com.lsf.test.service..*.add*(..)) " +
            "|| execution(* com.lsf.test.service..*.update*(..)) " +
            "|| execution(* com.lsf.test.service..*.edit*(..)) " +
            "|| execution(* com.lsf.test.service..*.delete*(..)) " +
            "|| execution(* com.lsf.test.service..*.remove*(..))")
    public void writerPointcut(){

    }

    @Before("readPointcut()")
    public void read(){
        DBContextHolder.slave();
    }

    @Before("writerPointcut()")
    public void writer(){
        DBContextHolder.master();
    }

}
