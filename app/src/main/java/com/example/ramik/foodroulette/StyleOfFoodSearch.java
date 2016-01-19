package com.example.ramik.foodroulette;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
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
    public String styleOfFoodChoice;

    public StyleOfFoodSearch(List<String> mock, ListView listView, Context context){
        this.mock = mock;
        this.listView = listView;
        this.context = context;
    }


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

        StyleOfFoodAdapter styleOfFoodAdapter = new StyleOfFoodAdapter(context, mockUpdated);
        listView.setAdapter(styleOfFoodAdapter);

        styleOfFoodChoice = mockUpdated.get(styleOfFoodAdapter.getPos());
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    public String getStyleOfFoodChoice(){
        return styleOfFoodChoice;
    }

}
