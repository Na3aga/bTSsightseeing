package whitechurchapplication.sig.mvp.presenter;

import java.util.List;

import whitechurchapplication.sig.mvp.model.entities.Location;

public interface MainContract {

    interface MainView {

    }

    interface MainPresenter {
        List<Location> getLocationsByType(String type);
    }

}
