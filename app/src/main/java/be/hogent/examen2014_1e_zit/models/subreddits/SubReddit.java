package be.hogent.examen2014_1e_zit.models.subreddits;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jbuy519 on 14/11/2014.
 */
public class SubReddit {


    @SerializedName("data")
    private SubRedditData subRedditData;

    private String kind;


    public SubRedditData getSubRedditData() {
        return subRedditData;
    }

    public void setSubRedditData(SubRedditData subRedditData) {
        this.subRedditData = subRedditData;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
