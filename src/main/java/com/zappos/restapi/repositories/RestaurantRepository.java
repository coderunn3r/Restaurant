package com.zappos.restapi.repositories;


import com.zappos.restapi.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, String> {
    @Override
    Restaurant findOne(String id);

    @Override
    void delete(Restaurant deleted);
}
