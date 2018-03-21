package com.example.android.tunevoyage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * Created by James on 3/20/18.
 */

public class SearchActivity extends AppCompatActivity{
    Spinner decadeSpinner;
    Spinner continentSpinner;
    String decadeInput;
    String continentInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_view);

        decadeSpinner = (Spinner) findViewById(R.id.decade_spinner);
        //Create an adapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> decadeAdapter =
                ArrayAdapter.createFromResource(this, R.array.decades_array,
                        android.R.layout.simple_spinner_item);
        //Specify the layout to use when the list of choices appears
        decadeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply the adapter to the spinner
        decadeSpinner.setAdapter(decadeAdapter);


        continentSpinner = (Spinner) findViewById(R.id.continent_spinner);
        //Create an adapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> continentAdapter =
                ArrayAdapter.createFromResource(this, R.array.continent_array,
                        android.R.layout.simple_spinner_item);
        //Specify the layout to use when the list of choices appears
        continentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply the adapter to the spinner
        continentSpinner.setAdapter(continentAdapter);

        ImageView search = (ImageView) findViewById(R.id.search_button);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decadeInput = decadeSpinner.getSelectedItem().toString();
                Log.v("decade: ", decadeInput);

                continentInput = continentSpinner.getSelectedItem().toString();

                Intent searchIntent = new Intent(SearchActivity.this, SongActivity.class);
                searchIntent.putExtra("Decade", decadeInput);
                searchIntent.putExtra("Continent", continentInput);
                startActivity(searchIntent);
            }
        });
    }
}