package whitechurchapplication.sig.mvp.presenter;

import android.content.Context;

import whitechurchapplication.sig.mvp.model.DetailMapModel;
import whitechurchapplication.sig.mvp.model.DetailMapModelImpl;
import whitechurchapplication.sig.mvp.model.entities.Location;

/**
 * Created by frontend on 5/22/17.
 */

public class DetailMapPresenterImpl implements DetailMapContract {

    DetailMapModel detailMapModel;

    public DetailMapPresenterImpl(Context context){
        detailMapModel = new DetailMapModelImpl(context);
    }

    @Override
    public Location findLocById(int id) {


        return detailMapModel.findLocById(id);
    }

}
