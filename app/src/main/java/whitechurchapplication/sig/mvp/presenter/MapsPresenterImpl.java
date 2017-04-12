package whitechurchapplication.sig.mvp.presenter;

import android.content.Context;

import java.util.List;

import whitechurchapplication.sig.mvp.model.MapsModel;
import whitechurchapplication.sig.mvp.model.MapsModelImpl;
import whitechurchapplication.sig.mvp.model.entities.MarkerInfo;

/**
 * Created by Nazar on 11.04.2017.
 */

public class MapsPresenterImpl implements MapsContract.MapsPresenter {

    private MapsContract.MapsView mapsView;
    private MapsModel mapsModel;

    public MapsPresenterImpl(Context context) {
        this.mapsModel = new MapsModelImpl(context);
    }

    @Override
    public void setMapsView(MapsContract.MapsView newMapsView) {
        this.mapsView = newMapsView;
    }

    @Override
    public void getMarkerInfo() {
        List<MarkerInfo> markerInfo = mapsModel.getMarkerInfo();
        mapsView.setMarkerInfo(markerInfo);
    }

}
