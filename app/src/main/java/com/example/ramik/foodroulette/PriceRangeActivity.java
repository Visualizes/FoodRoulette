package com.example.ramik.foodroulette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Rami on 1/18/2016.
 */
public class PriceRangeActivity extends Activity {

    private UserChoices userChoices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pricerange);

        Bundle extras = getIntent().getExtras();
        userChoices = (UserChoices) extras.get("UserChoices");

        final EditText startingPriceInput = (EditText) findViewById(R.id.startingPrice);
        final EditText endingPriceInput = (EditText) findViewById(R.id.endingPrice);

        Button nextButton = (Button) findViewById(R.id.nextButtonPR);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String startingPrice_STRING = startingPriceInput.getText().toString();
                String endingPrice_STRING = endingPriceInput.getText().toString();
                
                if (!startingPrice_STRING.equals("") && !endingPrice_STRING.equals("")){

                    double startingPrice = Double.parseDouble(startingPrice_STRING);
                    double endingPrice = Double.parseDouble(endingPrice_STRING);

                    if (endingPrice > startingPrice) {
                        userChoices = new UserChoices(userChoices.getTransportChoice(), startingPrice, endingPrice);
                        Intent i = new IntentNavigation(PriceRangeActivity.this, RestaurantTypeActivity.class, userChoices).getIntent();
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(PriceRangeActivity.this, "Make sure the starting price is less than the ending price.", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(PriceRangeActivity.this, "Make sure every box is filled.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
