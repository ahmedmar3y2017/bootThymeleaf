package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", "ahmed mar3y");
        return "home";
    }
}
