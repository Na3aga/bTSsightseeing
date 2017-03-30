package whitechurchapplication.sig.mvp.presenter;

import android.content.Context;

import whitechurchapplication.sig.mvp.model.SplashActivity;
import whitechurchapplication.sig.mvp.model.rest.json.LocationsResponse;



public interface SplashContract {
    interface SplashPresenter{

        void setView(SplashView view);
        void saveLocations(LocationsResponse location, Context context);
        void deleteLocations();
    }


    interface SplashView{

        void ShowMessage (String massage);

        void setView(SplashActivity splashActivity);
    }


}
