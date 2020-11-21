package com.example.demo.controller;

//import com.example.demo.config.WebSecurityConfig;
import com.example.demo.daomap.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private ClientDao clientDao;


    @PostMapping("/loginPost")
    public String loginPost(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,HttpSession session
            )throws Exception{
        Integer id=-1;
        if(!StringUtils.isEmpty(username)&&!StringUtils.isEmpty(password)){
            id=clientDao.IsClient(username,password);
        }
        if(id<0){
            model.addAttribute("msg","用户名或密码错误！");
            return "index";
        }else{
            session.setAttribute("userID",id);
            return "redirect:/booklist.html";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.invalidate();
        return "redirect:/index.html";
    }
}
