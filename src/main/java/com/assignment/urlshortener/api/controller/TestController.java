package com.assignment.urlshortener.api.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = {"/hello", "/hello/{who}"})
    public @ResponseBody String testHello(@PathVariable(required = false) String who) {
        String name = StringUtils.isEmpty(who) ? "World" : who;
        return "Hello, " + name;
    }
}
