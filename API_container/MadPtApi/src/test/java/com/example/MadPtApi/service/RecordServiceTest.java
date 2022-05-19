package com.example.MadPtApi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class RecordServiceTest {

    @Autowired
    RecordService recordService;

    @Test
    public void 운동_정보_저장() throws Exception {
        // given
/*        Record record = Record.builder()
                .startTime(1651738940000L)
                .endTime(1651739420000L)
                .build();*/
        // when
/*        "exercise_id" : 1,
                "start_time" : 1651738940000,
                "end_time" : 1651739420000,
                "reps" : 10,
                "sets" : 5,
                "avg_score" : 99.9*/
        // then
    }

    @Test
    public void 소모_칼로리_계산() throws Exception {
        // given
        Long startTime = 1651826078000L; // 34분
        Long endTime = 1651827038000L; // 50분

        Long totalTime = (endTime - startTime); // 밀리초
        long realTime = 30000L; // 10분 / 밀리초
        double weight = 70.0;

        // when
        double burnedKcal = recordService.calculateBurnedKcal(totalTime, realTime, weight);
        // then
        System.out.println(totalTime);
        System.out.println(burnedKcal);
    }
    
    @Test
    public void 운동_정보_조회() throws Exception {
        // given

        // when
        // then
    }

}