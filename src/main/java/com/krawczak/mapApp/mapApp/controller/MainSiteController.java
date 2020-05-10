package com.krawczak.mapApp.mapApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainSiteController {

    @RequestMapping("/")
    public ModelAndView getMainSite(){
        Map<String, Object> params = new HashMap<>();
        return new ModelAndView("main-site", params);
    }
}
