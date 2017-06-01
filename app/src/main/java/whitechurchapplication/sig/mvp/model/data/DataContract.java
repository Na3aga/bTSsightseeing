package whitechurchapplication.sig.mvp.model.data;

import android.provider.BaseColumns;

public class DataContract {

    public static final class LocationEntry implements BaseColumns {
        public final static String TABLE_LOCATIONS_NAME = "locationList";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME = "name";
        public final static String COLUMN_ADRESS = "adress";
        public final static String COLUMN_PHONE = "phone";
        public final static String COLUMN_SHORT_DESCRPT = "shortDescription";
        public final static String COLUMN_LONG_DESCRPT = "longDescription";
        public final static String COLUMN_LONGITUDE = "longitude";
        public final static String COLUMN_LATITUDE = "latitude";
        public final static String COLUMN_VERSION = "version";
        public final static String COLUMN_DELETED = "deleted";
        public final static String ID_TYPE = "idType";

        public final static String TABLE_TYPE_NAME = "locationByTypeList";
        public final static String _ID_OF_TYPE = BaseColumns._ID;
        public final static String COLUMN_TYPE_NAME = "typeName";

        public final static String TABLE_IMAGE_LIST = "imageList";
        public final static String _ID_IMAGE = BaseColumns._ID;
        public final static String _ID_IMG_LOCATION = "_ID_";
        public final static String COLUMN_URL = "imageUrl";

    }
}
