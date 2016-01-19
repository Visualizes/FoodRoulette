package com.example.ramik.foodroulette;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rami on 1/18/2016.
 */
public class StyleOfFoodSearch implements TextWatcher {

    private List<String> mock;
    private Context context;
    private ListView listView;
    public List<String> mockUpdated;
    private StyleOfFoodAdapter styleOfFoodAdapter;

    public StyleOfFoodSearch(List<String> mock, ListView listView, Context context, StyleOfFoodAdapter styleOfFoodAdapter){
        this.mock = mock;
        this.listView = listView;
        this.context = context;
        this.styleOfFoodAdapter = styleOfFoodAdapter;
        mockUpdated = mock;
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        mockUpdated = new ArrayList<>();

        Button button = (Button) ((Activity)context).findViewById(R.id.nextButtonSOF);
        button.setText("Pick for me");
        styleOfFoodAdapter.updateIsSelected(false);

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

        StyleOfFoodAdapter styleOfFoodAdapter = new StyleOfFoodAdapter(context, mockUpdated);
        listView.setAdapter(styleOfFoodAdapter);

    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    public List<String> getUpdatedSearchList(){
        return mockUpdated;
    }

}
