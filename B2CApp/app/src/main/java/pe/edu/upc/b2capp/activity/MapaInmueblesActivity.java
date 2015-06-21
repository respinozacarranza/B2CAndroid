package pe.edu.upc.b2capp.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.location.Criteria;
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
import pe.edu.upc.b2capp.fragment.MapaInmueblesFragment;

/**
 * Created by Renato on 6/20/2015.
 */
public class MapaInmueblesActivity extends BaseActivity{

    //private MapaInmueblesFragment fragmentMapa;

    GoogleMap googleMap;

    LocationManager locationManager;


    String bbb;
    Location myLocation;
    double lat;
    double lon;
    LatLng ll;
    MarkerOptions options;
    Marker marker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_inmuebles);


        locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        bbb = locationManager.GPS_PROVIDER;
        myLocation = locationManager.getLastKnownLocation(bbb);
        //myLocation = new Location(locationManager.getLastKnownLocation(bbb));
        //myLocation = locationManager.getLastKnownLocation(bbb);

        lat = myLocation.getLatitude();
        lon = myLocation.getLongitude();

        ll = new LatLng(lat,lon);

        createMapView();
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ll,20));

        //addMarker();
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
