package whitechurchapplication.sig.mvp.view;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import whitechurchapplication.sig.R;

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
}