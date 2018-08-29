package com.example.chidi.myapplication2ndone2ndday;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    String[] myCountries = {"china","india","USA","Nigeria"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.myList);

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(MainActivity.this,R.layout.item_layout,R.id.tvList,myCountries);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);

                Toast.makeText(MainActivity.this,
                        "Name of country is: " + item + " at position " + position + " at id " + id,
                        Toast.LENGTH_LONG).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.co.in/maps?q=" + item));

                startActivity(i);

            }
        });
    }
}
