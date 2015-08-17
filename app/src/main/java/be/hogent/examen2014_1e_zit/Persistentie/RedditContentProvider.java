package be.hogent.examen2014_1e_zit.Persistentie;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by jbuy519 on 03/12/2014.
 */
public class RedditContentProvider extends ContentProvider{

    /**
     * TAG die gebruikt wordt om output te loggen. Gebruik enkel deze tag om te loggen!
     */
    public static final String TAG = RedditContentProvider.class.getName();
    private RedditDB dba;
    private static final UriMatcher uriMatcher;
    private static final int SUBREDDITS = 1;

    public static final String AUTHORITY = "be.hogent.examen2014_1e_zit";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
            + "/" + Constants.TABLE_NAME_SUBREDDITS);
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, Constants.TABLE_NAME_SUBREDDITS, SUBREDDITS);
    }

    @Override
    public boolean onCreate() {
        dba = new RedditDB(this.getContext());
        dba.open();
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor c = null;
        switch(uriMatcher.match(uri)){
            case SUBREDDITS:
                c = dba.getSubRedditss();
                break;
            default:
                throw new IllegalArgumentException("Unknown URI" + uri);
        }
        c.setNotificationUri(getContext().getContentResolver(),uri);
        return c;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        dba.insertSubreddit(values);
        getContext().getContentResolver().notifyChange(uri, null);
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        dba.deleteAllElements();
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

}
