package com.gb.webaapp.homework3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping ("/info")
    @ResponseBody
    public String info(){
        return "Info page";
    }
}
