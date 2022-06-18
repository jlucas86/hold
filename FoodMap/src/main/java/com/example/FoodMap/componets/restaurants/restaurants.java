package com.example.FoodMap.componets.restaurants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "restaurants")
@Table(
    name = "restaurants"
)
public class restaurants {

    @Id
    @Column(columnDefinition = "serial", 
        name = "id", 
        nullable = false, 
        updatable = false
    )
    @SequenceGenerator(
        name= "restaurants_sequence",
        sequenceName = "restaurants_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "restaurants_sequence"
    )
    private Long id;

    @Column(
        name="restaurant_name",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String restaurant_name;

    @Column(
        name="food_type",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String food_type;

    @Column(
        name="cost",
        nullable = false,
        columnDefinition = "INTEGER"
    )
    private Integer cost;

    @Column(
        name="rating",
        nullable = false,
        columnDefinition = "DECIMAL"
    )
    private Double rating;

    @Column(
        name="address",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String address;

    @Column(
        name="city",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String city;

    @Column(
        name="state",
        nullable = false,
        columnDefinition = "TEXT"
    )
    private String state;

    @Column(
        name="zipcode",
        nullable = false,
        columnDefinition = "INTEGER"
    )
    private Integer zipcode;

    @Column(
        name="phone_number",
        nullable = false,
        columnDefinition = "INTEGER"
    )
    private Long phone_number;


    public restaurants() {
    }

    public restaurants( String restaurant_name, String food_type, Integer cost, Double rating, String address, String city, String state, Integer zipcode, Long phone_number) {
        this.restaurant_name = restaurant_name;
        this.food_type = food_type;
        this.cost = cost;
        this.rating = rating;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone_number = phone_number;
    }


    public restaurants(Long id, String restaurant_name, String food_type, Integer cost, Double rating, String address, String city, String state, Integer zipcode, Long phone_number) {
        this.id = id;
        this.restaurant_name = restaurant_name;
        this.food_type = food_type;
        this.cost = cost;
        this.rating = rating;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone_number = phone_number;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurant_name() {
        return this.restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getFood_type() {
        return this.food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public Integer getCost() {
        return this.cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public Long getPhone_number() {
        return this.phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }
    
}
