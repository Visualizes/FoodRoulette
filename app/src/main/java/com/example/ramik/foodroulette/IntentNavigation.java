package com.example.ramik.foodroulette;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Rami on 1/18/2016.
 */
public class IntentNavigation {

    public Intent i;

    public IntentNavigation(Context from, Class to, UserChoices userChoices ){
        i = new Intent(from, to);
        i.putExtra("UserChoices", userChoices);
    }

    public Intent getIntent(){
        return i;
    }
}
