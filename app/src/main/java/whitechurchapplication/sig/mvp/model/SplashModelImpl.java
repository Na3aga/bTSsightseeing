package whitechurchapplication.sig.mvp.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import whitechurchapplication.sig.mvp.model.dao.MainDao;
import whitechurchapplication.sig.mvp.model.dao.MainDaoImpl;
import whitechurchapplication.sig.mvp.model.entities.ImageList;
import whitechurchapplication.sig.mvp.model.entities.Location;
import whitechurchapplication.sig.mvp.model.entities.LocationType;
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
            mainDao.save(location);
            return true;
        } else return false;
    }

    public boolean saveAll(List<whitechurchapplication.sig.mvp.model.rest.json.response.Location> locationList) {
        List<Location> locaionListEntities = new ArrayList<Location>();
        int i = 0;
        for (whitechurchapplication.sig.mvp.model.rest.json.response.Location location : locationList) {

            Location location1 = new Location(location);
            location1.setLocationType(new LocationType(location.getLocationType()));
            List<ImageList> imageList = new ArrayList<ImageList>();

            for(i = 0; i < location.getImageList().size();i++) {
                ImageList imageList1 = new ImageList(location.getImageList().get(i).getId(),location.getImageList().get(i).getUrl());
                int q = imageList1.getId();
                String d = imageList1.getUrl();
                imageList.add(imageList1);
            }
            location1.setImageList(imageList);
            locaionListEntities.add(location1);


           i++;
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


}

