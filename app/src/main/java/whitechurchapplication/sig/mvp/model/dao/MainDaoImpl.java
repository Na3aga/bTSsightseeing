package whitechurchapplication.sig.mvp.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import whitechurchapplication.sig.mvp.model.entities.Location;
import whitechurchapplication.sig.mvp.model.rest.json.LocationsResponse;

/**
 * Created by Nazar on 23.03.2017.
 */

public class MainDaoImpl implements MainDao{
    @Override
    public void save(LocationsResponse location, Context context) {

        int id = location.getId();
        String locName = location.getName();
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();

        LocationDbHelper mDbHelper;
        mDbHelper = new LocationDbHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        while ( id == 1 /*не знаю яку поставити умову циклу */) {
            values.put(LocationContract.LocationEntry._ID, id);
            values.put(LocationContract.LocationEntry.COLUMN_NAME, locName);
            values.put(LocationContract.LocationEntry.COLUMN_LONGITUDE, longitude);/*НЕ знаю як перемикати на наступне значення*/
            values.put(LocationContract.LocationEntry.COLUMN_LATITUDE, latitude);
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
}
