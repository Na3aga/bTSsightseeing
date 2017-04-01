package whitechurchapplication.sig.mvp.model.dao;

import java.util.List;

import whitechurchapplication.sig.mvp.model.entities.Location;

public interface MainDao {

    boolean save(Location location);
    void delete(Location location);
    boolean saveAll(List<Location> locationList);
    void delete(long id);
    void update(Location location);
    void findById(long id);
    List<Location> findAll();

}
