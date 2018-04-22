package com.zappos.restapi.models;

import com.google.gson.Gson;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "restaurants")
@Data
public class Restaurant {
    @Id
    String id;
    String restaurantName;
    String restaurantDescription;
    String cuisine;
    String location;
    List<Menu> menus;

    public Restaurant(String s, String s1, String s2, String s3, String s4, List<Menu> menus) {
        this.id = s;
        this.restaurantName = s1;
        this.restaurantDescription = s2;
        this.restaurantDescription = s3;
        this.cuisine = s4;
        this.menus = menus;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
