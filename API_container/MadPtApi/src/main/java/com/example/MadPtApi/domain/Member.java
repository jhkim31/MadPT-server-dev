package com.example.MadPtApi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
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
    private GenderType genderType;
/*
    // diet 테이블의 user 참조
    @OneToMany(mappedBy = "user")
    private List<Diet> dietList;
    */

    @OneToMany(mappedBy = "member", fetch = LAZY)
    List<Diet> dietList = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = LAZY)
    List<Record> recordList = new ArrayList<>();
}
