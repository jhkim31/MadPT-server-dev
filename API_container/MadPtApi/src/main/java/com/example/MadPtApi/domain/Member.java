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

    private double weight;

    private double height;

    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<Diet> dietList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<Record> recordList;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<Routine> routineList;

    public void updateWeight(double weight) {
        this.weight = weight;
    }
}
