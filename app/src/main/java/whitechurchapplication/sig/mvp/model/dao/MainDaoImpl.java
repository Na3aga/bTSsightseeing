package whitechurchapplication.sig.mvp.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import whitechurchapplication.sig.mvp.model.data.DataContract;
import whitechurchapplication.sig.mvp.model.data.LocationDbHelper;
import whitechurchapplication.sig.mvp.model.entities.Location;

public class MainDaoImpl implements MainDao {

    private Context context;

    public MainDaoImpl(Context context) {
        this.context = context;
    }

    @Override
    public void save(Location location) {
        int id = location.getId();
        String locName = location.getName();
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();

        LocationDbHelper mDbHelper;
        mDbHelper = new LocationDbHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
            values.put(DataContract.LocationEntry._ID, id);
            values.put(DataContract.LocationEntry.COLUMN_NAME, locName);
            values.put(DataContract.LocationEntry.COLUMN_LONGITUDE, longitude);
            values.put(DataContract.LocationEntry.COLUMN_LATITUDE, latitude);
        //TODO write to db and close db
    }

    @Override
    public void saveAll(List<Location> locationList) {
        for (Location location : locationList) {
            save(location);
        }
    }

    @Override
    public void delete(Location location) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(Location location) {

    }

    @Override
    public void findById(long id) {

    }

    @Override
    public List<Location> findAll() {
        return null;
    }
}
