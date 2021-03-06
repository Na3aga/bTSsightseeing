package whitechurchapplication.sig.mvp.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import whitechurchapplication.sig.mvp.model.data.DataContract;
import whitechurchapplication.sig.mvp.model.data.DbHelper;
import whitechurchapplication.sig.mvp.model.entities.ImageList;
import whitechurchapplication.sig.mvp.model.entities.Location;

public class MainDaoImpl implements MainDao {

    private Context context;
    private DbHelper dbHelper;
    private SQLiteDatabase db;
    private double maxVersion = 0;

    public MainDaoImpl(Context context) {
        this.context = context;
        dbHelper = new DbHelper(context);
    }


    @Override
    public boolean saveAll(List<Location> locationList) {

        maxVersion = maxVersion();
        for (Location location : locationList) {
            save(location);
        }

        return true;
    }


    @Override
    public void save(Location location) {

        int _id = location.getId();
        double version = location.getVersion();
        //deleted location test
        if (location.getDeleted() == true) {
            delete(_id);
        } else {
            //initialize db
            //
            //check for type existence in the table of types
            int typeId = location.getLocationType().getId();
            String typeName = location.getLocationType().getType();
            if (testForUniquenessType(typeName) == true) {
                //if type is uniq(new) adds it to table
                db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(DataContract.LocationEntry._ID_OF_TYPE, typeId);
                values.put(DataContract.LocationEntry.COLUMN_TYPE_NAME, typeName);

                db.insertOrThrow(DataContract.LocationEntry.TABLE_TYPE_NAME, null, values);
                db.close();
            }
            //
            //check for location existence in database
            db = dbHelper.getWritableDatabase();
            Cursor cursor = db.query(DataContract.LocationEntry.TABLE_LOCATIONS_NAME,
                    new String[]{DataContract.LocationEntry.COLUMN_NAME},
                    DataContract.LocationEntry._ID + " = ? ",
                    new String[]{String.valueOf(_id)},
                    null, null, null);
            //
            if (cursor == null || cursor.getCount() == 0) {
                //if no = adds to db
                saveLocToDB(location);
            } else {
                //else compares it's version with current maximum location version
                if (version > maxVersion) {
                    //updates rows
                    update(location);
                }
            }
            db.close();
        }

    }


