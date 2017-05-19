package whitechurchapplication.sig.mvp.view;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.OnClick;
import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.view.main.MainActivity;

public class CardViewActivity extends Activity {

    TextView placeName;
    TextView placeInfo;
    ImageView placePhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_activity);
        placeName = (TextView) findViewById(R.id.place_name);
        placeInfo = (TextView) findViewById(R.id.place_info);
        placePhoto = (ImageView) findViewById(R.id.place_photo);
        placeName.setText("name");
        placeInfo.setText("info");
        placePhoto.setImageResource(R.drawable.hotelcity);
    }
    @OnClick(R.id.cardButton)
    protected void switch1() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
