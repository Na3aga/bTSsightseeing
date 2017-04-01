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
import whitechurchapplication.sig.mvp.presenter.DataSavedCallback;

public class SplashModelImpl implements SplashModel {

    private Context context;
    private MainDao mainDao = new MainDaoImpl(context);
    private DataSavedCallback dataSavedCallback;

    public SplashModelImpl(DataSavedCallback dataSavedCallback) {
        this.dataSavedCallback = dataSavedCallback;
    }

    @Override
    public boolean saveLocations(Location location, Context context) {

        if (mainDao != null && location != null && context != null) {
             return mainDao.save(location);
        }else return false;
    }

    public boolean saveAll(List<whitechurchapplication.sig.mvp.model.rest.json.response.Location> locationList) {
        List<Location> locaionListEntities = new ArrayList<Location>();
        for (whitechurchapplication.sig.mvp.model.rest.json.response.Location location : locationList) {
            locaionListEntities.add(new Location(location));
        }
        return mainDao.saveAll(locaionListEntities);
    }

    @Override
    public void startSync() {
        HttpApi httpApi = RetrofitGenerator.getApiService();
        Call<List<whitechurchapplication.sig.mvp.model.rest.json.response.Location>> getLocationsCall = httpApi.getLocations();
        getLocationsCall.enqueue(new Callback<List<whitechurchapplication.sig.mvp.model.rest.json.response.Location>>() {
            boolean saved = false;
            @Override
            public void onResponse(Call<List<whitechurchapplication.sig.mvp.model.rest.json.response.Location>> call, Response<List<whitechurchapplication.sig.mvp.model.rest.json.response.Location>> response) {
                List<whitechurchapplication.sig.mvp.model.rest.json.response.Location> locationList = response.body();
                if (locationList != null) {
                    saved = saveAll(locationList);
                }
                if (saved && dataSavedCallback != null) {
                    dataSavedCallback.dataWasSaved();
                }
            }

            @Override
            public void onFailure(Call<List<whitechurchapplication.sig.mvp.model.rest.json.response.Location>> call, Throwable t) {

            }
        });
    }

}
