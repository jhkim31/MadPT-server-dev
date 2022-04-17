package com.example.MadPtApi.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/diet")
public class DietController {
    @PostMapping("/daily-diet")
    public String post(
            @RequestBody Map<String, Object> requestData
    ) {
        int error = 0;

        ArrayList diet_list = (ArrayList) requestData.get("diet_list");
        for (Object item: diet_list) {
            Map<String, Object> fitness = (Map) item;
            System.out.println("food_id : " + fitness.get("food_id"));
            System.out.println("food_name : " + fitness.get("food_name"));
            System.out.println("diet_type : " + fitness.get("diet_type"));
            System.out.println("weight : " + fitness.get("weight"));
            System.out.println("count : " + fitness.get("count"));
            System.out.println("unit : " + fitness.get("unit"));
            System.out.println("is_custom : " + fitness.get("is_custom"));
            System.out.println();
            if (fitness.get("food_id") == null)
                error = 1;
            if (fitness.get("food_name") == null)
                error = 1;
            if (fitness.get("diet_type") == null)
                error = 1;
            if (fitness.get("weight") == null)
                error = 1;
            if (fitness.get("count") == null)
                error = 1;
            if (fitness.get("unit") == null)
                error = 1;
            if (fitness.get("is_custom") == null)
                error = 1;
        }
        if (error == 0){
            return "true";
        } else {
            return "false";
        }
    }
}