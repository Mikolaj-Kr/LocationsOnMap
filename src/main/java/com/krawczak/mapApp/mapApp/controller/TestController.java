package com.krawczak.mapApp.mapApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.krawczak.mapApp.mapApp.parser.ApiParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class TestController {

    private final ApiParser apiParser;

    @Autowired
    public TestController(ApiParser apiParser) {
        this.apiParser = apiParser;
    }

    @RequestMapping("/test")
    public ResponseEntity<String> getTest() throws IOException {
        return new ResponseEntity<String>(apiParser.devicesParser().toString(), HttpStatus.OK) ;
    }
}
