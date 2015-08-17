package be.hogent.examen2014_1e_zit.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import be.hogent.examen2014_1e_zit.R;
import be.hogent.examen2014_1e_zit.fragments.ListingFragment;
import be.hogent.examen2014_1e_zit.fragments.SubRedditsFragment;

/**
 * Created by jbuy519 on 08/12/2014.
 */
public class ListingActivity extends Activity {

    /**
     * TAG dat gebruikt wordt om het fragment te duiden bij deze acitivity.
     */
    public static final String LISTINGS_FRAGMENT= "be.hogent.examen2014.ListingsActivity";
    /**
     * TAG die gebruikt wordt om output te loggen. Gebruik enkel deze tag om te loggen!
     */
    public static final String TAG = ListingActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisiting);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (fm.findFragmentByTag(LISTINGS_FRAGMENT) == null) {
            Log.i(TAG, "Adding LisitingsFragment to the activity ");
            //Add Subreddits to the the activity
            ListingFragment frag = new ListingFragment();
            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            frag.setArguments(getIntent().getExtras());
            transaction.add(R.id.listing_container, frag, LISTINGS_FRAGMENT);
        }
        transaction.commit();
    }


}
