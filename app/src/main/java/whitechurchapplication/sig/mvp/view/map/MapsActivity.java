package whitechurchapplication.sig.mvp.view.map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.view.View;
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
import whitechurchapplication.sig.mvp.model.entities.MarkerInfo;
import whitechurchapplication.sig.mvp.presenter.MapsContract;
import whitechurchapplication.sig.mvp.presenter.MapsPresenterImpl;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, MapsContract.MapsView, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    MapsContract.MapsPresenter mMapsPresenter;
    List<MarkerInfo> markerInfoList;
    SlidingUpPanelLayout layout;
    TextView textView1,textView2,textView3,textView4;
    CardView cardViewName;
    Marker marker1;
    public int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mMapsPresenter = new MapsPresenterImpl(this);
        mMapsPresenter.setMapsView(this);
        mMapsPresenter.getMarkerInfo();
        layout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        cardViewName = (CardView) findViewById(R.id.card_view1);
        textView1 = (TextView) findViewById(R.id.MapsPanelTextViewName);
        textView2 = (TextView) findViewById(R.id.MapsPanelTextView22);
        textView3 = (TextView) findViewById(R.id.MapsPanelTextView32);
        textView4 = (TextView) findViewById(R.id.MapsPanelTextView42);
        layout.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });

        Intent intent = getIntent();
        id = intent.getIntExtra("showId", -1);


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

        LatLng bilaCerkva = new LatLng(49.79617015, 30.13094902);
        marker1 = mMap.addMarker(new MarkerOptions().position(bilaCerkva).title("Welcome to Bila Tserkva!"));
        marker1.setTag(markerInfoList.get(0));
        googleMap.setOnMarkerClickListener(this);


        for (int i = 0; i < markerInfoList.size(); i++) {
            LatLng bilaCerkva1 = new LatLng(markerInfoList.get(i).getLatitude(), markerInfoList.get(i).getLongitude());
            Marker marker = mMap.addMarker(new MarkerOptions().position(bilaCerkva1).title(markerInfoList.get(i).getName()));
            marker.setTag(markerInfoList.get(i));
            marker.setTag(markerInfoList.get(i));

            if (markerInfoList.get(i).getId() == id) {
                 onMarkerClick(marker);
            }

            mMap.moveCamera(CameraUpdateFactory.newLatLng(bilaCerkva));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(13), 2000, null);

        }


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

        textView1.setText(markerId);
        textView2.setText(markerInfo.getAdress());
        textView3.setText(markerInfo.getPhone());
        textView4.setText("no info");

        cardViewName.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                cardViewName.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                layout.setPanelHeight(cardViewName.getHeight());
            }
        });

        marker.showInfoWindow();
//        LatLng moveTo = new LatLng(markerInfo.getLatitude(), markerInfo.getLongitude());
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(moveTo));


        return true;
    }
}
