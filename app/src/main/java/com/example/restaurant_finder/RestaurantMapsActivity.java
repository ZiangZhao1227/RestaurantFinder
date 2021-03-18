package com.example.restaurant_finder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restaurant_finder.Classes.Restaurant;
import com.example.restaurant_finder.Classes.RestaurantLocation;
import com.example.restaurant_finder.MapModule.DirectionsJSONParser;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.content.Context.LOCATION_SERVICE;
import static com.example.restaurant_finder.MainActivity.RESTAURANT_ID;
import static com.example.restaurant_finder.MainActivity.helper;

/**
 * The type Restaurant maps activity.
 *
 * @author Gajalakshan Chandrasegaran
 * @date 05.03.2020  This RestaurantDetails Activity, for getting and displaying the Restaurant information.
 */
public class RestaurantMapsActivity extends AppCompatActivity implements OnMapReadyCallback,LocationListener {
    private int resID;
    private SupportMapFragment mapFragment;
    private GoogleMap mMap;
    private LatLng origin = new LatLng(60.224441, 24.758224);
    private LatLng dest;
    /**
     * The constant MY_PERMISSIONS_REQUEST_LOCATION.
     */
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private ProgressDialog progressDialog;
    private RestaurantLocation restaurantLocation;
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_maps);

        Bundle b = getIntent().getExtras();
        resID = b.getInt(RESTAURANT_ID, 0); // getting restaurant id

        restaurantLocation = helper.getRestaurantLocationByID(resID);
        dest = new LatLng(restaurantLocation.getRestaurantLatitude(), restaurantLocation.getRestaurantLongitude());

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    private void drawPolylines() {

       // Checks, whether start and end locations are captured
        // Getting URL to the Google Directions API
        String url = getDirectionsUrlByAPI(origin, dest);
        Log.d("url", url + "");
        DownloadTask downloadTask = new DownloadTask();
        // Start downloading json data from Google Directions API
        downloadTask.execute(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions()
                .position(origin)
                .title("Current Location")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        Restaurant restaurant = helper.getRestaurantsByID(resID);

        googleMap.addMarker(new MarkerOptions()
                .title(restaurant.getName())
                .position(dest));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(origin, 15));

    }

    /**
     * Btn draw path on click.
     *
     * @param v the v
     */
    public void btnDrawPathOnClick(View v){
        progressDialog = new ProgressDialog(RestaurantMapsActivity.this);
        progressDialog.setMessage("Please Wait, Loading location.");
        progressDialog.setCancelable(false);
        progressDialog.show();
        drawPolylines();
    }

    /**
     * Btn restaurant location.
     *
     * @param v the v
     */
    public void btnRestaurantLocation(View v){
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dest, 15));
    }

    @Override
    public void onLocationChanged(Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        LatLng latLng = new LatLng(latitude, longitude);
        if (location.getLatitude() != 0){
            origin = latLng;
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude","status");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude","Disabled");
    }

    private class DownloadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... url) {
            String data = "";
            try {
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            ParserTask parserTask = new ParserTask();
            parserTask.execute(result);
            final JSONObject json;
            try {
                json = new JSONObject( result);
                JSONArray routeArr = json.getJSONArray("routes");
                JSONObject routesInfo = routeArr.getJSONObject(0);

                JSONArray newTempArr = routesInfo.getJSONArray("legs");
                JSONObject newDistance_Duration_ob = newTempArr.getJSONObject(0);

                JSONObject distanceOb = newDistance_Duration_ob.getJSONObject("distance");
                JSONObject durationOb = newDistance_Duration_ob.getJSONObject("duration");
                String distance = distanceOb.getString("text");
                String duration = durationOb.getString("text");
                ((TextView) findViewById(R.id.tvDistance)).setText(distance.toString());
                ((TextView) findViewById(R.id.tvDuration)).setText(duration.toString());
                if(!distance.isEmpty()){
                    progressDialog.hide();
                }
                Log.i("Diatance :", distanceOb.getString("text"));
                Log.i("Time :", durationOb.getString("text"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * A class to parse the Google Places in JSON format
     */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;
            try {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points;
            PolylineOptions lineOptions = null;

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<>();
                lineOptions = new PolylineOptions();
                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);
                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);
                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);
                    points.add(position);
                }
                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(10);
                lineOptions.color(Color.RED);
                Log.d("onPostExecute","onPostExecute line options decoded");

            }
            // Drawing polyline in the Google Map for the i-th route
            if(lineOptions != null) {
                mMap.addPolyline(lineOptions);
            }
            else {
                Log.d("onPostExecute","without Poly lines drawn");
            }
        }
    }

    private String getDirectionsUrlByAPI(LatLng origin, LatLng destination) {
        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        // Destination of route
        String str_dest = "destination=" + destination.latitude + "," + destination.longitude;
        // Sensor enabled
        String sensor = "sensor=false";
        // API key
        String api = getString(R.string.google_maps_key);
        String mode = "mode=driving";
        // Building the parameters to the web service
        String para = str_origin + "&" + str_dest + "&" + sensor + "&" + mode+ "&"+ "&key="+api;
        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/json?" + para;
        return url;
    }

    /**
     * A method to download json data from url
     */
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            iStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            data = sb.toString();
            br.close();
            Log.d("data", data);

        } catch (Exception e) {
            Log.d("Exception", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
}
