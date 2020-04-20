package com.lsf.test.service;

import com.lsf.test.bean.Member;

import java.util.List;

/**
 * Created by Administrator on 2020/3/11.
 */
public interface MemberService {
    public int insert(Member record);
    public int save(Member record);
    public Member selectByPrimaryKey(int id);
}
