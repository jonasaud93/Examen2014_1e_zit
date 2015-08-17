package be.hogent.examen2014_1e_zit.Persistentie;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

/**
 * Created by jbuy519 on 03/12/2014.
 */
public class RedditDB {

    /**
     * TAG die gebruikt wordt om output te loggen. Gebruik enkel deze tag om te loggen!
     */
    public static final String TAG = RedditDB.class.getName();
    private SQLiteDatabase db;
    private final Context context;
    private final RedditDBHelper dbHelper;

    /**
     * Initialises this DB. Make sure the dbHelper object is also initialised.
     * @param context
     */
    public RedditDB(Context context) {
        this.context = context;
        dbHelper = new RedditDBHelper(context,Constants.DATABASE_NAME,null,Constants.DATABASE_VERSION);
    }

    /**
     * Closes the database
     */
    public void close(){
        db.close();
    }
    /**
     * Tries to open a writable database. If this is not possible, open a readable database.
     * Log the necessary messages for debugging purposes.
     */
    public void open(){
        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            Log.e(TAG,"Could not create a writeable database. Readable database has been opened");
            Log.e(TAG,e.getMessage());
            db = dbHelper.getReadableDatabase();
        }
    }


    public long insertSubreddit(ContentValues contentValue){
        try{
            return db.insert(Constants.TABLE_NAME_SUBREDDITS,null,contentValue);
        }catch(SQLiteException e){
            Log.e(TAG, "Inserting into database did not work");
            Log.e(TAG,e.getMessage());
            return -1;
        }
    }

    public void deleteAllElements(){
        try{
            db.execSQL("DELETE FROM "+Constants.TABLE_NAME_SUBREDDITS);
            Log.i("DBA","Removed alle elements");
        }catch(SQLiteException e){
            e.printStackTrace();
        }
    }

    /**
     * Fetches all diary entries from the database
     * @return The diary entries from the database.
     */
    public Cursor getSubRedditss(){
        Cursor c = db.query(Constants.TABLE_NAME_SUBREDDITS,null,null,null,null,null,null);
        return c;
    }
}
