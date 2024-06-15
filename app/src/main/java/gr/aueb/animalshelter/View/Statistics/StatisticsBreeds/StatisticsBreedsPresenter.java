package gr.aueb.animalshelter.View.Statistics.StatisticsBreeds;

import java.util.List;

import gr.aueb.animalshelter.DAO.AnimalDao;
import gr.aueb.animalshelter.domain.Employee;

public class StatisticsBreedsPresenter {
    private StatisticsBreedsView view;
    private AnimalDao animals;

    public StatisticsBreedsPresenter(StatisticsBreedsView view,AnimalDao animals){
        this.view = view;
        this.animals = animals;
    }

    /**
     * Calculates the statistics of the breed for the specific
     * animal type
     */
    void updateStatistics(String animalType){
        String stats = Employee.statistics("animals-breed",animalType);
        view.getTextView().setText(stats);

    }

    /**
     * loads a list with the items that will be displayed in
     * the animal breeds search bar
     */
    void onLoadBarBreeds()
    {
        List<String> animalsList =animals.getTypes();
        view.loadBreeds(animalsList);

    }

    /**
     * To go to Home Page
     */
    void onViewHomePage(){
        view.viewHomePage();
    }
    /**
     * Go to manageSettings activity
     */
    void onManageSettings(){
        view.manageSettings();
    }

    /**
     * Go to manageStatistics activity
     */
    void onManageStatistics(){
        view.manageStatistics();
    }

    /**
     * Go to manageObligations activity
     */
    void onManageObligations(){
        view.manageObligations();
    }

    /**
     * Go to manageAnimals activity
     */
    void onManageAnimals(){
        view.manageAnimals();
    }
}
