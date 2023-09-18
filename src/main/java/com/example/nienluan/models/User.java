package com.example.nienluan.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_User")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "Age")
    private int age;

    @Column(name = "Sex")
    private Boolean sex;

    @Column(name = "Year_Of_Birth")
    private int DOB;

    @Column(name = "Username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "Phone")
    private String phoneNumber;

    @OneToOne(mappedBy = "User")
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name ="User_Role", joinColumns = @JoinColumn(name="id_User"), inverseJoinColumns = @JoinColumn(name="ID_Role"))
    private List<Role> roles = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private InformationAccount informationAccount;

  // getters và setters
}
