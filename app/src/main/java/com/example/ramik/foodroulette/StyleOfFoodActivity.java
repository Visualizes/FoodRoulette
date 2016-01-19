package com.example.ramik.foodroulette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rami on 1/18/2016.
 */
public class StyleOfFoodActivity extends Activity {

    private List<String> mock = new ArrayList<>();
    private UserChoices userChoices;
    private String styleOfFoodChoice;
    private List<String> finalMock;

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
        final StyleOfFoodAdapter styleOfFoodAdapter = new StyleOfFoodAdapter(StyleOfFoodActivity.this, mock);
        listView.setAdapter(styleOfFoodAdapter);

        final EditText styleInput = (EditText) findViewById(R.id.styleInput);
        final StyleOfFoodSearch styleOfFoodSearch = new StyleOfFoodSearch(mock, listView, this, styleOfFoodAdapter);
        styleInput.addTextChangedListener(styleOfFoodSearch);

        final Button nextButton = (Button) findViewById(R.id.nextButtonSOF);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!styleOfFoodAdapter.getIsSelected()) {
                    //if they didn't click anything (they picked random)
                    Log.d("Random", "confirmed");
                    int range = mock.size();
                    int random = (int) (Math.random() * range);
                    styleOfFoodChoice = mock.get(random);
                }
                else{
                    int position = styleOfFoodAdapter.getPosition();
                    List<String> updatedSearchList = styleOfFoodSearch.getUpdatedSearchList();
                    styleOfFoodChoice = updatedSearchList.get(position);
                }

                userChoices = new UserChoices(userChoices.getTransportChoice(), userChoices.getStartingPrice(), userChoices.getEndingPrice(), userChoices.getRestaurantTypeChoice(), styleOfFoodChoice);
                Intent i = new IntentNavigation(StyleOfFoodActivity.this, MainActivity.class, userChoices).getIntent();
                startActivity(i);

            }
        });

    }
}