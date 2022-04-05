package com.example.MadPtApi.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class DietFood {
    @Id
    @GeneratedValue
    @Column(name = "diet_food_id")
    private Long id;

    private double foodWeight;

    @ManyToOne
    @JoinColumn(name = "diet_id")
    private Diet diet;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;
}
