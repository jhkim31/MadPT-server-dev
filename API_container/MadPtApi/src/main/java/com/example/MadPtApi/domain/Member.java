package com.example.MadPtApi.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    // private String email;
    // 프로필 사진
    // 닉네임
    // private Date birth;

    private double weight;

    private double height;

    @Enumerated(EnumType.STRING)
    private GenderStatus genderStatus;
/*
    // diet 테이블의 user 참조
    @OneToMany(mappedBy = "user")
    private List<Diet> dietList;
    */

    @OneToMany(mappedBy = "member")
    List<Diet> dietList = new ArrayList<>();
}
