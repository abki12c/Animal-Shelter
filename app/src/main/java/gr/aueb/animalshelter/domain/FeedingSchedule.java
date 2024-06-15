package gr.aueb.animalshelter.domain;

import androidx.annotation.NonNull;
import java.io.Serializable;

/** Class for the Feeding Schedule of an {@link Animal}.
 * Feeding Schedules can be create manually
 */
public class FeedingSchedule implements Serializable {

    private String name;
    private String type;
    private String breed;
    private String food;
    private String drink;
    private String foodAmount;
    private String hours;

    private final int feedingScheduleID;
    private static int lastFeedingScheduleID = 0;
    
    public FeedingSchedule(String name,String type, String breed, String food, String drink, String foodAmount, String hours){
        this.name = name;
        this.type=type;
        this.breed=breed;
        this.food=food;
        this.drink = drink;
        this.foodAmount=foodAmount;
        this.hours=hours;
        this.feedingScheduleID = NextFeedingScheduleID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(String foodAmount) {
        this.foodAmount = foodAmount;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public static int NextFeedingScheduleID() {
        return ++lastFeedingScheduleID;
    }

    public int getID() {
        return feedingScheduleID;
    }
    @NonNull
    public String toString() {
    	return "Type of Animal: "+getType()+"\n Breed: "+getBreed() +"\n Food brand: "+ getFood()+ "\n Food Amount: "+
                getFoodAmount()+"\n Drink: "+ getDrink() + "\n Hours: " + getHours();
    }
    
}
