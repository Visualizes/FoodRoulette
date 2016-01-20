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

    public UserChoices(String transportChoice) {
        this.transportChoice = transportChoice;
    }

    public UserChoices(String transportChoice, int dollarChoice) {
        this.transportChoice = transportChoice;
        this.dollarChoice = dollarChoice;
    }

    public UserChoices(String transportChoice, int dollarChoice, String restaurantTypeChoice) {
        this.transportChoice = transportChoice;
        this.dollarChoice = dollarChoice;
        this.restaurantTypeChoice = restaurantTypeChoice;
    }

    public UserChoices(String transportChoice, int dollarChoice, String restaurantTypeChoice, String styleOfFoodChoice) {
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
}
