package be.hogent.examen2014_1e_zit.models.subreddits;

import java.util.List;

/**
 * Created by jbuy519 on 14/11/2014.
 */
public class Data {

    /**
     * Array met objecten
     */
    List<SubReddit> children;


    public List<SubReddit> getChildren() {
        return children;
    }

    public void setChildren(List<SubReddit> children) {
        this.children = children;
    }
}
