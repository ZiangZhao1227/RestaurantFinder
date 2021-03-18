package com.example.restaurant_finder.Classes;

/**
 * The type Restaurant location.
 *
 * @author Gajalakshan Chandrasegaran
 * @date 09.03.2020  This class created for the RestaurantLocation, for getting and displaying the Restaurant Location information.
 */
public class RestaurantLocation {
    private int locaID;
    private int restaurantID;
    private double restaurantLatitude;
    private double restaurantLongitude;

    /**
     * Instantiates a new Restaurant location.
     *
     * @param _locaID              the loca id
     * @param _restaurantID        the restaurant id
     * @param _restaurantLatitude  the restaurant latitude
     * @param _restaurantLongitude the restaurant longitude
     */
    public RestaurantLocation(int _locaID, int _restaurantID, double _restaurantLatitude, double _restaurantLongitude) {
        this.locaID = _locaID;
        this.restaurantID = _restaurantID;
        this.restaurantLatitude = _restaurantLatitude;
        this.restaurantLongitude = _restaurantLongitude;
    }

    /**
     * Instantiates a new Restaurant location.
     */
    public RestaurantLocation() {
        super();
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getID() {
        return this.locaID;
    }

    /**
     * Gets restaurant id.
     *
     * @return the restaurant id
     */
    public int getRestaurantID() {
        return this.restaurantID;
    }

    /**
     * Gets restaurant latitude.
     *
     * @return the restaurant latitude
     */
    public double getRestaurantLatitude() {
        return this.restaurantLatitude;
    }

    /**
     * Gets restaurant longitude.
     *
     * @return the restaurant longitude
     */
    public double getRestaurantLongitude() {
        return this.restaurantLongitude;
    }


}
