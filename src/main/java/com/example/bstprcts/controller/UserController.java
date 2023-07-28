package com.example.bstprcts.controller;

import com.example.bstprcts.dto.request.RequestAddUserDTO;
import com.example.bstprcts.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/reg")
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public void addUser(@RequestBody RequestAddUserDTO requestAddUserDTO){
        userService.adduser(requestAddUserDTO);
    }

}
