package com.cs2450.intogeek.gps.mapper;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
// import android.widget.Toast;

public class MainActivity extends Activity implements LocationListener {
  private TextView latituteField;
  private TextView longitudeField;
  private TextView currProviderField;
  private TextView currDistanceField;
  private LocationManager locationManager;
  private String provider;
  private static double metersInAMile = 1609.344;
  private double currDistance = 0;
  private Location startLocation;
  private Location currLocation;
  private Location prevLocation;


  
/** Called when the activity is first created. */

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    latituteField = (TextView) findViewById(R.id.TextView02);
    longitudeField = (TextView) findViewById(R.id.TextView04);
    currProviderField = (TextView) findViewById(R.id.TextView06);
    currDistanceField = (TextView) findViewById(R.id.TextView08);
    
   // locationManager.addGpsStatusListener(MainActivity);
    // Get the location manager
    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    // Define the criteria how to select the location provider -> use
    // default
    Criteria criteria = new Criteria();
    criteria.setAccuracy(Criteria.ACCURACY_FINE);
    provider = locationManager.getBestProvider(criteria, true);
    Location location = locationManager.getLastKnownLocation(provider);


    // Initialize the location fields
    if (location != null) {
      System.out.println("Provider " + provider + " has been selected.");
      onLocationChanged(location);
    } else {
      latituteField.setText("Location not available");
      longitudeField.setText("Location not available");
    }
  }

  /* Request updates at startup */
  @Override
  protected void onResume() {
    super.onResume();
    locationManager.requestLocationUpdates(provider, 400, 1, this);
  }

  /* Remove the locationlistener updates when Activity is paused */
  @Override
  protected void onPause() {
    super.onPause();
    locationManager.removeUpdates(this);
  }

  @Override
  public void onLocationChanged(Location location) {
	if (startLocation == null)
		startLocation = new Location(location);
	if (currLocation == null)
		currLocation = new Location(startLocation);
	if (prevLocation == null)
		prevLocation = new Location(currLocation);
	else
		prevLocation.set(currLocation);
	currLocation.set(location);
	currDistance += prevLocation.distanceTo(currLocation);  
	  
    double lat = (location.getLatitude());
    double lng = (location.getLongitude());
    latituteField.setText(String.valueOf(lat));
    longitudeField.setText(String.valueOf(lng));
	currProviderField.setText(String.valueOf(provider));
	currDistanceField.setText(String.valueOf(String.format("%.2f", (currDistance/metersInAMile))));
  }

  @Override
  public void onStatusChanged(String provider, int status, Bundle extras) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onProviderEnabled(String provider) {
	   locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	   if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
	    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,  this);
	   } else {
	      locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
	   } 
//    Toast.makeText(this, "Enabled new provider " + provider,
  //      Toast.LENGTH_SHORT).show();

  }

  @Override
  public void onProviderDisabled(String provider) {
	   locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	   if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
	    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,  this);
	   } else {
	      locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
	   } 
//    Toast.makeText(this, "Disabled provider " + provider,
  //      Toast.LENGTH_SHORT).show();
  }
} 