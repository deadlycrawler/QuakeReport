package com.example.android.quakereport;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Earthquake>> {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    private static final String USGS_REQUEST_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=4&limit=20";
    private static final int EARTHQUAKE_LOADER_ID = 1;

    private EarthquakeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

//        EarthquakeAsync task = new EarthquakeAsync();
//        task.execute(USGS_REQUEST_URL);

        LoaderManager loadermanager = getLoaderManager();
        loadermanager.initLoader(EARTHQUAKE_LOADER_ID, null, this);

    }

    private void updateUI(final ArrayList<Earthquake> earthquakes) {

        // Find a reference to the {@link ListView} in the layout
        adapter = new EarthquakeAdapter(this, earthquakes);
        ListView earthquakeListView = (ListView) findViewById(R.id.list);
        earthquakeListView.setAdapter(adapter);


        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Earthquake earthquake = earthquakes.get(position);

                String url = earthquake.getmEarthQuakeURL();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    @Override
    public Loader<List<Earthquake>> onCreateLoader(int i, Bundle bundle) {
        return new EarthquakeLoader(this, USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> earthquakes) {

        updateUI((ArrayList<Earthquake>) earthquakes);
    }

    @Override
    public void onLoaderReset(Loader<List<Earthquake>> loader) {
        adapter.clear();

    }


//
//
//    private class EarthquakeAsync extends AsyncTask<String, Void, ArrayList<Earthquake>> {
//        @Override
//        protected ArrayList<Earthquake> doInBackground(String... urls) {
//
//            final ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes(USGS_REQUEST_URL);
//            return earthquakes;
//        }
//
//        protected void onPostExecute(ArrayList<Earthquake> earthquakes) {
//            updateUI(earthquakes);
//        }
//
//    }


}

