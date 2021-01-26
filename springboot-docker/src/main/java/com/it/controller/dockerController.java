package com.it.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class dockerController {
    @RequestMapping("/")
    public String index(){
        return "Hello docker";
    }
}
