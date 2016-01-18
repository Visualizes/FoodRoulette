package com.example.ramik.foodroulette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                String startingPrice = startingPriceInput.getText().toString();
                String endingPrice = endingPriceInput.getText().toString();

                if (startingPrice != null && endingPrice != null){
                    userChoices = new UserChoices(userChoices.getTransportChoice(), Integer.valueOf(startingPrice), Integer.valueOf(endingPrice));
                    Log.d("LOG", userChoices.getTransportChoice());
                    Intent i = new IntentNavigation(PriceRangeActivity.this, RestaurantTypeActivity.class, userChoices).getIntent();
                    startActivity(i);
                }
            }
        });
    }
}
