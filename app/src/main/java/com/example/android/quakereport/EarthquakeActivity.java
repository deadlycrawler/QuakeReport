package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        //public Earthquake(double magnatude, String location, String date)
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();


        // Find a reference to the {@link ListView} in the layout
        EarthquakeAdapter adapter = new EarthquakeAdapter(this,earthquakes);
        ListView earthquakeListView = (ListView) findViewById(R.id.list);
        earthquakeListView.setAdapter(adapter);


        //JSON test
//        String candyJson = "{\"candies\":{[\"name\":\"Jelly Beans\",\"count\":10}]}";
//
//        try {
//            JSONObject root = new JSONObject(candyJson);
//
//            JSONArray candiesArray = root.getJSONArray("candies");
//
//            JSONObject firstCandy = candiesArray.getJSONObject(0);
//
//            String name = firstCandy.getString("name");
//            int count= firstCandy.getInt("count");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


    }
}
