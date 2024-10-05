package com.eliza.testing.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Название книги не должно быть пустым")
    @Column(name = "city_name", unique = true)
    private String cityName;

    public City() {

    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
