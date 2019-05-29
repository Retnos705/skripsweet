package retno.monitorketinggianair;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import retno.monitorketinggianair.Adapter.AdapterDetailGrafik;
import retno.monitorketinggianair.Model.GrafikDataRensponse;
import retno.monitorketinggianair.Model.StatusPerDay;
import retno.monitorketinggianair.Model.StatusPerDayDataResponse;
import retno.monitorketinggianair.Rest.ApiClient;
import retno.monitorketinggianair.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String lokasiId, name;
    public double lat, lng;
    public ApiInterface mApiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        lokasiId = intent.getStringExtra("id");
        name= intent.getStringExtra("name");
        lat = Double.parseDouble(intent.getStringExtra("lat"));
        lng = Double.parseDouble(intent.getStringExtra("lng"));

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        int zoom = 13;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(sydney).title(name));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,zoom));
    }
}
