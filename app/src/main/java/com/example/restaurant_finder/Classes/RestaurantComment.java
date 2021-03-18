package com.example.restaurant_finder.Classes;

/**
 * The type Restaurant comment.
 *
 * @author Maksim Pasnitsenko
 * @date 22.02.2020  This class created for the Restaurant comments, for getting and displaying of the Restaurant comments given by customers.
 */


public class RestaurantComment extends Comments {
    private int commentID;
    private int restaurantID;
    private String commentUser;
    private String commentUserType;
    private float restaurantRating;
    private String restaurantComment;
    private String restaurantCommentDate;

    /**
     * Instantiates a new Restaurant comment.
     *
     * @param _commentID             the comment id
     * @param _restaurantID          the restaurant id
     * @param _commentUser           the comment user
     * @param _commentUserType       the comment user type
     * @param _restaurantRating      the restaurant rating
     * @param _restaurantComment     the restaurant comment
     * @param _restaurantCommentDate the restaurant comment date
     */
    public RestaurantComment( int _commentID,
                              int _restaurantID,
                        String _commentUser,
                        String _commentUserType,
                        float _restaurantRating,
                        String _restaurantComment,
                              String _restaurantCommentDate){
        this.commentID = _commentID;
        this.restaurantID = _restaurantID;
        this.commentUser = _commentUser;
        this.commentUserType = _commentUserType;
        this.restaurantRating = _restaurantRating;
        this.restaurantComment = _restaurantComment;
        this.restaurantCommentDate = _restaurantCommentDate;
    }

    /**
     * Instantiates a new Restaurant comment.
     */
    public RestaurantComment(){
        super();
    }

    /**
     * Get comment id int.
     *
     * @return the int
     */
    public int getCommentID(){
        return this.commentID;
    }

    public int getRestaurantID(){
        return this.restaurantID;
    }

    /**
     * Get user string.
     *
     * @return the string
     */
    public String getUser(){
        return this.commentUser;
    }

    /**
     * Get user type string.
     *
     * @return the string
     */
    public String getUserType(){
        return this.commentUserType;
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
     * Get comment date string.
     *
     * @return the string
     */
    public String getCommentDate(){
        return this.restaurantCommentDate;
    }
}
