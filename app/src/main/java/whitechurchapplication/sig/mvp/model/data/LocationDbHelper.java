package whitechurchapplication.sig.mvp.model.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LocationDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "locations.db";
    private static final int DATABASE_VERSION = 1;

    public LocationDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_GUESTS_TABLE = "CREATE TABLE " + DataContract.LocationEntry.TABLE_NAME + " ("
                + DataContract.LocationEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DataContract.LocationEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + DataContract.LocationEntry.COLUMN_LONGITUDE + " TEXT NOT NULL, "
                + DataContract.LocationEntry.COLUMN_LATITUDE + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_GUESTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}