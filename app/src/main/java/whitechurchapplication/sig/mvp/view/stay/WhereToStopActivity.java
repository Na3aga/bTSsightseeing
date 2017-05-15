package whitechurchapplication.sig.mvp.view.stay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.model.entities.Location;
import whitechurchapplication.sig.mvp.presenter.MainContract;
import whitechurchapplication.sig.mvp.presenter.MainPresenterImpl;
import whitechurchapplication.sig.mvp.view.Place;
import whitechurchapplication.sig.mvp.view.RVAdapter;


public class WhereToStopActivity extends AppCompatActivity {
    MainContract.MainPresenter mainPresenter;

    //TextView placeName;
    //TextView placeInfo;
    //ImageView placePhoto;

    private List<Place> places;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where_to_stop);
        rv = (RecyclerView) findViewById(R.id.rview);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        mainPresenter = new MainPresenterImpl(this);

        initializeData();
        initializeAdapter();

    }

    private List<Place> initializeData() {
        List <Location> locationList = mainPresenter.getLocationsByType("Ресторани");
        places = new ArrayList<>();
        for (int i = 0 ; i < locationList.size(); i++) {
            places.add(new Place(locationList.get(i).getName(), locationList.get(i).getShortDescription(), R.drawable.hotelcity));
        }
        return places;
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(places);
        rv.setAdapter(adapter);
    }
}


//placeName = (TextView) findViewById(R.id.place_name);
//placeInfo = (TextView) findViewById(R.id.place_info);
//placePhoto = (ImageView) findViewById(R.id.place_photo);
//placeName.setText("name");
//placeInfo.setText("info");
//placePhoto.setImageResource(R.drawable.hotelcity);


//@Override
// protected void onCreate(Bundle savedInstanceState) {
//   super.onCreate(savedInstanceState);
// setContentView(R.layout.activity_where_to_stop);
//ButterKnife.bind(this);
// mainPresenter = new MainPresenterImpl(this);
//mainPresenter.getLocationsByType("ресторан");


//Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//setSupportActionBar(toolbar);
// mainPresenter = new MainPresenterImpl(this);
// mainPresenter.getLocationsByType("ресторан");


