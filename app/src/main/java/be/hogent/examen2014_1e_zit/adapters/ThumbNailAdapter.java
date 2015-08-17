package be.hogent.examen2014_1e_zit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import be.hogent.examen2014_1e_zit.R;
import be.hogent.examen2014_1e_zit.models.listings.ListingData;

/**
 * Created by jbuy519 on 08/12/2014.
 */
public class ThumbNailAdapter extends BaseAdapter {

    /**
     * TAG die gebruikt wordt om output te loggen. Gebruik enkel deze tag om te loggen!
     */
    public static final String TAG = ThumbNailAdapter.class.getName();

    /**
     * De lijst met de post van de betreffende subreddit.
     */
    List<ListingData> dataList;

    private Context context;


    public ThumbNailAdapter(Context context, int resource,List<ListingData> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    /**
     * TODO: opdracht 5.3
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ListingData listingData = dataList.get(position);

        convertView = inflater.inflate(R.layout.thumbnailview, parent, false);
        TextView text = (TextView)convertView.findViewById(R.id.title);
        TextView description = (TextView)convertView.findViewById(R.id.description);
        ImageView image = (ImageView)convertView.findViewById(R.id.image);
        Picasso.with(context).load(listingData.getThumbnail()).into(image);
        text.setText(listingData.getTitle());
        description.setText(listingData.getUrl());
        return convertView;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
