package be.hogent.examen2014_1e_zit.models.subreddits;

/**
 * Created by jbuy519 on 14/11/2014.
 */
public class Listing {

    /**
     * Object dat overeenkomt met data van JSON antwoord.
     */
    private Data data;

    /**
     * Kind van JSON response
     */
    private String kind;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
