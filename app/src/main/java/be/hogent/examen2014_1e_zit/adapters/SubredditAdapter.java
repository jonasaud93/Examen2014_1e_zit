package be.hogent.examen2014_1e_zit.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import be.hogent.examen2014_1e_zit.R;
import be.hogent.examen2014_1e_zit.models.subreddits.SubRedditData;

/**
 * Created by jbuy519 on 04/12/2014.
 */
public class SubredditAdapter extends BaseAdapter{

    /**
     * TAG die gebruikt wordt om output te loggen. Gebruik enkel deze tag om te loggen!
     */
    public static final String TAG = SubredditAdapter.class.getName();

    /**
     * De lijst waarin  de subreddits zitten
     */
    private List<SubRedditData> dataList;

    private Context context;

    public SubredditAdapter(Context context, List<SubRedditData> dataList) {
        this.dataList = dataList;
        this.context = context;
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
        return position;
    }

    /**
     * TODO: opdracht 4.5
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }


}
