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
        if (locName == null) locName = "NoNAME";
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        String adress = location.getAddress();
        int typeId = 0;


        whitechurchapplication.sig.mvp.model.entities.LocationType typeObject = location.getLocationType();

//        try {
            db = dbHelper.getWritableDatabase();
//        } catch (SQLiteException ex) {
//        }

        if (typeObject != null) {
            typeId = typeObject.getId();
            String typeName = typeObject.getType();


            ContentValues values2 = new ContentValues();
            values2.put(DataContract.LocationEntry._ID_OF_TYPE, typeId);
            values2.put(DataContract.LocationEntry.COLUMN_TYPE_NAME, typeName);


            db.insertOrThrow(DataContract.LocationEntry.TABLE_TYPE_NAME, null, values2);
        }


        ContentValues values1 = new ContentValues();
        values1.put(DataContract.LocationEntry.COLUMN_NAME, locName);
        values1.put(DataContract.LocationEntry.COLUMN_LONGITUDE, longitude);
        values1.put(DataContract.LocationEntry.ID_TYPE, typeId);
        values1.put(DataContract.LocationEntry.COLUMN_LATITUDE, latitude);
        values1.put(DataContract.LocationEntry.COLUMN_ADRESS, adress);


        db.insertOrThrow(DataContract.LocationEntry.TABLE_LOCATIONS_NAME, null, values1);

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
    public void findByLocType(String type) {

        List<Location> locationListByType = new ArrayList<>();

        db = dbHelper.getReadableDatabase();

        Cursor cursor1 = db.query(DataContract.LocationEntry.TABLE_TYPE_NAME,
                new String[] {DataContract.LocationEntry._ID_OF_TYPE},
                DataContract.LocationEntry.COLUMN_TYPE_NAME + " = ",
                new String[] {type},
                null, null, null);


        if (cursor1!= null) {
            cursor1.moveToFirst();
        }
        cursor1.getInt(0);

        Cursor cursor2 = db.query(DataContract.LocationEntry.TABLE_LOCATIONS_NAME,
                new String[] {DataContract.LocationEntry.COLUMN_NAME,DataContract.LocationEntry.COLUMN_ADRESS},
                DataContract.LocationEntry.COLUMN_TYPE_NAME + " = ",
                new String[] {type},
                null, null, null);

        if (cursor2!= null) {
            cursor2.moveToFirst();
        }

        int i = 0;
        do {
            Location location = new Location(cursor2.getInt(0), cursor2.getString(1), cursor2.getString(1), cursor2.getDouble(2), cursor2.getDouble(3), cursor2.getString(4));
            locationListByType.add(i, location);


            i++;
        } while (cursor1.moveToNext());

        db.close();


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
}
