package whitechurchapplication.sig.mvp.model.dao;

import android.content.Context;

import java.util.List;

import whitechurchapplication.sig.mvp.model.entities.Location;

public interface MainDao {

    void save(Location location, Context context);
    void delete(Location location);
    void delete(long id);
    void update(Location location);
    void findById(long id);
    List<Location> findAll();

}
