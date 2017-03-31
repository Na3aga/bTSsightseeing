package whitechurchapplication.sig.mvp.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.model.entities.Location;
import whitechurchapplication.sig.mvp.model.rest.HttpApi;
import whitechurchapplication.sig.mvp.model.rest.json.response.LocationsResponse;
import whitechurchapplication.sig.mvp.presenter.SplashContract;
import whitechurchapplication.sig.mvp.presenter.SplashPresenterImpl;

public class SplashActivity extends AppCompatActivity implements SplashContract.SplashView {
    private SplashContract.SplashView splashPresenter;
    private HttpApi mHttpApi;
    private SplashPresenterImpl mSplashPresenterImpl;
    private Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHttpApi = RetrofitGenerator.getApiService();
        getLocation();
        splashPresenter = (SplashContract.SplashView) new SplashPresenterImpl();
        splashPresenter.setView(this);


    }


    public void getLocation() {
        final Call<List<LocationsResponse>> location = mHttpApi.getLocations();
        location.enqueue(new Callback<List<LocationsResponse>>() {
            @Override
            public void onResponse(Call<List<LocationsResponse>> call, Response<List<LocationsResponse>> response) {
                List<LocationsResponse> locationsResponses = response.body();
                mSplashPresenterImpl.saveLocations((Location) location, getApplicationContext());
                //TODO save to dbs

            }

            @Override
            public void onFailure(Call<List<LocationsResponse>> call, Throwable t) {
                //TODO handle error
            }
        });

    }


    @Override
    public void ShowMessage(String massage) {

    }

    @Override
    public void setView(SplashActivity splashActivity) {

    }
}

