package com.example.ramik.foodroulette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rami on 1/18/2016.
 */
public class StyleOfFoodActivity extends Activity {

    private List<String> mock = new ArrayList<>();
    private UserChoices userChoices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_styleoffood);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN); //prevents keyboard from popping up on activity creation

        Bundle extras = getIntent().getExtras();
        userChoices = (UserChoices) extras.get("UserChoices");

        mock.add("Watermelon");
        mock.add("Chocolate");
        mock.add("Chinese");
        mock.add("Wade");
        mock.add("Domino");
        mock.add("Dollar");
        mock.add("Dingo");
        mock.add("Eat");
        mock.add("Ether");
        mock.add("Earn");
        mock.add("Language");
        mock.add("Laptop");
        mock.add("Less");

        final ListView listView = (ListView) findViewById(R.id.listView);
        StyleOfFoodAdapter styleOfFoodAdapter = new StyleOfFoodAdapter(StyleOfFoodActivity.this, mock);
        listView.setAdapter(styleOfFoodAdapter);

        final EditText styleInput = (EditText) findViewById(R.id.styleInput);
        final StyleOfFoodSearch styleOfFoodSearch = new StyleOfFoodSearch(mock, listView, this);
        styleInput.addTextChangedListener(styleOfFoodSearch);

        Button nextButton = (Button) findViewById(R.id.nextButtonSOF);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoices = new UserChoices(userChoices.getTransportChoice(), userChoices.getStartingPrice(), userChoices.getEndingPrice(), userChoices.getRestaurantTypeChoice(), styleOfFoodSearch.getStyleOfFoodChoice());
                System.out.println(styleOfFoodSearch.getStyleOfFoodChoice());
                Intent i = new IntentNavigation(StyleOfFoodActivity.this, MainActivity.class, userChoices).getIntent();
                startActivity(i);
            }
        });

    }
}

interface Search{

}