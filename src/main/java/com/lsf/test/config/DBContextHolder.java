package com.lsf.test.config;

import com.lsf.test.utils.DBTypeEnum;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2020/3/11.
 */
public class DBContextHolder {
    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();
    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbType){
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get(){
        return contextHolder.get();
    }

    public static void master(){
        set(DBTypeEnum.MASTER);
        System.out.print("切换到master");
    }

    public static void slave(){
        set(DBTypeEnum.SLAVE);
        System.out.println("切换到slave");
    }

}
