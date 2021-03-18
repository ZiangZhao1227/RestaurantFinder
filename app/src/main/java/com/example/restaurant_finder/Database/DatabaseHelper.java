package com.example.restaurant_finder.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.restaurant_finder.Classes.Food;
import com.example.restaurant_finder.Classes.FoodComment;
import com.example.restaurant_finder.Classes.OpeningTime;
import com.example.restaurant_finder.Classes.Restaurant;
import com.example.restaurant_finder.Classes.RestaurantComment;
import com.example.restaurant_finder.Classes.RestaurantLocation;

import java.util.ArrayList;
import java.util.List;

import static com.example.restaurant_finder.MainActivity.TAG;

/**
 * The type Database helper.
 *
 * @author Gajalakshan Chandrasegaran
 * @date 08.03.2020  This class created for the Database access, for getting and adding of the all information.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;

    private static final float RESTAURANT_RATING = 4.5f;

    // Database Info
    private static final String DATABASE_NAME = "postsDatabase";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_FOODS = "food";
    private static final String TABLE_FOOD_COMMENTS = "food_comments";

    private static final String TABLE_RESTAURANT = "restaurant";
    private static final String TABLE_RESTAURANT_COMMENTS = "restaurant_comments";

    private static final String TABLE_RESTAURANT_OPENING_TIME = "restaurant_opening_time";
    private static final String TABLE_RESTAURANT_LOCATION = "restaurant_location";

    // Food Table Columns
    private static final String KEY_FOOD_ID = "foodID";
    private static final String KEY_FOOD_RESTAURANT_ID_FK = "restaurantID";
    private static final String KEY_FOOD_NAME = "foodName";
    private static final String KEY_FOOD_PRICE = "foodPrice";
    private static final String KEY_FOOD_RATING = "foodRating";
    private static final String KEY_FOOD_COMMENT = "foodComment";
    private static final String KEY_FOOD_IMAGE = "foodImage";

    // Food Comments Table Columns
    private static final String KEY_FOOD_COMMENTS_ID = "foodCommentID";
    private static final String KEY_FOOD_COMMENTS_RESTAURANT_ID_FK = "restaurantID";
    private static final String KEY_FOOD_COMMENTS_FOOD_ID_FK = "foodID";
    private static final String KEY_FOOD_COMMENTS_USER_NAME = "foodCommenttUser";
    private static final String KEY_FOOD_COMMENTS_USER_TYPE = "foodCommentUserType";
    private static final String KEY_FOOD_COMMENTS_RATING = "foodCommentRating";
    private static final String KEY_FOOD_COMMENTS_COMMENT = "foodComment";
    private static final String KEY_FOOD_COMMENTS_DATE = "foodCommentDate";

    // Restaurant Table Columns
    private static final String KEY_RESTAURANT_ID = "restaurantID";
    private static final String KEY_RESTAURANT_NAME = "restaurantName";
    private static final String KEY_RESTAURANT_DESCRIPTION = "restaurantDescription";
    private static final String KEY_RESTAURANT_RATING = "restaurantRating";
    private static final String KEY_RESTAURANT_COMMENT = "restaurantComment";
    private static final String KEY_RESTAURANT_LOCATION= "restaurantLocation";
    private static final String KEY_RESTAURANT_CONTACT= "restaurantContact";
    private static final String KEY_RESTAURANT_IMAGE = "restaurantImage";


    // Restaurant Comments Table Columns
    private static final String KEY_RESTAURANT_COMMENTS_ID = "restaurantCommentID";
    private static final String KEY_RESTAURANT_COMMENTS_RESTAURANT_ID_FK = "restaurantID";
    private static final String KEY_RESTAURANT_COMMENTS_USER = "restaurantCommentUser";
    private static final String KEY_RESTAURANT_COMMENTS_USER_TYPE = "restaurantCommentUserType";
    private static final String KEY_RESTAURANT_COMMENTS_RATING = "restaurantCommentRating";
    private static final String KEY_RESTAURANT_COMMENTS_COMMENT = "restaurantComment";
    private static final String KEY_RESTAURANT_COMMENTS_DATE = "restaurantCommentDate";


    // Restaurant Opening time Table Columns
    private static final String KEY_OPENING_TIME_ID = "restaurantCommentID";
    private static final String KEY_OPENING_TIME_RESTAURANT_ID_FK = "restaurantID";
    private static final String KEY_OPENING_TIME_WEEK_DAYS = "weekDays";
    private static final String KEY_RESTAURANT_OPENING_TIME = "openingTime";
    private static final String KEY_RESTAURANT_CLOSING_TIME = "closingTime";

    // Restaurant Location Table Columns
    private static final String KEY_RESTAURANT_LOCATION_ID = "locaID";
    private static final String KEY_RESTAURANT_LOCATION_RESTAURANT_ID_FK = "restaurantID";
    private static final String KEY_RESTAURANT_LOCATION_LATITUDE = "restaurantLatitude";
    private static final String KEY_RESTAURANT_LOCATION_LONGITUDE = "restaurantLongitude";

    /**
     * Gets instance.
     *
     * @param context the context
     * @return the instance
     */
    public static synchronized DatabaseHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    /**
     * Constructor should be private to prevent direct instantiation.
     */
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Called when the database connection is being configured.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    // Called when the database is created for the FIRST time.
    // If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Food Table Columns
        String CREATE_FOODS_TABLE = "CREATE TABLE " + TABLE_FOODS +
                "(" +
                KEY_FOOD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + // Define a primary key
                KEY_FOOD_RESTAURANT_ID_FK + " INTEGER REFERENCES " + TABLE_RESTAURANT + "," + // Define a foreign key
                KEY_FOOD_NAME + " TEXT," +
                KEY_FOOD_PRICE + " REAL," +
                KEY_FOOD_RATING + " REAL," +
                KEY_FOOD_COMMENT + " TEXT," +
                KEY_FOOD_IMAGE + " INTEGER" +
                ")";


        // Food Comments Table Columns

        String CREATE_FOOD_COMMENTS_TABLE = "CREATE TABLE " + TABLE_FOOD_COMMENTS +
                "(" +
                KEY_FOOD_COMMENTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + // Define a primary key
                KEY_FOOD_COMMENTS_RESTAURANT_ID_FK + " INTEGER REFERENCES " + TABLE_RESTAURANT + "," + // Define a foreign key
                KEY_FOOD_COMMENTS_FOOD_ID_FK + " INTEGER REFERENCES " + TABLE_FOODS + "," + // Define a foreign key
                KEY_FOOD_COMMENTS_USER_NAME + " TEXT," +
                KEY_FOOD_COMMENTS_USER_TYPE + " TEXT," +
                KEY_FOOD_COMMENTS_RATING + " REAL," +
                KEY_FOOD_COMMENTS_COMMENT + " TEXT," +
                KEY_FOOD_COMMENTS_DATE + " TEXT" +
                ")";


        // Restaurant Table Columns

        String CREATE_RESTAURANT_TABLE = "CREATE TABLE " + TABLE_RESTAURANT +
                "(" +
                KEY_RESTAURANT_ID + " INTEGER PRIMARY KEY," + // Define a primary key
                KEY_RESTAURANT_NAME + " TEXT," +
                KEY_RESTAURANT_DESCRIPTION + " TEXT," +
                KEY_RESTAURANT_RATING + " REAL," +
                KEY_RESTAURANT_COMMENT + " TEXT," +
                KEY_RESTAURANT_LOCATION+ " TEXT," +
                KEY_RESTAURANT_CONTACT+ " TEXT," +
                KEY_RESTAURANT_IMAGE + " INTEGER" +
                ")";


        // Restaurant Comments Table Columns

        String CREATE_RESTAURANT_COMMENTS_TABLE = "CREATE TABLE " + TABLE_RESTAURANT_COMMENTS +
                "(" +
                KEY_RESTAURANT_COMMENTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + // Define a primary key
                KEY_RESTAURANT_COMMENTS_RESTAURANT_ID_FK + " INTEGER REFERENCES " + TABLE_RESTAURANT + "," + // Define a foreign key
                KEY_RESTAURANT_COMMENTS_USER + " TEXT," +
                KEY_RESTAURANT_COMMENTS_USER_TYPE + " TEXT," +
                KEY_RESTAURANT_COMMENTS_RATING + " REAL," +
                KEY_RESTAURANT_COMMENTS_COMMENT + " TEXT," +
                KEY_RESTAURANT_COMMENTS_DATE + " TEXT" +
                ")";


        // Restaurant Opening Time Table Columns

        String CREATE_RESTAURANT_OPENING_TIME_TABLE = "CREATE TABLE " + TABLE_RESTAURANT_OPENING_TIME +
                "(" +
                KEY_OPENING_TIME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + // Define a primary key
                KEY_OPENING_TIME_RESTAURANT_ID_FK + " INTEGER REFERENCES " + TABLE_RESTAURANT + "," + // Define a foreign key
                KEY_OPENING_TIME_WEEK_DAYS + " TEXT," +
                KEY_RESTAURANT_OPENING_TIME + " REAL," +
                KEY_RESTAURANT_CLOSING_TIME + " REAL" +
                ")";


        // Restaurant Opening Time Table Columns

        String CREATE_RESTAURANT_LOCATION_TABLE = "CREATE TABLE " + TABLE_RESTAURANT_LOCATION +
                "(" +
                KEY_RESTAURANT_LOCATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + // Define a primary key
                KEY_RESTAURANT_LOCATION_RESTAURANT_ID_FK + " INTEGER REFERENCES " + TABLE_RESTAURANT + "," + // Define a foreign key
                KEY_RESTAURANT_LOCATION_LATITUDE + " TEXT," +
                KEY_RESTAURANT_LOCATION_LONGITUDE + " TEXT" +
                ")";


        db.execSQL(CREATE_FOODS_TABLE);
        db.execSQL(CREATE_FOOD_COMMENTS_TABLE);
        db.execSQL(CREATE_RESTAURANT_TABLE);
        db.execSQL(CREATE_RESTAURANT_COMMENTS_TABLE);
        db.execSQL(CREATE_RESTAURANT_OPENING_TIME_TABLE);
        db.execSQL(CREATE_RESTAURANT_LOCATION_TABLE);


    }

    // Called when the database needs to be upgraded.
    // This method will only be called if a database already exists on disk with the same DATABASE_NAME,
    // but the DATABASE_VERSION is different than the version of the database that exists on disk.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOODS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD_COMMENTS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTAURANT);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTAURANT_COMMENTS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTAURANT_OPENING_TIME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESTAURANT_LOCATION);
            onCreate(db);
        }
    }

    /**
     * Add restaurants.
     *
     * @param restaurant the restaurant
     */
