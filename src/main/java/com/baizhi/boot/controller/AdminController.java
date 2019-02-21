package com.baizhi.boot.controller;

import cn.hutool.http.HttpResponse;
import com.baizhi.boot.entity.Admin;
import com.baizhi.boot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private HttpSession session;
    @RequestMapping("/login")
    @ResponseBody
    public Object login(String username,String password){
        Admin user = adminService.getAdminByUsername(username);
        int login = adminService.login(username, password);
        Map<String,String> map = new HashMap<String,String>();
        if (login==1){
            map.put("code", "1");
            map.put("msg", "用户名不存在");
            return map;
        }
        if (login==2){
            map.put("code", "2");
            map.put("msg", "密码不正确");
            return map;
        }
        map.put("code", "3");
        map.put("msg", "登陆成功");
        session.setAttribute("user",user);
        return map;
    }
    @RequestMapping("/captchaTest")
    @ResponseBody
    public Object captchaTest(String enCode) throws Exception{
        String realcode = (String)session.getAttribute("code");
        Map<String,String> map = new HashMap<String,String>();
        if (!enCode.equals(realcode)){
            map.put("code", "1");
            map.put("msg", "验证码不对");
        }
        return map;
    }
    @RequestMapping("/usernameTest")
    @ResponseBody
    public Object usernameTest(String username) throws Exception{
        Admin adminByUsername = adminService.getAdminByUsername(username);
        Map<String,String> map = new HashMap<String,String>();
        if (adminByUsername!=null){
            map.put("code", "1");
            map.put("msg", "用户名不存在");
        }
        return map;
    }
    @RequestMapping("/remove")
    @ResponseBody
    public Object remove(Integer id){
        adminService.remove(id);
        Map<String,String> map = new HashMap<String,String>();
        map.put("code", "200");
        map.put("msg", "删除成功");
        return map;
    }
    @RequestMapping("/add")
    @ResponseBody
    public Object add(Admin admin,String code){
        adminService.insert(admin);
        String realcode = (String)session.getAttribute("code");
        Map<String,String> map = new HashMap<String,String>();
        if (code!=realcode){
            map.put("code", "100");
            map.put("msg", "验证码不对");
            return map;
        }
        map.put("code", "200");
        map.put("msg", "添加成功");
        return map;
    }
    @RequestMapping("/list")
    @ResponseBody
    public Object list(){
        return adminService.getAll();
    }
}
