package whitechurchapplication.sig.mvp.view.see;

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

public class WhatToSeeActivity extends AppCompatActivity {
    MainContract.MainPresenter mainPresenter;

    private List<Place> places;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_to_see);
        rv = (RecyclerView) findViewById(R.id.rview1);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        mainPresenter = new MainPresenterImpl(this);

        initializeData();
        initializeAdapter();

    }

    private List<Place> initializeData() {
        List <Location> locationList = mainPresenter.getLocationsByType("Визначні місця");
        places = new ArrayList<>();
        for (int i = 0 ; i < locationList.size(); i++) {
            places.add(new Place(locationList.get(i).getName(), locationList.get(i).getShortDescription(), R.drawable.hotelcity));
        }
        return places;
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(places,this);
        rv.setAdapter(adapter);
    }
}