// add all restaurants into the database
    public void addRestaurants(Restaurant restaurant) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            // The user might already exist in the database (i.e. the same user created multiple posts).
            //long userId = addOrUpdateUser();


            ContentValues values = new ContentValues();
            values.put(KEY_RESTAURANT_ID, restaurant.getID());
            values.put(KEY_RESTAURANT_NAME, restaurant.getName());
            values.put(KEY_RESTAURANT_DESCRIPTION, restaurant.getDescription());
            values.put(KEY_RESTAURANT_RATING, restaurant.getRating());
            values.put(KEY_RESTAURANT_COMMENT, restaurant.getComment());
            values.put(KEY_RESTAURANT_LOCATION, restaurant.getLocation());
            values.put(KEY_RESTAURANT_CONTACT, restaurant.getContact());
            values.put(KEY_RESTAURANT_IMAGE, restaurant.getImage());

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_RESTAURANT, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add restaurant to database");
        } finally {
            db.endTransaction();
        }
    }

    /**
     * Gets all restaurants.
     *
     * @return the all restaurants
     */
// Get all restaurant from the database
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();

        String RESTAURANTS_SELECT_QUERY =
                String.format("SELECT * FROM %s",
                        TABLE_RESTAURANT);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(RESTAURANTS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    restaurants.add(new Restaurant( cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_ID)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_NAME)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_DESCRIPTION)),
                            cursor.getFloat(cursor.getColumnIndex(KEY_RESTAURANT_RATING)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENT)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_LOCATION)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_CONTACT)),
                            cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_IMAGE))));

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get restaurant from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return restaurants;
    }

    /**
     * Gets top rating restaurant.
     *
     * @return the top rating restaurant
     */
