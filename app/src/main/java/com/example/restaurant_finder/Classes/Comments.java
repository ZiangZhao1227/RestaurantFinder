package com.example.restaurant_finder.Classes;

/**
 * The type Comments.
 *
 * @author Maksim Pasnitsenko on 22.02.2020
 * this is the class for the Comments, for loading and accessing comments
 */


public class Comments {
    private int restaurantID;
    private int foodID;

    /**
     * Instantiates a new Comments.
     *
     * @param _restaurantId the restaurant id
     * @param _foodID       the food id
     */
    public Comments(int _restaurantId,
                    int _foodID){
        this.restaurantID = _restaurantId;
        this.foodID = _foodID;
    }

    /**
     * Instantiates a new Comments.
     */
    public Comments(){
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
        return this.restaurantID;
    }

}
