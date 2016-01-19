package com.example.ramik.foodroulette;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rami on 1/18/2016.
 */
public class StyleOfFoodActivity extends Activity {

    private List<String> mock = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_styleoffood);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN); //prevents keyboard from popping up on activity creation

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
        StyleOfFoodSearchAdapter styleOfFoodSearchAdapter = new StyleOfFoodSearchAdapter(StyleOfFoodActivity.this, mock);
        listView.setAdapter(styleOfFoodSearchAdapter);

        final EditText styleInput = (EditText) findViewById(R.id.styleInput);
        styleInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                List<String> mockUpdated = new ArrayList<>();

                for (int i = 0; i < mock.size(); i++){

                    if (mock.get(i).length() > s.length() && s.length() > 0){
                        if (mock.get(i).toLowerCase().substring(0, s.length()).equals(String.valueOf(s).toLowerCase())) {
                            mockUpdated.add(mock.get(i));
                        }
                    }
                    //if there is nothing in the edittext, display the entire arraylist
                    if (s.length() == 0){
                        mockUpdated = mock;
                    }
                }

                listView.setAdapter(new StyleOfFoodSearchAdapter(StyleOfFoodActivity.this, mockUpdated));

            }
            
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }
}

interface Search{

}