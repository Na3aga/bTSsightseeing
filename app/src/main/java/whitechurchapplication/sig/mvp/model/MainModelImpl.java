package whitechurchapplication.sig.mvp.model;

import android.content.Context;

import java.util.List;

import whitechurchapplication.sig.mvp.model.dao.MainDao;
import whitechurchapplication.sig.mvp.model.dao.MainDaoImpl;
import whitechurchapplication.sig.mvp.model.entities.Location;


public class MainModelImpl implements MainModel {

    private Context context;
    private MainDao mainDao;

    public MainModelImpl(Context context) {
        this.context = context;
        mainDao = new MainDaoImpl(context);
    }


    @Override
    public List<Location> getLocationsByType(String type) {
        List<Location> locationList;
        locationList = mainDao.findByLocType(type);

        return locationList;
    }

    @Override
    public void getUpdates() {

    }
}
