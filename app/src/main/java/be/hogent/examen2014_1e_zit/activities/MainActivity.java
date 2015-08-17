package be.hogent.examen2014_1e_zit.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import be.hogent.examen2014_1e_zit.Persistentie.Constants;
import be.hogent.examen2014_1e_zit.Persistentie.RedditContentProvider;
import be.hogent.examen2014_1e_zit.R;
import be.hogent.examen2014_1e_zit.fragments.SubRedditsFragment;
import be.hogent.examen2014_1e_zit.interfaces.SubredditsListener;
import be.hogent.examen2014_1e_zit.models.subreddits.SubRedditData;
import be.hogent.examen2014_1e_zit.network.SubredditsDownloader;

/**
 * Dit is de klasse van beginactivity. Deze laadt de subreddits vanuit zijn lokale database. Indien
 * er nog geen subreddits opgeslaan zijn dan kunnen deze geladen worden en opgeslaan worden door
 * op de refresh knop te drukken.
 */

public class MainActivity extends Activity implements SubredditsListener{

    /**
     * TAG die gebruikt wordt om output te loggen. Gebruik enkel deze tag om te loggen!
     */
    public static final String TAG = FullscreenActivity.class.getName();
    /**
     * TAG die gebruikt wordt om een fragment te benoemen die geladen wordt bij deze activity.
     */
    public static final String SUBREDDITS_TAG = "be.hogent.examen2014_1e_zit.SUBREDDITS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"Starting Activity");
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (fm.findFragmentByTag(SUBREDDITS_TAG) == null) {
            Log.i(TAG, "Adding SubRedditsFragment to the activity ");
            //Add Subreddits to the the activity
            SubRedditsFragment subRedditsFragment = new SubRedditsFragment();
            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            subRedditsFragment.setArguments(getIntent().getExtras());
            transaction.add(R.id.subreddits_container, subRedditsFragment, SUBREDDITS_TAG);
        }
        transaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    /**
     * TODO: opdracht 4.1
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return true;
    }


    /**
     * TODO: opdracht 4.2: voeg hier de code toe die de subreddits in de databank steekt na het laden. Let erop
     * dat je het toevoegen assynchroon van de Main UI thread doet. (Gebruik dus een Async...

     */
    @Override
    public void downloadCompleted(List<SubRedditData> subRedditDatas) {


    }


}