// Get Top rating restaurant from the database
    public List<Restaurant> getTopRatingRestaurant() {
        List<Restaurant> restaurants = new ArrayList<>();

        String RESTAURANTS_SELECT_QUERY =
                String.format("SELECT * FROM %s WHERE %s >= %s",
                        TABLE_RESTAURANT, KEY_RESTAURANT_RATING, RESTAURANT_RATING);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(RESTAURANTS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    restaurants.add(new Restaurant( cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_ID)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_NAME)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_DESCRIPTION)),
                            cursor.getFloat(cursor.getColumnIndex(KEY_RESTAURANT_RATING)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENT)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_LOCATION)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_CONTACT)),
                            cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_IMAGE))));

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get restaurant from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return restaurants;
    }

    /**
     * Gets restaurants by name.
     *
     * @param text the text
     * @return the restaurants by name
     */
// Get restaurants by similar name from the database
    public List<Restaurant> getRestaurantsByName(String text) {
        List<Restaurant> restaurants = new ArrayList<>();

        String RESTAURANTS_SELECT_QUERY = "SELECT * FROM " + TABLE_RESTAURANT + " WHERE " + KEY_RESTAURANT_NAME + " LIKE '%" + text + "%'";

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(RESTAURANTS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    restaurants.add(new Restaurant( cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_ID)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_NAME)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_DESCRIPTION)),
                            cursor.getFloat(cursor.getColumnIndex(KEY_RESTAURANT_RATING)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENT)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_LOCATION)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_CONTACT)),
                            cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_IMAGE))));

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get restaurant from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return restaurants;
    }

    /**
     * Gets restaurants by id.
     *
     * @param id the id
     * @return the restaurants by id
     */
