package whitechurchapplication.sig.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.OnClick;
import whitechurchapplication.sig.R;
import whitechurchapplication.sig.view.map.MapsActivity;
import whitechurchapplication.sig.view.see.WhatToSeeActivity;
import whitechurchapplication.sig.view.eat.WhereToEatActivity;
import whitechurchapplication.sig.view.stay.WhereToStopActivity;
import whitechurchapplication.sig.view.about.AboutBCerkvaActivity;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ImageView imageView = (ImageView)findViewById(R.id.whitechurchimage);
        Picasso.with(this).load(R.drawable.bcmaintop_xxdpi).into(imageView);
    }
    @OnClick(R.id.buttonToAbout) protected void switch1(){
        Intent intent = new Intent(MainActivity.this, AboutBCerkvaActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.buttonWhatToSee) protected void switch2(){
        Intent intent = new Intent(MainActivity.this, WhatToSeeActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.buttonWhereToStop) protected void switch3(){
        Intent intent = new Intent(MainActivity.this, WhereToStopActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.buttonWhereToEat) protected void switch4(){
        Intent intent = new Intent(MainActivity.this, WhereToEatActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.buttonToTouristMap) protected void switch5(){
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
    }

}
