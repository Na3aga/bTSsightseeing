package whitechurchapplication.sig.mvp.model;

import android.content.Context;

import whitechurchapplication.sig.mvp.model.entities.Location;



public interface SplashModel {
    boolean saveLocations(Location location, Context context);

    void startSync();
}
