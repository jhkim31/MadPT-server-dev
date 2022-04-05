package com.example.MadPtApi.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
public class Diet {

    @Id
    @GeneratedValue
    @Column(name = "diet_id")
    private Long id;

    // user
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // dietfood
    @OneToMany(mappedBy = "diet")
    private List<DietFood> dietFoodList = new ArrayList<>();

    private Date dietDate;

    @Enumerated(EnumType.STRING)
    private DietType dietType;

}
