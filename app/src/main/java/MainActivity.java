package com.example.roadsafetyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    // 1. AdapterView - RecyclerView
    RecyclerView recyclerView;

    // 2. Data Source
    RoadModel[] myListData;

    // 3. Adapter
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        myListData = new RoadModel[]{
                new RoadModel("Give Way", R.drawable.giveway),
                new RoadModel("No Parking", R.drawable.noparking),
                new RoadModel("Pedastrian Prohibted", R.drawable.prohibited),
                new RoadModel("Cycle Crossing", R.drawable.cyccross)
        };

        //Adapter
        adapter = new MyAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Handling the Click Events
        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        Toast.makeText(this, "Road Sign Name: "+myListData[position].getTitle(), Toast.LENGTH_SHORT).show();
    }
}
