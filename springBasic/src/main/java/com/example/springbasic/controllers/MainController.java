package com.example.springbasic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/info")
    public String info (){
        return "info";
    }

//    @GetMapping("/index")
//    public String index (){
//        return "777index";
//    }
//


}
