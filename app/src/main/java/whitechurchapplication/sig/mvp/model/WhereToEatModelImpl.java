package whitechurchapplication.sig.mvp.model;

import java.util.List;

import whitechurchapplication.sig.mvp.model.dao.MainDao;
import whitechurchapplication.sig.mvp.model.entities.Location;

public class WhereToEatModelImpl implements WhereToEatModel {

    private MainDao mainDao;
    private WhereToEatModelImpl() {}





    @Override
    public int getNumberOfLocationsInBd() {
        List<Location> locationList = mainDao.findAll();
        return locationList.size();

    }
}
