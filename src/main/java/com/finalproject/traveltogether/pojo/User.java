package com.finalproject.traveltogether.pojo;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name="Users", schema = "TravelTogether")
public class User implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserID")
    private Long userID;
    @Column(name="UserName")
    @NotEmpty
    private String userName;

    @NotEmpty
    @Column(name="UserPassword")
    private String userPassword;

    @NotEmpty
    @Email
    @Column(name="Email")
    private String email;
    @Column(name="Phone")
    private String phone;
    @Column(name="DateOfBirth")
    private Date dateOfBirth;
    @Column(name="GenderID")
    private int genderID;
    @Column(name="Verified")
    private Boolean verified;
    @Column(name="RoleID")
    private String roleID;
    @Column(name="UserSummary")
    private String userSummary;

}
