package com.lsf.test.controller;

import com.lsf.test.bean.Member;
import com.lsf.test.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2020/3/13.
 */
@RestController
@RequestMapping("/member")
public class TestAction {


    @Autowired
    private MemberService memberService;

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, String name) {

        return "hello";
    }

    @RequestMapping("/insert")
    public String insertMember(HttpServletRequest request, String name) {
        Member member = new Member();
        member.setName("lishfe");
        member.setAge("28");
        member.setId(1);
        member.setPassword("123456");
        member.setPhone("18310727696");
        member.setSex(1);
        memberService.insert(member);
        return "ok";
    }

    @RequestMapping("/select")
    public String selectMember(HttpServletRequest request, String name) {

        return memberService.selectByPrimaryKey(1).toString();
    }


}




