package be.hogent.examen2014_1e_zit.Persistentie;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jbuy519 on 03/12/2014.
 */
public class RedditDBHelper extends SQLiteOpenHelper {

    /**
     * TAG die gebruikt wordt om output te loggen. Gebruik enkel deze tag om te loggen!
     */
    public static final String TAG = RedditDBHelper.class.getName();

    private static final String CREATE_TABLE ="CREATE TABLE "+Constants.TABLE_NAME_SUBREDDITS+ " ("+
            Constants.KEY_ID+" integer primary key autoincrement, "+
            Constants.SUBREDDIT_NAME + " text not null, "+
            Constants.URL + " text not null, UNIQUE("+Constants.SUBREDDIT_NAME+"));";

    public RedditDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Generates the tables in the  de SQLiteDatabase
     * @param db The SQLIteDatabase to add the tables to
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, " Creating the tables of the database");
        try{
            db.execSQL(CREATE_TABLE);
        }catch(SQLiteException e){
            Log.e(TAG," Create table exception");
            Log.e(TAG," "+ e.getMessage());
        }
    }

    /**
     * Performs an upgrade of the database in case of version mismatch.
     * Implementation here is to drop all the tables and generate new tables.
     * For actual implementations this should perform a clean data migration
     * @param db The database to update
     * @param oldVersion The old version of the database
     * @param newVersion The new version to perform the update for
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v(TAG," Upgrading from version "+oldVersion + " to "+newVersion +" and will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLE_NAME_SUBREDDITS);
        onCreate(db);

    }
}
