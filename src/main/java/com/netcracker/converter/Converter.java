package com.netcracker.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netcracker.pojo.CalculationPojo;
import com.netcracker.pojo.StatusCRUD;
import org.springframework.stereotype.Repository;

import java.io.IOException;


@Repository
public class Converter {


    public String convertPojoToJSON(String description) {
        StatusCRUD pojo = new StatusCRUD(description);
        String jsonString = "";

        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    public String convertPojoToJSONForCalculations(Double a, Double b, Double result) {
        CalculationPojo calculationPojo = new CalculationPojo(a, b, result);
        String jsonString = "";

        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(calculationPojo);
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonString;
    }
}
