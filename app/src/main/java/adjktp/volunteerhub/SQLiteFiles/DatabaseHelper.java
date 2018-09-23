package adjktp.volunteerhub.SQLiteFiles;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 3;

    // Database Name
    private static final String DATABASE_NAME = "local_storage_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(LocalStorageDB.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + LocalStorageDB.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertValue(String key, String value) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LocalStorageDB.COLUMN_ID, key);
        values.put(LocalStorageDB.COLUMN_VALUE, value);

        long id = 999;
        // insert row
        try {
            id = db.insert(LocalStorageDB.TABLE_NAME, null, values);
        } catch (SQLiteConstraintException ex) {
            ex.printStackTrace();
        }

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public String getValue(String id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(LocalStorageDB.TABLE_NAME,
                new String[]{LocalStorageDB.COLUMN_ID, LocalStorageDB.COLUMN_VALUE},
                LocalStorageDB.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        String rtn = cursor.getString(cursor.getColumnIndex(LocalStorageDB.COLUMN_VALUE));

        // close the db connection
        cursor.close();

        return rtn;
    }

    public int updateValue(String id, String newValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LocalStorageDB.COLUMN_VALUE, newValue);
        String[] whereArgs= {id};
        int count =db.update(LocalStorageDB.TABLE_NAME, contentValues, LocalStorageDB.COLUMN_ID+" = ?",whereArgs );
        return count;
    }

}