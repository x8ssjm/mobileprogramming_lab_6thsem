package com.app.labbca6thsem;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity {

    Button btnFrag1, btnFrag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        btnFrag1 = findViewById(R.id.btn_show_frag1);
        btnFrag2 = findViewById(R.id.btn_show_frag2);

        // Load initial fragment
        loadFragment(new FirstFragment());

        btnFrag1.setOnClickListener(v -> loadFragment(new FirstFragment()));
        btnFrag2.setOnClickListener(v -> loadFragment(new SecondFragment()));
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();
    }
}
