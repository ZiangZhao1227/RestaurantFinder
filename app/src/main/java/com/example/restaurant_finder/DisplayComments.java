package com.example.restaurant_finder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restaurant_finder.Adapter.FoodCommentList;
import com.example.restaurant_finder.Adapter.RestaurantCommentList;
import com.example.restaurant_finder.Classes.FoodComment;
import com.example.restaurant_finder.Classes.RestaurantComment;

import static com.example.restaurant_finder.MainActivity.COMMENTS;
import static com.example.restaurant_finder.MainActivity.RESTAURANT_ID;
import static com.example.restaurant_finder.MainActivity.USER_NAME;
import static com.example.restaurant_finder.MainActivity.helper;
import static com.example.restaurant_finder.RestaurantDetails.FOOD_ID;

/**
 * The type Display comments.
 *
 * @author Gajalakshan Chandrasegaran
 * @date 07.03.2020  This DisplayComments Activity, for getting and displaying the Restaurant Comments.
 */
public class DisplayComments extends AppCompatActivity {
    private int resID;
    private int foodID;
    private String userName;
    private String comments;
    private String commentsType;
    private float rating;
    private RestaurantComment res;
    private FoodComment foo;
    private SharedPreferences prefPut;
    private RestaurantCommentList restaurantCommentList;
    private FoodCommentList foodCommentsList;
    private ListView _displayComments;
    private TextView _editText;
    private String commentType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_comments);

        Bundle b = getIntent().getExtras();
        resID = b.getInt(RESTAURANT_ID, 0); // getting restaurant id
        foodID = b.getInt(FOOD_ID, 0); // getting food id
        commentsType = b.getString(COMMENTS, "Restaurant");

        _editText = findViewById(R.id.txtDisplayCommentType);
        _displayComments = findViewById(R.id.displayCommentsList);

        prefPut = getSharedPreferences("ResFinder", Activity.MODE_PRIVATE);
        userName = prefPut.getString(USER_NAME, "User ");
        _editText.setText(commentsType);
        _editText = findViewById(R.id.txtResName);
        loadListView();
    }

    private void loadListView(){

        String resName = "";

        if(commentsType.equals("Restaurant Comment")){
            restaurantCommentList= new RestaurantCommentList(this, helper.getAllRestaurantsCommentsByID(resID));
            _displayComments.setAdapter(restaurantCommentList);
            resName =  helper.getRestaurantsByID(resID).getName();

        } else if(commentsType.equals("Food Comment")){
            foodCommentsList= new FoodCommentList(this, helper.getFoodComments(foodID));
            _displayComments.setAdapter(foodCommentsList);
                resID = helper.getFoodsByID(foodID).getRestaurantID();
            resName =  helper.getRestaurantsByID(resID).getName();
        }
        else
        {
            Toast.makeText(this, "No Comment yet", Toast.LENGTH_SHORT).show();
        }
        _editText.setText(resName);
    }

}
