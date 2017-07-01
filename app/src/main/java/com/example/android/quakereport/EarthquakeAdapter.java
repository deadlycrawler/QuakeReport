package com.example.android.quakereport;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> Earthquake) {
        super(context, 0, Earthquake);

    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View listItemView = converView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnatude = (TextView)listItemView.findViewById(R.id.magnitude);
        magnatude.setText(Double.toString(currentEarthquake.getmMagnitude()));

        TextView location = (TextView)listItemView.findViewById(R.id.location);
        location.setText(currentEarthquake.getmLocation());

        TextView date = (TextView)listItemView.findViewById(R.id.date);
        date.setText(currentEarthquake.getmDate());


        return listItemView;
    }
}
