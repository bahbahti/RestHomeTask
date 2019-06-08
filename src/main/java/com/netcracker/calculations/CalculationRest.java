package com.netcracker.calculations;


import com.netcracker.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class CalculationRest {

    @Autowired
    Converter converter;

    @GetMapping("/add/{a}/{b}")
    public String addOperation(@PathVariable(value = "a") Double a,
                                       @PathVariable(value = "b") Double b) {
        System.out.println("Result of add operation = " + (a + b));
        return converter.convertPojoToJSONForCalculations(a, b, (a + b));
    }

    @GetMapping("/subtract/{a}/{b}")
    public String subtractOperation(@PathVariable(value = "a") Double a,
                                            @PathVariable(value = "b") Double b) {
        System.out.println("Result of subtract operation = " + (a - b));
        return converter.convertPojoToJSONForCalculations(a, b, (a - b));
    }

    @GetMapping("/multiply/{a}/{b}")
    public String multiplyOperation(@PathVariable(value = "a") Double a,
                                            @PathVariable(value = "b") Double b) {
        System.out.println("Result of multiply operation = " + (a * b));
        return converter.convertPojoToJSONForCalculations(a, b, (a * b));
    }

    @GetMapping("/divide/{a}/{b}")
    public String divideOperation(@PathVariable(value = "a") Double a,
                                            @PathVariable(value = "b") Double b) {
        System.out.println("Result of divide operation = " + (a / b));
        return converter.convertPojoToJSONForCalculations (a, b, (a / b));
    }
}
