package com.app.app.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document("places")
public class RestaurantModel implements Serializable {

    @Id
    private String id;

    private String name;

    private String start_time;

    private String end_time;

    private String creation_date;

    private CityModel city;

    private List<MenuModel> menus;

}
