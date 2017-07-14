package whitechurchapplication.sig.mvp.model.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "locations.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_LOCATIONS_TABLE = "CREATE TABLE " + DataContract.LocationEntry.TABLE_LOCATIONS_NAME + " ("
                + DataContract.LocationEntry._ID + " INTEGER NOT NULL, "
                + DataContract.LocationEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + DataContract.LocationEntry.COLUMN_ADRESS + " TEXT NOT NULL, "
                + DataContract.LocationEntry.COLUMN_SHORT_DESCRPT + " TEXT NOT NULL, "
                + DataContract.LocationEntry.COLUMN_LONG_DESCRPT + " TEXT NOT NULL, "
                + DataContract.LocationEntry.COLUMN_PHONE + " TEXT NOT NULL, "//TODO
                + DataContract.LocationEntry.COLUMN_LONGITUDE + " REAL, "
                + DataContract.LocationEntry.COLUMN_LATITUDE + " REAL, "
                + DataContract.LocationEntry.COLUMN_VERSION + " INTEGER, "//TODO
                + DataContract.LocationEntry.COLUMN_DELETED + " INTEGER, "//TODO
                + DataContract.LocationEntry.ID_TYPE + " INTEGER , FOREIGN KEY("
                + DataContract.LocationEntry.ID_TYPE + ") REFERENCES "
                + DataContract.LocationEntry.TABLE_TYPE_NAME + "(" + DataContract.LocationEntry._ID_OF_TYPE + ") ); ";

        db.execSQL(SQL_CREATE_LOCATIONS_TABLE);

        String SQL_CREATE_TYPE_TABLE = "CREATE TABLE " + DataContract.LocationEntry.TABLE_TYPE_NAME + " ("
                + DataContract.LocationEntry._ID_OF_TYPE + " INTEGER PRIMARY KEY , "
                + DataContract.LocationEntry.COLUMN_TYPE_NAME + " TEXT NOT NULL) ;";

        db.execSQL(SQL_CREATE_TYPE_TABLE);

        String SQL_CREATE_IMAGE_LIST_TABLE = "CREATE TABLE " + DataContract.LocationEntry.TABLE_IMAGE_LIST + " ("
                + DataContract.LocationEntry._ID_IMAGE + " INTEGER , "
                + DataContract.LocationEntry.COLUMN_URL + " TEXT NOT NULL , "
                + DataContract.LocationEntry._ID_IMG_LOCATION + " INTEGER , FOREIGN KEY("
                + DataContract.LocationEntry._ID_IMG_LOCATION + ") REFERENCES "
                + DataContract.LocationEntry.TABLE_LOCATIONS_NAME + "(" + DataContract.LocationEntry._ID + ") ); ";

        db.execSQL(SQL_CREATE_IMAGE_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}