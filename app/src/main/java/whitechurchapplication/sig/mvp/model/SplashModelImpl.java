package whitechurchapplication.sig.mvp.model;

import android.content.Context;

import whitechurchapplication.sig.mvp.model.dao.MainDao;
import whitechurchapplication.sig.mvp.model.dao.MainDaoImpl;
import whitechurchapplication.sig.mvp.model.rest.json.LocationsResponse;
import whitechurchapplication.sig.mvp.presenter.SplashPresenter;

/**
 * Created by Nazar on 27.03.2017.
 */

public class SplashModelImpl implements SplashPresenter {
    private MainDao mainDao = new MainDaoImpl();
    LocationsResponse locationsResponse = new LocationsResponse();

    @Override
    public void saveLocations(LocationsResponse location, Context context) {

        if (mainDao != null && location != null && context != null) {
            mainDao.save(location, context);
        }

    }
}
