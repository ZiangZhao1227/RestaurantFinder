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

import com.example.restaurant_finder.Classes.Food;
import com.example.restaurant_finder.R;

import java.util.List;

/**
 * The type Food list.
 *
 * @author Gajalakshan Chandrasegaran on 20.02.2020
 * this is the class for the FoodList adapter, for loading dynamic loop of food list
 */
public class FoodList extends BaseAdapter {

    private List<Food> listItem;
    private Context context;
    private String commentSet;

    /**
     * Instantiates a new Food list.
     *
     * @param context   the context
     * @param fooditems the fooditems
     * @param txt       the txt
     */
    public FoodList(Context context, List<Food> fooditems, String txt) {
        this.listItem = fooditems;
        this.context = context;
        this.commentSet = txt;
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        FoodList.ViewHolder _viewholder = null;
        final Food foodDe = listItem.get(position);
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(R.layout.food_bar, null);
            _viewholder = new FoodList.ViewHolder(v);
            v.setTag(_viewholder);
        } else {
            _viewholder = (FoodList.ViewHolder) v.getTag();
        }


        if(this.commentSet.equals("Food")){
            _viewholder.tv4.setVisibility(View.GONE);
            _viewholder.tv5.setVisibility(View.VISIBLE);
            _viewholder.tv5.setId(foodDe.getFoodID());
            v.setId(foodDe.getFoodID());

        }
        else {
            _viewholder.tv4.setVisibility(View.VISIBLE);
            _viewholder.tv5.setVisibility(View.GONE);
            v.setId(foodDe.getRestaurantID());
            _viewholder.tv4.setId(foodDe.getFoodID());


        }
        _viewholder.iv1.setImageDrawable(ContextCompat.getDrawable(context, foodDe.getFoodImage()));
        _viewholder.tv1.setText(foodDe.getFoodName());
        _viewholder.tv2.setText(String.format(foodDe.getFoodPrice()+"€"));
        _viewholder.tv3.setText(foodDe.getFoodComment());
        _viewholder.rb1.setRating(foodDe.getFoodRating());


        v.setTag(_viewholder);


        return v;
    }

    private class ViewHolder {

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
         * The Tv 4.
         */
        TextView tv4;
        /**
         * The Tv 5.
         */
        TextView tv5;
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
        ViewHolder(View v) {
            tv1 = v.findViewById(R.id.resFoodName);
            tv2 = v.findViewById(R.id.foodPrice);
            tv3 = v.findViewById(R.id.foodDescription);
            tv4 = v.findViewById(R.id.foodViewComment);
            tv5 = v.findViewById(R.id.foodAddComment);
            rb1 = v.findViewById(R.id.foodRatingBar);
            iv1 = v.findViewById(R.id.foodImg);
        }
    }
}