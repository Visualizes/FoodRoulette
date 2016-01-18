package com.example.ramik.foodroulette;

/**
 * Created by Rami on 1/18/2016.
 */
public class RestaurantTypeRadioButtons {

    String choice;

    public RestaurantTypeRadioButtons(int checkedId) {

        if (checkedId == R.id.driveThroughButton) {
            choice = "Drive through";
        }
        if (checkedId == R.id.fastFoodButton) {
            choice = "Fast food";
        }
        if (checkedId == R.id.sitDownButton) {
            choice = "Sit down";
        }
    }

    public String getChoice(){
        return choice;
    }

}
