package com.zappos.restapi.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "menus")
@Data
public class Menu {
    String name;
    String type;
    List<MenuItem> menuItems;
}
