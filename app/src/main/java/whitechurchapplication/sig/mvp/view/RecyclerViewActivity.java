package whitechurchapplication.sig.mvp.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import whitechurchapplication.sig.R;

/*/public class RecyclerViewActivity extends Activity {
    private List<Place> place;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycler_view);

        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        place = new ArrayList<>();
        place.add(new Place("bc", "info", R.drawable.hotelcity));
        place.add(new Place("name", "info info", R.drawable.hotelkiyv));
        place.add(new Place("bc name", "info info info", R.drawable.hotelkiyv2));
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(place);
        rv.setAdapter(adapter);
    }
/*/