package whitechurchapplication.sig.mvp.presenter;

import whitechurchapplication.sig.mvp.model.MainModel;
import whitechurchapplication.sig.mvp.model.MainModelImpl;

/**
 * Created by macbookpro on 22.03.17.
 */

public class MainPresenterImpl implements MainContract{

    private MainModel mainModel = new MainModelImpl();

    @Override
    public void synchronize() {
        mainModel.getUpdates();

    }

}
