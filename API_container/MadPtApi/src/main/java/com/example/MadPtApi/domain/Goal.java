package com.example.MadPtApi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gaol_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private double dietKcal;
    private double exerciseKcal;
    private double weight;
}
