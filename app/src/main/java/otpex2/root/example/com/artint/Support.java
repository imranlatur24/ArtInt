package otpex2.root.example.com.artint;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Support extends BaseActivity implements OnMapReadyCallback
{
    private GoogleMap mMap;
    Toolbar toolbar_support;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        init();
    }

    private void init()
    {
        toolbar_support = findViewById(R.id.toolbar_support);
        setSupportActionBar(toolbar_support);
        getSupportActionBar().setTitle(R.string.support);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng location = new LatLng(18.4435115, 73.8009392);
        mMap.addMarker(new MarkerOptions().position(location).title(getResources().getString(R.string.app_name)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location,17));
        mMap.setBuildingsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(false);
        mMap.getUiSettings().setMapToolbarEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
          int id = item.getItemId();

        if(id == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
