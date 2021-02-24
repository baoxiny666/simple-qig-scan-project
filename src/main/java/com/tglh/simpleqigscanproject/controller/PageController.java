package com.tglh.simpleqigscanproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping(value = {"/qigscan/index"})
    public  String qigScan(){
        return "/qigscan/index";
    }


    @RequestMapping(value = {"/qigscan/success"})
    public  String qigSuccess(){
        return "/qigscan/success";
    }

    @RequestMapping(value = {"/qigscan/error"})
    public  String qigError(){
        return "/qigscan/error";
    }


}
