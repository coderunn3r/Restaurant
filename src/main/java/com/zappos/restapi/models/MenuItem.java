package com.zappos.restapi.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "menuitems")
@Data
public class MenuItem {
    String name;
    double price;
}