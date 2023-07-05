package com.finalproject.traveltogether.pojo;

import jakarta.persistence.*;
import lombok.Data;
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
    private String userName;
    @Column(name="UserPassword")
    private String userPassword;
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
