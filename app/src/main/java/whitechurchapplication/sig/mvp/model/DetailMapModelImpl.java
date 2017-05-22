package whitechurchapplication.sig.mvp.model;

import android.content.Context;

import whitechurchapplication.sig.mvp.model.dao.MainDao;
import whitechurchapplication.sig.mvp.model.dao.MainDaoImpl;
import whitechurchapplication.sig.mvp.model.entities.Location;

/**
 * Created by frontend on 5/22/17.
 */

public class DetailMapModelImpl implements  DetailMapModel {

    MainDao mainDao;

    public DetailMapModelImpl(Context context){
        mainDao = new MainDaoImpl(context);
    }

    @Override
    public Location findLocById(int id) {


        return mainDao.findById(id);
    }
}
