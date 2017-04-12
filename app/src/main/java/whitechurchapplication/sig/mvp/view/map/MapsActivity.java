package whitechurchapplication.sig.mvp.view.map;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.model.entities.MarkerInfo;
import whitechurchapplication.sig.mvp.presenter.MapsContract;
import whitechurchapplication.sig.mvp.presenter.MapsPresenterImpl;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,MapsContract.MapsView {

    private GoogleMap mMap;
    MapsContract.MapsPresenter mMapsPresenter;
    List<MarkerInfo> markerInfoList;

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
        mMap.addMarker(new MarkerOptions().position(bilaCerkva).title("Welcome to Bila Tserkva!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bilaCerkva));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ukraine, 15));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13), 2000, null);




//
//        dbHelper = new DbHelper(this);
//        db = dbHelper.getReadableDatabase();
//
//        final Cursor cursor = db.query(DataContract.LocationEntry.TABLE_NAME,
//                new String[]{DataContract.LocationEntry.COLUMN_NAME, DataContract.LocationEntry.COLUMN_LATITUDE, DataContract.LocationEntry.COLUMN_LONGITUDE},
//                null,
//                null,
//                null, null, null);
//        if (cursor != null) {
//            cursor.moveToFirst();
//        }
        for (int i = 0; i < markerInfoList.size(); i++) {
            LatLng bilaCerkva1 = new LatLng(markerInfoList.get(i).getLatitude(), markerInfoList.get(i).getLongitude());
            mMap.addMarker(new MarkerOptions().position(bilaCerkva1).title(markerInfoList.get(i).getName()));
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
}
