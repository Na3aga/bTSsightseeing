package whitechurchapplication.sig.mvp.model;

import android.content.Context;

import whitechurchapplication.sig.mvp.model.rest.json.LocationsResponse;

/**
 * Created by Nazar on 27.03.2017.
 */

public interface SplashModel {
    void saveLocations(LocationsResponse location, Context context);
}
