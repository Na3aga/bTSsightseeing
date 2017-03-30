package whitechurchapplication.sig.mvp.model;

import android.content.Context;

import whitechurchapplication.sig.mvp.model.dao.MainDao;
import whitechurchapplication.sig.mvp.model.dao.MainDaoImpl;
import whitechurchapplication.sig.mvp.model.entities.Location;



public class MainModelImpl implements MainModel{

    private MainDao mainDao = new MainDaoImpl();

    @Override
    public void saveToDb(Location location, Context context) {

    }

    @Override
    public void getUpdates() {

    }
}
