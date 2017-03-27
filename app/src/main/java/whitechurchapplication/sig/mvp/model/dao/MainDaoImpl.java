package whitechurchapplication.sig.mvp.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import whitechurchapplication.sig.mvp.model.entities.Location;

/**
 * Created by Nazar on 23.03.2017.
 */

public class MainDaoImpl implements MainDao{
    @Override
    public void save(Location location, Context context) {
        LocationDbHelper mDbHelper;
        mDbHelper = new LocationDbHelper(context);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(LocationContract.LocationEntry.COLUMN_NAME,"Nazar");
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
