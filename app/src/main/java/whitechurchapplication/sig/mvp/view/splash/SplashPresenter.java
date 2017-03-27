package whitechurchapplication.sig.mvp.view.splash;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import whitechurchapplication.sig.mvp.model.entities.Location;

/**
 * Created by macbookpro on 25.03.17.
 */

public class SplashPresenter implements SplashPresenterInterface{
    private SplashModelInterface splashModel = (SplashModelInterface) new SplashModel();

    @Override
    public void saveLocations(@NotNull Location location, @NotNull Context context) {
        splashModel.saveLocations(location, context);

    }

}
