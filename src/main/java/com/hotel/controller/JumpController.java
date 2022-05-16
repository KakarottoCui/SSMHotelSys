package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jump")
public class JumpController {

    @RequestMapping("/guests_add")
    public String guest(){
        return "guests_add";
    }

    @RequestMapping("/vip_add")
    public String vip(){
        return "vip_add";
    }

    @RequestMapping("/home_add")
    public String home(){
        return "home_add";
    }

    @RequestMapping("/pwd_update")
    public String pwd(){
        return "pwd_update";
    }

    @RequestMapping("/excel_down")
    public String excel(){
        return "excel_down";
    }

    @RequestMapping("/web_cache")
    public String cache(){
        return "web_cache";
    }

    @RequestMapping("/web_index")
    public String web_index(){
        return "web_index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/exit")
    public String exit(){
        return "exit";
    }

    @RequestMapping("/vip_index")
    public String vip_index(){
        return "vip/index";
    }

    @RequestMapping("/vip_exit")
    public String vip_exit(){
        return "vip/exit";
    }

    @RequestMapping("/vip_register")
    public String vip_register(){
        return "vip/register";
    }
}
