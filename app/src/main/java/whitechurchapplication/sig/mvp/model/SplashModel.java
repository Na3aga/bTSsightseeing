package whitechurchapplication.sig.mvp.model;

import android.content.Context;

import whitechurchapplication.sig.mvp.model.entities.Location;



public interface SplashModel {
    void saveLocations(Location location, Context context);
}
