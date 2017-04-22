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
                + DataContract.LocationEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DataContract.LocationEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + DataContract.LocationEntry.COLUMN_LONGITUDE + " TEXT NOT NULL, "
                + DataContract.LocationEntry.COLUMN_LATITUDE + " TEXT NOT NULL, "
                +DataContract.LocationEntry.COLUMN_ADRESS + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_LOCATIONS_TABLE);

        String SQL_CREATE_TYPE_TABLE = "CREATE TABLE " + DataContract.LocationEntry.TABLE_TYPE_NAME + " ("
                + DataContract.LocationEntry._ID + " INTEGER PRIMARY KEY , "
                + DataContract.LocationEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + DataContract.LocationEntry.COLUMN_LONGITUDE + " TEXT NOT NULL, "
                + DataContract.LocationEntry.COLUMN_LATITUDE + " TEXT NOT NULL, "
                + DataContract.LocationEntry.COLUMN_TYPE + " TEXT NOT NULL, "
                +DataContract.LocationEntry.COLUMN_ADRESS + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_TYPE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}