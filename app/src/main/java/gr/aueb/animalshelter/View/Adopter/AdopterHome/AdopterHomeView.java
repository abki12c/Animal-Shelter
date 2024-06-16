package gr.aueb.animalshelter.View.Adopter.AdopterHome;

public interface AdopterHomeView {
    /**
     * Displays random animal
     * chosen by the presenter
     * from animals in animalDao
     */
    void showAnimal(String name,String type,String breed,String age,String gender,String chipped,String description,String imageName);
    /**
     * When user clicks on Add Request button from the Home Page
     * it loads the AddAdoptionRequestActivity if not in activity already
     */
    void createAdoptionRequest();

    /**
     * When user clicks on profile button from the Home Page
     * it loads the manageProfileActivity if not in activity already
     */
    void manageProfile();

    /**
     * When user clicks on adoption requests button from the Home Page
     * it loads the manageAdoptionRequestsActivity if not in activity already
     */
    void viewHomePage();
}
