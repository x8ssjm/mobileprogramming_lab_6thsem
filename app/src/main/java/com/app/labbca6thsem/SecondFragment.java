package com.app.labbca6thsem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        Button btn = view.findViewById(R.id.btn_fragment2);
        btn.setOnClickListener(v -> Toast.makeText(getContext(), "Hello from Fragment 2", Toast.LENGTH_SHORT).show());

        return view;
    }
}
