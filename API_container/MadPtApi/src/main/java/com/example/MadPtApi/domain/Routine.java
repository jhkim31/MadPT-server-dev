package com.example.MadPtApi.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routine_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String name;

    private LocalDateTime date;

    private int breaktime;

    @OneToMany(mappedBy = "routine", cascade = CascadeType.ALL)
    private List<RoutineExercise> routineExerciseList;

    //==관계연산 메소드==//
    public void setMember(Member member) {
        this.member = member;
        member.getRoutineList().add(this);
    }

    public void setRoutineExercise(RoutineExercise routineExercise) {
        routineExerciseList.add(routineExercise);
        routineExercise.setRoutine(this);
    }



}
