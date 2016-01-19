package com.example.ramik.foodroulette;

import java.io.Serializable;

/**
 * Created by Rami on 1/18/2016.
 */
public class UserChoices implements Serializable {

    private String transportChoice;
    private double startingPrice;
    private double endingPrice;
    private String restaurantTypeChoice;
    private String styleOfFoodChoice;

    public UserChoices(String transportChoice) {
        this.transportChoice = transportChoice;
    }

    public UserChoices(String transportChoice, double startingPrice, double endingPrice) {
        this.transportChoice = transportChoice;
        this.startingPrice = startingPrice;
        this.endingPrice = endingPrice;
    }

    public UserChoices(String transportChoice, double startingPrice, double endingPrice, String restaurantTypeChoice) {
        this.transportChoice = transportChoice;
        this.startingPrice = startingPrice;
        this.endingPrice = endingPrice;
        this.restaurantTypeChoice = restaurantTypeChoice;
    }

    public UserChoices(String transportChoice, double startingPrice, double endingPrice, String restaurantTypeChoice, String styleOfFoodChoice) {
        this.transportChoice = transportChoice;
        this.startingPrice = startingPrice;
        this.endingPrice = endingPrice;
        this.restaurantTypeChoice = restaurantTypeChoice;
        this.styleOfFoodChoice = styleOfFoodChoice;
    }

    public String getTransportChoice() {
        return transportChoice;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public double getEndingPrice() {
        return endingPrice;
    }

    public String getRestaurantTypeChoice() {
        return restaurantTypeChoice;
    }

    public String getStyleOfFoodChoice() {
        return styleOfFoodChoice;
    }
}
