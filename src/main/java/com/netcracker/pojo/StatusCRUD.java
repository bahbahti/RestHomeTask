package com.netcracker.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;

@Data
public class StatusCRUD {

    @JsonProperty("Status of operation")
    private String description;

    public StatusCRUD() {
    }

    public StatusCRUD(String description) {
        this.description = description;
    }

}
