package com.example.restaurant_finder.Database;


import com.example.restaurant_finder.Classes.Food;
import com.example.restaurant_finder.Classes.FoodComment;
import com.example.restaurant_finder.Classes.OpeningTime;
import com.example.restaurant_finder.Classes.Restaurant;
import com.example.restaurant_finder.Classes.RestaurantComment;
import com.example.restaurant_finder.Classes.RestaurantLocation;
import com.example.restaurant_finder.R;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Res db.
 *
 * @author Gajalakshan Chandrasegaran
 * @date 20.02.2020  This class created for the Restaurant temporary database, for getting and displaying data of all.
 */
public class ResDB {

    private List<Restaurant> _restaurants;
    private List<Food> _foods;
    private List<FoodComment> _foodComments;
    private List<RestaurantComment> _restaurantComments;
    private List<OpeningTime> _openingTimes;
    private List<RestaurantLocation> _restaurantLocations;

    private static final ResDB ourInstance = new ResDB();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ResDB getInstance() {
        return ourInstance;
    }

    private ResDB() {
        _restaurants = new ArrayList<>();
        _restaurants.add(new Restaurant(0,"Restaurant Lappi", "Description", 4.5f, "Comments","Annankatu 22, Helsinki 00100, Finland","+358 9 645550", R.drawable.res_lappi));
        _restaurants.add(new Restaurant(1,"Nokka", "Description", 4.5f, "Comments","Kanavaranta 7 F, Helsinki 00160, Finland","+358 9 61285600",R.drawable.res_nokka));
        _restaurants.add(new Restaurant(2,"Karl Fazer Cafe", "Description", 4f, "Comments","Kluuvikatu 3, Helsinki 00100, Finland","+358 20 7296702",R.drawable.res_karlfazercafe));
        _restaurants.add(new Restaurant(3,"Hard Rock Cafe", "Description", 4f, "Comments","Aleksanterinkatu 21, Helsinki 00100, Finland","+358 9 42826888", R.drawable.res_hardrock));
        _restaurants.add(new Restaurant(4,"Juuri", "Description", 4.5f, "Comments","Korkeavuorenkatu 27, Helsinki 00130, Finland","+358 50 4398465",R.drawable.res_juuri));
        _restaurants.add(new Restaurant(5,"Kappeli", "Description", 4f, "Comments","Eteläeesplanadi 1, Helsinki 00130, Finland","+358 10 7663880",R.drawable.res_kappeli));
        _restaurants.add(new Restaurant(6,"Restaurant Meripaviljonki", "Description", 4f, "Comments","Säästöpankinranta 3, Helsinki 00530, Finland", "+358 20 7425320",R.drawable.res_meripaviljonki));
        _restaurants.add(new Restaurant(7,"Restaurant Aino", "Description", 4f, "Comments","Pohjoisesplanadi 21, Helsinki 00100, Finland","+358 9 624327",R.drawable.res_aino));
        _restaurants.add(new Restaurant(8,"Restaurant Savotta", "Description", 4f, "Comments","Aleksanterinkatu 22, Helsinki 00170, Finland","+358 9 74255588",R.drawable.res_savotta));
        _restaurants.add(new Restaurant(9,"Restaurant Kuu", "Description", 4.5f, "Comments","Töölönkatu 27, 00260 Helsinki, Finland","+358 9 27090973",R.drawable.res_kuu));

        _foods = new ArrayList<>();

        _foods.add(new Food(0,1,  "Menu 1", 18, 5f, "Comments",R.drawable.lappi_food_1));
        _foods.add(new Food(0, 2,  "Menu 2", 15, 4f, "Comments",R.drawable.lappi_food_2));
        _foods.add(new Food(0,3,  "Menu 3", 21, 5f, "Comments",R.drawable.lappi_food_3));
        _foods.add(new Food(0, 4, "Menu 4", 15, 3.5f, "Comments",R.drawable.lappi_food_4));
        _foods.add(new Food(0, 5, "Menu 5", 12, 4.5f, "Comments",R.drawable.lappi_food_5));

        _foods.add(new Food(1,6,  "Menu 1", 14, 3.5f, "Comments",R.drawable.nokka_food_1));
        _foods.add(new Food(1, 7,  "Menu 2", 15, 2.5f, "Comments",R.drawable.nokka_food_2));
        _foods.add(new Food(1,8,  "Menu 3", 23, 3.0f, "Comments",R.drawable.nokka_food_3));
        _foods.add(new Food(1, 9, "Menu 4", 14, 4.5f, "Comments",R.drawable.nokka_food_4));
        _foods.add(new Food(1, 10, "Menu 5", 27, 5f, "Comments",R.drawable.nokka_food_5));

        _foods.add(new Food(2,11,  "Menu 1", 13, 5f, "Comments",R.drawable.karlfazercafe_food_1));
        _foods.add(new Food(2, 12,  "Menu 2", 14, 4.5f, "Comments",R.drawable.karlfazercafe_food_2));
        _foods.add(new Food(2,13,  "Menu 3", 26, 3f, "Comments",R.drawable.karlfazercafe_food_3));
        _foods.add(new Food(2, 14, "Menu 4", 17, 3.5f, "Comments",R.drawable.karlfazercafe_food_4));
        _foods.add(new Food(2, 15, "Menu 5", 19, 3f, "Comments",R.drawable.karlfazercafe_food_5));

        _foods.add(new Food(3,16,  "Menu 1", 13, 4.5f, "Comments",R.drawable.hardrock_food_1));
        _foods.add(new Food(3, 17,  "Menu 2", 15, 5f, "Comments",R.drawable.hardrock_food_2));
        _foods.add(new Food(3,18,  "Menu 3", 28, 3.5f, "Comments",R.drawable.hardrock_food_3));
        _foods.add(new Food(3, 19, "Menu 4", 19, 3f, "Comments",R.drawable.hardrock_food_4));
        _foods.add(new Food(3, 20, "Menu 5", 17, 2.5f, "Comments",R.drawable.hardrock_food_5));

        _foods.add(new Food(4,21,  "Menu 1", 13, 3.5f, "Comments",R.drawable.juuri_food_1));
        _foods.add(new Food(4, 22,  "Menu 2", 14, 4.5f, "Comments",R.drawable.juuri_food_2));
        _foods.add(new Food(4,23,  "Menu 3", 25, 4f, "Comments",R.drawable.juuri_food_3));
        _foods.add(new Food(4, 24, "Menu 4", 16, 5f, "Comments",R.drawable.juuri_food_4));
        _foods.add(new Food(4, 25, "Menu 5", 16, 3.5f, "Comments",R.drawable.juuri_food_5));

        _foods.add(new Food(5,26,  "Menu 1", 18, 5f, "Comments",R.drawable.kappeli_food_1));
        _foods.add(new Food(5, 27,  "Menu 2", 18, 4f, "Comments",R.drawable.kappeli_food_2));
        _foods.add(new Food(5,28,  "Menu 3", 24, 3f, "Comments",R.drawable.kappeli_food_3));
        _foods.add(new Food(5, 29, "Menu 4", 13, 3.5f, "Comments",R.drawable.kappeli_food_4));
        _foods.add(new Food(5, 30, "Menu 5", 19, 4.5f, "Comments",R.drawable.kappeli_food_5));

        _foods.add(new Food(6,31,  "Menu 1", 13, 3f, "Comments",R.drawable.meripaviljonki_food_1));
        _foods.add(new Food(6, 32,  "Menu 2", 15, 4.5f, "Comments",R.drawable.meripaviljonki_food_2));
        _foods.add(new Food(6,33,  "Menu 3", 29, 5f, "Comments",R.drawable.meripaviljonki_food_3));
        _foods.add(new Food(6, 34, "Menu 4", 17, 2.5f, "Comments",R.drawable.meripaviljonki_food_4));
        _foods.add(new Food(6, 35, "Menu 5", 15, 5f, "Comments",R.drawable.meripaviljonki_food_5));

        _foods.add(new Food(7,36,  "Menu 1", 13, 5f, "Comments",R.drawable.aino_food_1));
        _foods.add(new Food(7, 37,  "Menu 2", 16, 4.5f, "Comments",R.drawable.aino_food_2));
        _foods.add(new Food(7,38,  "Menu 3", 27, 3.5f, "Comments",R.drawable.aino_food_3));
        _foods.add(new Food(7, 39, "Menu 4", 18, 4f, "Comments",R.drawable.aino_food_4));
        _foods.add(new Food(7, 40, "Menu 5", 18, 5f, "Comments",R.drawable.aino_food_5));

        _foods.add(new Food(8,41,  "Menu 1", 19, 5f, "Comments",R.drawable.savotta_food_1));
        _foods.add(new Food(8, 42,  "Menu 2", 16, 4f, "Comments",R.drawable.savotta_food_2));
        _foods.add(new Food(8,43,  "Menu 3", 24, 5f, "Comments",R.drawable.savotta_food_3));
        _foods.add(new Food(8, 44, "Menu 4", 13, 4.5f, "Comments",R.drawable.savotta_food_4));
        _foods.add(new Food(8, 45, "Menu 5", 15, 4f, "Comments",R.drawable.savotta_food_5));

        _foods.add(new Food(9,46,  "Menu 1", 15, 4.5f, "Comments",R.drawable.kuu_food_1));
        _foods.add(new Food(9, 47,  "Menu 2", 14, 4.5f, "Comments",R.drawable.kuu_food_2));
        _foods.add(new Food(9,48,  "Menu 3", 27, 3.5f, "Comments",R.drawable.kuu_food_3));
        _foods.add(new Food(9, 49, "Menu 4", 15, 3f, "Comments",R.drawable.kuu_food_4));
        _foods.add(new Food(9, 50, "Menu 5", 13, 3f, "Comments",R.drawable.kuu_food_5));

        _restaurantLocations = new ArrayList<>();
        _restaurantLocations.add(new RestaurantLocation(1,0, 60.166810, 24.936918));
        _restaurantLocations.add(new RestaurantLocation(2,1, 60.169033, 24.961174));
        _restaurantLocations.add(new RestaurantLocation(3,2, 60.168912, 24.941297));
        _restaurantLocations.add(new RestaurantLocation(4,3, 60.179570, 24.946860));
        _restaurantLocations.add(new RestaurantLocation(5,4, 60.164010, 24.946284));
        _restaurantLocations.add(new RestaurantLocation(6,5, 60.167519, 24.950291));
        _restaurantLocations.add(new RestaurantLocation(7,6, 60.179570, 24.946860));
        _restaurantLocations.add(new RestaurantLocation(8,7, 60.171162, 24.944035));
        _restaurantLocations.add(new RestaurantLocation(9,8, 60.169441, 24.952762));
        _restaurantLocations.add(new RestaurantLocation(10,9, 60.180331, 24.925124));


        _openingTimes = new ArrayList<>();
        _openingTimes.add(new OpeningTime(1,0, "Mon:", 16.00, 22.30));
        _openingTimes.add(new OpeningTime(2,0, "Tue:", 16.00, 22.30));
        _openingTimes.add(new OpeningTime(3,0, "Wed:", 16.00, 22.30));
        _openingTimes.add(new OpeningTime(4,0, "Thu:", 16.00, 22.30));
        _openingTimes.add(new OpeningTime(5,0, "Fri:", 16.00, 22.30));
        _openingTimes.add(new OpeningTime(6,0, "Sat:", 16.00, 22.30));
        _openingTimes.add(new OpeningTime(7,0, "Sun:", 00.00, 00.00));

        _openingTimes.add(new OpeningTime(8,1, "Mon:", 11.30, 22.00));
        _openingTimes.add(new OpeningTime(9,1, "Tue:", 11.30, 22.00));
        _openingTimes.add(new OpeningTime(10,1, "Wed:", 11.30, 23.00));
        _openingTimes.add(new OpeningTime(11,1, "Thu:", 11.30, 23.00));
        _openingTimes.add(new OpeningTime(12,1, "Fri:", 11.30, 00.00));
        _openingTimes.add(new OpeningTime(13,1, "Sat:", 18.00, 00.00));
        _openingTimes.add(new OpeningTime(14,1, "Sun:", 00.00, 00.00));

        _openingTimes.add(new OpeningTime(15,2, "Mon:", 7.30, 22.00));
        _openingTimes.add(new OpeningTime(16,2, "Tue:", 7.30, 22.00));
        _openingTimes.add(new OpeningTime(17,2, "Wed:", 7.30, 22.00));
        _openingTimes.add(new OpeningTime(18,2, "Thu:", 7.30, 22.00));
        _openingTimes.add(new OpeningTime(19,2, "Fri:", 7.30, 22.00));
        _openingTimes.add(new OpeningTime(20,2, "Sat:", 9.00, 22.00));
        _openingTimes.add(new OpeningTime(21,2, "Sun:", 10.00, 18.00));

        _openingTimes.add(new OpeningTime(22,3, "Mon:", 11.00, 00.00));
        _openingTimes.add(new OpeningTime(23,3, "Tue:", 11.00, 00.00));
        _openingTimes.add(new OpeningTime(24,3, "Wed:", 11.00, 00.00));
        _openingTimes.add(new OpeningTime(25,3, "Thu:", 11.00, 00.00));
        _openingTimes.add(new OpeningTime(26,3, "Fri:", 11.00, 02.00));
        _openingTimes.add(new OpeningTime(27,3, "Sat:", 11.00, 02.00));
        _openingTimes.add(new OpeningTime(28,3, "Sun:", 11.00, 00.00));

        _openingTimes.add(new OpeningTime(29,4, "Mon:", 17.00, 23.00));
        _openingTimes.add(new OpeningTime(30,4, "Tue:", 17.00, 23.00));
        _openingTimes.add(new OpeningTime(31,4, "Wed:", 17.00, 23.00));
        _openingTimes.add(new OpeningTime(32,4, "Thu:", 17.00, 23.00));
        _openingTimes.add(new OpeningTime(33,4, "Fri:", 17.00, 23.00));
        _openingTimes.add(new OpeningTime(34,4, "Sat:", 17.00, 23.00));
        _openingTimes.add(new OpeningTime(35,4, "Sun:", 17.00, 23.00));

        _openingTimes.add(new OpeningTime(36,5, "Mon:", 10.00, 00.00));
        _openingTimes.add(new OpeningTime(37,5, "Tue:", 10.00, 00.00));
        _openingTimes.add(new OpeningTime(38,5, "Wed:", 10.00, 00.00));
        _openingTimes.add(new OpeningTime(39,5, "Thu:", 10.00, 00.00));
        _openingTimes.add(new OpeningTime(40,5, "Fri:", 10.00, 00.00));
        _openingTimes.add(new OpeningTime(41,5, "Sat:", 10.00, 00.00));
        _openingTimes.add(new OpeningTime(42,5, "Sun:", 10.00, 00.00));

        _openingTimes.add(new OpeningTime(43,6, "Mon:", 11.00, 22.00));
        _openingTimes.add(new OpeningTime(44,6, "Tue:", 11.00, 22.00));
        _openingTimes.add(new OpeningTime(45,6, "Wed:", 11.00, 23.00));
        _openingTimes.add(new OpeningTime(46,6, "Thu:", 11.00, 23.00));
        _openingTimes.add(new OpeningTime(47,6, "Fri:", 11.00, 00.00));
        _openingTimes.add(new OpeningTime(48,6, "Sat:", 14.00, 00.00));
        _openingTimes.add(new OpeningTime(49,6, "Sun:", 10.45, 17.15));

        _openingTimes.add(new OpeningTime(50,7, "Mon:", 11.30, 22.30));
        _openingTimes.add(new OpeningTime(51,7, "Tue:", 11.30, 22.30));
        _openingTimes.add(new OpeningTime(52,7, "Wed:", 11.30, 22.30));
        _openingTimes.add(new OpeningTime(53,7, "Thu:", 11.30, 22.30));
        _openingTimes.add(new OpeningTime(54,7, "Fri:", 11.30, 22.30));
        _openingTimes.add(new OpeningTime(55,7, "Sat:", 16.00, 22.30));
        _openingTimes.add(new OpeningTime(56,7, "Sun:", 9.00, 05.00));

        _openingTimes.add(new OpeningTime(57,8, "Mon:", 12.00, 23.00));
        _openingTimes.add(new OpeningTime(58,8, "Tue:", 12.00, 23.00));
        _openingTimes.add(new OpeningTime(59,8, "Wed:", 12.00, 23.00));
        _openingTimes.add(new OpeningTime(60,8, "Thu:", 12.00, 23.00));
        _openingTimes.add(new OpeningTime(61,8, "Fri:", 12.00, 23.00));
        _openingTimes.add(new OpeningTime(62,8, "Sat:", 12.00, 23.00));
        _openingTimes.add(new OpeningTime(63,8, "Sun:", 16.00, 22.00));

        _openingTimes.add(new OpeningTime(64,9, "Mon:", 11.30, 00.00));
        _openingTimes.add(new OpeningTime(65,9, "Tue:", 11.30, 00.00));
        _openingTimes.add(new OpeningTime(66,9, "Wed:", 11.30, 00.00));
        _openingTimes.add(new OpeningTime(67,9, "Thu:", 11.30, 00.00));
        _openingTimes.add(new OpeningTime(68,9, "Fri:", 11.30, 00.00));
        _openingTimes.add(new OpeningTime(69,9, "Sat:", 14.00, 00.00));
        _openingTimes.add(new OpeningTime(70,9, "Sun:", 14.00, 22.00));


        _foodComments = new ArrayList<>();

        _foodComments.add(new FoodComment(1,0,"User 01", 1, "Comment", 4.5f, "Good restaurant!!", "12/02/2020"));
        _foodComments.add(new FoodComment(2,0,"User 02", 2, "Comment", 3.5f, "Great!!", "12/01/2020"));
        _foodComments.add(new FoodComment(3,0,"User 02", 26, "Comment", 2.5f, "So happy to have found this place with it’s unlabeled possibilities for low carb picks. Loved the food, wine and atmosphere.", "12/11/2019"));
        _foodComments.add(new FoodComment(4,0,"User 02", 3, "Comment", 3.5f, "Excellent!!", "10/01/2020"));
        _foodComments.add(new FoodComment(5,0,"User 03", 20, "Comment", 1.5f, "Good restaurant!!", "12/12/2019"));
        _foodComments.add(new FoodComment(6,0,"User 02", 4, "Comment", 3.5f, "Nice", "11/01/2020"));
        _foodComments.add(new FoodComment(7,0,"User 01", 5, "Comment", 4.5f, "Good restaurant!!", "12/02/2020"));
        _foodComments.add(new FoodComment(8,0,"User 02", 6, "Comment", 3.5f, "Great!!", "12/01/2020"));
        _foodComments.add(new FoodComment(9,0,"User 02", 27, "Comment", 2.5f, "So happy to have found this place with it’s unlabeled possibilities for low carb picks. Loved the food, wine and atmosphere.", "12/11/2019"));
        _foodComments.add(new FoodComment(10,0,"User 02", 28, "Comment", 3.5f, "Excellent!!", "10/01/2020"));
        _foodComments.add(new FoodComment(11,0,"User 03", 50, "Comment", 1.5f, "Good restaurant!!", "12/12/2019"));
        _foodComments.add(new FoodComment(12,0,"User 02", 1, "Comment", 3.5f, "Nice", "11/01/2020"));
        _foodComments.add(new FoodComment(13,0,"User 04", 22, "Comment", 0.5f, "We did recommended menu and food was excellent. Service was fantastic and we got the feeling every table group got personal service and time to relax with good atmosphere. Very cozy.", "22/01/2019"));
        _foodComments.add(new FoodComment(15,0,"User 02", 23, "Comment", 3.5f, "Great!!", "12/01/2020"));
        _foodComments.add(new FoodComment(16,0,"User 05", 43, "Comment", 4.0f, "We have been here a couple of times as a family. Enjoyed very much each time. Excellent food, good and friendly service. Book a table well in advance", "12/02/2018"));
        _foodComments.add(new FoodComment(17,0,"User 02", 43, "Comment", 3.5f, "Great!!", "09/01/2020"));

        _foodComments.add(new FoodComment(18,1,"User 01", 7, "Comment", 0.6f, "This well hidden restaurant is amazing. The reindeer paired with the barolo is to die for. I will definetely come back when back in Helsinki.", "12/11/2019"));
        _foodComments.add(new FoodComment(19,1,"User 02", 8, "Comment", 3.6f, "Great!!", "12/12/2019"));
        _foodComments.add(new FoodComment(20,1,"User 01", 29, "Comment", 0.5f, "Burrata, reindeer heart, pumpkin with goat cheese mousse, pike perch, beef tartar, etc. It is all gourmet and served with relaxed style. I live 1km away, will come back.", "12/01/2019"));
        _foodComments.add(new FoodComment(21,1,"User 02", 30, "Comment", 3.3f, "BasBas is the perfect combination of superb food, innovative wine and drinks, ambient interior and most welcoming and caring staff. Perfect!", "02/12/2019"));
        _foodComments.add(new FoodComment(22,1,"User 01", 2, "Comment", 0.1f, "Good restaurant!!", "03/11/2019"));
        _foodComments.add(new FoodComment(23,1,"User 02", 3, "Comment", 3.5f, "Food and service exellent. Only problem is the difficulty to book a table. Visitied two times,both superb.", "04/12/2019"));
        _foodComments.add(new FoodComment(24,1,"User 01", 24, "Comment", 0.6f, "Good restaurant!!", "12/04/2019"));
        _foodComments.add(new FoodComment(25,1,"User 02", 25, "Comment", 3.7f, "An absolutely fantastic dinner in a super cool space. The pasta and risotto was sublime, while the fish was just divine!", "12/05/2019"));
        _foodComments.add(new FoodComment(26,1,"User 01", 44, "Comment", 0.3f, "Good restaurant!!", "16/11/2018"));
        _foodComments.add(new FoodComment(27,1,"User 02", 45, "Comment", 3.1f, "Fantastic food again. My nephew is a vegan and he was really happy with his food too, specially the aubergine dish. We both had 2+1+1 dishes, My favourite was the gravad whitefish with tomatoes. And of course the wild mushroom risotto was delicious too.", "02/02/2019"));

        _foodComments.add(new FoodComment(28,2,"User 01", 9, "Comment", 4.0f, "We had lunch here a few times while on the island visiting family and friends. The servers here are just wonderful and have great memories it seems. We sat on the ocean front patio and enjoyed the view with our delicious wine and lunch. Must try!", "11/03/2018"));
        _foodComments.add(new FoodComment(29,2,"User 02", 10, "Comment", 2.0f, "Great!!", "12/05/2019"));
        _foodComments.add(new FoodComment(30,2,"User 02", 32, "Comment", 2.1f, "Good restaurant!!", "20/02/2020"));
        _foodComments.add(new FoodComment(31,2,"User 02", 33, "Comment", 3.2f, "Great!!", "16/02/2020"));
        _foodComments.add(new FoodComment(32,2,"User 03", 4, "Comment", 3.3f, "Rachel at the Pool (drinks server) was so gorgeous. We chatted with her all weekend and she played with the kids. She's an asset to the hotel esp for people with families. I saw other attendants playing with the kids too which is so welcoming. Rachel was gorgeous. Give her a raise!", "12/06/2019"));
        _foodComments.add(new FoodComment(33,2,"User 04", 5, "Comment", 3.9f, "The food was absolutely wonderful, from preparation to presentation, very pleasing. We especially enjoyed the special bar drinks, the cucumber/cilantro infused vodka martini and the K&P Aquarium was great (even took photos so we could try to replicate at home).", "12/01/2019"));
        _foodComments.add(new FoodComment(34,2,"User 05", 26, "Comment", 4.0f, "I've been to this restaurant about a 100 times, just because it ROCKS! Best food ever and service. Amanda loves.", "12/12/2019"));
        _foodComments.add(new FoodComment(35,2,"User 02", 27, "Comment", 3.0f, "I had lunch with some of my colleagues at Echo on Day 1. I had the wedge salad - it was delicious. On Night 2, I enjoyed a drink at the bar. I had a Margarita. The service was excellent", "13/01/2020"));
        _foodComments.add(new FoodComment(36,2,"User 01", 46, "Comment", 4.0f, "Had dinner with girl friends. Menu is perfect, something for everyone. Service was awesome and Jason was very accommodating. Will be back definitely!", "12/03/2019"));
        _foodComments.add(new FoodComment(37,2,"User 02", 47, "Comment", 3.2f, "Great!!", "12/11/2019"));

        _foodComments.add(new FoodComment(38,3,"User 01", 11, "Comment", 0.1f, "Good restaurant!!", "15/10/2019"));
        _foodComments.add(new FoodComment(39,3,"User 02", 12, "Comment", 2.4f, "My only (dining) experience was ordering a pizza at 9:15pm. Tanner answered my telephone call to inquire about the time of service and the pizza options. He took a lot of time discussing details with me and even went over the menu - assuring me that I would have my pizza by the time the kitchen closed at 10pm. At 9:45 the pizza was delivered PIPING HOT as if I were sitting in a restaurant. It was delicious and exactly what I ordered.", "05/04/2018"));
        _foodComments.add(new FoodComment(40,3,"User 02", 34, "Comment", 2.4f, "Good restaurant!!", "16/10/2019"));
        _foodComments.add(new FoodComment(41,3,"User 02", 35, "Comment", 4.4f, "Excellent!", "04/06/2018"));
        _foodComments.add(new FoodComment(42,3,"User 03", 6, "Comment", 3.7f, "The food was fresh, properly prepared and a great value for the price. We highly recommend it. The breakfast buffet on Sunday was equally as good.", "15/10/2019"));
        _foodComments.add(new FoodComment(43,3,"User 02", 7, "Comment", 3.4f, "Great!!", "04/05/2018"));
        _foodComments.add(new FoodComment(44,3,"User 04", 28, "Comment", 2.7f, "Reception and all service staff were very helpful and cordial. Our beachfront room on the third floor had a balcony and a great view of the pool area, the ocean, and sunrise- magnificent. Food in the tavern for dinner and breakfast was good. Especially liked the lowcountry shrimp and grits. They surprised my husband with a slice of chocolate cake with \"Happy Birthday\" written on the plate when we casually mentioned that it was his birthday!", "10/10/2019"));
        _foodComments.add(new FoodComment(45,3,"User 02", 29, "Comment", 1.3f, "The poolside common areas are great with chairs and umbrellas for free. Also the servers are ever present to provide whatever you like from their cafe menu. My wife is hard to cook for since she has to special order for low salt. The chef nailed it perfectly. That was memorable.", "04/08/2018"));
        _foodComments.add(new FoodComment(46,3,"User 05", 49, "Comment", 2.2f, "Good restaurant!!", "10/10/2019"));
        _foodComments.add(new FoodComment(47,3,"User 02", 50, "Comment", 1.1f, "Although we didn't go into the onsite restaurant, we ordered some food at the bar a few times and it was delicious. The bar area and lobby were nice and open, good place to relax and meet friends.", "04/04/2018"));

        _foodComments.add(new FoodComment(48,4,"User 01", 13, "Comment", 0.1f, "All the good reviews that I have read about this property are true. The friendliness of the staff seems genuine. I have never seen such good customer service as I experienced poolside.", "21/03/2019"));
        _foodComments.add(new FoodComment(49,4,"User 02", 14, "Comment", 1.0f, "Had a terrific dinner (Thanksgiving Buffet) today at the King and Prince with good food, wonderful service.", "17/07/2019"));
        _foodComments.add(new FoodComment(50,4,"User 02", 36, "Comment", 2.1f, "Good restaurant!!", "21/03/2019"));
        _foodComments.add(new FoodComment(51,4,"User 02", 37, "Comment", 1.2f, "The breakfast brunch was great. We went at 10:45 and everything was still hot and there was plenty of everything. Our server was very friendly and took good care of us. We enjoyed sitting at the pool and enjoying cocktails. We also loved walking on the beach.", "18/04/2019"));
        _foodComments.add(new FoodComment(52,4,"User 03", 8, "Comment", 3.1f, "Everything brought to us through room service was impeccable. We were celebrating a birthday, and several unique requests that were all satisfied perfectly.", "21/03/2019"));
        _foodComments.add(new FoodComment(53,4,"User 02", 9, "Comment", 4.1f, "Great!!", "12/08/2019"));
        _foodComments.add(new FoodComment(54,4,"User 04", 30, "Comment", 2.1f, "Wait staff were extremely friendly and helpful. Delicious meals!", "21/03/2019"));
        _foodComments.add(new FoodComment(55,4,"User 02", 31, "Comment", 1.4f, "It was beautiful-peaceful and relaxing. Staff was outstanding. The restaurant was exceptional along with the hosts and servers.", "19/04/2019"));
        _foodComments.add(new FoodComment(56,4,"User 05", 4, "Comment", 2.5f, "Good restaurant!!", "21/03/2019"));
        _foodComments.add(new FoodComment(57,4,"User 02", 6, "Comment", 1.6f, "Service was very good and servers were kind, friendly and even offered to-go coffees in the morning for us to take back to our room.", "12/09/2019"));

        _foodComments.add(new FoodComment(58,5,"User 01", 15, "Comment", 0.5f, "Good restaurant!!", "01/02/2019"));
        _foodComments.add(new FoodComment(59,5,"User 02", 16, "Comment", 0.7f, "Great!!", "10/01/2018"));
        _foodComments.add(new FoodComment(60,5,"User 02", 38, "Comment", 0.5f, "We thoroughly enjoyed staying at the King and Prince. Everything was perfect. We dined in the restaurant at the hotel and it was delicious and the service was excellent. We played golf, went shopping downtown, rode the trolley and just enjoyed sightseeing on this beautiful island. Love it all and want to come back to visit soon.", "11/07/2019"));
        _foodComments.add(new FoodComment(61,5,"User 02", 39, "Comment", 0.1f, "Great!!", "10/11/2018"));
        _foodComments.add(new FoodComment(62,5,"User 03", 10, "Comment", 1.5f, "A very friendly welcoming place to spend a couple of nights.  All personnel were very well trained, accommodating and helpful (all done with a smile).  Everything was handled with efficiency and attention to every detail was given.  Food was delicious and the view was wonderful while dining. Thanks for doing such an outstanding job to make the stay so pleasurable. ", "01/04/2019"));
        _foodComments.add(new FoodComment(63,5,"User 02", 11, "Comment", 0.2f, "Simply, everything was perfect for the dinner with good friends! It was worth of waiting the table for a month.", "19/01/2018"));
        _foodComments.add(new FoodComment(64,5,"User 04", 32, "Comment", 0.3f, "We have had two meals here in two days.  Both were excellent.  Tonight was attentive and friendly.  Great job!", "21/02/2019"));
        _foodComments.add(new FoodComment(65,5,"User 02", 33, "Comment", 4.7f, "A nice unique place i would say for Helsinki, great vibe and decor is sublime. Food and service top notch.", "10/11/2018"));
        _foodComments.add(new FoodComment(66,5,"User 05", 6, "Comment", 4.5f, "Simply, everything was perfect for the dinner with good friends! It was worth of waiting the table for a month.", "11/02/2019"));
        _foodComments.add(new FoodComment(67,5,"User 02", 45, "Comment", 0.7f, "Anniversary/birthday weekend, room was beautiful and very clean. Request for top floor and king bed was fulfilled. Brunch was outstanding loved it loved it loved it", "11/01/2018"));

        _foodComments.add(new FoodComment(68,6,"User 01", 17, "Comment", 3.3f, "Delicious food; great service!!! The €45 fixed price dinner was great value. Between two of us that meant we got to try 4 of the starters, both pasta dishes and 2 of the three mains (the lamb was incredible!)", "17/06/2019"));
        _foodComments.add(new FoodComment(69,6,"User 02", 18, "Comment", 1.1f, "Great!!", "11/05/2019"));
        _foodComments.add(new FoodComment(70,6,"User 02", 40, "Comment", 3.0f, "It was an amazing experience. The whole atmosphere, the owner and the fabulous and smiling staff , the food and the open kitchen. Absolutely a wonderful place. Ceviche, risotto and polpo are the masterpiece. The choices of wines is stunning. I will come back for sure.", "13/06/2019"));
        _foodComments.add(new FoodComment(71,6,"User 02", 41, "Comment", 0.1f, "Love it! All is just fabulous. They do love what they're doing - you can see and feel it in everything ♡♡♡♡", "19/05/2019"));
        _foodComments.add(new FoodComment(72,6,"User 03", 12, "Comment", 1.3f, "I found amazing reviews for this restaurant. The menu looked delicious and I loved the option of a la carte and a prefix meal. I emailed a month early and provided 3 nights for reservations - and they were already booked! Fortunately they have a coffee bar with 3 seats, so we arrived early and sat there.", "17/06/2019"));
        _foodComments.add(new FoodComment(73,6,"User 02", 13, "Comment", 2.1f, "Great!!", "11/09/2019"));
        _foodComments.add(new FoodComment(74,6,"User 04", 34, "Comment", 3.4f, "All works out Well once You get a table there. For friday evening is booked weeks ahead. Could try to speak in before normal dinner hours and get server at the Bar. Not easy to find the location.", "17/05/2019"));
        _foodComments.add(new FoodComment(75,6,"User 02", 35, "Comment", 4.1f, "Great!!", "14/04/2019"));
        _foodComments.add(new FoodComment(76,6,"User 05", 44, "Comment", 3.1f, "I ate at the bistro. Quality ingredients and very good tastes. Surprising wines. Service relaxed. I ate starter, risotto and dessert and this was enough food. :)", "17/06/2019"));
        _foodComments.add(new FoodComment(77,6,"User 02", 33, "Comment", 1.1f, "Great!!", "13/03/2019"));

        _foodComments.add(new FoodComment(78,7,"User 01", 19, "Comment", 0.5f, "Surprising combinations, superb service, good wines, the owner himself introduced us each portion. Absolutely worth visiting, high class food yet relaxed interior.Not the cheapest but food was well worth it.Place is a bit hard to find, you need to go inner yard and it's on the second floor. Book a table, it can be fully reserved for weeks ahead.", "12/12/2018"));
        _foodComments.add(new FoodComment(79,7,"User 02", 20, "Comment", 3.9f, "One of the best restaurants in Helsinki for the moment: great food, attentive service, relaxed atmosphere and really cute vintage chubby chic plates. But damn it's difficult to get a table there, especially if you want to eat dinner at the end of the week! But still worth it!", "13/11/2019"));
        _foodComments.add(new FoodComment(80,7,"User 01", 42, "Comment", 4.5f, "A lot of unkindness from the lady seating and waiting on us, after enduring several minutes of such harshness including reprimand and mocking comment, we gave up our hopes for a nice evening here and left before suffering more.", "12/08/2018"));
        _foodComments.add(new FoodComment(81,7,"User 02", 45, "Comment", 3.3f, "Great!!", "13/03/2019"));
        _foodComments.add(new FoodComment(82,7,"User 01", 14, "Comment", 0.5f, "The location is very attractive and the atmosphere even in crowded restaurant is easygoing and pleasant. Service is nice and food is tasty well prepared and especially the fish is good. Blueberry desert is good.", "12/02/2018"));
        _foodComments.add(new FoodComment(83,7,"User 02", 15, "Comment", 3.6f, "Came to have lunch, but was turned away because there is a group we need to get to the Airport - no new guests before 4pm. If you face this situation, go across the Street to Juttutupa. Second time its happended to me!", "13/01/2019"));
        _foodComments.add(new FoodComment(84,7,"User 01", 36, "Comment", 1.5f, "Good restaurant!!", "12/01/2018"));
        _foodComments.add(new FoodComment(85,7,"User 02", 37, "Comment", 3.1f, "Great!!", "13/05/2019"));
        _foodComments.add(new FoodComment(86,7,"User 01", 7, "Comment", 2.5f, "Great atmosphere. The on-site team is really friendly and help us to organize activities and last minute group dinner. Food is amazing : fresh, well cooked and not so expensive for Helsinki.", "12/12/2018"));
        _foodComments.add(new FoodComment(87,7,"User 02", 8, "Comment", 3.7f, "Great!!", "13/06/2019"));

        _foodComments.add(new FoodComment(88,8,"User 01", 21, "Comment", 4.1f, "Tasting menu (6) tried. Worth to choose. Variety of nice portions \"separated\" by small bites. Interesting description of all the ingrediens performed by waiter. Vine tasting menu will be tried next time :)", "01/02/2019"));
        _foodComments.add(new FoodComment(89,8,"User 02", 22, "Comment", 2.2f, "We're so glad we made a reservation for SPIS. Independence Day evening in Finland could not have been better. The food, the service, the cost atmosphere all added up to a wonderful evening. Such interesting flavors and combination of ingredients in each dish. Wines were perfectly matched too", "01/01/2019"));
        _foodComments.add(new FoodComment(90,8,"User 02", 46, "Comment", 3.1f, "Good restaurant!!", "01/03/2019"));
        _foodComments.add(new FoodComment(91,8,"User 02", 47, "Comment", 2.3f, "Had an excellent evening at Spis. Food was imaginative and delicious and the wine pairings interesting. The service was welcoming, knowledgeable and friendly. An absolutely brilliant find!", "01/09/2019"));
        _foodComments.add(new FoodComment(92,8,"User 03", 16, "Comment", 1.1f, "Great food, great wine, mostly great wine that was paired perfectly. Not a cheap place, but definitely an experience if you want to splurge. Only thing I would recommend is turning up the heat a bit when there are few customers and also turn down the lighting a little. Would recommend!", "01/10/2019"));
        _foodComments.add(new FoodComment(93,8,"User 02", 17, "Comment", 2.1f, "Great!!", "01/11/2019"));
        _foodComments.add(new FoodComment(94,8,"User 04", 38, "Comment", 0.1f, "Local produce in combination with expertly paired wines. Nice presentation and service, very knowledgeable staff. Overall, would recommend!", "27/02/2019"));
        _foodComments.add(new FoodComment(95,8,"User 02", 39, "Comment", 0.2f, "Great!!", "28/01/2019"));
        _foodComments.add(new FoodComment(96,8,"User 05", 25, "Comment", 4.0f, "Good restaurant!!", "29/02/2019"));
        _foodComments.add(new FoodComment(97,8,"User 02", 40, "Comment", 2.3f, "Great food, great wine, mostly great wine that was paired perfectly. Not a cheap place, but definitely an experience if you want to splurge. Only thing I would recommend is turning up the heat a bit when there are few customers and also turn down the lighting a little. Would recommend!", "30/01/2019"));

        _foodComments.add(new FoodComment(98,9,"User 01", 23, "Comment", 2.0f, "This is a really good restaurant and the kitchen is flexible in terms of people who have special requests. Very cozy, small number of tables, great presentation, nice atmosphere and very good food.", "02/02/2019"));
        _foodComments.add(new FoodComment(99,9,"User 02", 24, "Comment", 0.1f, "My husband and I went for dinner tonight and we were overwhelmed with the quality of food, the service and the. ambience of the place. We were served a surprise menu and the ingredients were very fresh and the food was very nicely cooked. Everyone in the restaurant (there were 12 of us) was served the same food. I would not be surprised if they soon become a Michelin recommended restaurant. This is definitely one of our highlights in our short stay in Helsinki. The 2 cooks put their heart and soul in their cooking and we feel very honored to be part of the establishment tonight! You must reserve a table because the restaurant is very small.", "11/07/2018"));
        _foodComments.add(new FoodComment(100,9,"User 02", 48, "Comment", 2.1f, "Simple restaurant with amazing food and service, beautiful plating - and fuss free! Glad we managed to finish our many courses in 90 minutes. Highly recommended!", "08/02/2019"));
        _foodComments.add(new FoodComment(101,9,"User 02", 49, "Comment", 0.2f, "Great!!", "11/09/2018"));
        _foodComments.add(new FoodComment(102,9,"User 03", 18, "Comment", 3.0f, "Good restaurant!!", "01/02/2019"));
        _foodComments.add(new FoodComment(103,9,"User 02", 19, "Comment", 4.1f, "First of I just have to say wow just wow. This may have been one of the best meals I have eaten. The food here is absolutely amazing. I can't remember what I had but whatever I had I know it was really good.", "11/02/2018"));
        _foodComments.add(new FoodComment(104,9,"User 04", 40, "Comment", 2.5f, "Good restaurant!!", "04/02/2019"));
        _foodComments.add(new FoodComment(105,9,"User 02", 41, "Comment", 0.6f, "Niceee!", "13/07/2018"));
        _foodComments.add(new FoodComment(106,9,"User 05", 29, "Comment", 2.7f, "Good restaurant!!", "02/05/2019"));
        _foodComments.add(new FoodComment(107,9,"User 02", 10, "Comment", 0.8f, "Restaurant has excellent service and interesting concept. The dinner was tasty. I would like to thank stuff and cooks for great service and marvellous dinner. Definitely recommend this place", "11/06/2018"));


        _restaurantComments = new ArrayList<>();
        _restaurantComments.add(new RestaurantComment(1,0, "User 01", "Comment", 4.5f, "Good restaurant!!", "12/01/2020"));
        _restaurantComments.add(new RestaurantComment(2,0, "Andrey 26", "Comment", 3.5f, "Really decent and delicious food! Me and my husband really enjoyed our dinner: appetizers, main dishes and dessert. Definitely coming back again ;].", "22/05/2018"));
        _restaurantComments.add(new RestaurantComment(3,0, "Jack 11", "Comment", 2.5f, "Very friendly service with plenty of advice with dishes. Two couples ate some bread based starters and three main courses and we all were well Fed and satisfied afterwards:) We will definitely go back...", "24/01/2020"));
        _restaurantComments.add(new RestaurantComment(4,0, "User 09", "Comment", 1.5f, "There was so much food in the Supra sharing menu that we could not finish it. There were so so many different portions that everyone got satisfied even if they did not like everything. Khachapuri was to die for.", "28/01/2020"));
        _restaurantComments.add(new RestaurantComment(5,0, "Jason 31", "Comment", 4.7f, "An excellent set of Georgian food. Vegetable options are also very good. Friendly service. Worthy to come even further. Wines really good.", "12/03/2019"));
        _restaurantComments.add(new RestaurantComment(6,0, "Ben 98", "Comment", 4.9f, "Hope to see more of this kind of authentic restaurants in Espoo.", "19/03/2019"));
        _restaurantComments.add(new RestaurantComment(7,0, "Joe 34", "Comment", 2.3f, "A really authentic Georgian food, made at the restaurant, Georgian wines and coupled with a very friendly service. Highly recommended. But it is a small place, make sure to book a table", "12/01/2020"));
        _restaurantComments.add(new RestaurantComment(8,0, "User 54", "Comment", 1.6f, "Small Place, far from the center but worth the visit. Very tasty food and warm bread. Polite service and will deffinately visit again.", "08/07/2019"));
        _restaurantComments.add(new RestaurantComment(9,0, "Lucy 74", "Comment", 1.9f, "Excellent!!", "12/09/2019"));
        _restaurantComments.add(new RestaurantComment(10,0, "Danil 76", "Comment", 2.7f, "It is like we flew to Tbilisi for dinner. Delicious in every way, with very warm Georgian hospitality!", "12/03/2019"));

        _restaurantComments.add(new RestaurantComment(11,1, "Lucy 34", "Comment", 1.9f, "Excellent!!", "23/08/2019"));
        _restaurantComments.add(new RestaurantComment(12,1, "Lee 74", "Comment", 1.3f, "Good!!", "12/07/2019"));
        _restaurantComments.add(new RestaurantComment(13,1, "Long 02", "Comment", 2.9f, "Lovely caffe with great service, been here for a quick break straight after arriving from Petersburg, the girl in charge gave me some foodie tips and made me the perfect mocha", "12/03/2020"));
        _restaurantComments.add(new RestaurantComment(14,1, "Wei 09", "Comment", 5.0f, "very nice place. so relaxing coffee near the harbour, where you can have a break and listen good music", "22/04/2020"));
        _restaurantComments.add(new RestaurantComment(15,1, "Xiao 46", "Comment", 1.9f, "In a country where filtered stale coffee is served so often this is such a treat! High quality coffee, expensive but so is all coffee in Finland", "27/01/2018"));
        _restaurantComments.add(new RestaurantComment(16,1, "Ming 98", "Comment", 1.4f, "Excellent!!", "12/04/2019"));
        _restaurantComments.add(new RestaurantComment(17,1, "Machael 83", "Comment", 1.3f, "Freshly brewed coffee and a croissant worthy of Paris invited us in to this lovely cafe. It is convenient with friendly service.", "12/09/2019"));
        _restaurantComments.add(new RestaurantComment(18,1, "User 73", "Comment", 5.4f, "Organic coffee and teas. Lovely spot for breakfast or brunch with a good selection on offer. Also a little shop to stock up on related stuff", "19/09/2019"));
        _restaurantComments.add(new RestaurantComment(19,1, "User 57", "Comment", 6.1f, "Nice place!!", "12/01/2020"));
        _restaurantComments.add(new RestaurantComment(20,1, "User 98", "Comment", 8.1f, "Hidden gem in an old beaten down shopping mall backalley. Suberb friendly service, the food was really good and the Georgian wines matched the food perfectly. Warmest thank you & recommendations", "12/01/2020"));


        _restaurantComments.add(new RestaurantComment(21,2, "User 64", "Comment", 3.7f, " The café has a great view to the beautiful harbour and is located next to the cathedral. The food looks very tasty and the coffee taste good.", "12/01/2020"));
        _restaurantComments.add(new RestaurantComment(22,2, "User 94", "Comment", 1.5f, "Good Place!!", "13/01/2020"));
        _restaurantComments.add(new RestaurantComment(23,2, "User 34", "Comment", 1.4f, "Nice experience!!", "14/01/2020"));
        _restaurantComments.add(new RestaurantComment(24,2, "User 67", "Comment", 2.8f, " This waterside cafe serves extraordinary coffee. Its reputation is well earned and richly deserved. The cinnamon buns are tasty too", "15/01/2020"));
        _restaurantComments.add(new RestaurantComment(25,2, "User 98", "Comment", 4.9f, " he staff spoke good English and the view was nice from the ground floor. Had some very nice tea and a water fountain which was good for filling our bottles in the hot weather", "16/01/2020"));
        _restaurantComments.add(new RestaurantComment(26,2, "User 83", "Comment", 1.9f, "Excellent!!", "17/01/2020"));
        _restaurantComments.add(new RestaurantComment(27,2, "User 24", "Comment", 1.9f, "Excellent!!", "18/01/2020"));
        _restaurantComments.add(new RestaurantComment(28,2, "User 74", "Comment", 1.8f, " My favourite place. Beautiful location and great service. Plus great interior design. One of the best coffee shops in Helsinki. Try hand-brew!", "19/01/2020"));
        _restaurantComments.add(new RestaurantComment(29,2, "Jack 11", "Comment", 1.9f, " Nice informal Café at the pier - some seats outside. Really good coffee and some snacks - only had coffee and a cinnamon bun.. Sandwiches and salads looked good. Great for a quick stopover with a view to the boats!", "20/01/2020"));
        _restaurantComments.add(new RestaurantComment(30,2, "Lucy 19", "Comment", 1.7f, " e were nearby and so much needed a real coffee. It is cozy place by the water. It was sunny chilly day and we sat outside. We had coffee, tea and cinnamon bun. Everything was delicious! Staff- nice and willing to help!", "21/01/2020"));

        _restaurantComments.add(new RestaurantComment(31,3, "User 34", "Comment", 0.9f, "Excellent!!", "21/08/2019"));
        _restaurantComments.add(new RestaurantComment(32,3, "User 34", "Comment", 1.9f, "This place has everything, the best coffee, airy space, treats and the location. Regularly visiting!", "03/08/2019"));
        _restaurantComments.add(new RestaurantComment(33,3, "User 34", "Comment", 2.9f, "Excellent!!", "02/08/2019"));
        _restaurantComments.add(new RestaurantComment(34,3, "User 34", "Comment", 3.9f, "Really good cafe at the airport!!! I've tasted hand brew from Ethiopia Guji. Now it's my favorite coffee beans! Thank you!", "01/08/2019"));
        _restaurantComments.add(new RestaurantComment(35,3, "User 34", "Comment", 4.9f, "Excellent!!", "11/08/2019"));
        _restaurantComments.add(new RestaurantComment(36,3, "User 34", "Comment", 1.8f, "Smoked tastes, 70s Finnish fine dining, raindeer, potatoes, cranberries and lingonberries. If you are into that, then OK. fantastic meat, lovely service. not really the taste And finess standards of the 2020s. Good place to bring tourists.", "10/08/2019"));
        _restaurantComments.add(new RestaurantComment(37,3, "User 34", "Comment", 1.7f, "Good!!", "20/08/2019"));
        _restaurantComments.add(new RestaurantComment(38,3, "User 34", "Comment", 1.6f, "Great space, attentive staff. The Food was amazing and I love the open kitchen View. It's a rare sight in Helsinki and I enjoyed it. The food was authentic and Nordic.", "21/08/2019"));
        _restaurantComments.add(new RestaurantComment(39,3, "User 34", "Comment", 1.5f, "Came for a coffee and small bit after a Sunday afternoon stroll. Ordered some coffee and feta pie. The coffee was awful and pie cold... not coming back.", "22/08/2019"));
        _restaurantComments.add(new RestaurantComment(40,3, "User 34", "Comment", 1.4f, "Yes the shop in town is cosy and nice.... but the café at the airport is a joke. Soggy old bread for an 8eur sandwich, tasteless pain au chocolat. Thank you for the free coffee refill though,", "23/08/2019"));


        _restaurantComments.add(new RestaurantComment(41,4, "User 14", "Comment", 0.9f, "Excellent!!", "11/08/2019"));
        _restaurantComments.add(new RestaurantComment(42,4, "User 15", "Comment", 0.8f, "Niceee!!", "20/08/2019"));
        _restaurantComments.add(new RestaurantComment(43,4, "User 16", "Comment", 0.7f, "Good!!", "21/02/2019"));
        _restaurantComments.add(new RestaurantComment(44,4, "User 17", "Comment", 1.9f, "Excellent!!", "21/01/2019"));
        _restaurantComments.add(new RestaurantComment(45,4, "User 18", "Comment", 2.7f, "We had the set meal that comprises 7 dishes. From appetiser to desserts. We also brought a bottle of Barbaresco red wine. The diner is 69 euro per head. Overall we had a wonderful time!", "21/04/2019"));
        _restaurantComments.add(new RestaurantComment(46,4, "User 19", "Comment", 0.6f, "Excellent food - all local produce from Finland, friendly and very knowledgeable staff, cosy atmosphere - perfect setting for a perfect evening!", "21/03/2019"));
        _restaurantComments.add(new RestaurantComment(47,4, "User 20", "Comment", 1.7f, "The interiors are special, the food is unique, the wine is very good and the staff is wonderful. They also have tasty vegetarian options - although I have appreciated fish-based dishes the most. Ideal for a formal dinner, in my opinion.", "21/05/2019"));
        _restaurantComments.add(new RestaurantComment(48,4, "User 21", "Comment", 2.3f, "If one is willing to spend to have a great, fine dining experience, this would be a place to go to in Helsinki. Very involved server and creative dishes", "21/06/2019"));
        _restaurantComments.add(new RestaurantComment(49,4, "User 22", "Comment", 3.6f, "Nice experience and good local food. I recommend you visit. a little expensive but wonderful place and good service.", "21/07/2019"));
        _restaurantComments.add(new RestaurantComment(50,4, "User 23", "Comment", 3.4f, "Fantastic worth a star! Perfect balanced meny, exciting tastes and good service. Very good winelist.", "21/08/2019"));

        _restaurantComments.add(new RestaurantComment(51,5, "User 25", "Comment", 1.2f, "Lovely place. The food is so fresh, green and pure.", "21/11/2019"));
        _restaurantComments.add(new RestaurantComment(52,5, "User 35", "Comment", 1.3f, "Good, but not cheap", "20/11/2019"));
        _restaurantComments.add(new RestaurantComment(53,5, "User 57", "Comment", 1.4f, "Excellent food & out standing service. Can really recommend", "19/11/2019"));
        _restaurantComments.add(new RestaurantComment(54,5, "User 85", "Comment", 1.5f, "Excellent!!", "18/11/2019"));
        _restaurantComments.add(new RestaurantComment(55,5, "User 59", "Comment", 1.6f, "Nice and classy, but something's missing", "17/11/2019"));
        _restaurantComments.add(new RestaurantComment(56,5, "User 05", "Comment", 1.7f, "Really good Finnish food made from very nice ingredients!", "16/11/2019"));
        _restaurantComments.add(new RestaurantComment(57,5, "User 51", "Comment", 1.8f, "Awesome!!", "15/11/2019"));
        _restaurantComments.add(new RestaurantComment(58,5, "User 25", "Comment", 1.9f, "Great!!", "14/11/2019"));
        _restaurantComments.add(new RestaurantComment(59,5, "User 53", "Comment", 2.2f, "Good!!", "13/11/2019"));
        _restaurantComments.add(new RestaurantComment(60,5, "User 54", "Comment", 2.3f, "Excellent!!", "12/11/2019"));


        _restaurantComments.add(new RestaurantComment(61,6, "User 13", "Comment", 2.8f, "Decent food, but overpriced, pretty poor service for this type of restaurant. ", "12/12/2019"));
        _restaurantComments.add(new RestaurantComment(62,6, "User 22", "Comment", 2.7f, "Good place to go - expensive - stylish - recommendable.", "22/12/2019"));
        _restaurantComments.add(new RestaurantComment(63,6, "User 55", "Comment", 2.6f, "Awesome!!", "02/11/2019"));
        _restaurantComments.add(new RestaurantComment(64,6, "User 66", "Comment", 2.5f, "Awesome!!", "02/10/2019"));
        _restaurantComments.add(new RestaurantComment(65,6, "User 99", "Comment", 2.4f, "nice interiör but they charge too much for water bottle even if you drink wine there", "02/04/2019"));
        _restaurantComments.add(new RestaurantComment(66,6, "User 44", "Comment", 2.3f, "Awesome!!", "02/06/2019"));
        _restaurantComments.add(new RestaurantComment(67,6, "User 17", "Comment", 2.2f, "it was nothing special. if you try an more expensive restaurant with a great reputation you expect more than an \"okay-meal\"", "02/09/2019"));
        _restaurantComments.add(new RestaurantComment(68,6, "User 31", "Comment", 2.1f, "fantastic. Great ingredients, cooked in a simple yet very modern way, with the idea in mind to reveal the best of those great products. ", "02/22/2019"));
        _restaurantComments.add(new RestaurantComment(69,6, "User 41", "Comment", 1.8f, "On of my favorites, especially for business lunches", "01/12/2019"));
        _restaurantComments.add(new RestaurantComment(70,6, "User 97", "Comment", 0.8f, "Awesome!!", "02/10/2019"));

        _restaurantComments.add(new RestaurantComment(71,7, "User 32", "Comment", 0.8f, "Nice experience every time. Quality ingredients and proficient service, excellent place to bring your customers. In summertime terrace is located on the waterfront.", "11/09/2019"));
        _restaurantComments.add(new RestaurantComment(72,7, "User 31", "Comment", 0.9f, "Went here with work and was a pleasant surprise. Well adjusted portions and kitchen has a very nice eye for detail and quality. Tried the reindeer which was very tender and tasty. Setting next to the see and cousy interior. Waitors were well informed about what they were serving and always added the extra attention to feel appreciated as customer. Ad digestive they offered the black berry wine that tastes almost like sherry wine. Will be back on one of my next trips to helsinki", "29/09/2019"));
        _restaurantComments.add(new RestaurantComment(73,7, "User 30", "Comment", 0.2f, "Awesome!!", "30/09/2019"));
        _restaurantComments.add(new RestaurantComment(74,7, "User 92", "Comment", 0.1f, "We had nice dinner in summertime at Nokka. Try their beatifull terrace, but notice that they have only 5 tables outside!", "11/09/2019"));
        _restaurantComments.add(new RestaurantComment(75,7, "User 82", "Comment", 0.2f, "The restaurant is in an old warehouse, sort of Scandinavian minimalistic style indoor, but has still warm atmosphere. The food is absolutely great; as fresh as it can be. They buy their fish from a local fisherman who brings it by boat directly to the pier next to the restaurant entrance. The only minus I can imagine is the price; but I suppose it's still better value than the most in this category", "20/09/2019"));
        _restaurantComments.add(new RestaurantComment(76,7, "User 72", "Comment", 4.3f, "Awesome!!", "11/06/2019"));
        _restaurantComments.add(new RestaurantComment(77,7, "User 62", "Comment", 3.3f, "The title says it all. On the other hand, it's situated in the heart of Helsinki, near the Uspensky Cathedral and the Marketplace. That's a plus.", "11/07/2019"));
        _restaurantComments.add(new RestaurantComment(78,7, "User 52", "Comment", 2.3f, "We were taken there by some Finnish friends - she's American. Located in a converted building, with an open kitchen, Nokka takes its food very seriously. Every course is explained. I had a multi-course meal with a variety of tastes, all interesting", "11/08/2019"));
        _restaurantComments.add(new RestaurantComment(79,7, "User 42", "Comment", 1.3f, "Great wine list, Solid Food. Pricey. Its a good place to go for special occasion. its right on the sea, but doesn't have a view.", "13/09/2019"));
        _restaurantComments.add(new RestaurantComment(80,7, "User 22", "Comment", 0.3f, "Awesome!!", "12/09/2019"));


        _restaurantComments.add(new RestaurantComment(81,8,"User 3", "Comment", 3.6f, "We ordered full Independence day menu with all suggested wines. Food was super, if I had skipped something, it would be cheese plate. Excellent service, really nice staff! Wines were chosen with excellent taste! It was not hard to pay for it!", "21/01/2019"));
        _restaurantComments.add(new RestaurantComment(82,8,"User 43", "Comment", 4.6f, "this is the place, where everything has to be perfect. very good food, perfect service, well vine card, and maybe litlle bit expencive...", "22/01/2019"));
        _restaurantComments.add(new RestaurantComment(83,8,"User 30", "Comment", 1.4f, "Like stated in the topic here, the restaurant is very atmospheric during dark evenings. Service and food are very good and also the wine list is pretty good. Will go again!", "23/01/2019"));
        _restaurantComments.add(new RestaurantComment(84,8,"User 45", "Comment", 1.2f, "Awesome!!", "24/01/2019"));
        _restaurantComments.add(new RestaurantComment(85,8,"User 65", "Comment", 2.6f, "One of the best restaurants in Helsinki, great food, great atmosphere, great service. Very good for romantic wining and dining", "25/01/2019"));
        _restaurantComments.add(new RestaurantComment(86,8,"User 7", "Comment", 1.3f, "Excellent atmosphere, close to the waterfront, food and wine pairings were outstanding, service was excellent, a must-see dinner every time I visit! The lead chef and cooking staff were amazing as well and were very proud to show their cooking talents in the kitchen!!", "26/01/2019"));
        _restaurantComments.add(new RestaurantComment(87,8,"User 67", "Comment", 3.6f, "On the quay just behind the Russian cathedral we came across Nokka - and liked everything about it. The interior, the outside seating and the food. And a very kind and helpful staff. All at reasonable prices - what more can you ask for?", "27/01/2019"));
        _restaurantComments.add(new RestaurantComment(88,8,"User 76", "Comment", 2.6f, "Awesome!!", "28/01/2019"));
        _restaurantComments.add(new RestaurantComment(89,8,"User 98", "Comment", 1.9f, "Helsinki menu and the wine menu were great. Service was a bit slow, maybe because the place was full, but otherwise good. Location is great and the decor is really nice.", "29/01/2019"));
        _restaurantComments.add(new RestaurantComment(90,8,"User 09", "Comment", 1.7f, "I am from Helsinki and this was the worst price/value restaurant that I have ever eaten in Helsinki. They offered us a set menu, 66 euros per person for the dishes and 44 euros for the wine per person. The starter was herring, literally taken from a glas jar and the main course was duck like in any Chinese restaurant. The wines were 10 cl per glass and common basic wines. One glass of white, red, currant and dessert. Really not worth the price. The bill ended up being 250 euros for two persons. Beware!!", "30/01/2019"));

        _restaurantComments.add(new RestaurantComment(91,9, "User 88", "Comment", 1.0f, "Was there with business associates, who we hadn;t seen in about 20 yrs...excellent choice of restaurant, interesting set menus designed for the season. Liked the small portions of multiple dishes...Would go back if ever in Helsinki again", "22/02/2019"));
        _restaurantComments.add(new RestaurantComment(92,9, "User 78", "Comment", 2.0f, "Brilliant service, the food was amazing (especially the fish and raw chocolate cake), and it was lovely sitting by the harbour. Definitely worth a trip", "14/02/2019"));
        _restaurantComments.add(new RestaurantComment(93,9, "User 86", "Comment", 3.0f, "Elegant casual, Nokka serves bio local products and has a very diverse menu that catered to most tastes. Service is very hospitable and friendly. The decor is conducive to a very dinner between friends or for business.", "30/02/2019"));
        _restaurantComments.add(new RestaurantComment(94,9, "User 58", "Comment", 4.0f, "Awesome!!", "19/02/2019"));
        _restaurantComments.add(new RestaurantComment(95,9, "User 48", "Comment", 5.0f, "This place has very good service and attention to details. I think the food was one of the best i had on my visit to helsinki, and i would recomend this place to any one. I will be back", "09/02/2019"));
        _restaurantComments.add(new RestaurantComment(96,9, "User 83", "Comment", 1.1f, "The day we went to this restaurant is was very cold and snowing and so when you enter the restaurant it had a lovely warm feeling. It is an old building and built of red brick ,so not sure if that old world charm and warm brick colour helped the mood. We where taken to our table by the window and so a lovely spot to see the snow fall on the harbour while we where all warm and snug inside. Staff are very helpful and friendly and walked us through the A la Carte menu or the set lunch menu. Both looked great but as this was a bit of a special occasion we had the A La carte menu. The food was AMAZING and I can honestly say that you will not be disappointed if you visit this fine establishment. Highly recommended.", "07/02/2019"));
        _restaurantComments.add(new RestaurantComment(97,9, "User 08", "Comment", 1.2f, "Awesome!!", "06/02/2019"));
        _restaurantComments.add(new RestaurantComment(98,9, "User 04", "Comment", 1.3f, "we had a group business dinner here recently and the food and service was excellent. A few of the dishes pushed my culinary comfort zone, but in a good way and no regrets! highly recommend the 9-course tasting menu w/ wine pairings (\"Helsinki Menu\").", "05/02/2019"));
        _restaurantComments.add(new RestaurantComment(99,9, "User 01", "Comment", 1.4f, "hat a wonderful restaurant! We went for the six-course tasting menu with wine pairing. It's a little expensive, but every dish - and every glass - was special. Seamless service, each element carefully explained and each pairing thoughtfully considered. Well worth a detour.", "04/02/2019"));
        _restaurantComments.add(new RestaurantComment(100,9, "User 15", "Comment", 1.5f, "I had a lovely dinner with a work colleague here, and my first taste of reindeer (I hope it wasn't Rudolf!). Lovely food, good wines, great service. Highly recommended!", "03/02/2019"));

    }

    /**
     * Gets all restaurants.
     *
     * @return the all restaurants
     */
    public List<Restaurant> getAllRestaurants() {
        return this._restaurants;
    }

    /**
     * Gets all restaurant comments.
     *
     * @return the all restaurant comments
     */
    public List<RestaurantComment> getAllRestaurantComments() {
        return _restaurantComments;
    }

    /**
     * Gets all foods.
     *
     * @return the all foods
     */
    public List<Food> getAllFoods() {
        return _foods;
    }

    /**
     * Gets all food comments.
     *
     * @return the all food comments
     */
    public List<FoodComment> getAllFoodComments() {
        return _foodComments;
    }

    /**
     * Gets all restaurant opening time.
     *
     * @return the all restaurant opening time
     */
    public List<OpeningTime> getAllRestaurantOpeningTime() {
        return _openingTimes;
    }

    /**
     * Gets all restaurant locations.
     *
     * @return the all restaurant locations
     */
    public List<RestaurantLocation> getAllRestaurantLocations() {
        return _restaurantLocations;
    }
}