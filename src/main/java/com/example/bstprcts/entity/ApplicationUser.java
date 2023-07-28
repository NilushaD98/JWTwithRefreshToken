package com.example.bstprcts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "applicationUser")
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id",length = 10,nullable = false)
    private int userID;
    @Column(name = "user_name",length = 20,nullable = false)
    private String username;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name = "role",nullable = false)
    private String role;

    public ApplicationUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
