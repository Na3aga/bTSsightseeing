package whitechurchapplication.sig.mvp.model;

import android.content.Context;

import whitechurchapplication.sig.mvp.model.entities.Location;



public interface MainModel {

    void saveToDb(Location location, Context context);

    void getUpdates();

}
