package com.c4reto3.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="peripheralsDB")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Peripheral {
    @Id
    private String reference;
    private String brand;
    private String category;
    private String description;
    private double price;
    private boolean availability = true;
    private int quantity;
    private String photography;
}
