package com.example.MadPtApi.controller.testController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TEST_RoutineController {
    @PostMapping("/routine-dev")
    public String post(
            @RequestHeader String member_id,
            @RequestBody Map<String, Object> requestData
    ) {
        Gson gson = new Gson();
        JsonObject json = gson.toJsonTree(requestData).getAsJsonObject();
        json.addProperty("member_id", member_id);
        return json.toString();
    }

    @GetMapping("/routine/list-dev")
    public String routine_list(
            @RequestHeader String member_id
    ) {
        JsonObject returnData = new JsonObject();
        JsonObject routine1 = new JsonObject();
        JsonObject routine2 = new JsonObject();
        JsonObject ex1 = new JsonObject();
        JsonObject ex2 = new JsonObject();
        JsonObject ex3 = new JsonObject();
        JsonObject ex4 = new JsonObject();
        ex1.addProperty("exercise_id", 1);
        ex1.addProperty("sets", 3);
        ex1.addProperty("reps", 5);
        ex1.addProperty("breaktime", 10);

        ex2.addProperty("exercise_id", 2);
        ex2.addProperty("sets", 2);
        ex2.addProperty("reps", 2);
        ex2.addProperty("breaktime", 15);

        ex3.addProperty("exercise_id", 3);
        ex3.addProperty("sets", 3);
        ex3.addProperty("reps", 5);
        ex3.addProperty("breaktime", 20);

        ex4.addProperty("exercise_id", 4);
        ex4.addProperty("sets", 4);
        ex4.addProperty("reps", 4);
        ex4.addProperty("breaktime", 5);

        routine1.addProperty("routine_name", "r1");
        routine1.addProperty("date", 1651770226);
        JsonArray tmp = new JsonArray();
        tmp.add(ex1);
        tmp.add(ex2);
        routine1.add("exercise_list", tmp);

        routine2.addProperty("routine_name", "r2");
        routine2.addProperty("date", 1651753123);
        JsonArray tmp2 = new JsonArray();
        tmp2.add(ex4);
        tmp2.add(ex3);
        routine2.add("exercise_list", tmp);

        JsonArray tmp3 = new JsonArray();

        tmp3.add(routine1);
        tmp3.add(routine2);
        returnData.add("routine_list", tmp3);
        returnData.addProperty("member_id", member_id);

        return returnData.toString();
    }
}