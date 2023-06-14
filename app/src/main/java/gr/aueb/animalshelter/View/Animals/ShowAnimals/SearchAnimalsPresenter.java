package gr.aueb.animalshelter.View.Animals.ShowAnimals;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.animalshelter.DAO.AnimalDao;
import gr.aueb.animalshelter.domain.Animal;

public class SearchAnimalsPresenter {
    private AnimalDao animals;
    private SearchAnimalsView view;
    private String category=null;
    private String lookingfor=null;

    /**
     * Initializes Presenter.
     * @param view Instance of SearchAnimalView
     * @param animals Instance of AnimalDao
     */
    public SearchAnimalsPresenter(SearchAnimalsView view, AnimalDao animals) {
        this.view = view;
        this.animals = animals;

    }
    /**
     * loads a list with the items that will be displayed in
     * the animal types search bar
     */
    void onLoadBarTypes()
    {
        List<String> toReturn;
        toReturn=animals.getTypes();
        view.loadTypes(toReturn);

    }
    /**
     * loads a list with the items that will be displayed in
     * the animal breeds search bar
     */
    void onLoadBarBreeds()
    {
        List<String> toReturn;
        toReturn=animals.getBreeds();
        view.loadBreeds(toReturn);

    }
    /**
     * loads a list with the items that will be displayed in the grid
     */
    void onLoadSource()
    {
        List<Animal> toReturn=null;
        category = view.getCategory();
        lookingfor = view.getLookingfor();

        if(lookingfor=="All"&& category!="Breed"){
            toReturn = new ArrayList<>(animals.findAll());
            view.loadBreeds(animals.getBreeds());
        } else if (category=="Breed" && lookingfor!="All"){

            toReturn = new ArrayList<>(animals.find("Breed", lookingfor));

        } else if (category=="Type"&& lookingfor!="All") {
            toReturn = new ArrayList<>(animals.find("Type", lookingfor));
            view.loadBreeds(animals.findBreeds(lookingfor));
        } else if (lookingfor=="All") {
            if(view.getLookingforType()!="All")
                toReturn = new ArrayList<>(animals.find("Type", view.getLookingforType()));
            else {
                toReturn = new ArrayList<>(animals.findAll());
                view.loadBreeds(animals.getBreeds());
            }
        }

        view.loadSource(toReturn);

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
