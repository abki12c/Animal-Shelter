package gr.aueb.animalshelter.View.Adopter.AdopterHome;
import java.util.List;

import gr.aueb.animalshelter.DAO.AnimalDao;
import gr.aueb.animalshelter.domain.Animal;

public class AdopterHomePresenter {
    private AdopterHomeView view;
    AnimalDao animals;

    /**
     * Initializes Presenter.
     * @param view Instance of AdopterHomeView
     * @param animals Instance of AnimalDao
     */
    public AdopterHomePresenter(AdopterHomeView view, AnimalDao animals){
        this.view=view;
        this.animals=animals;
    }
    /**
     * Chooses a random animal
     * from AnimalDao and calls setters
     * to integrate it into the view
     */

    void onRandom(){
        List<Animal> a;
        a = animals.findAll();
        int randomInt = getRandomNumber(0,a.size());
        int animalId = a.get(randomInt).getId();
        Animal lucky = animals.find(animalId);
        String age = lucky.getAge()+"";
        String chipped = lucky.getChipped() ? "yes" : "no";
        view.showAnimal(lucky.getName(), lucky.getType(),lucky.getBreed(),age, lucky.getGender(),chipped, lucky.getDescription(),lucky.getImageName());
    }
    /**
     * produces random number for
     * onRandom() method
     */
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
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
