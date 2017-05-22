package whitechurchapplication.sig.mvp.model;

import whitechurchapplication.sig.mvp.model.entities.Location;

/**
 * Created by frontend on 5/22/17.
 */

public interface DetailMapModel {
    Location findLocById(int id);
}
