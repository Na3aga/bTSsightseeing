package whitechurchapplication.sig.mvp.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import whitechurchapplication.sig.mvp.model.dao.MainDao;
import whitechurchapplication.sig.mvp.model.dao.MainDaoImpl;
import whitechurchapplication.sig.mvp.model.entities.Location;
import whitechurchapplication.sig.mvp.model.entities.MarkerInfo;

/**
 * Created by Nazar on 11.04.2017.
 */

public class MapsModelImpl implements MapsModel {

    MainDao mainDao;

    public MapsModelImpl(Context context) {
        this.mainDao = new MainDaoImpl(context);
    }

    @Override
    public List<MarkerInfo> getMarkerInfo() {
        List<Location> locationList = mainDao.findAll();

        List<MarkerInfo> markerInfoList = new ArrayList<>();

        for (int i = 0; i < locationList.size(); i++) {
            MarkerInfo markerInfo = new MarkerInfo(locationList.get(i).getId(), locationList.get(i).getLongitude(),
                    locationList.get(i).getLatitude(), locationList.get(i).getName(), locationList.get(i).getShortDescription(), locationList.get(i).getAddress(),locationList.get(i).getPhone());
            markerInfoList.add(markerInfo);
        }
        return markerInfoList;
    }
}
