package gr.aueb.animalshelter.View.Statistics.ManageStatistics;

public class ManageStatisticsPresenter {

    private ManageStatisticsView view;

    public ManageStatisticsPresenter(ManageStatisticsView view){
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
