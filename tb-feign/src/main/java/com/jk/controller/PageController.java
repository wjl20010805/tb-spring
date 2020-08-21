package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("page")
public class PageController {

    //用户分页
    @RequestMapping("toUserPage")
    public String toUserPage(){
        return "userlist";
    }

    @RequestMapping("toAddUserPage")
    public String toAddUserPage(){
        return "adduser";
    }

}
