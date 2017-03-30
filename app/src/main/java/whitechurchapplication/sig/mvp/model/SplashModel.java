package whitechurchapplication.sig.mvp.model;

import android.content.Context;

import whitechurchapplication.sig.mvp.model.rest.json.LocationsResponse;



public interface SplashModel {
    void saveLocations(LocationsResponse location, Context context);
}
