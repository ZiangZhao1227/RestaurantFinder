package com.example.restaurant_finder.Classes;

/**
 * The type Food comment.
 *
 * @author Maksim Pasnitsenko
 * @date 19.02.2020  This class created for the FoodComment, for getting and displaying food comments those who commented access
 */

public class FoodComment extends Comments{
    private int commentID;
    private int restaurantID;
    private int foodID;
    private String commentUser;
    private String commentUserType;
    private float foodRating;
    private String foodComment;
    private String foodCommentDate;

    /**
     * Instantiates a new Food comment.
     *
     * @param _commentID       the comment id
     * @param _restaurantID    the restaurant id
     * @param _commentUser     the comment user
     * @param _foodID          the food id
     * @param _commentUserType the comment user type
     * @param _foodRating      the food rating
     * @param _foodComment     the food comment
     * @param _foodCommentDate the food comment date
     */
    public FoodComment( int _commentID,
                        int _restaurantID,
                        String _commentUser,
                        int _foodID,
                        String _commentUserType,
                        float _foodRating,
                        String _foodComment,
                        String _foodCommentDate){
        this.commentID =_commentID;
        this.restaurantID =_restaurantID;
        this.foodID = _foodID;
        this.commentUser = _commentUser;
        this.commentUserType = _commentUserType;
        this.foodRating = _foodRating;
        this.foodComment = _foodComment;
        this.foodCommentDate = _foodCommentDate;
    }

    /**
     * Instantiates a new Food comment.
     */
    public FoodComment(){
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

    public int getFoodID(){
        return this.foodID;
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
        return this.foodRating;
    }

    /**
     * Get comment string.
     *
     * @return the string
     */
    public String getComment(){
        return this.foodComment;
    }

    /**
     * Get comment date string.
     *
     * @return the string
     */
    public String getCommentDate(){
        return this.foodCommentDate;
    }
}
