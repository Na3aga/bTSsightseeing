package whitechurchapplication.sig.mvp.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import whitechurchapplication.sig.mvp.model.dao.MainDao;
import whitechurchapplication.sig.mvp.model.dao.MainDaoImpl;
import whitechurchapplication.sig.mvp.model.entities.Location;
import whitechurchapplication.sig.mvp.model.rest.HttpApi;

public class SplashModelImpl implements SplashModel {

    private Context context;

    private MainDao mainDao = new MainDaoImpl(context);

    @Override
    public void saveLocations(Location location, Context context) {

        if (mainDao != null && location != null && context != null) {
            mainDao.save(location);
        }
    }

    @Override
    public void startSync() {
        HttpApi httpApi = RetrofitGenerator.getApiService();
        Call<List<whitechurchapplication.sig.mvp.model.rest.json.response.Location>> getLocationsCall = httpApi.getLocations();
        getLocationsCall.enqueue(new Callback<List<whitechurchapplication.sig.mvp.model.rest.json.response.Location>>() {
            @Override
            public void onResponse(Call<List<whitechurchapplication.sig.mvp.model.rest.json.response.Location>> call, Response<List<whitechurchapplication.sig.mvp.model.rest.json.response.Location>> response) {
                List<whitechurchapplication.sig.mvp.model.rest.json.response.Location> locationList = response.body();
                List<Location> locList = new ArrayList<Location>();
                for (whitechurchapplication.sig.mvp.model.rest.json.response.Location location : locationList) {
                    locList.add(new Location(location));
                }
                mainDao.saveAll(locList);
            }

            @Override
            public void onFailure(Call<List<whitechurchapplication.sig.mvp.model.rest.json.response.Location>> call, Throwable t) {

            }
        });
    }

}
