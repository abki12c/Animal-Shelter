package gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest;

import java.util.List;

import gr.aueb.animalshelter.domain.Animal;

public interface AddAdoptionRequestView {

    /**
     * Getters
     */
    Animal getAnimal();

    String getCategory();
    String getLookingfor();
    String getLookingforType();


    public void setCategory(String s);
    public void setLookingFor(String s);

    public void setLookingForType(String s);



    /**
     * Goes to AnimalRequestInfoActivity
     * when the user clicks on an it,
     * @param a is the animal chosen.
     */

    void enterInfo(Animal a);

    /**
     * Goes to AnimalDetailsActivity
     * when the user clicks on an it,
     * @param a is the animal chosen.
     */
    void moreInfo(Animal a);

    /**
     * Loads list of animals
     * @param input the list.
     */
    void loadSource(List<Animal> input);
    /**
     * Loads list of animal types for the search bar
     * @param input the list.
     */
    void loadTypes(List<String> input);
    /**
     * Loads list of animal breeds for the search bar
     * @param input the list.
     */
    void loadBreeds(List<String> input);



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
    /**
     * When user clicks on search button on the menu
     * it loads the searchAnimalsActivity if not in activity already
     */

    void search();
}
