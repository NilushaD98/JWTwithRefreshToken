package com.example.bstprcts.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/api/v1/users/")
public class Test {

    @GetMapping("test")
    public String sdfdf(){
        return "sdf";
    }
}
