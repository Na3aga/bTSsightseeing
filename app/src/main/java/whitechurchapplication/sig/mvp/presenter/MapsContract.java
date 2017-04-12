package whitechurchapplication.sig.mvp.presenter;

import java.util.List;

import whitechurchapplication.sig.mvp.model.entities.MarkerInfo;


public interface MapsContract {

    interface MapsView {
        void setMarkerInfo(List<MarkerInfo> markerInfo);

    }

    interface MapsPresenter {
        void setMapsView(MapsContract.MapsView newMapsView);
        void getMarkerInfo();
    }


}
