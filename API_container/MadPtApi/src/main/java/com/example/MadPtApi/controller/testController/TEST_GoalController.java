package com.example.MadPtApi.controller.testController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class TEST_GoalController {
    @PostMapping("/goal-dev")
    public String post(
            @RequestHeader String member_id,
            @RequestBody Map<String, Object> requestData
    ) {
        Gson gson = new Gson();
        JsonObject json = gson.toJsonTree(requestData).getAsJsonObject();
        json.addProperty("member_id", member_id);
        return json.toString();
    }
}