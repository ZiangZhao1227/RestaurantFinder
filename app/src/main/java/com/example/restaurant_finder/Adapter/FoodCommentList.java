package com.example.restaurant_finder.Adapter;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.restaurant_finder.Classes.FoodComment;
import com.example.restaurant_finder.R;

import java.util.List;

/**
 * The type Food comment list.
 *
 * @author Maksim Pasnitsenko on 19.02.2020
 * this is the class for the foodCommentList adapter, for loading dynamic loop of food comments
 */
public class FoodCommentList extends BaseAdapter {

    private List<FoodComment> listItem;
    private Context context;

    /**
     * Instantiates a new Food comment list.
     *
     * @param context      the context
     * @param foodComments the food comments
     */
    public FoodCommentList(Context context, List<FoodComment> foodComments) {
        this.listItem = foodComments;
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
        FoodCommentList.ViewHolder _viewholder = null;
        final FoodComment resCo =  listItem.get(position);
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(R.layout.comment_bar, null);
            _viewholder = new FoodCommentList.ViewHolder(v);
            v.setTag(_viewholder);
        }
        else{
            _viewholder =  (FoodCommentList.ViewHolder) v.getTag();
        }

        _viewholder.tv1.setText(resCo.getUser());
        _viewholder.tv2.setText(resCo.getComment());
        _viewholder.tv2.setMovementMethod(new ScrollingMovementMethod());
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