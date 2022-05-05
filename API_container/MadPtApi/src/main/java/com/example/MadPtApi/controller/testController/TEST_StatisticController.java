package com.example.MadPtApi.controller.testController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/statistic")
public class TEST_StatisticController {
    @GetMapping("/record-dev")
    public String customJson(
            @RequestParam(defaultValue="1651676400000") String start_day,
            @RequestParam(defaultValue="1651762800000") String end_day,
            @RequestHeader String member_id
    ) throws ParseException {
        JsonObject returnData = new JsonObject();
        JsonArray recordList = new JsonArray();


        JsonObject rec1 = new JsonObject();
        rec1.addProperty("exercise_id", 123);
        rec1.addProperty("start_time", "1651676400000");
        rec1.addProperty("sets", 3);
        rec1.addProperty("reps", 5);
        rec1.addProperty("score", 10);

        JsonObject rec2 = new JsonObject();
        rec2.addProperty("exercise_id", 321);
        rec2.addProperty("start_time", "1651762800000");
        rec2.addProperty("sets", 3);
        rec2.addProperty("reps", 1);
        rec2.addProperty("score", 104);

        recordList.add(rec1);
        recordList.add(rec2);

        returnData.add("record_list", recordList);
        returnData.addProperty("member_id", member_id);
        return returnData.toString();
    }

    @GetMapping("/diet-dev")
    public String getDiet(
            @RequestParam(defaultValue="1651762800000") String date,
            @RequestHeader String member_id
    ) throws ParseException {
        JsonObject returnData = new JsonObject();
        JsonArray returnDietList = new JsonArray();
        JsonObject diet = new JsonObject();
        JsonArray dietList = new JsonArray();

        JsonObject diet1 = new JsonObject();
        diet1.addProperty("food_name", "김치");
        diet1.addProperty("diet_kcal", 200);
        diet1.addProperty("weight", 300);
        diet1.addProperty("count", 5);
        diet1.addProperty("unit", "잔");
        diet1.addProperty("is_custom", false);

        JsonObject food_data1 = new JsonObject();
        food_data1.addProperty("default_carbonhydrate", 30);
        food_data1.addProperty("default_proteinl", 300);
        food_data1.addProperty("default_fat", 200);
        diet1.add("food_data", food_data1);

        JsonObject diet2 = new JsonObject();
        diet2.addProperty("food_name", "라면");
        diet2.addProperty("diet_kcal", 400);
        diet2.addProperty("weight", 300);
        diet2.addProperty("count", 41);
        diet2.addProperty("unit", "컵");
        diet1.addProperty("is_custom", false);

        JsonObject food_data2 = new JsonObject();
        food_data2.addProperty("default_carbonhydrate", 50);
        food_data2.addProperty("default_proteinl", 900);
        food_data2.addProperty("default_fat", 100);
        diet2.add("food_data", food_data2);

        dietList.add(diet1);
        dietList.add(diet2);

        diet.add("diet_list_by_type", dietList);
        diet.addProperty("diet_type", "Breakfast");
        diet.addProperty("simple_diet_kcal", 350);

        returnDietList.add(diet);

        returnData.add("daily_diet_list", returnDietList);

        return returnData.toString();
    }

    @GetMapping("/day-dev")
    public String dailyData(
            @RequestParam(defaultValue="1651676400000") String date,
            @RequestHeader String member_id
    ) throws ParseException {
        JsonObject returnData = new JsonObject();
        JsonObject goal = new JsonObject();

        returnData.addProperty("exercise_kcal", 500);
        returnData.addProperty("breakfast_kcal", 300);
        returnData.addProperty("lunch_kcal", 500);
        returnData.addProperty("dinner_kcal", 200);
        returnData.addProperty("snack_kcal", 100);

        goal.addProperty("diet_kcal", 35.8);
        goal.addProperty("exercise_kcal", 22.9);
        goal.addProperty("weight", 12.3);

        returnData.add("goal", goal);
        returnData.addProperty("member_id", member_id);
        return returnData.toString();
    }
}