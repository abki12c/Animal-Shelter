package gr.aueb.animalshelter.View.Animals.AddEditAnimals;

import java.util.List;

import gr.aueb.animalshelter.domain.FeedingSchedule;

/** View for the addition and edit of an animal
 * @author Komnas Kafasis
 */

public interface AddEditAnimalsView {

    /**
     * Loads list of feeding schedules for the search bar
     * @param input the list.
     */
    void loadFeedingSchedules(List<String> input);
    /**
     * Returns the name of the animal
     * @return the name of the animal
     */
    String getName();
    /**
     * Returns the type of the animal
     * @return the type of the animal
     */
    String getType();
    /**
     * Returns the breed of the animal
     * @return the breed of the animal
     */
    String getBreed();
    /**
     * Returns the age of the animal
     * @return the age of the animal
     */
    Integer getAge();
    /**
     * Returns the chipped status of the animal
     * @return the chipped status of the animal
     */
    boolean getChipped();
    /**
     * Returns the description of the animal
     * @return the description of the animal
     */
    String getDescription();
    /**
     * Returns the gender of the animal
     * @return the gender of the animal
     */
    String getGender();
    /**
     * Returns the feeding schedule of the animal
     * @return the feeding schedule of the animal
     */

    FeedingSchedule getFeedingSchedule();

    /**
     * Returns the id of the animal
     * @return the id of the animal
     */
    Integer getAttachedAnimalID();

    /**
     * Sets the name of the animal.
     * @param name the name of the animal
     */
    public void setName(String name);

    /**
     * Sets the type of the animal.
     * @param type the type of the animal
     */
    public void setType(String type);

    /**
     * Sets the breed of the animal.
     * @param breed the type of the animal
     */
    public void setBreed(String breed);

    /**
     * Sets the age of the animal.
     * @param age the type of the animal
     */
    public void setAge(int age);
    /**
     * Sets the description for the animal.
     * @param description the type of the animal
     */
    public void setDescription(String description);
    /**
     * Sets the state of the animal's chipped status.
     * @param chipped the state of the animal's chipped status
     */
    public void setChipped(Boolean chipped);

    /**
     * Sets the gender of the animal.
     * @param gender the type of the animal
     */
    public void setGender(String gender);
    /**
     * Sets the feeding schedule of the animal.
     * @param feedingSchedule the type of the animal
     */
    public void setFeedingSchedule(FeedingSchedule feedingSchedule);

    /**
     * Sets the name of the page.
     * @param value the name of the page
     */
    void setPageName(String value);
    /**
     * The message that is shown when
     * an activity is finished successfully.
     * @param message the message that will be shown
     */
    void successfullyFinishActivity(String message);
    /**
     * The message that will be shown in case of an error
     * @param title the title of the message
     * @param message the content of the message
     */
    void showErrorMessage(String title, String message);
}