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
import whitechurchapplication.sig.mvp.model.entities.MarkerInfo;
import whitechurchapplication.sig.mvp.presenter.MapsContract;
import whitechurchapplication.sig.mvp.presenter.MapsPresenterImpl;

public  class DetailedMapsActivity extends FragmentActivity implements OnMapReadyCallback, MapsContract.MapsView, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    MapsContract.MapsPresenter mMapsPresenter;
    List<MarkerInfo> markerInfoList;
    SlidingUpPanelLayout layout;
    TextView textView;
    Marker marker1;
    public int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mMapsPresenter = new MapsPresenterImpl(this);
        mMapsPresenter.setMapsView(this);
        mMapsPresenter.getMarkerInfo();
        layout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        textView = (TextView) findViewById(R.id.MapsPanelTextView11);
        Intent intent = getIntent();
        id = intent.getIntExtra("showId", -1);

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        googleMap.setOnMarkerClickListener(this);


            LatLng bilaCerkva1 = new LatLng(markerInfoList.get(id).getLatitude(), markerInfoList.get(id).getLongitude());
            Marker marker = mMap.addMarker(new MarkerOptions().position(bilaCerkva1).title(markerInfoList.get(id).getName()));
            marker.setTag(markerInfoList.get(id));

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
        markerInfoList = markerInfo;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        MarkerInfo markerInfo = (MarkerInfo) marker.getTag();
        String markerId = markerInfo.getName();

        textView.setText(markerId);
        int myColor = Color.argb(127, 255, 0, 255);
        textView.setTextColor(myColor);

        marker.showInfoWindow();
        LatLng moveTo = new LatLng(markerInfo.getLatitude(), markerInfo.getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(moveTo));

        layout.setPanelHeight(200);

        return true;
    }
}
