package whitechurchapplication.sig.mvp.view.DetailedMap;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.List;

import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.model.entities.Location;
import whitechurchapplication.sig.mvp.model.entities.MarkerInfo;
import whitechurchapplication.sig.mvp.presenter.DetailMapContract;
import whitechurchapplication.sig.mvp.presenter.DetailMapPresenterImpl;
import whitechurchapplication.sig.mvp.presenter.MapsContract;

public  class DetailedMapsActivity extends FragmentActivity implements OnMapReadyCallback, MapsContract.MapsView, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    DetailMapContract detailMap;
    SlidingUpPanelLayout Mainlayout;
    SlidingUpPanelLayout layout;
    TextView textView1,textView2,textView3,textView4;
    public int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        detailMap = new DetailMapPresenterImpl(this);
        Mainlayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        layout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);


        textView1 = (TextView) findViewById(R.id.MapsPanelTextView11);
        textView2 = (TextView) findViewById(R.id.MapsPanelTextView21);
        textView3 = (TextView) findViewById(R.id.MapsPanelTextView31);
        textView4 = (TextView) findViewById(R.id.MapsPanelTextView41);
        Intent intent = getIntent();
        id = intent.getIntExtra("showId", -1);

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        googleMap.setOnMarkerClickListener(this);

            Location location = detailMap.findLocById(id);

            LatLng bilaCerkva1 = new LatLng(location.getLatitude(), location.getLongitude());
            Marker marker = mMap.addMarker(new MarkerOptions().position(bilaCerkva1).title(location.getName()));

            MarkerInfo markerInfo = new MarkerInfo();
            markerInfo.setLatitude(location.getLatitude());
            markerInfo.setLongitude(location.getLongitude());
            markerInfo.setName(location.getName());
            marker.setTag(markerInfo);

            onMarkerClick(marker);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(bilaCerkva1));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(13), 2000, null);




    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setMarkerInfo(List<MarkerInfo> markerInfo) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        MarkerInfo markerInfo = (MarkerInfo) marker.getTag();

        textView1.setText(markerInfo.getAdress());
        textView2.setText(markerInfo.getPhone());
        textView3.setText(markerInfo.getName());
        textView4.setText(markerInfo.getName());
        int myColor = Color.argb(127, 255, 0, 255);
        textView1.setTextColor(myColor);

        marker.showInfoWindow();
        LatLng moveTo = new LatLng(markerInfo.getLatitude(), markerInfo.getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(moveTo));

        Mainlayout.setPanelHeight(100);
        layout.setPanelHeight(100);

        return true;
    }
}
