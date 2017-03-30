package whitechurchapplication.sig.mvp.presenter;

import whitechurchapplication.sig.mvp.model.AboutModel;
import whitechurchapplication.sig.mvp.model.AboutModelImpl;

public class AboutPresenterImpl implements AboutContract.AboutPresenter {

    private AboutContract.AboutView aboutView;
    private AboutModel aboutModel;

    public AboutPresenterImpl() {
        this.aboutModel = new AboutModelImpl();
    }

    @Override
    public void setView(AboutContract.AboutView view) {
        aboutView = view;
    }

    @Override
    public void getNumberOfLocationsInDb() {
        int numberOfLocations = aboutModel.getNumberOfLocationsInDb();
        if (aboutView != null) {
            aboutView.showMessage("Number of locations: " + numberOfLocations);
        }
    }


}
