package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        //public Earthquake(double magnatude, String location, String date)
        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        earthquakes.add(new Earthquake(7.2, "San Francisco", "2 Feb 2016"));
        earthquakes.add(new Earthquake(7.2, "San Francisco", "2 Feb 2016"));
        earthquakes.add(new Earthquake(7.2, "San Francisco", "2 Feb 2016"));
        earthquakes.add(new Earthquake(7.2, "San Francisco", "2 Feb 2016"));
        earthquakes.add(new Earthquake(7.2, "San Francisco", "2 Feb 2016"));
        earthquakes.add(new Earthquake(7.2, "San Francisco", "2 Feb 2016"));
        earthquakes.add(new Earthquake(7.2, "San Francisco", "2 Feb 2016"));
        earthquakes.add(new Earthquake(7.2, "San Francisco", "2 Feb 2016"));

        // Find a reference to the {@link ListView} in the layout
        EarthquakeAdapter adapter = new EarthquakeAdapter(this,earthquakes);
        ListView earthquakeListView = (ListView) findViewById(R.id.list);
        earthquakeListView.setAdapter(adapter);



    }
}
