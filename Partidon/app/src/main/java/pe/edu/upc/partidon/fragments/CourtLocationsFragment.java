package pe.edu.upc.partidon.fragments;


import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.CompaniesRepository;
import pe.edu.upc.partidon.models.Court;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourtLocationsFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap map;
    private Marker marker;
    private double lat = 0.0;
    private double lng = 0.0;
    private CompaniesRepository courtRepository;
    float   HUE_GREEN;
    AlertDialog alert = null;
    private static View view;


    public CourtLocationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.fragment_court_locations, container, false);
        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }


        courtRepository = new CompaniesRepository(getContext());


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_courts);
        mapFragment.getMapAsync(this);




    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser) {
            LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);


            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                AlertNoGps();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;


        myLocation();
        loadCourtsAsync();
        /*
        LatLng pp = new LatLng(11.5448729, 104.8921668);
        MarkerOptions options = new MarkerOptions();
        options.position(pp).title("Estoy Aqui!");
        map.addMarker(options);
        map.moveCamera(CameraUpdateFactory.newLatLng(pp));
        */
    }

    public void addMarker(double lat, double lng) {
        LatLng coordenadas = new LatLng(lat, lng);
        CameraUpdate MyPosition = CameraUpdateFactory.newLatLngZoom(coordenadas, 16);
        if (marker != null) marker.remove();
        marker = map.addMarker(new MarkerOptions().position(coordenadas).title("Aqui Estoy!"));
        map.animateCamera(MyPosition);

    }

    protected Marker addMarkerCompany(double lat, double lng,String name) {
        return map.addMarker(new MarkerOptions()
                .position(new LatLng(lat, lng))
                .title(name));
    }

    private void updateLocation(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
            addMarker(lat, lng);
        }
    }

    LocationListener locListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            updateLocation(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private void myLocation() {

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        updateLocation(location);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,15000,5000,locListener);
    }

    private void loadCourtsAsync(){
        courtRepository.getCourts(new CompaniesRepository.CourtsCallback() {
            @Override
            public void onComplete(List<Court> courts) {

                for(int i = 0 ; i < courts.size() ; i++ ) {
                    addMarkerCompany(Double.parseDouble(courts.get(i).getLatitude()),Double.parseDouble(courts.get(i).getLength()),courts.get(i).getUser().getName());
                }

            }

            @Override
            public void onError(String message) {
                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void AlertNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("El sistema GPS esta desactivado, ¿Desea activarlo?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }


                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                    }
                });
        alert = builder.create();
        alert.show();
    }
}
