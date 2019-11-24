package com.hariobudiharjo.destiny.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.hariobudiharjo.destiny.R

class DetailFunStudyActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var markerSydney: Unit

    override fun onMarkerClick(marker: Marker?): Boolean {
        Log.d("MARKER", marker.toString())

        if (marker!!.equals(markerSydney)) {
            Log.d("MARKER", "Sydney")
        }
        return true
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!
        mMap.setOnMarkerClickListener(this)
        this.title = "Detail Fun Study"
        val sydney = LatLng(-7.982854, 112.637732)
        markerSydney = mMap.addMarker(MarkerOptions().position(sydney).title("Wisata Air, Batu").snippet("Indonesia"))
            .showInfoWindow()
        val zoomLevel = 16.0f //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng, zoomLevel));
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_fun_study)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapdetaildestination) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
}
