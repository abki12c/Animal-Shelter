package gr.aueb.animalshelter.View.Obligations.ObligationDetails;

public class ObligationDetailsPresenter {

        private ObligationDetailsView view;

    public ObligationDetailsPresenter(ObligationDetailsView view){
        this.view = view;
    }


    void onStartShowAnimal(int animalID){
        view.startShowAnimal(animalID);
    }

    void onFulfillObligation(int obligationID){

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
