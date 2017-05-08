package whitechurchapplication.sig.mvp.model;

import java.util.List;

import whitechurchapplication.sig.mvp.model.entities.Location;

public interface MainModel {

    List<Location> getLocationsByType(String type);

    void getUpdates();

}
