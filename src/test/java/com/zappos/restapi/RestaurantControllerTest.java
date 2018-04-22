package com.zappos.restapi;

import com.zappos.restapi.models.Menu;
import com.zappos.restapi.models.Restaurant;
import com.zappos.restapi.repositories.RestaurantRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void getIndexTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome to online food ordering system!")));
    }

    @Test
    public void getRestaurantsTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/restaurants").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello Kaushik!")));
    }

//    @Test
//    public void getRestaurantTest() throws Exception {
//        List<Menu> menus = new ArrayList<>();
//        Restaurant restaurant=new Restaurant("12345","Olive Garden","Italian Chain","Italian","Seattle",menus);
//        given(restaurantRepository.findOne("12345")).willReturn(restaurant);
//        mvc.perform(MockMvcRequestBuilders.get("/restaurants/" + "12345").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(restaurant.getId())))
//                .andExpect(jsonPath("$.restaurantName", is(restaurant.getRestaurantName())))
//                .andExpect(jsonPath("$.restaurantDescription", is(restaurant.getRestaurantDescription())))
//                .andExpect(jsonPath("$.cuisine", is(restaurant.getCuisine())))
//                .andExpect(jsonPath("$.location", is(restaurant.getLocation())))
//                .andExpect(jsonPath("$.menus", is(restaurant.getMenus())));
//    }

    @Test
    @Ignore
    public void postRestaurantsTest() throws Exception {
        List<Menu> menus = new ArrayList<>();
        Restaurant restaurant=new Restaurant("12345","Olive Garden","Italian Chain","Italian","Seattle",menus);
        mvc.perform(post("/restaurants").accept(MediaType.APPLICATION_JSON).content(restaurant.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(restaurant.getId())));
    }

    @Test
    public void deleteRestaurantTest() throws Exception {
        List<Menu> menus = new ArrayList<>();
        Restaurant restaurant=new Restaurant("12345","Olive Garden","Italian Chain","Italian","Seattle",menus);
        mvc.perform(delete("/restaurants/" + restaurant.getId()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Restaurant deleted:" + restaurant.getId())));
    }

    @Test
    public void notFoundRestaurantTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/restaurants/2").accept(MediaType.APPLICATION_JSON)).andExpect(content().string(equalTo("")));
    }
}