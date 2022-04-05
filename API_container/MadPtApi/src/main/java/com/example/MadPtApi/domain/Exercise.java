package com.example.MadPtApi.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Exercise {

    @Id
    @GeneratedValue
    @Column(name = "exercise_id")
    private Long id;

    private String exercise_name;

    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;

    @Embedded
    private ExerciseData exerciseData;
}
