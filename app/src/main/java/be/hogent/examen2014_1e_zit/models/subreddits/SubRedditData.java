package be.hogent.examen2014_1e_zit.models.subreddits;

/**
 * Created by jbuy519 on 14/11/2014.
 */
public class SubRedditData {

    /**
     * Titel van de subreddit
     */
    private String title;

    /**
     * Url van de subreddit
     */
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }


}
