package whitechurchapplication.sig.mvp.view.detailView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.OnClick;
import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.view.DetailedMap.DetailedMapsActivity;
import whitechurchapplication.sig.mvp.view.Place;
import whitechurchapplication.sig.mvp.view.map.MapsActivity;

public class DetailInfoActivity extends AppCompatActivity {


    Place place;
    public int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Picasso.with(this).load(intent.getIntExtra("imageId", 1)).into(imageView);
        textView4.setText(intent.getStringExtra("placeName"));
        textView5.setText(intent.getStringExtra("placeInfo"));
        id = intent.getIntExtra("id", -1);


    }


@OnClick(R.id.floatingActionButton1)
protected void switch5() {
    Intent intent = new Intent(this, DetailedMapsActivity.class);
    intent.putExtra("showId",id);
    startActivity(intent);
}
}
