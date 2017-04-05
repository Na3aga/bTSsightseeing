package whitechurchapplication.sig.mvp.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.List;

import whitechurchapplication.sig.mvp.model.data.DataContract;
import whitechurchapplication.sig.mvp.model.data.DbHelper;
import whitechurchapplication.sig.mvp.model.entities.Location;

public class MainDaoImpl implements MainDao {

    private Context context;
    DbHelper dbHelper;
    SQLiteDatabase db;

    public MainDaoImpl(Context context) {
        this.context = context;
        dbHelper = new DbHelper(context);
    }


    @Override
    public boolean saveAll(List<Location> locationList) {
        for (Location location : locationList) {
            save(location);
        }
        return true;
    }

    @Override
    public void save(Location location) {
        //        int id = location.getId();
        String locName = location.getName();
        if (locName == null) locName = "nothing";
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();


        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
//            db = dbHelper.getReadableDatabase();
        }
        ContentValues values = new ContentValues();
//        values.put(DataContract.LocationEntry._ID, id);
        values.put(DataContract.LocationEntry.COLUMN_NAME, locName);
        values.put(DataContract.LocationEntry.COLUMN_LONGITUDE, longitude);
        values.put(DataContract.LocationEntry.COLUMN_LATITUDE, latitude);

        db.insertOrThrow(DataContract.LocationEntry.TABLE_NAME, null, values);
        db.close();


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
