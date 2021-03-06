package com.lsf.test.mybatis.mapper;

import com.lsf.test.bean.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    int selectCounts();
}