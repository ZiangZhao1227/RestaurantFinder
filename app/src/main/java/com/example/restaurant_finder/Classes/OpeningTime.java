package com.example.restaurant_finder.Classes;

/**
 * The type Opening time.
 *
 * @author Gajalakshan Chandrasegaran
 * @date 29.02.2020  This class created for the OpeningTime, for getting and displaying restaurant opening and closing time
 */
public class OpeningTime {
    private int openingTimeID;
    private int restaurantID;
    private String weekDays;
    private double openingTime;
    private double closingTime;

    /**
     * Instantiates a new Opening time.
     *
     * @param _openingTimeID the opening time id
     * @param _restaurantID  the restaurant id
     * @param _weekDays      the week days
     * @param _openingTime   the opening time
     * @param _closingTime   the closing time
     */
    public OpeningTime( int _openingTimeID, int _restaurantID, String _weekDays, double _openingTime, double _closingTime){
        this.openingTimeID= _openingTimeID;
        this.restaurantID= _restaurantID;
        this.weekDays = _weekDays;
        this.openingTime = _openingTime;
        this.closingTime = _closingTime;
    }

    /**
     * Instantiates a new Opening time.
     */
    public OpeningTime(){
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
     * Get opening time id int.
     *
     * @return the int
     */
    public int getOpeningTimeID(){
        return this.openingTimeID;
    }

    /**
     * Get week days string.
     *
     * @return the string
     */
    public String getWeekDays(){
        return this.weekDays;
    }

    /**
     * Get opening time double.
     *
     * @return the double
     */
    public double getOpeningTime(){
        return this.openingTime;
    }

    /**
     * Get closing time double.
     *
     * @return the double
     */
    public double getClosingTime(){
        return this.closingTime;
    }
}
