package com.example.MadPtApi.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
@RequestMapping("/api/dev")
public class TestController {

    @GetMapping("/test1")
    public String customJson() {
        JsonObject jo = new JsonObject();

        long time = new Date().getTime();
        jo.addProperty("string", "hello-world");
        jo.addProperty("integer", 123);
        jo.addProperty("double", 1.23);
        jo.addProperty("timestamp", time);

        return jo.toString();
    }
}