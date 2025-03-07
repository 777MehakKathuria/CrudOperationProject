package com.example.task.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "products")
public class Product {
    @Id
    private String id;

    private String name;
    private String description;
    private Double price;
    private Map<String, String> characteristics = new HashMap<>();

    // Default constructor
    public Product() {}

    // Parameterized constructor
    public Product(String name, String description, Double price, Map<String, String> characteristics) {
        this.name = name;
        this.description = description;
        this.price = price != null ? price : 0.0;  // Prevent null price
        this.characteristics = characteristics != null ? new HashMap<>(characteristics) : new HashMap<>();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price != null ? price : this.price;
    }

    public Map<String, String> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Map<String, String> characteristics) {
        if (characteristics != null) {
            this.characteristics.putAll(characteristics); // Merge instead of replacing
        }
    }
}
