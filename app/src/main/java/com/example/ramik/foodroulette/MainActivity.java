package com.example.ramik.foodroulette;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        UserChoices userChoices = (UserChoices) extras.get("UserChoices");

        String transportChoice = userChoices.getTransportChoice();
        double startingPrice = userChoices.getStartingPrice();
        double endingPrice= userChoices.getEndingPrice();
        String restaurantTypeChoice = userChoices.getRestaurantTypeChoice();
        String styleOfFoodChoice = userChoices.getStyleOfFoodChoice();

        System.out.println(transportChoice);
        System.out.println(startingPrice);
        System.out.println(endingPrice);
        System.out.println(restaurantTypeChoice);
        System.out.println(styleOfFoodChoice);

        TextView textView = (TextView) findViewById(R.id.textview);
        textView.setText(transportChoice + ", " + startingPrice + ", " + endingPrice + ", " + restaurantTypeChoice + ", " + styleOfFoodChoice);
    }
}
