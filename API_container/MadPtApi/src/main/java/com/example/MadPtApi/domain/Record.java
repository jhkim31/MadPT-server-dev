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

    @Embedded
    private ExerciseData exerciseData;
}
