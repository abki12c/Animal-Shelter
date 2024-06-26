package gr.aueb.animalshelter.View.Animals.AnimalDetails;

public interface AnimalDetailsView {

    /**
     * Goes to AnimalRequestInfoActivity
     * when the user clicks on an it,
     * @param a is the animal chosen.
     */

    void enterInfo(int a);

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
     * When user clicks on Add Request button on the menu
     * it loads the AddAdoptionRequestActivity if not in activity already
     */
    void createAdoptionRequest();

    /**
     * When user clicks on profile button on the menu
     * it loads the manageProfileActivity if not in activity already
     */
    void manageProfile();

    /**
     * When user clicks on adoption requests button on the menu
     * it loads the manageAdoptionRequestsActivity if not in activity already
     */
    void viewHomePage();
}