// Get restaurant using id from the database
    public Restaurant getRestaurantsByID(int id) {
        Restaurant restaurant = new Restaurant();
        String RESTAURANTS_SELECT_QUERY = "SELECT * FROM " + TABLE_RESTAURANT + " WHERE " + KEY_RESTAURANT_ID + " ='" + id + "'";

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(RESTAURANTS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                restaurant = new Restaurant( cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_ID)),
                        cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_NAME)),
                        cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_DESCRIPTION)),
                        cursor.getFloat(cursor.getColumnIndex(KEY_RESTAURANT_RATING)),
                        cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENT)),
                        cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_LOCATION)),
                        cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_CONTACT)),
                        cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_IMAGE)));

            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get restaurant from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return restaurant;
    }

    /**
     * Add foods.
     *
     * @param food the food
     */
// add all foods into the database
    public void addFoods(Food food) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            // The user might already exist in the database (i.e. the same user created multiple posts).

            ContentValues values = new ContentValues();
            values.put(KEY_FOOD_ID , food.getFoodID());
            values.put(KEY_FOOD_RESTAURANT_ID_FK ,food.getRestaurantID());
            values.put(KEY_FOOD_NAME ,food.getFoodName());
            values.put(KEY_FOOD_PRICE ,food.getFoodPrice());
            values.put(KEY_FOOD_RATING,food.getFoodRating());
            values.put(KEY_FOOD_COMMENT,food.getFoodComment());
            values.put(KEY_FOOD_IMAGE ,food.getFoodImage());

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_FOODS, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add foods to database");
        } finally {
            db.endTransaction();
        }
    }

    /**
     * Gets all foods.
     *
     * @return the all foods
     */
