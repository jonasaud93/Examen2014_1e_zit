package be.hogent.examen2014_1e_zit.models.listings;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jbuy519 on 14/11/2014.
 */
public class ListingElement {

    @SerializedName("data")
    private ListingData listingData;

    public ListingData getListingData() {
        return listingData;
    }

    public void setListingData(ListingData listingData) {
        this.listingData = listingData;
    }
}
