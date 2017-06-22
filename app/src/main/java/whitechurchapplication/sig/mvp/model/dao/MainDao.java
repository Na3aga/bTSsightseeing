package whitechurchapplication.sig.mvp.model.dao;

import java.util.List;

import whitechurchapplication.sig.mvp.model.entities.Location;

public interface MainDao {

    void save(Location location);
    boolean saveAll(List<Location> locationList);
    Location findById(int id);
    List<Location> findByLocType(String type);
    List<Location> findAll();
    void delete(int id);
    void update(Location location);
    double maxVersion();

}
