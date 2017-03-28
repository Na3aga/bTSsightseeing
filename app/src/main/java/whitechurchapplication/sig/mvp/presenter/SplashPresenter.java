package whitechurchapplication.sig.mvp.presenter;

import android.content.Context;

import whitechurchapplication.sig.mvp.model.rest.json.LocationsResponse;

/**
 * Created by Nazar on 27.03.2017.
 */

public interface SplashPresenter {
    void saveLocations(LocationsResponse location, Context context);
    void deleteLocations();
}
