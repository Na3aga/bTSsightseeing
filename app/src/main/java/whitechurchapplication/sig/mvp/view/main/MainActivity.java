package whitechurchapplication.sig.mvp.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.OnClick;
import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.view.about.AboutBCerkvaActivity;
import whitechurchapplication.sig.mvp.view.eat.WhereToEatActivity;
import whitechurchapplication.sig.mvp.view.map.MapsActivity;
import whitechurchapplication.sig.mvp.view.see.WhatToSeeActivity;
import whitechurchapplication.sig.mvp.view.stay.WhereToStopActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ImageView imageView1 = (ImageView) findViewById(R.id.whitechurchimage);
        Picasso.with(this).load(R.drawable.bcmaintop_xxdpi).into(imageView1);
        ImageView imageView2 = (ImageView)findViewById(R.id.whitechurchimage);
        Picasso.with(this).load(R.drawable.golovnyiekran2).into(imageView2);
    }

    @OnClick(R.id.buttonToAbout)
    protected void switch1() {
        Intent intent = new Intent(MainActivity.this, AboutBCerkvaActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.buttonWhatToSee)
    protected void switch2() {
        Intent intent = new Intent(MainActivity.this, WhatToSeeActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.buttonWhereToStop)
    protected void switch3() {
        Intent intent = new Intent(MainActivity.this, WhereToStopActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.buttonWhereToEat)
    protected void switch4() {
        Intent intent = new Intent(MainActivity.this, WhereToEatActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.buttonToTouristMap)
    protected void switch5() {
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
    }

}