// Get all foods from the database
    public List<Food> getAllFoods() {
        List<Food> foods = new ArrayList<>();

        String FOODS_SELECT_QUERY =
                String.format("SELECT * FROM %s",
                        TABLE_FOODS);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(FOODS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    foods.add(new Food(
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_RESTAURANT_ID_FK)),
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_ID)),
                            cursor.getString(cursor.getColumnIndex(KEY_FOOD_NAME)),
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_PRICE)),
                            cursor.getFloat(cursor.getColumnIndex(KEY_FOOD_RATING)),
                            cursor.getString(cursor.getColumnIndex(KEY_FOOD_COMMENT)),
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_IMAGE ))));

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get foods from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return foods;
    }

    /**
     * Gets restaurant foods by id.
     *
     * @param id the id
     * @return the restaurant foods by id
     */
// Get all related to one restaurant foods from the database
    public List<Food> getRestaurantFoodsByID(int id) {
        List<Food> foods = new ArrayList<>();

        String FOODS_SELECT_QUERY ="SELECT * FROM " + TABLE_FOODS + " WHERE " + KEY_FOOD_RESTAURANT_ID_FK + " = '" + id + "'";

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(FOODS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    foods.add(new Food(
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_RESTAURANT_ID_FK)),
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_ID)),
                            cursor.getString(cursor.getColumnIndex(KEY_FOOD_NAME)),
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_PRICE)),
                            cursor.getFloat(cursor.getColumnIndex(KEY_FOOD_RATING)),
                            cursor.getString(cursor.getColumnIndex(KEY_FOOD_COMMENT)),
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_IMAGE ))));

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get foods from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return foods;
    }

    /**
     * Gets foods by id.
     *
     * @param id the id
     * @return the foods by id
     */
// Get food info from the database
   public Food getFoodsByID(int id) {
        Food food = null;

        String FOODS_SELECT_QUERY ="SELECT * FROM " + TABLE_FOODS + " WHERE " + KEY_FOOD_ID + " = '" + id + "'";

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(FOODS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    food = new Food(
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_RESTAURANT_ID_FK)),
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_ID)),
                            cursor.getString(cursor.getColumnIndex(KEY_FOOD_NAME)),
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_PRICE)),
                            cursor.getFloat(cursor.getColumnIndex(KEY_FOOD_RATING)),
                            cursor.getString(cursor.getColumnIndex(KEY_FOOD_COMMENT)),
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_IMAGE )));

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get foods from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return food;
    }

    /**
     * Add foods comments.
     *
     * @param foodComment the food comment
     */
// add all foods comments into the database
    public void addFoodsComments(FoodComment foodComment) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();
            values.put(KEY_FOOD_COMMENTS_ID , foodComment.getCommentID());
            values.put(KEY_FOOD_COMMENTS_RESTAURANT_ID_FK ,foodComment.getRestaurantID());
            values.put(KEY_FOOD_COMMENTS_FOOD_ID_FK ,foodComment.getFoodID());
            values.put(KEY_FOOD_COMMENTS_USER_NAME ,foodComment.getUser());
            values.put(KEY_FOOD_COMMENTS_USER_TYPE,foodComment.getUserType());
            values.put(KEY_FOOD_COMMENTS_RATING,foodComment.getRating());
            values.put(KEY_FOOD_COMMENTS_COMMENT ,foodComment.getComment());
            values.put(KEY_FOOD_COMMENTS_DATE ,foodComment.getCommentDate());

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_FOOD_COMMENTS, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add foods to database");
        } finally {
            db.endTransaction();
        }
    }

    /**
     * Gets all foods comments.
     *
     * @return the all foods comments
     */
