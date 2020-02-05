package com.george.template.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Webpage {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String webpage() {
        return new FileReader("index.html").toString();
    }
}
