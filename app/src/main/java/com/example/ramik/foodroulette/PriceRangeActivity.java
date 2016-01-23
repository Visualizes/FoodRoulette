package com.example.ramik.foodroulette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rami on 1/18/2016.
 */
public class PriceRangeActivity extends Activity {

    private UserChoices userChoices;
    private int dollarChoice = 0;


    private TextView dollarOne;
    private TextView dollarTwo;
    private TextView dollarThree;
    private TextView dollarFour;

    private int green;
    private int gray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pricerange);

        Bundle extras = getIntent().getExtras();
        userChoices = (UserChoices) extras.get("UserChoices");

        final TextView priceRange = (TextView) findViewById(R.id.priceRange);

        dollarOne = (TextView) findViewById(R.id.dollarOne);
        dollarTwo = (TextView) findViewById(R.id.dollarTwo);
        dollarThree = (TextView) findViewById(R.id.dollarThree);
        dollarFour = (TextView) findViewById(R.id.dollarFour);

        green = getResources().getColor(R.color.green);
        gray = getResources().getColor(R.color.gray);

        dollarOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateColors(true, false, false, false);
                dollarChoice = 1;
                priceRange.setText("$0 - $20");
            }
        });

        dollarTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateColors(true, true, false, false);
                dollarChoice = 2;
                priceRange.setText("$21 - $40");
            }
        });

        dollarThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateColors(true, true, true, false);
                dollarChoice = 3;
                priceRange.setText("$41 - 60");
            }
        });

        dollarFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateColors(true, true, true, true);
                dollarChoice = 4;
                priceRange.setText("$61+");
            }
        });

        Button nextButton = (Button) findViewById(R.id.nextButtonPR);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dollarChoice != 0) {
                    userChoices.setDollarChoice(dollarChoice);
                    Intent i = new IntentNavigation(PriceRangeActivity.this, RestaurantTypeActivity.class, userChoices).getIntent();
                    startActivity(i);
                }
                else{
                    Toast.makeText(PriceRangeActivity.this, "Please select a price range.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button backButton = (Button) findViewById(R.id.backButtonPR);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void updateColors(boolean firstActive, boolean secondActve, boolean thirdActive, boolean fourthActive){
        if (firstActive){
            dollarOne.setBackgroundColor(green);
            dollarTwo.setBackgroundColor(gray);
            dollarThree.setBackgroundColor(gray);
            dollarFour.setBackgroundColor(gray);
        }
        if (secondActve){
            dollarTwo.setBackgroundColor(green);
            dollarThree.setBackgroundColor(gray);
            dollarFour.setBackgroundColor(gray);
        }
        if (thirdActive){
            dollarThree.setBackgroundColor(green);
            dollarFour.setBackgroundColor(gray);
        }
        if (fourthActive){
            dollarFour.setBackgroundColor(green);
        }

    }
}
