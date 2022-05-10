package com.example.MadPtApi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private int realTime;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    private int reps;
    private int sets;
    private double avgScore;
    private int breakTime;

    private double burnedKcal;

    //==관계연산 메소드==//
    public void setMember(Member member) {
        this.member = member;
        member.getRecordList().add(this);
    }
}
