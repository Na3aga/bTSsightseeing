package whitechurchapplication.sig.mvp.presenter;

import android.content.Context;

import whitechurchapplication.sig.mvp.model.MainModel;
import whitechurchapplication.sig.mvp.model.MainModelImpl;


public class MainPresenterImpl implements MainContract.MainPresenter {

    private MainModel mainModel;

    public MainPresenterImpl(Context context) {
        this.mainModel = new MainModelImpl(context);;
    }


    @Override
    public void getLocationsByType(String type) {
        mainModel.getLocationsByType(type);
    }
}
