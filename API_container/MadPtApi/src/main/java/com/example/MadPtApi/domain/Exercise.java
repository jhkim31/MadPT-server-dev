package com.example.MadPtApi.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long id;

    private String exerciseName;

    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;

}
