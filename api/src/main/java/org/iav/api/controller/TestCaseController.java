package org.iav.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCaseController {
    @GetMapping("/hello")
    public Object hello(){
        return "hello";
    }
}
