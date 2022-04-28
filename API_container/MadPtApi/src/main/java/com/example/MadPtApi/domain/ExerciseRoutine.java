package com.example.MadPtApi.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ExerciseRoutine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_routine_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
    private List<Exercise> exerciseList = new ArrayList<>();*/


}
