package com.example.restaurant_finder.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_finder.Classes.Restaurant;
import com.example.restaurant_finder.R;

import java.util.List;

/**
 * The type Restaurant list horizontal.
 *
 * @author Gajalakshan Chandrasegaran on 20.02.2020
 * this is the class for the RestaurantListHorizontal adapter (RecyclerView), for loading dynamic loop of Restaurant list Horizontally
 */
public class RestaurantListHorizontal extends RecyclerView.Adapter<RestaurantListHorizontal.MyViewHolder> {

    private List<Restaurant> relist;

    /**
     * The type My view holder.
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        /**
         * The Tv 1.
         */
        public TextView tv1;
        /**
         * The Tv 2.
         */
        public TextView tv2;
        /**
         * The Tv 3.
         */
        public TextView tv3;
        /**
         * The Rb 1.
         */
        public RatingBar rb1;
        /**
         * The Iv 1.
         */
        public ImageView iv1;

        /**
         * Instantiates a new My view holder.
         *
         * @param v the v
         */
        public MyViewHolder(View v) {
            super(v);
                tv1 = (TextView) v.findViewById(R.id.resDetName);
                tv2 = (TextView) v.findViewById(R.id.resRating);
                tv3 = (TextView) v.findViewById(R.id.resDescription);
                rb1 = (RatingBar) v.findViewById(R.id.ratingBar);
                iv1 = (ImageView) v.findViewById(R.id.resImg);
        }
    }


    /**
     * Instantiates a new Restaurant list horizontal.
     *
     * @param list the list
     */
    public RestaurantListHorizontal(List<Restaurant> list) {
        this.relist = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.res_top_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Restaurant resDe = relist.get(position);
        holder.iv1.setImageResource(resDe.getImage());
        holder.tv1.setText(resDe.getName());
        holder.tv2.setText("Comments");
        holder.tv2.setId(position);
        holder.tv3.setText(resDe.getDescription());
        holder.rb1.setRating(resDe.getRating());

    }


    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public int getItemCount() {
        return relist.size();
    }

}
