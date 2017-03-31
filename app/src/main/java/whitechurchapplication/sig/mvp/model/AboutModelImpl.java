package whitechurchapplication.sig.mvp.model;

import java.util.List;

import whitechurchapplication.sig.mvp.model.dao.MainDao;
import whitechurchapplication.sig.mvp.model.entities.Location;

public class AboutModelImpl implements AboutModel {

    private MainDao mainDao;

    public AboutModelImpl() {
        
    }

    @Override
    public int getNumberOfLocationsInDb() {
        List<Location> locationList = mainDao.findAll();
        return locationList.size();
    }



}
