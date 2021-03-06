package whitechurchapplication.sig.mvp.view.eat;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.model.entities.Location;
import whitechurchapplication.sig.mvp.model.entities.Place;
import whitechurchapplication.sig.mvp.presenter.MainContract;
import whitechurchapplication.sig.mvp.presenter.MainPresenterImpl;
import whitechurchapplication.sig.mvp.view.RVAdapter;

public class WhereToEatActivity extends AppCompatActivity{
    MainContract.MainPresenter mainPresenter;

    private List<Place> places;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where_to_eat);
        ButterKnife.bind(this);
        rv = (RecyclerView) findViewById(R.id.rview2);
        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decor = getWindow().getDecorView();
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }

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
            places.add(new Place(locationList.get(i).getName(), locationList.get(i).getShortDescription(),imgUrl,i,locationList.get(i).getId()));
        }
        return places;
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(places,this);
        rv.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}