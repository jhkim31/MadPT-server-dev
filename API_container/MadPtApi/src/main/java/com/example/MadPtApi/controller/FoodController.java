package com.example.MadPtApi.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/food")
public class FoodController {
    @GetMapping("/list")
    public String customJson(
            @RequestParam(defaultValue="제육") String food_name
    ) {
        JsonObject returnData = new JsonObject();
        JsonArray foodList = new JsonArray();

        JsonObject jeyuk = new JsonObject();
        JsonObject mjeyuk = new JsonObject();
        JsonObject don = new JsonObject();
        JsonObject cdon = new JsonObject();

        jeyuk.addProperty("food_name", "제육볶음");
        jeyuk.addProperty("food_id", 1);
        jeyuk.addProperty("maker_name", "우리집");
        jeyuk.addProperty("default_weight", 100);
        jeyuk.addProperty("default_kcal", 200);
        jeyuk.addProperty("default_carbonhydrate", 300);
        jeyuk.addProperty("default_protein", 400);
        jeyuk.addProperty("default_fat", 500);

        mjeyuk.addProperty("food_name", "매콤 제육볶음");
        mjeyuk.addProperty("food_id", 2);
        mjeyuk.addProperty("maker_name", "우리집");
        mjeyuk.addProperty("default_weight", 300);
        mjeyuk.addProperty("default_kcal", 100);
        mjeyuk.addProperty("default_carbonhydrate", 300);
        mjeyuk.addProperty("default_protein", 50);
        mjeyuk.addProperty("default_fat", 200);

        don.addProperty("food_name", "돈까쓰");
        don.addProperty("food_id", 3);
        don.addProperty("maker_name", "학교");
        don.addProperty("default_weight", 300);
        don.addProperty("default_kcal", 100);
        don.addProperty("default_carbonhydrate", 300);
        don.addProperty("default_protein", 900);
        don.addProperty("default_fat", 800);

        cdon.addProperty("food_name", "치즈 돈까쓰");
        cdon.addProperty("food_id", 4);
        cdon.addProperty("maker_name", "이퀘");
        cdon.addProperty("default_weight", 300);
        cdon.addProperty("default_kcal", 200);
        cdon.addProperty("default_carbonhydrate", 300);
        cdon.addProperty("default_protein", 123);
        cdon.addProperty("default_fat", 310);

        System.out.println(food_name);
        if (food_name.equals("제육")){
            foodList.add(jeyuk);
            foodList.add(mjeyuk);
        }

        if (food_name.equals("돈까쓰")){
            foodList.add(don);
            foodList.add(cdon);
        }

        long time = new Date().getTime();
        returnData.addProperty("timestamp", time);
        returnData.add("food_list", foodList);

        return returnData.toString();
    }
}