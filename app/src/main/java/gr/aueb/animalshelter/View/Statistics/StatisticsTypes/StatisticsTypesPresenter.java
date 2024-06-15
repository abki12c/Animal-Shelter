package gr.aueb.animalshelter.View.Statistics.StatisticsTypes;

public class StatisticsTypesPresenter {
    private StatisticsTypesView view;

    public StatisticsTypesPresenter(StatisticsTypesView view){
        this.view = view;
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
