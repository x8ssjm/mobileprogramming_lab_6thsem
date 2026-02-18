package com.app.labbca6thsem;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class CustomListViewActivity extends AppCompatActivity {

    ListView listView;
    String[] fruits = { "Apple", "Banana", "Cherry", "Grapes", "Mango", "Orange" };
    int[] icons = { R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        listView = findViewById(R.id.custom_listview);
        CustomAdapter adapter = new CustomAdapter(this, fruits, icons);
        listView.setAdapter(adapter);
    }
}
