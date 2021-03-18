package com.example.restaurant_finder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restaurant_finder.Classes.FoodComment;
import com.example.restaurant_finder.Classes.RestaurantComment;

import static com.example.restaurant_finder.MainActivity.COMMENTS;
import static com.example.restaurant_finder.MainActivity.RESTAURANT_ID;
import static com.example.restaurant_finder.MainActivity.USER_NAME;
import static com.example.restaurant_finder.MainActivity.helper;
import static com.example.restaurant_finder.RestaurantDetails.FOOD_ID;

/**
 * The type Add comment.
 *
 * @author Maksim Pasnitsenko
 * @date 29.02.2020  This class created for the getting comments from customers.
 */
public class AddComment extends AppCompatActivity {
    private int resID =-1;
    private int foodID =-1;
    private String userName;
    private String comments;
    private String commentsType;
    private float rating = 0f;
    private RestaurantComment res;
    private FoodComment foo;
    private SharedPreferences prefPut;
    private String description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);
        Bundle b = getIntent().getExtras();
        resID = b.getInt(RESTAURANT_ID, 0); // getting restaurant id
        foodID = b.getInt(FOOD_ID, 0); // getting food id
        commentsType = b.getString(COMMENTS, "commentsType");


        if (foodID == 0){
            description=  helper.getRestaurantsByID(resID).getName();
        }else {
           description=  helper.getRestaurantsByID(resID).getName() +" ( "+ helper.getFoodsByID(foodID).getFoodName() + " )";
        }
        prefPut = getSharedPreferences("ResFinder", Activity.MODE_PRIVATE);
        userName = prefPut.getString(USER_NAME, "User ");

        ((TextView) findViewById(R.id.txtCommentType)).setText(commentsType);
        ((TextView) findViewById(R.id.txtDescrip)).setText(description);
    }

    /**
     * Btn add onclick.
     *
     * @param V the v
     */
    public void btnAddOnclick(View V){

        comments = ((EditText) findViewById(R.id.editTextComment)).getText().toString();
        rating = ((RatingBar) findViewById(R.id.ratingBarComments)).getRating();
        if (!comments.isEmpty()) {

            if (commentsType.equals("Restaurant")) {
                int lastID = helper.getAllRestaurantsComments().size() + 1;
                res = new RestaurantComment(lastID, resID, userName, "Comment", rating, comments, "11/03/2020");
                helper.addRestaurantComments(res);
            } else if (commentsType.equals("Food")) {
                int lastID = helper.getAllFoodsComments().size() + 2;
                foo = new FoodComment(lastID, resID, userName, foodID, "Comment", rating, comments, "11/03/2020");
                helper.addFoodsComments(foo);
            } else {
                Toast.makeText(this, "Error, Finding the Food Name or Restaurant Name", Toast.LENGTH_SHORT).show();
            }

            Intent mapActivity = new Intent(this, RestaurantDetails.class);
            mapActivity.putExtra(RESTAURANT_ID, resID);
            startActivity(mapActivity);
            Toast.makeText(this, "Comment Successfully Saved", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Please type a Comment", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Btn cancel onclick.
     *
     * @param V the v
     */
    public void btnCancelOnclick(View V){
        ((EditText) findViewById(R.id.editTextComment)).setText("");
        ((RatingBar) findViewById(R.id.ratingBarComments)).setRating(0f);
        Intent mapActivity = new Intent(this, RestaurantDetails.class);
        mapActivity.putExtra(RESTAURANT_ID, resID);
        startActivity(mapActivity);
    }
}
