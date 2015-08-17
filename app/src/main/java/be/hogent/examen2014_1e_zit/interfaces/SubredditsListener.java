package be.hogent.examen2014_1e_zit.interfaces;

import java.util.List;

import be.hogent.examen2014_1e_zit.models.subreddits.SubRedditData;

/**
 * Created by jbuy519 on 04/12/2014.
 *
 * Klasse die gebruikt wordt om de SubreddtsTask te testen.
 */
public interface  SubredditsListener {

    /**
     * Wordt opgeroepen wanneer de lijst met subreddits gedownload is.
     * @param subRedditDatas
     */
    void downloadCompleted(List<SubRedditData> subRedditDatas);
}
