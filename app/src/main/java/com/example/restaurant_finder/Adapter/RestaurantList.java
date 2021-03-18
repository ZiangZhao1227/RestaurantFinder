package com.example.restaurant_finder.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.restaurant_finder.Classes.Restaurant;
import com.example.restaurant_finder.R;

import java.util.List;

/**
 * The type Restaurant list.
 *
 * @author Ziang Zhao on 19.02.2020
 * this is the class for the RestaurantList adapter, for loading dynamic loop of Restaurant list Modified name on 04.03.2020 ListAdapter to RestaurantList
 */
public class RestaurantList extends BaseAdapter {
    private List<Restaurant> listItem;
    private Context context;

    /**
     * Instantiates a new Restaurant list.
     *
     * @param context     the context
     * @param restaurants the restaurants
     */
    public RestaurantList(Context context, List<Restaurant> restaurants) {
        this.listItem = restaurants;
        this.context = context;
    }
    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        RestaurantList.ViewHolder _viewholder = null;
        final Restaurant resDe =  listItem.get(position);
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(R.layout.res_list, null);
            _viewholder = new RestaurantList.ViewHolder(v);
            v.setTag(_viewholder);
        }
        else{
            _viewholder =  (RestaurantList.ViewHolder) v.getTag();
        }
        v.setId(resDe.getID());
        _viewholder.iv1.setImageDrawable(ContextCompat.getDrawable(context, resDe.getImage()));
        _viewholder.tv1.setText(resDe.getName());
        //_viewholder.tv2.setText("Comments");
        _viewholder.tv2.setId(resDe.getID());
        _viewholder.tv3.setText(resDe.getDescription());
        _viewholder.rb1.setRating(resDe.getRating());
        v.setTag(_viewholder);

        return v;
    }

    /**
     * The type View holder.
     */
    class ViewHolder{

        /**
         * The Tv 1.
         */
        TextView tv1;
        /**
         * The Tv 2.
         */
        TextView tv2;
        /**
         * The Tv 3.
         */
        TextView tv3;
        /**
         * The Rb 1.
         */
        RatingBar rb1;
        /**
         * The Iv 1.
         */
        final ImageView iv1;

        /**
         * Instantiates a new View holder.
         *
         * @param v the v
         */
        ViewHolder(View v){
            tv1 = v.findViewById(R.id.resDetName);
            tv2 = v.findViewById(R.id.resRating);
            tv3 = v.findViewById(R.id.resDescription);
            rb1 = v.findViewById(R.id.ratingBar);
            iv1 = v.findViewById(R.id.resImg);
        }
    }
}
