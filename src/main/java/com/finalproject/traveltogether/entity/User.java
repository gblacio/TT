package com.finalproject.traveltogether.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="Users", schema = "TravelTogether")
public class User {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserID")
    private Long userID;
    @Column(name="UserName", nullable = false)
    @NotEmpty(message = "User's name cannot be empty.")
    private String userName;
    @NotEmpty(message = "User's password cannot be empty.")
    @Column(name="UserPassword", nullable = false)
    private String userPassword;
    @NotEmpty(message = "User's email cannot be empty.")
    @Email
    @Column(name="Email", nullable = false)
    private String email;
    @Column(name="Phone")
    private String phone;
    @Column(name="DateOfBirth", nullable = false)
    private Date dateOfBirth;
    @Column(name="GenderID")
    private int genderID;
    @Column(name="Verified")
    private Boolean verified = false; //Setting default value
    @Column(name="RoleID")
    private int roleID;
    @Column(name="UserSummary")
    private String userSummary;
    @Column(name="DateCreated")
    private LocalDateTime dateCreated = LocalDateTime.now();
}
