package com.mycompany.talk.Fragments;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mycompany.talk.R;

import java.net.URISyntaxException;


public class MapFragment extends Fragment implements OnMapReadyCallback{

SupportMapFragment mSupportMapFragment;
int radius = 20;
private GoogleMap maps;

LatLng mLatLng;
LocationManager mLocationManager;
LocationListener mLocationListener;
private Button bUpdate;


@Override
public void onStart(){
    super.onStart();
}


    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("http://localhost");


            }catch (URISyntaxException e) {
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        mSocket.connect();

    }

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View v = inflater.inflate(R.layout.fragment_map,container,true);

    mSupportMapFragment = SupportMapFragment.newInstance();
    android.support.v4.app.FragmentManager sfm = getFragmentManager();
    mSupportMapFragment.getMapAsync(this);
    if(!mSupportMapFragment.isAdded())
    sfm.beginTransaction().add(R.id.map_frag,mSupportMapFragment).commit();

   else if(mSupportMapFragment.isAdded())
        sfm.beginTransaction().hide(mSupportMapFragment).commit();
    else
        sfm.beginTransaction().show(mSupportMapFragment).commit();


   // bUpdate = (Button)v.findViewById(R.id.bUpdate);

    mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            if (location != null && maps != null) {

                /*
                Updates to our map may need to be taken place here. Need to listen to other devices in the area.
                 */

                Log.e("Latitude: ", "" + location.getLatitude());
                Log.e("Longitude: ", "" + location.getLongitude());

                maps.clear(); //Clear the map of any  existing markers

                mLatLng = new LatLng(location.getLatitude(),location.getLongitude());
                MarkerOptions mp1 = new MarkerOptions();//Instantiate a new "MarkerOptions" where we will be able to define a...
                                                        //...marker

                mp1.position(mLatLng);
                mp1.title("You");
                maps.addMarker(mp1);//Finally add the marker to the map
                maps.moveCamera(CameraUpdateFactory.newLatLng(mLatLng));//Move camera to markers location using our "latLng" variable
                maps.animateCamera(CameraUpdateFactory.zoomTo(20));// Zoom, (between 2.0 - 21.0) the higher, the more zoomed in

            }
        }
        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }
        @Override
        public void onProviderEnabled(String s) {

        }
        @Override
        public void onProviderDisabled(String s) {

        }
    };

    mLocationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
    mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,mLocationListener);
    //Need more precise coordinates..............
    return v;
}

@Override
public void onMapReady(GoogleMap map) {
    maps = map;
}

    private void attemptSend(){


    }


@Override
public void onResume(){
    Log.e("RESUME","onResume called");
    super.onResume();
}
@Override
public void onStop(){
   // mLocationManager.removeUpdates(mLocationListener);
    Log.e("PAUSE", "Coordinates stopped");
    super.onStop();
}

@Override
public void onPause(){
   // mLocationManager.removeUpdates(mLocationListener);
    Log.e("PAUSE", "Coordinates stopped");
    super.onPause();
 }
}




