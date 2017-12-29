package com.example.thegreatyahagi.penghitungbbm;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    EditText jrk;
    EditText hrg;
    EditText kns;
    TextView hsl;
    Button jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        jrk = (EditText) findViewById(R.id.jarak);
        hrg = (EditText) findViewById(R.id.harga);
        kns = (EditText) findViewById(R.id.konsumsi);
        hsl = (TextView) findViewById(R.id.hasil);
        jumlah = (Button) findViewById(R.id.hitung);

        jumlah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HasilHitung();
            }
        });
        String opjrk = jrk.getText().toString().trim();
        String ophrg = hrg.getText().toString().trim();
        String opkns = kns.getText().toString().trim();

        Double a = Double.parseDouble(opjrk);
        Double b = Double.parseDouble(ophrg);
        Double c = Double.parseDouble(opkns);
        Double hasill = (c / 100) * a * b;
        hsl.setText("Hasil : " + hasill);


    }

    public void HasilHitung() {

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

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
