package com.example.bstprcts.service;

import com.example.bstprcts.dto.request.RequestAuthenticatDTO;
import com.example.bstprcts.dto.response.ResponseAuthenticationSuccessDTO;

public interface AuthenticationService {
    ResponseAuthenticationSuccessDTO authenticate(RequestAuthenticatDTO requestAuthenticatDTO);
}
