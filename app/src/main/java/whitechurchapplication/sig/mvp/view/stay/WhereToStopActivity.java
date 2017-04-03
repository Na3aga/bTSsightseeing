package whitechurchapplication.sig.mvp.view.stay;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import whitechurchapplication.sig.R;
import whitechurchapplication.sig.mvp.model.data.DataContract;
import whitechurchapplication.sig.mvp.model.data.DbHelper;

public class WhereToStopActivity extends AppCompatActivity {

    private String[] columns = {DataContract.LocationEntry.COLUMN_NAME, DataContract.LocationEntry.COLUMN_LATITUDE, DataContract.LocationEntry.COLUMN_LONGITUDE};
    whitechurchapplication.sig.mvp.model.entities.Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where_to_stop);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        DbHelper dbHelper;
        SQLiteDatabase db;
        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query(DataContract.LocationEntry.TABLE_NAME,
                new String[] {DataContract.LocationEntry.COLUMN_NAME, DataContract.LocationEntry.COLUMN_LATITUDE, DataContract.LocationEntry.COLUMN_LONGITUDE},
                "_Id = ?",
                new String[] {Integer.toString(1)},
                null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        textView1.setText("Name = " + cursor.getString(0));
        db.close();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
