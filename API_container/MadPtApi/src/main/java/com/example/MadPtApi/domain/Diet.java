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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diet_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL)
    private List<DietFood> dietFoodList = new ArrayList<>();

    private LocalDateTime dietDate;

    // 간편 입력 칼로리
    private double simpleTotalKcal;

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
    public static Diet createDiet(Member member, LocalDateTime date ,DietType dietType, double simpleTotalKcal, List<DietFood> dietFoodList) {
        Diet diet = new Diet();
        diet.setMember(member);
        diet.setDietDate(date);
        diet.setDietType(dietType);
        diet.setSimpleTotalKcal(simpleTotalKcal);
        for (DietFood dietFood : dietFoodList) {
            diet.addDietFood(dietFood);
        }
        return diet;
    }

    //== 비지니스 로직 ==//

    /**
     * 식단 총 칼로리 계산
     */
    public double getTotalDietKcal() {
        double total = 0;
        total += simpleTotalKcal;
        for (DietFood dietFood : dietFoodList) {
            total += dietFood.getDietKcal();
        }
        return total;
    }

}
