package whitechurchapplication.sig.mvp.presenter;

import android.content.Context;

import java.util.List;

import whitechurchapplication.sig.mvp.model.MainModel;
import whitechurchapplication.sig.mvp.model.MainModelImpl;
import whitechurchapplication.sig.mvp.model.entities.Location;


public class MainPresenterImpl implements MainContract.MainPresenter {

    private MainModel mainModel;

    public MainPresenterImpl(Context context) {
        this.mainModel = new MainModelImpl(context);
        ;
    }


    @Override
    public List<Location> getLocationsByType(String type) {
        List<Location> locationList;
        locationList = mainModel.getLocationsByType(type);

        return locationList;
    }
}
