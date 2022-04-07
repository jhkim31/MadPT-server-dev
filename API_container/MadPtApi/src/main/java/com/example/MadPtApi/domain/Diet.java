package com.example.MadPtApi.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
public class Diet {

    @Id
    @GeneratedValue
    @Column(name = "diet_id")
    private Long id;

    // user
    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    // dietfood
    @OneToMany(mappedBy = "diet")
    private List<DietFood> dietFoodList = new ArrayList<>();

    private Date dietDate;

    @Enumerated(EnumType.STRING)
    private DietType dietType;

    //==관계연산 메소드==//
    public void setMember(Member member) {
        this.member = member;
        member.getDietList().add(this);
    }

    public void addDietFood(DietFood dietFood) {
        dietFoodList.add(dietFood);
        dietFood.setDiet(this);
    }
}
