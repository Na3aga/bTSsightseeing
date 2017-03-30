package whitechurchapplication.sig.mvp.presenter;

public interface AboutContract {

    interface AboutPresenter {

        void setView(AboutView view);

        void getNumberOfLocationsInDb();

    }

    interface AboutView {

        void showMessage(String message);

    }

}
