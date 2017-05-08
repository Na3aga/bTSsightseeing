package whitechurchapplication.sig.mvp.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

        String locName = location.getName();
        if (locName == null) locName = "NoNAME";
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        String adress = location.getAddress();

        int typeId = location.getLocationType().getId();
        String typeName = location.getLocationType().getType();
        db = dbHelper.getWritableDatabase();

        if (testForUniquenessType(typeName) == true) {

            ContentValues values = new ContentValues();
            values.put(DataContract.LocationEntry._ID_OF_TYPE, typeId);
            values.put(DataContract.LocationEntry.COLUMN_TYPE_NAME, typeName);

            db.insertOrThrow(DataContract.LocationEntry.TABLE_TYPE_NAME, null, values);

        }


        ContentValues values = new ContentValues();
        values.put(DataContract.LocationEntry.COLUMN_NAME, locName);
        values.put(DataContract.LocationEntry.COLUMN_LONGITUDE, longitude);
        values.put(DataContract.LocationEntry.ID_TYPE, typeId);
        values.put(DataContract.LocationEntry.COLUMN_LATITUDE, latitude);
        values.put(DataContract.LocationEntry.COLUMN_ADRESS, adress);


        db.insertOrThrow(DataContract.LocationEntry.TABLE_LOCATIONS_NAME, null, values);

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
    public List<Location> findByLocType(String type) {

        List<Location> locationListByType = new ArrayList<>();

        SQLiteDatabase ndb = dbHelper.getReadableDatabase();

        Cursor cursor1 = ndb.query(DataContract.LocationEntry.TABLE_TYPE_NAME,
                new String[]{DataContract.LocationEntry._ID_OF_TYPE},
                DataContract.LocationEntry.COLUMN_TYPE_NAME + " = ? ",
                new String[]{type},
                null, null, null);


        if (cursor1 != null) {
            cursor1.moveToFirst();
        }

        int typeId = cursor1.getInt(0);
        Cursor cursor2 = ndb.query(DataContract.LocationEntry.TABLE_LOCATIONS_NAME,
                new String[]{DataContract.LocationEntry._ID, DataContract.LocationEntry.COLUMN_NAME, DataContract.LocationEntry.COLUMN_LATITUDE,
                        DataContract.LocationEntry.COLUMN_LONGITUDE, DataContract.LocationEntry.COLUMN_ADRESS},
                DataContract.LocationEntry.ID_TYPE + " = ? ",
                new String[]{Integer.toString(typeId)},
                null, null, null);

        if (cursor2 != null) {
            cursor2.moveToFirst();
        }

        int i = 0;
        do {
            Location location = new Location(cursor2.getInt(0), cursor2.getString(1), cursor2.getString(1), cursor2.getDouble(2), cursor2.getDouble(3), cursor2.getString(4));
            locationListByType.add(i, location);


            i++;
        } while (cursor2.moveToNext());

        ndb.close();
        return locationListByType;

    }

    @Override
    public List<Location> findAll() {

        List<Location> locationList = new ArrayList<>();

        db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(DataContract.LocationEntry.TABLE_LOCATIONS_NAME,
                new String[]{DataContract.LocationEntry._ID, DataContract.LocationEntry.COLUMN_NAME, DataContract.LocationEntry.COLUMN_LATITUDE,
                        DataContract.LocationEntry.COLUMN_LONGITUDE, DataContract.LocationEntry.COLUMN_ADRESS},
                null,
                null,
                null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        int i = 0;
        do {
            Location location = new Location(cursor.getInt(0), cursor.getString(1), cursor.getString(1), cursor.getDouble(2), cursor.getDouble(3), cursor.getString(4));
            locationList.add(i, location);
            i++;
        } while (cursor.moveToNext());

        db.close();

        //TODO implement
        return locationList;
    }

    public boolean testForUniquenessType(String typeName) {
        boolean result = true;
        SQLiteDatabase testDB;

        testDB = dbHelper.getReadableDatabase();
        Cursor cursor = testDB.query(DataContract.LocationEntry.TABLE_TYPE_NAME,
                new String[]{DataContract.LocationEntry._ID_OF_TYPE},
                DataContract.LocationEntry.COLUMN_TYPE_NAME + " = ? ",
                new String[]{typeName},
                null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            result = false;
        }


        return result;
    }
}
