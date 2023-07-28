package com.example.bstprcts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicationUserDTO {
    private int userID;
    private String username;
    private String password;
}
