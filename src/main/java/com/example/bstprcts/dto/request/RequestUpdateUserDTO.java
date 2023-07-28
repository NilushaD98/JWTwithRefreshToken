package com.example.bstprcts.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestUpdateUserDTO {
    private int userID;
    private String username;
    private String password;
    private String role;

}
