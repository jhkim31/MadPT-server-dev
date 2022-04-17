package com.example.MadPtApi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
public class Record {

    @Id
    @GeneratedValue
    @Column(name = "record_id")
    private Long id;

    private Date startTime;

    private Date endTime;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @Embedded
    private ExerciseData exerciseData;

    @Builder
    public Record(Long id, Date startTime, Date endTime, Member member, Exercise exercise, ExerciseData exerciseData) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.member = member;
        this.exercise = exercise;
        this.exerciseData = exerciseData;
    }

    //==관계연산 메소드==//
    public void setMember(Member member) {
        this.member = member;
        member.getRecordList().add(this);
    }
}
