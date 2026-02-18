package com.app.labbca6thsem;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] planetaryItems = { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };
    int[] planetIcons = { R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerAdapter adapter = new RecyclerAdapter(planetaryItems, planetIcons,
                new RecyclerAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(String itemName) {
                        Toast.makeText(RecyclerViewActivity.this, "Clicked: " + itemName, Toast.LENGTH_SHORT).show();
                    }
                });

        recyclerView.setAdapter(adapter);
    }
}
