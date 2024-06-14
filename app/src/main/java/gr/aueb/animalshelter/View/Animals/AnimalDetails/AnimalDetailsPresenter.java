package gr.aueb.animalshelter.View.Animals.AnimalDetails;

import gr.aueb.animalshelter.DAO.AnimalDao;
import gr.aueb.animalshelter.domain.Animal;

public class AnimalDetailsPresenter {
    AnimalDetailsView view;
    private AnimalDao animals;
    private Animal attachedAnimal;

    /**
     * Initializes Presenter.
     * @param view Instance of AnimalDetailsView
     * @param animals Instance of AnimalDao
     */
    public AnimalDetailsPresenter(AnimalDetailsView view, AnimalDao animals) {
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
     * To go to Adoption request Page
     */

    void onCreateAdoptionRequest(){
        view.createAdoptionRequest();
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
    void onManageProfile(){
        view.manageProfile();
    }

    /**
     * To go to Search Animals Page
     */
    void onSearch(){
        view.search();
    }
}
