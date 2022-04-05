package com.example.MadPtApi.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class ExerciseData {
    private int score;
    private int sets;
    private int reps;
}
