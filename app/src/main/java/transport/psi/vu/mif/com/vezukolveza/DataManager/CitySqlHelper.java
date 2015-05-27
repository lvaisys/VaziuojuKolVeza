package transport.psi.vu.mif.com.vezukolveza.DataManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CitySqlHelper extends SQLiteOpenHelper {

    public static final String TABLE_CITIES = "trips";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";


    private static final String DATABASE_NAME = "transport.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_CITIES + "(" + COLUMN_ID
            + " integer primary key autoincrement, "
            + COLUMN_NAME + " text not null,"
            +");";

    public CitySqlHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(CitySqlHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CITIES);
        onCreate(db);
    }

}


