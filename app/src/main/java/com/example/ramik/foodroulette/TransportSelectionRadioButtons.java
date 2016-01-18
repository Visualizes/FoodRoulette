package com.example.ramik.foodroulette;

/**
 * Created by Rami on 1/18/2016.
 */
public class TransportSelectionRadioButtons {

    String choice;

    TransportSelectionRadioButtons(int checkedID){
        if (checkedID == R.id.walkButton){
            choice = "Walk";
        }
        if (checkedID == R.id.carButton){
            choice = "Car";
        }
        if (checkedID == R.id.publicTransportButton){
            choice = "Public Transport";
        }
        if (checkedID == R.id.bikeButton){
            choice = "Bike";
        }
    }

    public String getChoice(){
        return choice;
    }
}
