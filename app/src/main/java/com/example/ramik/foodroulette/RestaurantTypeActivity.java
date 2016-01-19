package com.example.ramik.foodroulette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Rami on 1/18/2016.
 */
public class RestaurantTypeActivity extends Activity {

    private String restaurantTypeChoice;
    private UserChoices userChoices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restauranttype);

        Bundle extras = getIntent().getExtras();
        userChoices = (UserChoices) extras.get("UserChoices");

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroupRT);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                restaurantTypeChoice = new RestaurantTypeRadioButtons(checkedId).getChoice();
            }
        });

        Button nextButton = (Button) findViewById(R.id.nextButtonRT);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (restaurantTypeChoice != null) {
                    userChoices = new UserChoices(userChoices.getTransportChoice(), userChoices.getStartingPrice(), userChoices.getEndingPrice(), restaurantTypeChoice);
                    Intent i = new IntentNavigation(RestaurantTypeActivity.this, StyleOfFoodActivity.class, userChoices).getIntent();
                    startActivity(i);
                } else {
                    Toast.makeText(RestaurantTypeActivity.this, "Please select a type of restaurant.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
