package com.example.bstprcts.controller;

import com.example.bstprcts.dto.request.RequestAuthenticatDTO;
import com.example.bstprcts.dto.response.ResponseAuthenticationSuccessDTO;
import com.example.bstprcts.service.AuthenticationService;
import com.example.bstprcts.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate/")
@CrossOrigin(origins = "*",methods = {RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST})
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(path = "auth")
    public ResponseEntity<StandardResponse> authenticate(@RequestBody RequestAuthenticatDTO requestAuthenticatDTO){
        ResponseAuthenticationSuccessDTO responseAuthenticationSuccessDTO = authenticationService.authenticate(requestAuthenticatDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"authenticate success",responseAuthenticationSuccessDTO), HttpStatus.ACCEPTED
        );
    }
}
