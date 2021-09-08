package com.shape.shapecalculator.controller;

/*
Created by Ali Artukov
*/

import com.shape.shapecalculator.model.ApiResponse;
import com.shape.shapecalculator.service.ShapeCalcService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ShapeCalcController {

    private final ShapeCalcService shapeCalcService;

    public ShapeCalcController(@NonNull ShapeCalcService shapeCalcService) {
        this.shapeCalcService = shapeCalcService;
    }


    /**
     * Get one side of the square and if the value is positive return the area
     * and the perimeter of the square.
     * @param a Double a
     * @return ResponseEntity<?>
     */
    @GetMapping("/square")
    public ResponseEntity<?> getSquareAreaAndPerimeter(@RequestParam Double a){
        ApiResponse apiResponse = shapeCalcService.getSquareAreaAndPerimeter(a);
        return ResponseEntity.status(
                apiResponse.getSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT
        ).body(apiResponse);
    }


    /**
     * Get the length and width of the rectangle and if the length and width are
     * positive return the area and perimeter of the rectangle.
     * @param length Double length
     * @param width Double length
     * @return ResponseEntity<?>
     */
    @GetMapping("/rectangle")
    public ResponseEntity<?> getRectangleAreaAndPerimeter(@RequestParam Double length, @RequestParam Double width){
        ApiResponse apiResponse = shapeCalcService.getRectangleAreaAndPerimeter(length, width);
        return ResponseEntity.status(
                apiResponse.getSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT
        ).body(apiResponse);
    }


    /**
     * Get a side, b side and c side of the triangle and if the addition of a and
     * c is greater than b return the area and perimeter of the triangle.
     * @param a Double a
     * @param b Double b
     * @param c Double c
     * @return ResponseEntity<?>
     */
    @GetMapping("/triangle")
    public ResponseEntity<?> getTriangleAreaAndPerimeter(@RequestParam Double a, @RequestParam Double b, @RequestParam Double c){
        ApiResponse apiResponse = shapeCalcService.getTriangleAreaAndPerimeter(a, b, c);
        return ResponseEntity.status(
                apiResponse.getSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT
        ).body(apiResponse);
    }


    /**
     * Get radius of the circle and if the value is positive return the area and
     * circumference of the circle.
     * @param radius Double radius
     * @return ResponseEntity<?>
     */
    @GetMapping("/circle")
    public ResponseEntity<?> getCircleAreaAndCircumference(@RequestParam Double radius){
        ApiResponse apiResponse = shapeCalcService.getCircleAreaAndCircumference(radius);
        return ResponseEntity.status(
                apiResponse.getSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT
        ).body(apiResponse);
    }

}
