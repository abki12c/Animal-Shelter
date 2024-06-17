package gr.aueb.animalshelter.View.Animals.AnimalDetailsFromObligation;

import gr.aueb.animalshelter.DAO.AnimalDao;
import gr.aueb.animalshelter.domain.Animal;

public class AnimalDetailsFromObligationPresenter {
    AnimalDetailsFromObligationView view;
    private AnimalDao animals;
    private Animal attachedAnimal;

    /**
     * Initializes Presenter.
     * @param view Instance of AnimalDetailsView
     * @param animals Instance of AnimalDao
     */
    public AnimalDetailsFromObligationPresenter(AnimalDetailsFromObligationView view, AnimalDao animals) {
        this.view = view;
        this.animals = animals;
    }

    /**
     * Sets animal information to be displayed
     * @param id The id of the animal
     */
    void onLoadAnimal(int id){

        attachedAnimal= animals.find(id);

        view.setName(attachedAnimal.getName());
        view.setType(attachedAnimal.getType());
        view.setBreed(attachedAnimal.getBreed());
        view.setAge(attachedAnimal.getAge()+"");
        view.setGender(attachedAnimal.getGender());
        view.setChipped((attachedAnimal.getChipped()) ? "yes" : "no");
        view.setDescription(attachedAnimal.getDescription());
        view.setImage(attachedAnimal.getImageName());
    }





    /**
     * To go to Home Page
     */
    void onViewHomePage(){
        view.viewHomePage();
    }
    /**
     * To go to Settings Page
     */
    void onManageSettings(){
        view.manageSettings();
    }


    /**
     * Go to manageObligations activity
     */
    void onManageObligations(){
        view.manageObligations();
    }

    /**
     * To go to the Animals Page
     */

    void onManageAnimals(){
        view.manageAnimals();
    }

    /**
     * To go to the Statistics Page
     */

    void onManageStatistics(){
        view.manageStatistics();
    }
    /**
     *loads the information page of the shelter
     */

}
