package com.example.restaurant_finder;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_finder.Adapter.FoodCommentList;
import com.example.restaurant_finder.Adapter.FoodList;
import com.example.restaurant_finder.Adapter.RestaurantCommentList;
import com.example.restaurant_finder.Adapter.RestaurantList;
import com.example.restaurant_finder.Adapter.RestaurantListHorizontal;
import com.example.restaurant_finder.Database.DatabaseHelper;

import java.util.Random;

import static com.example.restaurant_finder.RestaurantDetails.FOOD_ID;

/**
 * The type Main activity.
 *
 * @author Ziang Zhao
 * @date 19.02.2020  This DisplayComments Activity, for getting and displaying the Restaurant Comments.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The constant USER_NAME.
     */
    public static final String USER_NAME ="User ";
    /**
     * The constant COMMENTS.
     */
    public static final String COMMENTS ="Restaurant";
    /**
     * The constant TAG.
     */
    public static final String TAG ="Tag";
    /**
     * The constant RESTAURANT_ID.
     */
    public static final String RESTAURANT_ID ="RestaurantID";
    /**
     * The constant helper.
     */
    public static DatabaseHelper helper;
    private ListView _listView;
    private ListView _listViewSearch;
    private RecyclerView _recyclerView;
    private String userName;
    private TextView _editText;
    private RestaurantList customAdapter;
    private RestaurantListHorizontal recyclerView;
    private FoodList foodList;
    private int resID;
    private int foodID;
    private String commentType;
    private LayoutInflater inflater;
    private SharedPreferences prefPut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefPut = getSharedPreferences("ResFinder", Activity.MODE_PRIVATE);

        helper = DatabaseHelper.getInstance(this);
        int num_of_dow = helper.getAllRestaurants().size();

        if (num_of_dow==0) {
            int random = new Random().nextInt(61) + 20;
            String userID = String.format("User "+ random);
             // 2. Open the Editor to be able to define what is added ap
            SharedPreferences.Editor prefEditor = prefPut.edit();
            prefEditor.putString(USER_NAME, userID);

            // 4. save the changes by the commits
            prefEditor.apply();

            // add all information if the data base is empty
            helper.addAllInformation();

        }

        _recyclerView = findViewById(R.id.res_list_add);
        _editText = findViewById(R.id.editTextSearch);
        _listView = findViewById(R.id.loadListItems);


        _recyclerView.setHasFixedSize(true);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        _recyclerView.setLayoutManager(horizontalLayoutManager);

        recyclerView = new RestaurantListHorizontal(helper.getAllRestaurants());
        _recyclerView.setAdapter(recyclerView);
        _recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent nextActivity = new Intent(MainActivity.this, RestaurantDetails.class);
                resID = v.getId();
                nextActivity.putExtra(RESTAURANT_ID, resID);
                nextActivity.putExtra(USER_NAME, USER_NAME);
                nextActivity.putExtra(COMMENTS, commentType);
                startActivity(nextActivity);
            }
        });


        _editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String txt = _editText.getText().toString();
                if (helper.getRestaurantsByName(txt).size() >= 1 && !txt.isEmpty()) {
                    search(txt);
                }
                else {
                    LinearLayout layout = (LinearLayout) findViewById(R.id.searchList);
                    layout.setVisibility(View.GONE);
                }
            }
        });

        customAdapter= new RestaurantList(this, helper.getAllRestaurants());
        _listView.setAdapter(customAdapter);
        loadListView();
    }

    /**
     * Btn nearby.
     *
     * @param v the v
     */
    public void btnNearby(View v){
        customAdapter= new RestaurantList(this, helper.getAllRestaurants());
        _listView.setAdapter(customAdapter);
        loadListView();
    }

    private void loadListView(){
        _listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent(MainActivity.this, RestaurantDetails.class);
                resID = view.getId();
                nextActivity.putExtra(RESTAURANT_ID, resID);
                nextActivity.putExtra(USER_NAME, USER_NAME);
                nextActivity.putExtra(COMMENTS, commentType);
                startActivity(nextActivity);
            }
        });
    }

    /**
     * Search.
     *
     * @param txt the txt
     */
    public void search(String txt) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.searchList);
        layout.setVisibility(View.VISIBLE);
        layout.removeAllViewsInLayout();
        inflater = LayoutInflater.from(MainActivity.this);
        View view = inflater.inflate(R.layout.search_bar, null);
        layout.addView(view);
        _listViewSearch = (ListView) view.findViewById(R.id.search_bar_listview);

        customAdapter = new RestaurantList(this, helper.getRestaurantsByName(txt));
        _listViewSearch.setAdapter(customAdapter);
        loadListView();

        _listViewSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent(MainActivity.this, RestaurantDetails.class);
                resID = view.getId();
                userName = prefPut.getString("User ", "defaultStringIfNothingFound");
                nextActivity.putExtra(RESTAURANT_ID, resID);
                nextActivity.putExtra(USER_NAME, userName);
                nextActivity.putExtra(COMMENTS, commentType);
                startActivity(nextActivity);
            }
        });
    }

    /**
     * Btn restaurant comment.
     *
     * @param v the v
     */
    public void btnRestaurantComment(View v){
        commentType = "Restaurant Comment";
        Intent nextActivity = new Intent(MainActivity.this, DisplayComments.class);
        resID = v.getId();
        userName = prefPut.getString("User ", "defaultStringIfNothingFound");
        nextActivity.putExtra(RESTAURANT_ID, resID);
        nextActivity.putExtra(USER_NAME, userName);
        nextActivity.putExtra(COMMENTS, commentType);
        startActivity(nextActivity);
    }

    /**
     * Btn food comment.
     *
     * @param v the v
     */
    public void btnFoodComment(View v){
        commentType = "Food Comment";
        Intent nextActivity = new Intent(MainActivity.this, DisplayComments.class);
        foodID = v.getId();
        userName = prefPut.getString("User ", "defaultStringIfNothingFound");
        nextActivity.putExtra(FOOD_ID, foodID);
        nextActivity.putExtra(USER_NAME, userName);
        nextActivity.putExtra(COMMENTS, commentType);
        startActivity(nextActivity);

    }

    /**
     * Btn food.
     *
     * @param v the v
     */
    public void btnFood(View v){
        foodList= new FoodList(this, helper.getAllFoods(),"Res");
        _listView.setAdapter(foodList);
        loadListView();
    }

    /**
     * Btn priority.
     *
     * @param v the v
     */
    public void btnPriority(View v){
        customAdapter= new RestaurantList(this, helper.getTopRatingRestaurant());
        _listView.setAdapter(customAdapter);
        loadListView();
    }
}
