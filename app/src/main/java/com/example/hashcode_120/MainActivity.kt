package com.example.hashcode_120

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() ,OnMapReadyCallback{
    private var mGoogleMap:GoogleMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap

        googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID;

        val zoomLevel = 17f;

        val bangalore = LatLng(12.9351, 77.5360)

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bangalore, zoomLevel));

        googleMap.addMarker(MarkerOptions().position(bangalore).title("Bangalore"))
    }
}