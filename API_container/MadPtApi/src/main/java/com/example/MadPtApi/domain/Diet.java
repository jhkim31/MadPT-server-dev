package com.example.MadPtApi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Diet {

    @Id
    @GeneratedValue
    @Column(name = "diet_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // dietfood
    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL)
    private List<DietFood> dietFoodList = new ArrayList<>();

    private LocalDateTime dietDate;

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

    //==생성 메서드==//
    public static Diet createDiet(Member member, LocalDateTime date ,DietType dietType, DietFood... dietFoods) {
        Diet diet = new Diet();
        diet.setMember(member);
        diet.setDietDate(date);
        diet.setDietType(dietType);
        for (DietFood dietFood : dietFoods) {
            diet.addDietFood(dietFood);
        }

        return diet;
    }

}
