package adjktp.volunteerhub.SQLiteFiles;

public class LocalStorageDB {

    public static final String TABLE_NAME = "localstoragedb";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_VALUE = "value";

    private String id, value;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " TEXT NOT NULL,"
                    + COLUMN_VALUE + " TEXT)";

    public LocalStorageDB() {
    }

    public LocalStorageDB(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setNote(String value) {
        this.value = value;
    }

    public void setId(String id) {
        this.id = id;
    }
}