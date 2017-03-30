package whitechurchapplication.sig.mvp.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class LocationDbHelper extends SQLiteOpenHelper {


    public static final String LOG_TAG = LocationDbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "locations.db";
    private static final int DATABASE_VERSION = 1;

    /**
     * Конструктор {@link LocationDbHelper}.
     *
     * @param context Контекст приложения
     */
    public LocationDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    /**
     * Вызывается при создании базы данных
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_GUESTS_TABLE = "CREATE TABLE " + LocationContract.LocationEntry.TABLE_NAME + " ("
                + LocationContract.LocationEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LocationContract.LocationEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + LocationContract.LocationEntry.COLUMN_LONGITUDE + " TEXT NOT NULL, "
                + LocationContract.LocationEntry.COLUMN_LATITUDE + " TEXT NOT NULL);";

        db.execSQL(SQL_CREATE_GUESTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}