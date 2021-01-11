package com.tutorial.machinetest.map

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tutorial.machinetest.R
import com.tutorial.machinetest.activity.MainScreen

class MainActivity : FragmentActivity(), OnMapReadyCallback {
    var currentLocation: Location? = null
    var fusedLocationProviderClient: FusedLocationProviderClient? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        fetchLocation()
    }

    private fun fetchLocation() {
        if (ActivityCompat.checkSelfPermission(
                        this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_CODE)
            return
        }
        val task = fusedLocationProviderClient!!.lastLocation
        task.addOnSuccessListener { location ->
            if (location != null) {
                currentLocation = location
                Toast.makeText(applicationContext, currentLocation!!.latitude.toString() + "" + currentLocation!!.longitude, Toast.LENGTH_SHORT).show()
                val supportMapFragment = (supportFragmentManager.findFragmentById(R.id.myMap) as SupportMapFragment?)!!
                supportMapFragment.getMapAsync(this@MainActivity)
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val latLng = LatLng(currentLocation!!.latitude, currentLocation!!.longitude)
        val markerOptions = MarkerOptions().position(latLng).title("I am here!")
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5f))
        googleMap.addMarker(markerOptions)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_CODE -> if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fetchLocation()
            }
        }
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes) { arg0, arg1 ->
                    val intent = Intent(this@MainActivity, MainScreen::class.java)
                    startActivity(intent)
                }.create().show()
    }

    companion object {
        private const val REQUEST_CODE = 101
    }
}