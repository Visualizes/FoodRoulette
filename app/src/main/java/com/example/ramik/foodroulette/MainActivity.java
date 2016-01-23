package com.example.ramik.foodroulette;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;

public class MainActivity extends FragmentActivity implements GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient mGoogleApiClient;
    private static final String TAG = LocationSelectionActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        UserChoices userChoices = (UserChoices) extras.get("UserChoices");

        String transportChoice = userChoices.getTransportChoice();
        int dollarChoice = userChoices.getDollarChoice();
        String restaurantTypeChoice = userChoices.getRestaurantTypeChoice();
        String styleOfFoodChoice = userChoices.getStyleOfFoodChoice();
        String placeId = userChoices.getPlaceId();

        System.out.println(transportChoice);
        System.out.println(dollarChoice);
        System.out.println(restaurantTypeChoice);
        System.out.println(styleOfFoodChoice);
        System.out.println(placeId);


        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();


        Places.GeoDataApi.getPlaceById(mGoogleApiClient, placeId)
                .setResultCallback(new ResultCallback<PlaceBuffer>() {
                    @Override
                    public void onResult(PlaceBuffer places) {
                        if (places.getStatus().isSuccess() && places.getCount() > 0) {
                            final Place myPlace = places.get(0);
                            Log.i(TAG, "Place found: " + myPlace.getName());



                        } else {
                            Log.e(TAG, "Place not found");
                        }
                        places.release();
                    }
                });
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // This callback is important for handling errors that
        // may occur while attempting to connect with Google.
        //
        // More about this in the 'Handle Connection Failures' section.
        System.out.println("CONNECTION FAILED");
    }
}
