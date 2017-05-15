package whitechurchapplication.sig.mvp.view.see;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.List;

import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.model.entities.Location;
import whitechurchapplication.sig.mvp.presenter.MainContract;
import whitechurchapplication.sig.mvp.presenter.MainPresenterImpl;

public class WhatToSeeActivity extends AppCompatActivity {

    MainContract.MainPresenter mainPresenter;
    TextView textView1,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_to_see);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainPresenter = new MainPresenterImpl(this);
        List <Location> locationList = mainPresenter.getLocationsByType("Церкви");

        textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText(locationList.get(0).getName());
        textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(locationList.get(1).getName());
        textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText(locationList.get(6).getName());;


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
