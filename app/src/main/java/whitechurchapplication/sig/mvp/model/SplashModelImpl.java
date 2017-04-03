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
    private MainDao mainDao;
    private DataSavedCallback dataSavedCallback;

    public SplashModelImpl(DataSavedCallback dataSavedCallback, Context context) {
        this.dataSavedCallback = dataSavedCallback;
        this.context = context;
        mainDao = new MainDaoImpl(context);
    }

    @Override
    public boolean saveLocations(Location location, Context context) {

        if (mainDao != null && location != null && context != null) {
            return mainDao.save(location);
        } else return false;
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
                } else {
                    //TODO remove it later
                    List<whitechurchapplication.sig.mvp.model.rest.json.response.Location> locationList2 = new ArrayList<whitechurchapplication.sig.mvp.model.rest.json.response.Location>();
                    locationList2.add(new whitechurchapplication.sig.mvp.model.rest.json.response.Location());
                    whitechurchapplication.sig.mvp.model.rest.json.response.Location location1 = new whitechurchapplication.sig.mvp.model.rest.json.response.Location();
                    location1.setId(1);
                    location1.setName("Kino");
                    location1.setLatitude(123.213);
                    location1.setLongitude(123.123);
                    locationList2.add(location1);
                    locationList2.add(new whitechurchapplication.sig.mvp.model.rest.json.response.Location());
                    whitechurchapplication.sig.mvp.model.rest.json.response.Location location2 = new whitechurchapplication.sig.mvp.model.rest.json.response.Location();
                    location2.setId(2);
                    location2.setName("Kinoshka");
                    location2.setLatitude(123.213);
                    location2.setLongitude(123.123);
                    locationList2.add(location2);
                    saved = saveAll(getLocationsForTestOnly());

//                    dataSavedCallback.dataWasSaved();
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

    private List<whitechurchapplication.sig.mvp.model.rest.json.response.Location> getLocationsForTestOnly() {
        List<whitechurchapplication.sig.mvp.model.rest.json.response.Location> locationList2 = new ArrayList<>();
        locationList2.add(new whitechurchapplication.sig.mvp.model.rest.json.response.Location());
        whitechurchapplication.sig.mvp.model.rest.json.response.Location location = new whitechurchapplication.sig.mvp.model.rest.json.response.Location();
        location.setId(12);
        location.setName("Kino");
        location.setLatitude(123.213);
        location.setLongitude(123.123);
        locationList2.add(location);
        return locationList2;

    }

}
