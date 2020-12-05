package com.example.demo.controller;

import com.example.demo.daomap.ClientDao;
import com.example.demo.pojo.Client;
import com.example.demo.pojo.LinkMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class BookListController {
    @Autowired
    private ClientDao clientDao;

    private Client user=null;
    @GetMapping("/booklist.html")
    public String BookList(Model model, HttpSession session)throws Exception{
        Integer id=(Integer)session.getAttribute("userID");
        user= clientDao.getClientById(id);
        Collection<LinkMan> Links=user.getLinks().getBooks();
        model.addAttribute("links",Links);
        return "booklist";
    }

    @GetMapping("/addLink")
    public String toAddpage(){
        return "book/addNew";
    }

    @PostMapping("/addLink")
    public String AddLink(LinkMan newlink){
        user.getLinks().save(newlink);//保存新联系人
        return "redirect:/booklist.html";
    }

    @GetMapping("/check")
    @ResponseBody
    public String toCheckTel(@RequestParam("uphone")String Tel){
        Boolean now=user.getLinks().checkTel(Tel);
        System.out.println(now?"1":"0");
        return now?"1":"0";
    }

    @GetMapping("/editLink/{id}")
    public String toUpdataPage(@PathVariable("id")Integer id,Model model){
        LinkMan now=user.getLinks().getLinkById(id);
        model.addAttribute("link",now);
        return "book/updata";
    }

    @PostMapping("/Updata")
    public String editLink(LinkMan newlink){
        user.getLinks().save(newlink);//修改联系人
        return "redirect:/booklist.html";
    }

    @GetMapping("/deleteLink/{id}")
    public String deleteLink(@PathVariable("id")Integer id){
        user.getLinks().deleteLinkById(id);
        return "redirect:/booklist.html";
    }
}

