package gr.aueb.animalshelter.View.Animals.AnimalDetailsFromObligation;

public interface AnimalDetailsFromObligationView {

    /**
     * Setters
     */
    void setName(String name);

    void setType(String type);
    void setBreed(String breed);
    void setAge(String age);
    void setGender(String gender);
    void setChipped(String chipped);
    void setDescription(String description);
    void setImage(String image);

    void setAnimalId(int i);

    String getName();
    String getType();
    String getBreed();
    String getAge();
    String getGender();
    String getChipped();
    String getDescription();

    int getAnimalId();

    /**
     * When user clicks on adoption requests button on the menu
     * it loads the manageAdoptionRequestsActivity if not in activity already
     */
    void viewHomePage();

    /**
     * When user clicks on profile button on the menu
     * it loads the SubordinateSettingsActivity if not in activity already
     */
    void manageSettings();

    /**
     * When user clicks on search button on the menu
     * it loads the ManageAnimalsActivity if not in activity already
     */
    void manageAnimals();

    /**
     * When user clicks on search button on the menu
     * it loads the ManageAnimalsActivity if not in activity already
     */

    void manageStatistics();


    /**
     * When user clicks on search button on the menu
     * it loads the ManageObligations if not in activity already
     */
    void manageObligations();
}
