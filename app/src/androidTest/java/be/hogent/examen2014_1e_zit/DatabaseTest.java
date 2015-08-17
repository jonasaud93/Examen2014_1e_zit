package be.hogent.examen2014_1e_zit;

import android.content.ContentResolver;
import android.database.Cursor;
import android.test.AndroidTestCase;

import be.hogent.examen2014_1e_zit.Persistentie.RedditContentProvider;

/**
 * Created by jbuy519 on 04/12/2014.
 */
public class DatabaseTest extends AndroidTestCase{

    public void testDatabase(){
        ContentResolver cr = getContext().getContentResolver();
        Cursor c = cr.query(RedditContentProvider.CONTENT_URI,null,null,null,null);
        assertEquals(25,c.getCount());
    }
}
