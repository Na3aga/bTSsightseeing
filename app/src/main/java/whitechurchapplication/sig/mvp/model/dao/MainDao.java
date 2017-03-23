package whitechurchapplication.sig.mvp.model.dao;

import whitechurchapplication.sig.mvp.model.entities.Location;

/**
 * Created by Nazar on 23.03.2017.
 */

public interface MainDao {

    void save(Location location);
    void delete(Location location);
    void delete(long id);
    void update(Location location);
    void findById(long id);

}
