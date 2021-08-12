package com.example.lightitupxx.activity.detail

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.lightitupxx.R
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class FragmentMapActivity: AppCompatActivity(), OnMapReadyCallback {
    lateinit var backButton:View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_map)

        backButton = findViewById(R.id.img_mapBack)
//        backButton.setOnClickListener {
//            onBackPressed()
//        }

        //지도 프래그먼트 설정
        // Get the SupportMapFragment and request notification when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
        MapsInitializer.initialize(this);
    }

    override fun onMapReady(googleMap: GoogleMap) {
        Log.d(TAG, "onMapReady: ");
        val sydney = LatLng(-33.852, 151.211)

        googleMap.addMarker(
            MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney")
        )
        val cameraPosition = CameraPosition.builder()
            .target(sydney)
            .zoom(15.0f)
            .build()

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }
}
