package com.app.app.model;

import lombok.*;

@Getter
@Setter
@ToString
public class CityModel {
    private String name;
    private CountryModel country;
}
