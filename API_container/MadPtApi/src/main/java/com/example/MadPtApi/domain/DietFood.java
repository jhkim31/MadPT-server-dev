package com.example.MadPtApi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class DietFood {
    @Id
    @GeneratedValue
    @Column(name = "diet_food_id")
    private Long id;

    private double foodWeight;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "diet_id")
    private Diet diet;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id")
    private Food food;
}
