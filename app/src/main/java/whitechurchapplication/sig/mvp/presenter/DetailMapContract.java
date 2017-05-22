package whitechurchapplication.sig.mvp.presenter;

import whitechurchapplication.sig.mvp.model.entities.Location;



public interface DetailMapContract {

Location findLocById(int id);

}
