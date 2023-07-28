package com.example.bstprcts.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseAuthenticationSuccessDTO {
    private String accessToken;
    private String refreshToken;
}
