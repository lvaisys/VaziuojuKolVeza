package transport.psi.vu.mif.com.vezukolveza.DataManager;



import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CityData {

    // Database fields
    private SQLiteDatabase database;
    private CitySqlHelper dbHelper;
    private String[] allColumns = { CitySqlHelper.COLUMN_ID,
            CitySqlHelper.COLUMN_NAME };

    public CityData(Context context) {
        dbHelper = new CitySqlHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public City createCity(String city) {
        ContentValues values = new ContentValues();
        values.put(CitySqlHelper.COLUMN_NAME, city);

        long insertId = database.insert(CitySqlHelper.TABLE_CITIES, null,
                values);
        Cursor cursor = database.query(CitySqlHelper.TABLE_CITIES,
                allColumns, CitySqlHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        City newCity = cursorToCity(cursor);
        cursor.close();
        return newCity;
    }

    public void deleteCity(City city) {
        long id = city.getId();
        database.delete(CitySqlHelper.TABLE_CITIES, CitySqlHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<City> getAllComments() {
        List<City> cities = new ArrayList<City>();

        Cursor cursor = database.query(CitySqlHelper.TABLE_CITIES,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            City city = cursorToCity(cursor);
            cities.add(city);
            cursor.moveToNext();
        }

        cursor.close();
        return cities;
    }

    private City cursorToCity(Cursor cursor) {
        City city = new City(cursor.getString(1));
        city.setId(cursor.getLong(0));
        return city;
    }
} 

