package com.example.restaurant_finder.Classes;

/**
 * The type Restaurant.
 *
 * @author Gajalakshan Chandrasegaran
 * @date 20.02.2020  This class created for the Restaurant, for getting and displaying of the Restaurant.
 */

public class Restaurant{
    private int restaurantID;
    private String restaurantName;
    private String restaurantDescription;
    private float restaurantRating;
    private String restaurantComment;
    private String restaurantContact;
    private String restaurantLocation;
    private int restaurantImage;

    /**
     * Instantiates a new Restaurant.
     *
     * @param _restaurantID          the restaurant id
     * @param _restaurantName        the restaurant name
     * @param _restaurantDescription the restaurant description
     * @param _restaurantRating      the restaurant rating
     * @param _restaurantComment     the restaurant comment
     * @param _restaurantLocation    the restaurant location
     * @param _restaurantContact     the restaurant contact
     * @param _restaurantImage       the restaurant image
     */
    public Restaurant(int _restaurantID,
                      String _restaurantName,
                      String _restaurantDescription,
                      float _restaurantRating,
                      String _restaurantComment,
                      String _restaurantLocation,
                      String _restaurantContact,
                      int _restaurantImage){
        this.restaurantID = _restaurantID;
        this.restaurantName = _restaurantName;
        this.restaurantDescription = _restaurantDescription;
        this.restaurantRating = _restaurantRating;
        this.restaurantComment = _restaurantComment;
        this.restaurantLocation = _restaurantLocation;
        this.restaurantContact = _restaurantContact;
        this.restaurantImage = _restaurantImage;
    }

    /**
     * Instantiates a new Restaurant.
     */
    public Restaurant(){
        super();
    }

    /**
     * Get id int.
     *
     * @return the int
     */
    public int getID(){
        return this.restaurantID;
    }

    /**
     * Get name string.
     *
     * @return the string
     */
    public String getName(){
        return this.restaurantName;
    }

    /**
     * Get description string.
     *
     * @return the string
     */
    public String getDescription(){
        return this.restaurantDescription;
    }

    /**
     * Get rating float.
     *
     * @return the float
     */
    public float getRating(){
        return this.restaurantRating;
    }

    /**
     * Get comment string.
     *
     * @return the string
     */
    public String getComment(){
        return this.restaurantComment;
    }

    /**
     * Get image int.
     *
     * @return the int
     */
    public int getImage(){
        return this.restaurantImage;
    }

    /**
     * Get location string.
     *
     * @return the string
     */
    public String getLocation(){
        return this.restaurantLocation;
    }

    /**
     * Get contact string.
     *
     * @return the string
     */
    public String getContact(){
        return this.restaurantContact;
    }

}
