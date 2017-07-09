package com.andri.sample.bottomsheetexample;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "MainActivity";

    private BottomSheetBehavior mBottomSheetBehavior;
    private GoogleMap mMap;
    private SupportMapFragment mapFragment;
    private TextView fareDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View bottomSheet = findViewById( R.id.bottom_sheet );
        fareDetail = (TextView) findViewById(R.id.fare_detail);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setPeekHeight(Utils.dpToPx(this, 190));
        fareDetail.setVisibility(View.GONE);

        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior.setPeekHeight(Utils.dpToPx(MainActivity.this, 190));
                    fareDetail.setVisibility(View.GONE);
                } else fareDetail.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });

        this.mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG, "Google map is ready");
        mMap = googleMap;
        LatLng defaultLoc = new LatLng(-6.175392, 106.827153);
        mMap.setMaxZoomPreference(20f);
        mMap.setMinZoomPreference(5f);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(defaultLoc));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14));
    }
}
