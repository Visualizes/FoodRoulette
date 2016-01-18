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
public class TransportSelectionActivity extends Activity {

    private String transportationChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportationselection);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                transportationChoice = new TransportSelectionRadioButtons(checkedId).getChoice();
            }
        });

        Button nextButton = (Button) findViewById(R.id.nextButtonTS);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (transportationChoice != null) {
                    UserChoices userChoices = new UserChoices(transportationChoice);
                    Intent i = new IntentNavigation(TransportSelectionActivity.this, PriceRangeActivity.class, userChoices).getIntent();
                    startActivity(i);
                } else {
                    Toast.makeText(TransportSelectionActivity.this, "Please select a mode of transportation.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button backButton = (Button) findViewById(R.id.backButtonTS);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
