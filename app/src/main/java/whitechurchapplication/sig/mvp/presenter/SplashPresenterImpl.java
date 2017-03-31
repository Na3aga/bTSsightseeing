package whitechurchapplication.sig.mvp.presenter;

import android.content.Context;

import org.jetbrains.annotations.NotNull;

import whitechurchapplication.sig.mvp.model.SplashModel;
import whitechurchapplication.sig.mvp.model.SplashModelImpl;
import whitechurchapplication.sig.mvp.model.entities.Location;


public class SplashPresenterImpl implements SplashContract.SplashPresenter {

    private SplashContract.SplashView splashView;
    private SplashModel splashModel;

    public SplashPresenterImpl() {this.splashModel= (SplashModel) new SplashModelImpl();}


    @Override
    public void setView(SplashContract.SplashView view) { splashView = view;

    }

    @Override
    public void saveLocations(@NotNull Location location, @NotNull Context context) {
        splashModel.saveLocations(location, context);

    }

    @Override
    public void deleteLocations() {

    }

}
