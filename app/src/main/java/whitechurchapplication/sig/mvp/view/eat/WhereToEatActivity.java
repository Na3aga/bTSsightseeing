package whitechurchapplication.sig.mvp.view.eat;

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

public class WhereToEatActivity extends AppCompatActivity{
    MainContract.MainPresenter mainPresenter;

    private List<Place> places;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where_to_eat);

        rv = (RecyclerView) findViewById(R.id.rview2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        mainPresenter = new MainPresenterImpl(this);

        initializeData();
        initializeAdapter();


    }

    private List<Place> initializeData() {
        List <Location> locationList = mainPresenter.getLocationsByType("Перекусити");
        places = new ArrayList<>();
        for (int i = 0 ; i < locationList.size(); i++) {
            String imgUrl = "not exist";
            if(locationList.get(i).getImageList().size() > 0){
                imgUrl = locationList.get(i).getImageList().get(0).getUrl();
            }
            places.add(new Place(locationList.get(i).getName(), locationList.get(i).getShortDescription(),imgUrl, R.drawable.hotelcity,locationList.get(i).getId()));
        }
        return places;
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(places,this);
        rv.setAdapter(adapter);
    }

}