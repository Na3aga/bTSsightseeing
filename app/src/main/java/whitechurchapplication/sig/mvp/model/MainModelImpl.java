package whitechurchapplication.sig.mvp.model;

import android.content.Context;

import whitechurchapplication.sig.mvp.model.dao.MainDao;
import whitechurchapplication.sig.mvp.model.dao.MainDaoImpl;


public class MainModelImpl implements MainModel{

    private Context context;
    private MainDao mainDao;

    public MainModelImpl(Context context) {
        this.context = context;
        mainDao = new MainDaoImpl(context);
    }



    @Override
    public void getLocationsByType(String type) {
        mainDao.findByLocType(type);

    }

    @Override
    public void getUpdates() {

    }
}
