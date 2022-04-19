package com.example.MadPtApi.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/api/dev")
public class TestController {
    @GetMapping("/get")
    public String customJson(
            @RequestParam(defaultValue="default") String param
    ) {
        JsonObject jo = new JsonObject();

        long time = new Date().getTime();
        jo.addProperty("string", "hello-world");
        jo.addProperty("integer", 123);
        jo.addProperty("double", 1.23);
        jo.addProperty("timestamp", time);
        jo.addProperty("your_param", param);

        return jo.toString();
    }

    @PostMapping("/post")
    public String post(
            @RequestBody Map<String, Object> requestData
    ){
        JsonObject jo = new JsonObject();
        JsonArray ja = new JsonArray();

        requestData.forEach((key, value) -> {
            ja.add(key);
            System.out.println("key : " + key);
            System.out.println("value : " + value);
        });

        jo.add("key_list", ja);
        return jo.toString();
    }
}