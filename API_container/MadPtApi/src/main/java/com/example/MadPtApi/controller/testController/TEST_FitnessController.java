package com.example.MadPtApi.controller.testController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/fitness")
public class TEST_FitnessController {
    @PostMapping("/save-results-dev")
    public String post(
            @RequestBody Map<String, Object> requestData
    ) {
        int error = 0;

        ArrayList fitness_list = (ArrayList) requestData.get("fitnesses");
        for (Object item: fitness_list) {
            Map<String, Object> fitness = (Map) item;
            System.out.println("exercise_id : " + fitness.get("exercise_id"));
            System.out.println("start_time : " + fitness.get("start_time"));
            System.out.println("end_time : " + fitness.get("end_time"));
            System.out.println("score : " + fitness.get("score"));
            System.out.println("reps : " + fitness.get("reps"));
            System.out.println("sets : " + fitness.get("sets"));
            System.out.println();
            if (fitness.get("exercise_id") == null)
                error = 1;
            if (fitness.get("start_time") == null)
                error = 1;
            if (fitness.get("end_time") == null)
                error = 1;
            if (fitness.get("score") == null)
                error = 1;
            if (fitness.get("reps") == null)
                error = 1;
            if (fitness.get("sets") == null)
                error = 1;
        }
        if (error == 0){
            return "true";
        } else {
            return "false";
        }

    }
}