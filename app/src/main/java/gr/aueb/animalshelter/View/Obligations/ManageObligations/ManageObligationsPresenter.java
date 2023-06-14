package gr.aueb.animalshelter.View.Obligations.ManageObligations;

public class ManageObligationsPresenter {

        private ManageObligationsView view;

    public ManageObligationsPresenter(ManageObligationsView view){
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
