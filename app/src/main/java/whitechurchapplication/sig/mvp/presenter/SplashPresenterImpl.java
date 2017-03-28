package whitechurchapplication.sig.mvp.presenter;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import whitechurchapplication.sig.mvp.model.SplashModel;
import whitechurchapplication.sig.mvp.model.SplashModelImpl;
import whitechurchapplication.sig.mvp.model.rest.json.LocationsResponse;

/**
 * Created by macbookpro on 25.03.17.
 */

public class SplashPresenterImpl implements SplashPresenter {
    private SplashModel splashModel = (SplashModel) new SplashModelImpl();

    @Override
    public void saveLocations(@NotNull LocationsResponse location, @NotNull Context context) {
        splashModel.saveLocations(location, context);

    }

}
