package com.workintech.zoo.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Kangaroo {

    private Integer id;
    private String name;
    private Double height;
    private Double weight;

    private String gender;
    private Boolean isAggressive;



}

