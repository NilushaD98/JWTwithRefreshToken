package com.example.bstprcts.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseAllUserDTO {
    private int userID;
    private String username;
    private String role;
}
