package be.hogent.examen2014_1e_zit.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import be.hogent.examen2014_1e_zit.interfaces.SubredditsListener;
import be.hogent.examen2014_1e_zit.models.subreddits.Data;
import be.hogent.examen2014_1e_zit.models.subreddits.Listing;
import be.hogent.examen2014_1e_zit.models.subreddits.SubReddit;
import be.hogent.examen2014_1e_zit.models.subreddits.SubRedditData;

/**
 * Created by jbuy519 on 04/12/2014.
 */
public class SubredditsDownloader {
    /**
     * TAG die gebruikt wordt om output te loggen. Gebruik enkel deze tag om te loggen!
     */
    public static final String TAG = SubredditsDownloader.class.getName();

    private SubredditsListener subredditsListener;
    public SubredditsDownloader(SubredditsListener subredditsListener) {
        this.subredditsListener = subredditsListener;
    }

    public void download(URL url){
        new SubredditsTask().execute(url);
    }

    /**
     * De uiteindelijke klasse voor het downloaden van de meest populaire subreddits.
     */
    public class SubredditsTask extends AsyncTask<URL,Integer,List<SubRedditData>> {

        /**
         * TAG die gebruikt wordt om output te loggen. Gebruik enkel deze tag om te loggen!
         */
        public final String TAG = SubredditsTask.class.getName();


        /**
         * TODO: Opdracht 3.1
         */
        @Override
        protected List<SubRedditData> doInBackground(URL... params) {
            URL url = null;

            try{
                url = params[0];

                URLConnection connection = url.openConnection();
                HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

                int responseCode = httpURLConnection.getResponseCode();
                if(responseCode == HttpURLConnection.HTTP_OK){
                    InputStream in = httpURLConnection.getInputStream();

                    Reader reader = new InputStreamReader(in);
                    Gson gson = new Gson();

                    Listing listing =  gson.fromJson(reader, Listing.class);
                    List<SubRedditData> data = new ArrayList<>();

                    for(SubReddit reddit : listing.getData().getChildren())
                        data.add(reddit.getSubRedditData());

                    return data;


                }
            } catch (IOException e) {
                Log.e(TAG, "IO excpetion in connection setup: " + e);
                return null;
            }

            return null;
        }

        /**
         * TODO: Opdracht 3.1 : zorg ervoor dat na het downloaden de listener het gevraagde uitvoert
         */
        @Override
        protected void onPostExecute(List<SubRedditData> subRedditDatas) {
            subredditsListener.downloadCompleted(subRedditDatas);
        }


    }
    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
