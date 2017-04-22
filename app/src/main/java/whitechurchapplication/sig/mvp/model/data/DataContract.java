package whitechurchapplication.sig.mvp.model.data;

import android.provider.BaseColumns;

public class DataContract {

    public static final class LocationEntry implements BaseColumns {
        public final static String TABLE_LOCATIONS_NAME = "locationList";
        public final static String TABLE_TYPE_NAME = "locationByTypeList";
        public final static String COLUMN_TYPE = "type";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME = "name";
        public final static String COLUMN_LONGITUDE = "longitude";
        public final static String COLUMN_LATITUDE = "latitude";
        public final static String COLUMN_ADRESS = "adress";

    }
}
