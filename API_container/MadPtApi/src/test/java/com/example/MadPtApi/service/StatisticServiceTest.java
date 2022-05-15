package com.example.MadPtApi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class StatisticServiceTest {

    @Autowired StatisticService statisticService;

    @Test
    public void test1() throws Exception {
        // given
        statisticService.getMonthlyData(1L, 1661570300000L);
        // when
        // then
    }

}