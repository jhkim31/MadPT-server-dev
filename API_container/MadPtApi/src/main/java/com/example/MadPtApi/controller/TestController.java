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

        jo.addProperty("projectName", "preword");
        jo.addProperty("author", "hello-bryan");
        jo.addProperty("createdDate", new Date().toString());

        JsonArray ja = new JsonArray();
        for(int i=0; i<5; i++) {
            JsonObject jObj = new JsonObject();
            jObj.addProperty("prop"+i, i);
            ja.add(jObj);
        }

        jo.add("follower", ja);

        return jo.toString();
    }
}