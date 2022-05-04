package com.example.MadPtApi.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private Long clientId;

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
    List<Diet> dietList;

    @OneToMany(mappedBy = "member", fetch = LAZY)
    List<Record> recordList;

}
