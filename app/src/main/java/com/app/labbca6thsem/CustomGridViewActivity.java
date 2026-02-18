package com.app.labbca6thsem;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class CustomGridViewActivity extends AppCompatActivity {

    GridView gridView;
    String[] items = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6" };
    int[] icons = { R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_grid_view);

        gridView = findViewById(R.id.custom_gridview);
        CustomAdapter adapter = new CustomAdapter(this, items, icons);
        gridView.setAdapter(adapter);
    }
}
