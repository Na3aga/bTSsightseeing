package whitechurchapplication.sig.mvp.model;

import android.content.Context;

import whitechurchapplication.sig.mvp.model.dao.MainDao;
import whitechurchapplication.sig.mvp.model.dao.MainDaoImpl;
import whitechurchapplication.sig.mvp.model.entities.Location;

/**
 * Created by macbookpro on 22.03.17.
 */

public class MainModelImpl implements MainModel{

    private MainDao mainDao = new MainDaoImpl();

    @Override
    public void saveToDb(Location location, Context context) {

    }

    @Override
    public void getUpdates() {

    }
}
