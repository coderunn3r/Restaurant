package com.zappos.restapi.controllers;

import com.zappos.restapi.models.Restaurant;
import com.zappos.restapi.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;

    @RequestMapping("/")
    public String index() {
        return "Welcome to online food ordering system!";
    }


    @RequestMapping(method=RequestMethod.GET, value="/restaurants")
    public Iterable<Restaurant> restaurant() {
        return restaurantRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/restaurants")
    public String save(@RequestBody Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return restaurant.getId();
    }

    @RequestMapping(method=RequestMethod.GET, value="/restaurants/{id}")
    public Restaurant get(@PathVariable String id) {
        return restaurantRepository.findOne(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/restaurants/{id}")
    public Restaurant update(@PathVariable String id, @RequestBody Restaurant restaurant) {
        Restaurant res = restaurantRepository.findOne(id);
        if(restaurant.getRestaurantName() != null)
            res.setRestaurantName(restaurant.getRestaurantName());
        if(restaurant.getRestaurantDescription() != null)
            res.setRestaurantDescription(restaurant.getRestaurantDescription());
        if(restaurant.getCuisine() != null)
            res.setCuisine(restaurant.getCuisine());
        if(restaurant.getLocation() != null)
            res.setLocation(restaurant.getLocation());
        if(restaurant.getMenus() != null)
            res.setMenus(restaurant.getMenus());
        restaurantRepository.save(res);
        return res;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/restaurants/{id}")
    public String remove(@PathVariable String id) {
        Restaurant res = restaurantRepository.findOne(id);
        restaurantRepository.delete(res);
        return "Restaurant deleted:" + id;
    }
}