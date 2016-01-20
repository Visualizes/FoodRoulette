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
        int dollarChoice = userChoices.getDollarChoice();
        String restaurantTypeChoice = userChoices.getRestaurantTypeChoice();
        String styleOfFoodChoice = userChoices.getStyleOfFoodChoice();

        System.out.println(transportChoice);
        System.out.println(dollarChoice);
        System.out.println(restaurantTypeChoice);
        System.out.println(styleOfFoodChoice);

        TextView textView = (TextView) findViewById(R.id.textview);
        textView.setText(transportChoice + ", " + dollarChoice + ", " + restaurantTypeChoice + ", " + styleOfFoodChoice);
    }
}
