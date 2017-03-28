package whitechurchapplication.sig.mvp.model.dao;

import android.provider.BaseColumns;

/**
 * Created by Nazar on 27.03.2017.
 */

public class LocationContract {
    private LocationContract() {
    }

    ;

    public static final class LocationEntry implements BaseColumns {
        public final static String TABLE_NAME = "guests";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME = "name";
        public final static String COLUMN_LONGITUDE = "longitude";
        public final static String COLUMN_LATITUDE = "latitude";

    }
}
