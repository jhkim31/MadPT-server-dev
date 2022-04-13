package com.example.MadPtApi.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/statistic")
public class StatisticController {
    @GetMapping("/get-record")
    public String customJson(
            @RequestParam(defaultValue="1649855760593") long timestamp,
            @RequestParam(defaultValue="123") String user_id,
            @RequestParam(defaultValue="2022/04/13") String start_day,
            @RequestParam(defaultValue="2022/04/13") String end_day
    ) throws ParseException {
        JsonObject returnData = new JsonObject();
        JsonArray recordList = new JsonArray();

//        Date s_day = new SimpleDateFormat("yyyy/MM/dd").parse(start_day);
//        System.out.println(s_day.getTime());
//
//        Date e_day = new SimpleDateFormat("yyyy/MM/dd").parse(end_day);
//        System.out.println(e_day.getTime());
//        long day_diff = (e_day.getTime() - s_day.getTime()) / (24 * 60 * 60 * 1000) + 1;
//        System.out.println(day_diff + "일간 데이터");
//
//        long time = new Date().getTime();
//        returnData.addProperty("timestamp", time);
//        returnData.add("food_list", foodList);

        long time = new Date().getTime();
        returnData.addProperty("timestamp", time);

        JsonObject rec1 = new JsonObject();
        rec1.addProperty("user_id", user_id);
        rec1.addProperty("exercise_id", 123);
        rec1.addProperty("start_time", "2012/03/12");
        rec1.addProperty("sets", 3);
        rec1.addProperty("reps", 5);

        JsonObject rec2 = new JsonObject();
        rec2.addProperty("user_id", user_id);
        rec2.addProperty("exercise_id", 321);
        rec2.addProperty("start_time", "2015/03/12");
        rec2.addProperty("sets", 3);
        rec2.addProperty("reps", 1);

        recordList.add(rec1);
        recordList.add(rec2);

        returnData.add("record_list", recordList);

        return returnData.toString();
    }

    @GetMapping("/get-diet")
    public String getDiet(
            @RequestParam(defaultValue="1649855760593") long timestamp,
            @RequestParam(defaultValue="123") String user_id,
            @RequestParam(defaultValue="2022/04/13") String start_day,
            @RequestParam(defaultValue="2022/04/13") String end_day
    ) throws ParseException {
        JsonObject returnData = new JsonObject();
        JsonArray dietList = new JsonArray();

//        Date s_day = new SimpleDateFormat("yyyy/MM/dd").parse(start_day);
//        System.out.println(s_day.getTime());
//
//        Date e_day = new SimpleDateFormat("yyyy/MM/dd").parse(end_day);
//        System.out.println(e_day.getTime());
//        long day_diff = (e_day.getTime() - s_day.getTime()) / (24 * 60 * 60 * 1000) + 1;
//        System.out.println(day_diff + "일간 데이터");
//
//        long time = new Date().getTime();
//        returnData.addProperty("timestamp", time);
//        returnData.add("food_list", foodList);

        long time = new Date().getTime();
        returnData.addProperty("timestamp", time);

        JsonObject diet1 = new JsonObject();
        diet1.addProperty("user_id", user_id);
        diet1.addProperty("food_name", "김치");
        diet1.addProperty("type", 0);
        diet1.addProperty("weight", 300);
        diet1.addProperty("count", 5);
        diet1.addProperty("unit", "unit");
        diet1.addProperty("date", "2022/04/13");
        diet1.addProperty("default_weight", 100);
        diet1.addProperty("default_kcal", 200);
        diet1.addProperty("default_carbonhydrate", 30);
        diet1.addProperty("default_proteinl", 300);
        diet1.addProperty("default_fat", 200);

        JsonObject diet2 = new JsonObject();
        diet2.addProperty("user_id", user_id);
        diet2.addProperty("food_name", "라면");
        diet2.addProperty("type", 1);
        diet2.addProperty("weight", 300);
        diet2.addProperty("count", 41);
        diet2.addProperty("unit", "unit");
        diet2.addProperty("date", "2022/04/15");
        diet2.addProperty("default_weight", 200);
        diet2.addProperty("default_kcal", 100);
        diet2.addProperty("default_carbonhydrate", 50);
        diet2.addProperty("default_proteinl", 900);
        diet2.addProperty("default_fat", 100);

        dietList.add(diet1);
        dietList.add(diet2);

        returnData.add("diet_list", dietList);

        return returnData.toString();
    }
}