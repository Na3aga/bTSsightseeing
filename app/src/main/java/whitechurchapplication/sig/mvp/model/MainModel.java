package whitechurchapplication.sig.mvp.model;

import android.content.Context;

import whitechurchapplication.sig.mvp.model.entities.Location;

/**
 * Created by macbookpro on 22.03.17.
 */

public interface MainModel {

    void saveToDb(Location location, Context context);

    void getUpdates();

}