// Get all foods comments from the database
    public List<FoodComment> getAllFoodsComments() {
        List<FoodComment> foodComments = new ArrayList<>();

        String FOOD_COMMENTS_SELECT_QUERY =
                String.format("SELECT * FROM %s",
                        TABLE_FOOD_COMMENTS);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(FOOD_COMMENTS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    foodComments.add(new FoodComment(
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_COMMENTS_ID)),
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_RESTAURANT_ID_FK)),
                            cursor.getString(cursor.getColumnIndex(KEY_FOOD_COMMENTS_USER_NAME)),
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_COMMENTS_FOOD_ID_FK)),
                            cursor.getString(cursor.getColumnIndex(KEY_FOOD_COMMENTS_USER_TYPE)),
                            cursor.getFloat(cursor.getColumnIndex(KEY_FOOD_COMMENTS_RATING)),
                            cursor.getString(cursor.getColumnIndex(KEY_FOOD_COMMENTS_COMMENT)),
                            cursor.getString(cursor.getColumnIndex(KEY_FOOD_COMMENTS_DATE))));

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get foods from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return foodComments;
    }

    /**
     * Gets food comments.
     *
     * @param foodID the food id
     * @return the food comments
     */
// Get all foods comments using food id from the database
    public List<FoodComment> getFoodComments(int foodID) {
        List<FoodComment> foodComments = new ArrayList<>();

        String FOOD_COMMENTS_SELECT_QUERY =
                String.format("SELECT * FROM %s WHERE %s = '%s'",
                        TABLE_FOOD_COMMENTS, KEY_FOOD_COMMENTS_FOOD_ID_FK , foodID);

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(FOOD_COMMENTS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    foodComments.add(new FoodComment(
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_COMMENTS_ID)),
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_RESTAURANT_ID_FK)),
                            cursor.getString(cursor.getColumnIndex(KEY_FOOD_COMMENTS_USER_NAME)),
                            cursor.getInt(cursor.getColumnIndex(KEY_FOOD_COMMENTS_FOOD_ID_FK)),
                            cursor.getString(cursor.getColumnIndex(KEY_FOOD_COMMENTS_USER_TYPE)),
                            cursor.getFloat(cursor.getColumnIndex(KEY_FOOD_COMMENTS_RATING)),
                            cursor.getString(cursor.getColumnIndex(KEY_FOOD_COMMENTS_COMMENT)),
                            cursor.getString(cursor.getColumnIndex(KEY_FOOD_COMMENTS_DATE))));
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get foods using food id from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return foodComments;
    }

    /**
     * Add restaurant comments.
     *
     * @param restaurantComment the restaurant comment
     */
// add all restaurant comments to the database
    public void addRestaurantComments(RestaurantComment restaurantComment) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();
            values.put(KEY_RESTAURANT_COMMENTS_ID , restaurantComment.getCommentID());
            values.put(KEY_RESTAURANT_COMMENTS_RESTAURANT_ID_FK ,restaurantComment.getRestaurantID());
            values.put(KEY_RESTAURANT_COMMENTS_USER ,restaurantComment.getUser());
            values.put(KEY_RESTAURANT_COMMENTS_USER_TYPE ,restaurantComment.getUserType());
            values.put(KEY_RESTAURANT_COMMENTS_RATING ,restaurantComment.getRating());
            values.put(KEY_RESTAURANT_COMMENTS_COMMENT,restaurantComment.getComment());
            values.put(KEY_RESTAURANT_COMMENTS_DATE,restaurantComment.getCommentDate());

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_RESTAURANT_COMMENTS, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add restaurant comments to database");
        } finally {
            db.endTransaction();
        }
    }

    /**
     * Gets all restaurants comments.
     *
     * @return the all restaurants comments
     */
// Get all restaurant comments from the database
    public List<RestaurantComment> getAllRestaurantsComments() {
        List<RestaurantComment> restaurantComments = new ArrayList<>();

        String RESTAURANT_COMMENTS_SELECT_QUERY =
                String.format("SELECT * FROM %s",
                        TABLE_RESTAURANT_COMMENTS);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(RESTAURANT_COMMENTS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    //
                    restaurantComments.add(new RestaurantComment(
                            cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_ID)),
                            cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_RESTAURANT_ID_FK)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_USER)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_USER_TYPE)),
                            cursor.getFloat(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_RATING)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_COMMENT)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_DATE))));

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get restaurant comments from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return restaurantComments;
    }

    /**
     * Gets all restaurants comments by id.
     *
     * @param id the id
     * @return the all restaurants comments by id
     */
