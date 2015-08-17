package be.hogent.examen2014_1e_zit.interfaces;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;


import be.hogent.examen2014_1e_zit.models.listings.*;

/**
 * Created by jbuy519 on 08/12/2014.
 */
public interface ListingsInterface {

    /**
     * Gaat de JSON informatie ophalen voor een bepaalde subreddit en deze parsen.
     * @param section In dit geval altijd /r/
     * @param subreddit De naam van de subdreddit die opgehaald moet worden
     * @param data De callback interface die opgeroepen moet worden na het laden.
     */
    @GET("/{section}/{subreddit}")
    void getListing(@Path("section") String section, @Path("subreddit") String subreddit, Callback<Listing> data );
}
