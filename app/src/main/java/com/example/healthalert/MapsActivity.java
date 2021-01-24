package com.example.healthalert;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.healthalert.Bll.LongitudeLongitude;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        List<LongitudeLongitude> latLngs = new ArrayList<>();
        latLngs.add(new LongitudeLongitude(27.6752823, 85.30457129999999, "Grande City Pharmacy"));
        latLngs.add(new LongitudeLongitude(27.7482321, 85.35379050000002, "SNH PHARMACIA"));
        latLngs.add(new LongitudeLongitude(27.7086437, 85.3114033, "Ideal Pharmacy"));
        latLngs.add(new LongitudeLongitude(27.6849369, 85.3076332, "Bir Pharmecy"));
        latLngs.add(new LongitudeLongitude(27.6611609, 85.3191908, "Ideal Pharma"));
        latLngs.add(new LongitudeLongitude(27.7268856,85.3309268,  "Tesla Pharmacy Pvt."));
        latLngs.add(new LongitudeLongitude(27.7317887, 85.3069783, "Caterpillar my pharmacy"));
        latLngs.add(new LongitudeLongitude(27.7314981,85.3268251, "ACME Pharmacy Pvt. Ltd."));
        latLngs.add(new LongitudeLongitude(27.7207977,85.3061903,  "Kripa Pharmacy"));
        latLngs.add(new LongitudeLongitude(27.6717679,85.3451101,  "Narephant Pharmacy"));
        CameraUpdate center, zoom;
        for (int i = 0; i < latLngs.size(); i++) {
            center =
                    CameraUpdateFactory.newLatLng(new LatLng(latLngs.get(i).getLat(),
                            latLngs.get(i).getLon()));
            zoom =
                    CameraUpdateFactory.zoomTo(16);
            mMap.addMarker(new MarkerOptions().position(new LatLng(latLngs.get(i).getLat(),
                    latLngs.get(i).getLon())).title(latLngs.get(i).getMarker()));

            mMap.moveCamera(center);
            mMap.animateCamera(zoom);
            mMap.getUiSettings().setZoomControlsEnabled(true);

        }
    }
}