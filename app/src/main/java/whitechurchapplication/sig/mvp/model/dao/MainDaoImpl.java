package whitechurchapplication.sig.mvp.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

import whitechurchapplication.sig.mvp.model.data.DataContract;
import whitechurchapplication.sig.mvp.model.data.DbHelper;
import whitechurchapplication.sig.mvp.model.entities.Location;

public class MainDaoImpl implements MainDao {

    public Context context;
    private DbHelper dbHelper;
    private SQLiteDatabase db;

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
        }
        ContentValues values = new ContentValues();
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

        List<Location> locationList = new ArrayList<>();

        db =  dbHelper.getReadableDatabase();

        Cursor cursor = db.query(DataContract.LocationEntry.TABLE_NAME,
                new String[]{DataContract.LocationEntry.COLUMN_NAME, DataContract.LocationEntry.COLUMN_LATITUDE, DataContract.LocationEntry.COLUMN_LONGITUDE},
                null,
                null,
                null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        for (int i = 0; i < 56; i++) {
            Location location = new Location(cursor.getString(0), cursor.getString(0), cursor.getDouble(1), cursor.getDouble(2));
            locationList.add(i, location);

            cursor.moveToNext();
        }

        db.close();

        //TODO implement
        return locationList;
    }
}