// Get all restaurant comments from the database
    public List<RestaurantComment> getAllRestaurantsCommentsByID(int id) {
        List<RestaurantComment> restaurantComments = new ArrayList<>();

        String RESTAURANT_COMMENTS_SELECT_QUERY = String.format("SELECT * FROM %s WHERE %s = '%s'",
                TABLE_RESTAURANT_COMMENTS, KEY_RESTAURANT_COMMENTS_RESTAURANT_ID_FK, id);
        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(RESTAURANT_COMMENTS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    restaurantComments.add(new RestaurantComment(
                            cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_ID)),
                            cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_RESTAURANT_ID_FK)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_USER)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_USER_TYPE)),
                            cursor.getFloat(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_RATING)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_COMMENT)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_DATE))));

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get restaurant comments from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return restaurantComments;
    }

    /**
     * Gets restaurants comments.
     *
     * @param restaurantID the restaurant id
     * @return the restaurants comments
     */
// Get all restaurant comments from the database
    public List<RestaurantComment> getRestaurantsComments(int restaurantID) {
        List<RestaurantComment> restaurantComments = new ArrayList<>();

        String RESTAURANT_COMMENTS_SELECT_QUERY =
                String.format("SELECT * FROM %s WHERE %s = '%s'",
                        TABLE_RESTAURANT_COMMENTS, KEY_RESTAURANT_COMMENTS_RESTAURANT_ID_FK, restaurantID);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(RESTAURANT_COMMENTS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    restaurantComments.add(new RestaurantComment(
                            cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_ID)),
                            cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_RESTAURANT_ID_FK)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_USER)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_USER_TYPE)),
                            cursor.getFloat(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_RATING)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_COMMENT)),
                            cursor.getString(cursor.getColumnIndex(KEY_RESTAURANT_COMMENTS_DATE))));

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get restaurant comments from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return restaurantComments;
    }

    /**
     * Add opening time.
     *
     * @param openingTime the opening time
     */
// add all opening time to the database
    public void addOpeningTime(OpeningTime openingTime) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();

            values.put(KEY_OPENING_TIME_ID , openingTime.getOpeningTimeID());
            values.put(KEY_OPENING_TIME_RESTAURANT_ID_FK ,openingTime.getRestaurantID());
            values.put(KEY_OPENING_TIME_WEEK_DAYS ,openingTime.getWeekDays());
            values.put(KEY_RESTAURANT_OPENING_TIME ,openingTime.getOpeningTime());
            values.put(KEY_RESTAURANT_CLOSING_TIME,openingTime.getClosingTime());

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_RESTAURANT_OPENING_TIME, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add restaurant opening time to database");
        } finally {
            db.endTransaction();
        }
    }

    /**
     * Gets opening time.
     *
     * @param id the id
     * @return the opening time
     */
