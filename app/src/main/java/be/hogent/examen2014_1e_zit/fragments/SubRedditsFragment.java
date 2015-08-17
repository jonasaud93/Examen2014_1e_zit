package be.hogent.examen2014_1e_zit.fragments;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import be.hogent.examen2014_1e_zit.Persistentie.Constants;
import be.hogent.examen2014_1e_zit.Persistentie.RedditContentProvider;
import be.hogent.examen2014_1e_zit.R;
import be.hogent.examen2014_1e_zit.activities.ListingActivity;
import be.hogent.examen2014_1e_zit.adapters.SubredditAdapter;
import be.hogent.examen2014_1e_zit.models.subreddits.SubRedditData;

/**
 * Created by jbuy519 on 08/12/2014.
 */
public class SubRedditsFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    /**
     * Actie die gebruikt wordt om subreddits up te daten.
     */
    public static final String ACTION_UPDATE_SUBREDDITS = "be.hogent.examen2014_1e_zit.ACTION_UPDATE_SUBREDDITS";
    /**
     * Lijst met de informatie betreffende de subreddits die getoond moeten worden. (Moet dezelfde
     * informatie bevatten als de onderliggende databank.
     */
    private List<SubRedditData> subRedditDataList;
    /**
     * De ListView die de subreddits toont.
     */
    private ListView list;
    /**
     * Intent filter om intent resolutie te doen voor de broadcastreceiver.
     */
    private IntentFilter filter;
    /**
     * TAG die gebruikt wordt om output te loggen. Gebruik enkel deze tag om te loggen!
     */
    public static final String TAG = SubRedditsFragment.class.getName();

    /**
     * De adapter voor de lijst.
     */
    private SubredditAdapter adapter;
    /**
     * Broadcastreceiver die luistert naar bepaalde intents
     */
    private BroadcastReceiver receiver;

    /**
     * De Listview die de subreddits bevat
     */

    private ListView listView;

    //TODO opdracht 4.4: definieer een eigen broadcastReceiver (bekijk de reeds gedefnieerde variabale namen
    //hierboven om ze toe te kennen.

    /**
     * TODO 4.4: vul code verder aan
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG,"Added broadcastreceiver");
        getActivity().registerReceiver(receiver,filter);
        adapter = new SubredditAdapter(getActivity().getApplicationContext(),subRedditDataList);

        if(listView == null){
            listView = (ListView) getActivity().findViewById(R.id.subreddits);
        }
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),ListingActivity.class);
                SubRedditData data = subRedditDataList.get(position);
                intent.putExtra(ListingFragment.SUBREDDIT,data.getUrl());
                startActivity(intent);
            }
        });
    }

    //TODO: opdracht opdracht 4.4 Best Practices! (Denk aan de lifecycle van een Android app)



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subreddits,container, false);
        list = (ListView)view.findViewById(R.id.subreddits);
        return view;
    }

    //TODO: opdacht 4.3
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }



    //TODO: opdacht 4.3
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

       //TODO: niet vergeten er bij te zetten!
        getLoaderManager().destroyLoader(loader.getId());
    }

    //TODO: opdacht 4.3
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
