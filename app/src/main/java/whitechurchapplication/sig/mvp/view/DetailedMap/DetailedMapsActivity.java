package whitechurchapplication.sig.mvp.view.DetailedMap;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.view.ViewTreeObserver;
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
    SlidingUpPanelLayout layout;
    TextView textView1,textView2,textView3,textView4;
    CardView cardView;
    public int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        detailMap = new DetailMapPresenterImpl(this);
        layout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);

        cardView = (CardView) findViewById(R.id.card_view1);
        textView1 = (TextView) findViewById(R.id.MapsPanelTextViewName);
        textView2 = (TextView) findViewById(R.id.MapsPanelTextView22);
        textView3 = (TextView) findViewById(R.id.MapsPanelTextView32);
        textView4 = (TextView) findViewById(R.id.MapsPanelTextView42);
        Intent intent = getIntent();
        id = intent.getIntExtra("showId", -1);

        Location location = detailMap.findLocById(id);
        textView1.setText(location.getName());
        textView2.setText(location.getAddress());
        textView3.setText(location.getPhone());
        textView4.setText("No info");

        cardView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                cardView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                layout.setPanelHeight(cardView.getHeight()); //height is ready
            }
        });

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        googleMap.setOnMarkerClickListener(this);

            Location location = detailMap.findLocById(id);

            LatLng bilaCerkva1 = new LatLng(location.getLatitude(), location.getLongitude());
            Marker marker = mMap.addMarker(new MarkerOptions().position(bilaCerkva1).title(location.getName()));
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

        marker.showInfoWindow();


        return true;
    }
}