// Get all opening time from the database
    public List<OpeningTime> getOpeningTime(int id) {
        List<OpeningTime> openingTimes = new ArrayList<>();

        String OPENING_TIME_SELECT_QUERY =  String.format("SELECT * FROM %s WHERE %s = '%s'",
                TABLE_RESTAURANT_OPENING_TIME, KEY_OPENING_TIME_RESTAURANT_ID_FK, id);
        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(OPENING_TIME_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {

                    openingTimes.add(new OpeningTime(
                            cursor.getInt(cursor.getColumnIndex(KEY_OPENING_TIME_ID)),
                            cursor.getInt(cursor.getColumnIndex(KEY_OPENING_TIME_RESTAURANT_ID_FK)),
                            cursor.getString(cursor.getColumnIndex(KEY_OPENING_TIME_WEEK_DAYS)),
                            cursor.getDouble(cursor.getColumnIndex(KEY_RESTAURANT_OPENING_TIME)),
                            cursor.getDouble(cursor.getColumnIndex(KEY_RESTAURANT_CLOSING_TIME))));

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get restaurant comments from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return openingTimes;
    }

    /**
     * Add restaurant location.
     *
     * @param restaurantLocation the restaurant location
     */
// add all opening time to the database
    public void addRestaurantLocation(RestaurantLocation restaurantLocation) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {

            ContentValues values = new ContentValues();
            values.put(KEY_RESTAURANT_LOCATION_ID , restaurantLocation.getID());
            values.put(KEY_RESTAURANT_LOCATION_RESTAURANT_ID_FK ,restaurantLocation.getRestaurantID());
            values.put(KEY_RESTAURANT_LOCATION_LATITUDE ,restaurantLocation.getRestaurantLatitude());
            values.put(KEY_RESTAURANT_LOCATION_LONGITUDE ,restaurantLocation.getRestaurantLongitude());

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_RESTAURANT_LOCATION, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add restaurant opening time to database");
        } finally {
            db.endTransaction();
        }
    }

    /**
     * Gets all restaurant location.
     *
     * @return the all restaurant location
     */
// Get all opening time from the database
    public List<RestaurantLocation> getAllRestaurantLocation() {
        List<RestaurantLocation> restaurantLocations = new ArrayList<>();

        String OPENING_TIME_SELECT_QUERY =
                String.format("SELECT * FROM %s",
                        TABLE_RESTAURANT_LOCATION);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(OPENING_TIME_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {


                    restaurantLocations.add(new RestaurantLocation(
                            cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_LOCATION_ID)),
                            cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_LOCATION_RESTAURANT_ID_FK)),
                            cursor.getDouble(cursor.getColumnIndex(KEY_RESTAURANT_LOCATION_LATITUDE)),
                            cursor.getDouble(cursor.getColumnIndex(KEY_RESTAURANT_LOCATION_LONGITUDE))));

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get restaurant comments from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return restaurantLocations;
    }

    /**
     * Gets restaurant location by id.
     *
     * @param id the id
     * @return the restaurant location by id
     */
    public RestaurantLocation getRestaurantLocationByID(int id) {
        RestaurantLocation restaurantLocations = null;

        String OPENING_TIME_SELECT_QUERY =
                String.format("SELECT * FROM %s WHERE %s = '%s'",
                        TABLE_RESTAURANT_LOCATION,KEY_RESTAURANT_LOCATION_RESTAURANT_ID_FK,id);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(OPENING_TIME_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {


                    restaurantLocations = new RestaurantLocation(
                            cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_LOCATION_ID)),
                            cursor.getInt(cursor.getColumnIndex(KEY_RESTAURANT_LOCATION_RESTAURANT_ID_FK)),
                            cursor.getDouble(cursor.getColumnIndex(KEY_RESTAURANT_LOCATION_LATITUDE)),
                            cursor.getDouble(cursor.getColumnIndex(KEY_RESTAURANT_LOCATION_LONGITUDE)));

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get restaurant comments from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return restaurantLocations;
    }


    /**
     * Add all information.
     */
    public void addAllInformation() {

        for (Restaurant r : ResDB.getInstance().getAllRestaurants()){
            addRestaurants(r);
        }

        for (Food r : ResDB.getInstance().getAllFoods()){
            addFoods(r);
        }

        for (FoodComment r : ResDB.getInstance().getAllFoodComments()){
            addFoodsComments(r);
        }

        for (RestaurantComment r : ResDB.getInstance().getAllRestaurantComments()){
            addRestaurantComments(r);

        }
        for (OpeningTime r : ResDB.getInstance().getAllRestaurantOpeningTime()){
            addOpeningTime(r);
        }

        for (RestaurantLocation r : ResDB.getInstance().getAllRestaurantLocations()){
            addRestaurantLocation(r);
        }
    }
}



