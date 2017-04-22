package whitechurchapplication.sig.mvp.presenter;

public interface MainContract {

    interface MainView {

    }

    interface MainPresenter {
        void getLocationsByType(String type);
    }

}
