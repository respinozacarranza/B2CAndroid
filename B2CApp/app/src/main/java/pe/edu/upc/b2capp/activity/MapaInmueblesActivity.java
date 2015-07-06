package pe.edu.upc.b2capp.activity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import pe.edu.upc.b2capp.R;

/**
 * Created by Renato on 6/20/2015.
 */
public class MapaInmueblesActivity extends NavDrawerActivity{


    GoogleMap googleMap;

    /*Intent i = this.getIntent();
    Bundle b = i.getExtras();*/
   double latObtenida = 0;
   double lonObtenida = 0;




    //LocationManager locationManager;

    Location location;

    protected LocationManager locationManager;
    String bbb;
    //Location myLocation;
    double lat;
    double lon;
    LatLng ll;
    MarkerOptions options;
    Marker marker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_inmuebles);


       /* Intent i = this.getIntent();
        if(i!=null) {
            Bundle b = i.getExtras();
            latObtenida = b.getDouble("lat");
            lonObtenida = b.getDouble("lon");
        }*/


        locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        bbb = locationManager.GPS_PROVIDER;
        location = locationManager.getLastKnownLocation(bbb);


        if(latObtenida != 0 && lonObtenida !=0){
            lat = latObtenida;
            lon = lonObtenida;
        }
        else{
            lat = -12.1040537;
            lon = -76.9630775;
        }
        //lat = location.getLatitude();//latObtenida;
        //lon = location.getLongitude();//lonObtenida;

        ll = new LatLng(lat,lon);//coordInmueble;
        createMapView();
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ll,17));

        /*addMarker();*/
        options = new MarkerOptions().position(ll).draggable(true).title("Estas aqui!");
        marker = googleMap.addMarker(options);
        marker.showInfoWindow();
        marker.setPosition(ll);





    }

    private void createMapView(){
        try{
            if(null == googleMap){

                googleMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.mapView)).getMap();

                if(null == googleMap){
                    Toast.makeText(getApplicationContext(),"error creating map", Toast.LENGTH_LONG).show();
                }
            }
        }catch(NullPointerException exception){
            Log.e("mapApp",exception.toString());
        }
    }

    private void addMarker(){
        if(null != googleMap){
            googleMap.addMarker(new MarkerOptions().position(new LatLng(0,0)).title("Marker").draggable(true));
        }
    }






}
