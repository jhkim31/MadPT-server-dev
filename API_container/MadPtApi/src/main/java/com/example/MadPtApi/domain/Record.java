package com.example.MadPtApi.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
public class Record {

    @Id
    @GeneratedValue
    @Column(name = "record_id")
    private Long id;

    private Date startTime;

    private Date endTime;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @Embedded
    private ExerciseData exerciseData;
}
