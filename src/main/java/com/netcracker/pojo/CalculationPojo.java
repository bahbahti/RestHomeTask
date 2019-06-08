package com.netcracker.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CalculationPojo {

    @JsonProperty("Number a")
    private Double a;

    @JsonProperty("Number b")
    private Double b;

    @JsonProperty("Result")
    private Double result;

    public CalculationPojo() {
    }

    public CalculationPojo(Double a, Double b, Double result) {
        this.a = a;
        this.b = b;
        this.result = result;
    }
}
