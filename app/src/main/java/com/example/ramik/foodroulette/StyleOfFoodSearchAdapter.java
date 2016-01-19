package com.example.ramik.foodroulette;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rami on 1/18/2016.
 */
public class StyleOfFoodSearchAdapter extends ArrayAdapter<String> {

    private List<String> items;
    private TextView tvHolder;
    private boolean isSelected;
    private int pos;

    public StyleOfFoodSearchAdapter(Context context, List<String> items) {
        super(context, 0, items);
        this.items = items;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_searchresult, parent, false);
        }

        final TextView searchResult = (TextView) convertView.findViewById(R.id.searchResult);
        searchResult.setText(items.get(position));
        searchResult.setOnClickListener(  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvHolder != null) { //every click afterwards
                    isSelected = true;
                    tvHolder.setBackgroundColor(Color.TRANSPARENT);
                    v.setBackgroundColor(Color.YELLOW);
                    tvHolder = searchResult;
                    pos = position;
                }
                else { //first click
                    isSelected = true;
                    v.setBackgroundColor(Color.YELLOW);
                    tvHolder = searchResult;
                    pos = position;

                }
            }
        });
        return convertView;
    }

    public int getPos() {
        return pos;
    }

    public List<String> getItems() {
        return items;
    }

    public boolean getIsSelected(){
        return isSelected;
    }
}
