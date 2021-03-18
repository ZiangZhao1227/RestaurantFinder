package com.example.restaurant_finder.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.restaurant_finder.Classes.RestaurantComment;
import com.example.restaurant_finder.R;

import java.util.List;

/**
 * The type Restaurant comment list.
 *
 * @author Maksim Pasnitsenko on 19.02.2020
 * this is the class for the RestaurantCommentList adapter, for loading dynamic loop of Restaurant comments
 */


public class RestaurantCommentList extends BaseAdapter {

    private List<RestaurantComment> listItem;
    private Context context;

    /**
     * Instantiates a new Restaurant comment list.
     *
     * @param context           the context
     * @param restaurantComment the restaurant comment
     */
    public RestaurantCommentList(Context context, List<RestaurantComment> restaurantComment) {
        this.listItem = restaurantComment;
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
        RestaurantCommentList.ViewHolder _viewholder = null;
        final RestaurantComment resCo =  listItem.get(position);
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(R.layout.comment_bar, null);
            _viewholder = new ViewHolder(v);
            v.setTag(_viewholder);
        }
        else{
            _viewholder =  (RestaurantCommentList.ViewHolder) v.getTag();
        }

        _viewholder.tv1.setText(resCo.getUser());
        _viewholder.tv2.setText(resCo.getComment());
        // _viewholder.tv2.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        _viewholder.tv3.setText(resCo.getCommentDate());
        _viewholder.rb1.setRating(resCo.getRating());
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
         * Instantiates a new View holder.
         *
         * @param v the v
         */
        ViewHolder(View v){
            tv1 = (TextView) v.findViewById(R.id.resCommentUser);
            tv2 = (TextView) v.findViewById(R.id.resComments);
            tv3 = (TextView) v.findViewById(R.id.resCommentDate);
            rb1 = (RatingBar) v.findViewById(R.id.resCommentRatingBar);
        }
    }

}