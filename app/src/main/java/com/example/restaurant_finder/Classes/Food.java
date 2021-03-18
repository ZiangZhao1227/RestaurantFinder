package com.example.restaurant_finder.Classes;

/**
 * The type Food.
 *
 * @author Gajalakshan Chandrasegaran
 * @date 19.02.2020  This class created for the Food, for getting and displaying food access
 */

public class Food  {

    private int restaurantID;
    private int foodID;
    private String foodName;
    private int foodPrice;
    private float foodRating;
    private String foodComment;
    private int foodImage;

    /**
     * Instantiates a new Food.
     *
     * @param _restaurantID the restaurant id
     * @param _foodID       the food id
     * @param _foodName     the food name
     * @param _foodPrice    the food price
     * @param _foodRating   the food rating
     * @param _foodComment  the food comment
     * @param _foodImage    the food image
     */
    public Food( int _restaurantID,
                 int _foodID,
                 String _foodName,
                 int _foodPrice,
                 float _foodRating,
                 String _foodComment,
                 int _foodImage){
        this.restaurantID= _restaurantID;
        this.foodID= _foodID;
        this.foodName = _foodName;
        this.foodPrice = _foodPrice;
        this.foodRating = _foodRating;
        this.foodComment = _foodComment;
        this.foodImage = _foodImage;
    }

    /**
     * Instantiates a new Food.
     */
    public Food(){
        super();
    }

    /**
     * Get restaurant id int.
     *
     * @return the int
     */
    public int getRestaurantID(){
        return this.restaurantID;
    }

    /**
     * Get food id int.
     *
     * @return the int
     */
    public int getFoodID(){
        return this.foodID;
    }

    /**
     * Get food name string.
     *
     * @return the string
     */
    public String getFoodName(){
        return this.foodName;
    }

    /**
     * Get food price int.
     *
     * @return the int
     */
    public int getFoodPrice(){
        return this.foodPrice;
    }

    /**
     * Get food rating float.
     *
     * @return the float
     */
    public float getFoodRating(){
        return this.foodRating;
    }

    /**
     * Get food comment string.
     *
     * @return the string
     */
    public String getFoodComment(){
        return this.foodComment;
    }

    /**
     * Get food image int.
     *
     * @return the int
     */
    public int getFoodImage(){
        return this.foodImage;
    }

}