    @Override
    public Location findById(int id) {

        Location location;

        SQLiteDatabase ndb = dbHelper.getReadableDatabase();

        Cursor cursor = ndb.query(DataContract.LocationEntry.TABLE_LOCATIONS_NAME,
                new String[]{DataContract.LocationEntry._ID, DataContract.LocationEntry.COLUMN_NAME, DataContract.LocationEntry.COLUMN_SHORT_DESCRPT, DataContract.LocationEntry.COLUMN_LATITUDE,
                        DataContract.LocationEntry.COLUMN_LONGITUDE, DataContract.LocationEntry.COLUMN_ADRESS, DataContract.LocationEntry.COLUMN_PHONE, DataContract.LocationEntry.COLUMN_LONG_DESCRPT},
                DataContract.LocationEntry._ID + " = ? ",
                new String[]{Integer.toString(id)},
                null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        location = new Location(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getDouble(3), cursor.getDouble(4), cursor.getString(5), null, cursor.getString(6), cursor.getString(7));//TODO
        cursor.close();


        cursor = ndb.query(DataContract.LocationEntry.TABLE_IMAGE_LIST,
                new String[]{DataContract.LocationEntry._ID_IMAGE, DataContract.LocationEntry.COLUMN_URL},
                DataContract.LocationEntry._ID_IMG_LOCATION + " = ? ",
                new String[]{Integer.toString(id)},
                null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }


        List<ImageList> imageList = new ArrayList<ImageList>();

        for (int i = 0; i < cursor.getCount(); i++) {
            ImageList imageList1 = new ImageList(cursor.getInt(0), cursor.getString(1));
            imageList.add(imageList1);
            cursor.moveToNext();
        }
        cursor.close();
        location.setImageList(imageList);
        ndb.close();

        return location;
    }

    @Override
    public List<Location> findByLocType(String type) {

        List<Location> locationListByType = new ArrayList<>();

        SQLiteDatabase qndb = dbHelper.getReadableDatabase();

        Cursor cursor1 = qndb.query(DataContract.LocationEntry.TABLE_TYPE_NAME,
                new String[]{DataContract.LocationEntry._ID_OF_TYPE},
                DataContract.LocationEntry.COLUMN_TYPE_NAME + " = ? ",
                new String[]{type},
                null, null, null);


        if (cursor1 != null) {
            cursor1.moveToFirst();
        }

        int typeId = cursor1.getInt(0);
        String id_type = String.valueOf(typeId);
        cursor1.close();
        qndb.close();
        SQLiteDatabase ndb = dbHelper.getReadableDatabase();

        Cursor cursor2 = ndb.query(DataContract.LocationEntry.TABLE_LOCATIONS_NAME,
                new String[]{DataContract.LocationEntry._ID, DataContract.LocationEntry.COLUMN_NAME, DataContract.LocationEntry.COLUMN_SHORT_DESCRPT, DataContract.LocationEntry.COLUMN_LATITUDE,
                        DataContract.LocationEntry.COLUMN_LONGITUDE, DataContract.LocationEntry.COLUMN_ADRESS, DataContract.LocationEntry.COLUMN_PHONE},
                DataContract.LocationEntry.ID_TYPE + " = ? ",
                new String[]{String.valueOf(id_type)},
                null, null, null);

        if (cursor2 != null) {
            cursor2.moveToFirst();


            int i = 0;

            do {
                int id = cursor2.getInt(0);
                Cursor cursor3 = ndb.query(DataContract.LocationEntry.TABLE_IMAGE_LIST,
                        new String[]{DataContract.LocationEntry.COLUMN_URL},
                        DataContract.LocationEntry._ID_IMG_LOCATION + " = ? ",
                        new String[]{String.valueOf(id)},
                        null, null, null);
                List<ImageList> imageLists = new ArrayList<>();
                if (cursor3 != null && cursor3.getCount() > 0) {
                    cursor3.moveToFirst();
                    do {
                        ImageList imageList = new ImageList(0, cursor3.getString(0));
                        imageLists.add(imageList);
                    } while (cursor3.moveToNext());
                }
                Location location = new Location(id, cursor2.getString(1), cursor2.getString(2), cursor2.getDouble(3), cursor2.getDouble(4), cursor2.getString(5), imageLists, cursor2.getString(6));
                locationListByType.add(i, location);

                i++;
            } while (cursor2.moveToNext());
        }
        cursor2.close();

        ndb.close();
        return locationListByType;

    }

    @Override
    public List<Location> findAll() {

        List<Location> locationList = new ArrayList<>();

        db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(DataContract.LocationEntry.TABLE_LOCATIONS_NAME,
                new String[]{DataContract.LocationEntry._ID, DataContract.LocationEntry.COLUMN_NAME, DataContract.LocationEntry.COLUMN_SHORT_DESCRPT, DataContract.LocationEntry.COLUMN_LATITUDE,
                        DataContract.LocationEntry.COLUMN_LONGITUDE, DataContract.LocationEntry.COLUMN_ADRESS, DataContract.LocationEntry.COLUMN_PHONE},
                null,
                null,
                null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        int i = 0;
        do {
            Location location = new Location(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getDouble(3), cursor.getDouble(4), cursor.getString(5), null, cursor.getString(6));//TODO
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

    @Override
    public void delete(int id) {
        //deletes images and data connected with location witch id it gets as argument
        db = dbHelper.getWritableDatabase();
        db.delete(DataContract.LocationEntry.TABLE_LOCATIONS_NAME, DataContract.LocationEntry._ID + " = ? ", new String[]{String.valueOf(id)});
        db.delete(DataContract.LocationEntry.TABLE_IMAGE_LIST, DataContract.LocationEntry._ID_IMG_LOCATION + " = ? ", new String[]{String.valueOf(id)});

        db.close();
    }

    @Override
    public void update(Location location) {
        //
        //this method updates all location data
        //
        //it is similar with "saveLocToDB" in all, but
        //we use db.update instead of db.insertOrThrow
        //
        //get location data
        int _id = location.getId();
        short deleted = 0;
        String locName = location.getName();
        String adress = location.getAddress();
        String phone = location.getPhone();
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        double version = location.getVersion();
        int typeId = location.getLocationType().getId();
        //get text data with utf-8
        String shortDescription = location.getShortDescription();
        try {
            shortDescription = new String(shortDescription.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String longDescription = location.getLongDescription();
        try {
            longDescription = new String(longDescription.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //
        //initialize db
        db = dbHelper.getWritableDatabase();


        if (location.getImageList() != null) {
            db.delete(DataContract.LocationEntry.TABLE_IMAGE_LIST, DataContract.LocationEntry._ID_IMG_LOCATION + " = ? ", new String[]{String.valueOf(_id)});
            for (int i = 0; i < location.getImageList().size(); i++) {
                try {
                    int imgId = location.getImageList().get(i).getId();

                    String imgUrl = location.getImageList().get(i).getUrl();

                    ContentValues values = new ContentValues();
                    values.put(DataContract.LocationEntry._ID_IMAGE, imgId);
                    values.put(DataContract.LocationEntry._ID_IMG_LOCATION, _id);
                    values.put(DataContract.LocationEntry.COLUMN_URL, imgUrl);

                    db.insertOrThrow(DataContract.LocationEntry.TABLE_IMAGE_LIST,null, values);

                } catch (Exception e) {
                    i = location.getImageList().size();
                }
            }
        }
        try {
            ContentValues values = new ContentValues();
            values.put(DataContract.LocationEntry._ID, _id);
            values.put(DataContract.LocationEntry.COLUMN_NAME, locName);
            values.put(DataContract.LocationEntry.COLUMN_SHORT_DESCRPT, shortDescription);
            values.put(DataContract.LocationEntry.COLUMN_LONG_DESCRPT, longDescription);
            values.put(DataContract.LocationEntry.COLUMN_PHONE, phone);
            values.put(DataContract.LocationEntry.COLUMN_LONGITUDE, longitude);
            values.put(DataContract.LocationEntry.ID_TYPE, typeId);
            values.put(DataContract.LocationEntry.COLUMN_LATITUDE, latitude);
            values.put(DataContract.LocationEntry.COLUMN_VERSION, version);
            values.put(DataContract.LocationEntry.COLUMN_DELETED, deleted);
            values.put(DataContract.LocationEntry.COLUMN_ADRESS, adress);


            db.update(DataContract.LocationEntry.TABLE_LOCATIONS_NAME, values, DataContract.LocationEntry._ID + " = ?", new String[]{String.valueOf(_id)});
        } catch (Exception e) {
        //TODO send messege to developer
        }

        db.close();

    }

    @Override
    public double maxVersion() {

        double maxVersion = 0;

        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DataContract.LocationEntry.TABLE_LOCATIONS_NAME,
                new String[]{DataContract.LocationEntry.COLUMN_VERSION},
                null,
                null,
                null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                if (cursor.getDouble(0) > maxVersion) {
                    maxVersion = cursor.getDouble(0);
                }
            } while (cursor.moveToNext());
        }
        return maxVersion;
    }

    private void saveLocToDB(Location location) {
        //get location data
        int _id = location.getId();
        short deleted = 0;
        String locName = location.getName();
        String adress = location.getAddress();
        String phone = location.getPhone();
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        double version = location.getVersion();
        int typeId = location.getLocationType().getId();
        //get text data with utf-8
        String shortDescription = location.getShortDescription();
        try {
            shortDescription = new String(shortDescription.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String longDescription = location.getLongDescription();
        try {
            longDescription = new String(longDescription.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //
        //initialize db
        db = dbHelper.getWritableDatabase();


        if (location.getImageList() != null) {
            for (int i = 0; i < location.getImageList().size(); i++) {
                try {
                    int imgId = location.getImageList().get(i).getId();

                    String imgUrl = location.getImageList().get(i).getUrl();

                    ContentValues values = new ContentValues();
                    values.put(DataContract.LocationEntry._ID_IMAGE, imgId);
                    values.put(DataContract.LocationEntry._ID_IMG_LOCATION, _id);
                    values.put(DataContract.LocationEntry.COLUMN_URL, imgUrl);
                    //adds images to imageTable
                    db.insertOrThrow(DataContract.LocationEntry.TABLE_IMAGE_LIST, null, values);

                } catch (Exception e) {
                    i = location.getImageList().size();
                }
            }
        }
        try {
            ContentValues values = new ContentValues();
            values.put(DataContract.LocationEntry._ID, _id);
            values.put(DataContract.LocationEntry.COLUMN_NAME, locName);
            values.put(DataContract.LocationEntry.COLUMN_SHORT_DESCRPT, shortDescription);
            values.put(DataContract.LocationEntry.COLUMN_LONG_DESCRPT, longDescription);
            values.put(DataContract.LocationEntry.COLUMN_PHONE, phone);
            values.put(DataContract.LocationEntry.COLUMN_LONGITUDE, longitude);
            values.put(DataContract.LocationEntry.ID_TYPE, typeId);
            values.put(DataContract.LocationEntry.COLUMN_LATITUDE, latitude);
            values.put(DataContract.LocationEntry.COLUMN_VERSION, version);
            values.put(DataContract.LocationEntry.COLUMN_DELETED, deleted);
            values.put(DataContract.LocationEntry.COLUMN_ADRESS, adress);

            //adds data of "location"
            db.insertOrThrow(DataContract.LocationEntry.TABLE_LOCATIONS_NAME, null, values);
        } catch (Exception e) {

        }

        db.close();

    }

}
