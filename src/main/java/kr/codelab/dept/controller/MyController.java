package kr.codelab.dept.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MyController {
    @GetMapping("/hello")
    public String printHello() {
        return "Hello World!";
    }
}
