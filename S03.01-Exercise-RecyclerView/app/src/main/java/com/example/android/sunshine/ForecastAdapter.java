package com.example.android.sunshine;


// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
// Done (15) Add a class file called ForecastAdapter
// Done (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>

// Done (23) Create a private string array called mWeatherData

// Done (47) Create the default constructor (we will pass in parameters in a later lesson)

// Done (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
// Done (17) Extend RecyclerView.ViewHolder

// Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
// Done (18) Create a public final TextView variable called mWeatherTextView

// Done (19) Create a constructor for this class that accepts a View as a parameter
// Done (20) Call super(view) within the constructor for ForecastAdapterViewHolder
// Done (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView
// Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////


// Done (24) Override onCreateViewHolder
// Done (25) Within onCreateViewHolder, inflate the list item xml into a view
// Done (26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter

// Done (27) Override onBindViewHolder
// Done (28) Set the text of the TextView to the weather for this list item's position

// Done (29) Override getItemCount
// Done (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null

// Done (31) Create a setWeatherData method that saves the weatherData to mWeatherData
// Done (32) After you save mWeatherData, call notifyDataSetChanged
// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    private String[] mWeatherData;

    public ForecastAdapter() {

    }

    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View itemView) {
            super(itemView);

            mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
        }
    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forecast_list_item, parent, false);

        return new ForecastAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        holder.mWeatherTextView.setText(mWeatherData[position]);
    }

    @Override
    public int getItemCount() {

        if (mWeatherData != null) {
            return mWeatherData.length;
        } else {
            return 0;
        }
    }

    public void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }
}
