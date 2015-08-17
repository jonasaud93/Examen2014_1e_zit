package be.hogent.examen2014_1e_zit.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import be.hogent.examen2014_1e_zit.R;
import be.hogent.examen2014_1e_zit.activities.FullscreenActivity;
import be.hogent.examen2014_1e_zit.adapters.ThumbNailAdapter;
import be.hogent.examen2014_1e_zit.interfaces.ListingsInterface;
import be.hogent.examen2014_1e_zit.models.listings.*;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by jbuy519 on 08/12/2014.
 */
public class ListingFragment extends Fragment {

    /**
     * TAG die gebruikt wordt om output te loggen. Gebruik enkel deze tag om te loggen!
     */
    public static final String TAG = ListingFragment.class.getName();

    /**
     * DE subreddit waarvoor we een listing aan het maken zijn. Deze heeft de vorm
     * /r/naam_van_de_subreddit
     */
    private String subReddit;
    /**
     * TAG dat gebruikt wordt om de subredditparameter mee te geven met een intent
     * naar dit fragment.
     */
    public static final String SUBREDDIT  ="be.hogent.examen2013.SUBRREDDIT";
    /**
     * De referentie naar de lijst met de posts van de betreffende subreddit
     */
    List<ListingData> dataList;
    /**
     * De interface die gebruikt wordt om calls (retrofit) te maken met de API van reddit.
     */
    ListingsInterface redditRestAPI;

    /**
     * Referentie naar de lijst in de view
     */
    private ListView list;
    /**
     * De adapter voor de view.
     */
    private ThumbNailAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null && getArguments().containsKey(SUBREDDIT)){
            subReddit = getArguments().getString(SUBREDDIT);
            Log.i(TAG,"Start fragment for " + subReddit);
        }


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lisitings,container, false);
        return view;
    }


    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = (ListView)getActivity().findViewById(R.id.listings);
        dataList = new ArrayList<>();
        adapter = new ThumbNailAdapter(getActivity().getApplicationContext(),0,dataList);
        list.setAdapter(adapter);
        getData();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), FullscreenActivity.class);
                ListingData d = dataList.get(position);
                intent.putExtra(FullscreenActivity.TITLE,d.getTitle());
                intent.putExtra(FullscreenActivity.URL,d.getUrl());

            }
        });

    }

    /**
     * TODO: opdracht 5.1
     */
    public void getData(){

    }
}
