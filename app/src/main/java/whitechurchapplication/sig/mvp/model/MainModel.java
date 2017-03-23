package whitechurchapplication.sig.mvp.model;

import whitechurchapplication.sig.mvp.model.entities.Location;

/**
 * Created by macbookpro on 22.03.17.
 */

public interface MainModel {

    void saveToDb(Location location);

    void getUpdates();

}
