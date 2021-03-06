package com.shape.shapecalculator.service;

/*
Created by Ali Artukov
*/

import com.shape.shapecalculator.model.ApiResponse;
import com.shape.shapecalculator.model.FigureDTO;
import org.springframework.stereotype.Service;

@Service
public class ShapeCalcService {


    /**
     * Get one side of the square and if the value is positive return the area
     * and the perimeter of the square.
     * @param a Double a
     * @return ApiResponse
     */
    public ApiResponse getSquareAreaAndPerimeter(Double a) {
        if (a <= 0){
            return new ApiResponse(false, "The side of the square must be positive.", null);
        }
        Double area = a * a;
        Double perimeter = a * 4;
        FigureDTO squareAreaAndPerimeter = new FigureDTO();
        squareAreaAndPerimeter.setArea(area);
        squareAreaAndPerimeter.setPerimeter(perimeter);
        return new ApiResponse(true, "The calculation was completed successfully!", squareAreaAndPerimeter);
    }


    /**
     * Get the length and width of the rectangle and if the length and width are
     * positive return the area and perimeter of the rectangle.
     * @param length Double length
     * @param width Double length
     * @return ApiResponse
     */
    public ApiResponse getRectangleAreaAndPerimeter(Double length, Double width) {
        if (length <= 0 || width <= 0){
            return new ApiResponse(false, "The length and width of the rectangle must be positive!", null);
        }
        Double area = length * width;
        Double perimeter = 2 * (length + width);
        FigureDTO rectangleAreaAndPerimeter = new FigureDTO();
        rectangleAreaAndPerimeter.setArea(area);
        rectangleAreaAndPerimeter.setPerimeter(perimeter);
        return new ApiResponse(true, "The calculation was completed successfully.", rectangleAreaAndPerimeter);
    }


    /**
     * Get a side, b side and c side of the triangle and if the addition of a and c
     * is greater than b return the area and perimeter of the triangle.
     * @param a Double a
     * @param b Double b
     * @param c Double c
     * @return ApiResponse
     */
    public ApiResponse getTriangleAreaAndPerimeter(Double a, Double b, Double c) {
        if ((a <= 0 || b <= 0 || c <= 0) || (c >= (a + b))){
            return new ApiResponse(false, "The sum of two side lengths has to exceed the length of the third side.", null);
        }
        Double area = 0.25 * Math.sqrt((a + b + c) * (-a + b + c) * (a - b + c) * (a + b - c));
        Double perimeter = a + b + c;
        FigureDTO triangleAreaAndPerimeter = new FigureDTO();
        triangleAreaAndPerimeter.setArea(area);
        triangleAreaAndPerimeter.setPerimeter(perimeter);
        return new ApiResponse(true, "The calculation was completed successfully.", triangleAreaAndPerimeter);
    }


    /**
     * Get radius of the circle and if the value is positive return the area
     * and circumference of the circle.
     * @param radius Double radius
     * @return ApiResponse
     */
    public ApiResponse getCircleAreaAndCircumference(Double radius) {
        if (radius <= 0){
            return new ApiResponse(false, "The variable radius should be positive.", null);
        }
        Double area = Math.PI * Math.pow(radius, 2);
        Double circumference = 2 * Math.PI * radius;
        FigureDTO circleAreaAndCircumference = new FigureDTO();
        circleAreaAndCircumference.setArea(area);
        circleAreaAndCircumference.setCircumference(circumference);
        return new ApiResponse(true, "The calculation was completed successfully.", circleAreaAndCircumference);
    }

}
