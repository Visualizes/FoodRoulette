package com.example.ramik.foodroulette;

import java.io.Serializable;

/**
 * Created by Rami on 1/18/2016.
 */
public class UserChoices implements Serializable {

    private String transportChoice;
    int dollarChoice;
    private String restaurantTypeChoice;
    private String styleOfFoodChoice;
    private String placeId;

    public UserChoices(String placeId) {
        this.placeId = placeId;
    }

    public UserChoices(String placeId, String transportChoice, int dollarChoice, String restaurantTypeChoice, String styleOfFoodChoice) {
        this.placeId = placeId;
        this.transportChoice = transportChoice;
        this.dollarChoice = dollarChoice;
        this.restaurantTypeChoice = restaurantTypeChoice;
        this.styleOfFoodChoice = styleOfFoodChoice;
    }

    public String getTransportChoice() {
        return transportChoice;
    }

    public int getDollarChoice() {
        return dollarChoice;
    }

    public String getRestaurantTypeChoice() {
        return restaurantTypeChoice;
    }

    public String getStyleOfFoodChoice() {
        return styleOfFoodChoice;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId){
        this.placeId = placeId;
    }

    public void setTransportChoice(String transportChoice){
        this.transportChoice = transportChoice;
    }

    public void setDollarChoice(int dollarChoice){
        this.dollarChoice = dollarChoice;
    }

    public void setRestaurantTypeChoice(String restaurantTypeChoice){
        this.restaurantTypeChoice = restaurantTypeChoice;
    }

    public void setStyleOfFoodChoice(String styleOfFoodChoice){
        this.styleOfFoodChoice = styleOfFoodChoice;
    }
}
