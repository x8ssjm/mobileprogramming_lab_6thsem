package com.app.labbca6thsem;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be
        // used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Coordinates for Kathmandu (simulated "My Location")
        LatLng myLocation = new LatLng(27.7172, 85.3240);
        mMap.addMarker(new MarkerOptions().position(myLocation).title("My Location"));

        // Two nearest places (e.g., Garden of Dreams and Narayanhiti Palace)
        LatLng place1 = new LatLng(27.7143, 85.3148);
        mMap.addMarker(new MarkerOptions().position(place1).title("Nearest Place 1: Garden of Dreams"));

        LatLng place2 = new LatLng(27.7151, 85.3186);
        mMap.addMarker(new MarkerOptions().position(place2).title("Nearest Place 2: Narayanhiti Palace"));

        // Move the camera to Kathmandu and zoom in
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 15));
    }
}
