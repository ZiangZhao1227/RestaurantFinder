package com.example.restaurant_finder;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.location.LocationManager;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.restaurant_finder.Adapter.FoodList;
import com.example.restaurant_finder.Adapter.RestaurantCommentList;
import com.example.restaurant_finder.Classes.Food;
import com.example.restaurant_finder.Classes.OpeningTime;
import com.example.restaurant_finder.Classes.Restaurant;

import java.util.List;

import static com.example.restaurant_finder.MainActivity.COMMENTS;
import static com.example.restaurant_finder.MainActivity.RESTAURANT_ID;
import static com.example.restaurant_finder.MainActivity.USER_NAME;
import static com.example.restaurant_finder.MainActivity.helper;

/**
 * The type Restaurant details.
 *
 * @author Gajalakshan Chandrasegaran
 * @date 20.02.2020  This RestaurantDetails Activity, for getting and displaying the Restaurant information.
 */
public class RestaurantDetails extends AppCompatActivity {
    /**
     * The constant MY_PERMISSIONS_REQUEST_LOCATION.
     */
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    /**
     * The constant FOOD_ID.
     */
    public static final String FOOD_ID ="Food ID";
    private static final int REQUEST_PHONE_CALL = 1;
    private int resID;
    private int foodID;
    /**
     * The List view.
     */
    private ListView _listView;
    private RestaurantCommentList restaurantCommentList;
    private FoodList foodList;
    private Restaurant restaurant;
    private String commentType;
    private List<OpeningTime> openList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        Bundle b = getIntent().getExtras();
        resID = b.getInt(RESTAURANT_ID, 0); // getting restaurant id

        restaurant = helper.getRestaurantsByID(resID);
        ImageView image = findViewById(R.id.resDetImg);

        image.setImageResource(restaurant.getImage());
        ((TextView) findViewById(R.id.resDetName))
                .setText(restaurant.getName());
        ((TextView) findViewById(R.id.resDetdesc))
                .setText(restaurant.getDescription());
        ((RatingBar) findViewById(R.id.resDetRate))
                .setRating(restaurant.getRating());
        ((TextView) findViewById(R.id.resDetdesc))
                .setText(restaurant.getLocation());

        _listView = findViewById(R.id.loadCommentsListItems);
    }

    /**
     * Btn restaurant comment onclick.
     *
     * @param view the view
     */
    public void btnRestaurantCommentOnclick(View view) {

        RestaurantCommentList restaurantCommentList1 = new RestaurantCommentList(RestaurantDetails.this, helper.getAllRestaurantsCommentsByID(resID));
        _listView.setAdapter(restaurantCommentList1);
    }

    /**
     * Btn display food onclick.
     *
     * @param view the view
     */
    public void btnDisplayFoodOnclick(View view) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.food_bar, null);
        foodList = new FoodList(this, helper.getRestaurantFoodsByID(resID), "Food");
        _listView.setAdapter(foodList);
        _listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                commentType = "Food Comment";
                Intent nextActivity = new Intent(RestaurantDetails.this, DisplayComments.class);
                foodID = view.getId();
                nextActivity.putExtra(RESTAURANT_ID, resID);
                nextActivity.putExtra(FOOD_ID, foodID);
                nextActivity.putExtra(COMMENTS, commentType);
                startActivity(nextActivity);
            }
        });
    }

    /**
     * Btn add food comment.
     *
     * @param view the view
     */
    public void btnAddFoodComment(View view) {
        Intent nextActivity = new Intent(RestaurantDetails.this, AddComment.class);
        int id = view.getId();
        nextActivity.putExtra(RESTAURANT_ID, resID);
        nextActivity.putExtra(FOOD_ID, id);
        nextActivity.putExtra(COMMENTS, "Food");
        startActivity(nextActivity);
    }


    /**
     * Show popup opening time.
     *
     * @param v the v
     */
    public void showPopupOpeningTime(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        openList = helper.getOpeningTime(resID);
        int i = 0;
        for (OpeningTime result : openList) {
            String openingtime="";
            if(result.getOpeningTime()== 0.0f &&  result.getClosingTime() == 0.0f){
                openingtime = String.format(result.getWeekDays() + " Closed");
            }
            else {
                openingtime = String.format(result.getWeekDays() + " " + result.getOpeningTime() + "0 - " + result.getClosingTime() + "0");
            }

            popup.getMenu().add(i, i, i, openingtime);
            i++;
        }
        inflater.inflate(R.menu.opening_time, popup.getMenu());
        popup.show();
    }


    /**
     * Display location.
     *
     * @param v the v
     */
    public void displayLocation(View v) {
        Intent mapActivity = new Intent(this, RestaurantMapsActivity.class);
        mapActivity.putExtra(RESTAURANT_ID, resID);
        startActivity(mapActivity);
    }

    /**
     * Btn add restaurant comment onclick.
     *
     * @param v the v
     */
    public void btnAddRestaurantCommentOnclick(View v) {
        Intent nextActivity = new Intent(RestaurantDetails.this, AddComment.class);
        nextActivity.putExtra(RESTAURANT_ID, resID);
        nextActivity.putExtra(COMMENTS, "Restaurant");
        startActivity(nextActivity);
    }

    /**
     * Btn reservation onclick.
     *
     * @param v the v
     */
    public void btnReservationOnclick(View v) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        String phone_number = restaurant.getContact();
        callIntent.setData(Uri.parse("tel:"+phone_number));
        if (ContextCompat.checkSelfPermission(RestaurantDetails.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(RestaurantDetails.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
        }
        else
        {
            startActivity(callIntent);
        }
    }
}
