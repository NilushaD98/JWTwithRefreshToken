package com.example.bstprcts.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestAddUserDTO {
    private String username;
    private String password;
    private String role;
}
