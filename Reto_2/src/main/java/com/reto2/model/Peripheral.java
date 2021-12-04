package com.reto2.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "peripherals")
public class Peripheral {

    @Id
    private String reference;
    private String category;
    private String description;
    private Double price;
    private Boolean availability;
    private Integer quantity;
    private String photography;
}
