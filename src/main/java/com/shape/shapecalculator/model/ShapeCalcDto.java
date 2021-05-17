package com.shape.shapecalculator.model;

/*
Created by Ali Artukov
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShapeCalcDto {

    private Double area;
    private Double perimeterOrCircumference;

}
