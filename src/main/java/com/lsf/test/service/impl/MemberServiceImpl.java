package com.lsf.test.service.impl;

import com.lsf.test.bean.Member;
import com.lsf.test.handler.Master;
import com.lsf.test.mybatis.mapper.MemberMapper;
import com.lsf.test.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2020/3/11.
 */
@Service
public class MemberServiceImpl implements MemberService {


    @Autowired
    private MemberMapper memberMapper;

   // @Transactional
    @Override
    public int insert(Member record) {
        try{
            record.setId(memberMapper.selectCounts()+1);
        }catch (Exception e){
            e.printStackTrace();
        }

        record.setName(record.getName() + memberMapper.selectCounts()+1);
        return memberMapper.insert(record);
    }

    @Master
    @Override
    public int save(Member record) {
        return memberMapper.insert(record);
    }

    @Master
    @Override
    public Member selectByPrimaryKey(int id) {
        return memberMapper.selectByPrimaryKey(id);
    }
}
