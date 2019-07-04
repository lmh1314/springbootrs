package com.zking.springbootrs.controller;

import com.zking.springbootrs.model.User;
import com.zking.springbootrs.service.UserService;
import com.zking.springbootrs.util.MD5Util;
import com.zking.springbootrs.util.RedisTemplateUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    @Autowired
    private UserService userService;
    @RequestMapping("ll")
    public String he(){
        redisTemplateUtil.set("us","哈哈哈");
        System.out.println(redisTemplateUtil.get("us"));

        return "你好";
    }

    @RequestMapping("user")
    public User getUser(){
        return userService.getUser(1);
    }

    @RequestMapping("/toLogin")
    public ModelAndView loginHTML(){
        ModelAndView mv=new ModelAndView("login.html");
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login(String uname, String upwd){
        ModelAndView mv=new ModelAndView("test.html");
        System.out.println("uname:"+uname +"  "+"upwd:"+upwd);
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token=new UsernamePasswordToken(uname,upwd);
        //执行登陆方法
        try {
            subject.login(token);
            //登陆成功
            return mv;
        }catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败:用户名不存在
            return mv;
        }catch (IncorrectCredentialsException e) {
           // e.printStackTrace();
            //登录失败:密码错误
            return mv;
        }
    }


}
