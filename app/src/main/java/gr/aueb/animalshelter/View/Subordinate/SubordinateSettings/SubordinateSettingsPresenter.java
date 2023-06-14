package gr.aueb.animalshelter.View.Subordinate.SubordinateSettings;

public class SubordinateSettingsPresenter {

    private SubordinateSettingsView view;

    /**
     * Initializes Presenter.
     * @param view Instance of SubordinateSettingsView
     */
    public SubordinateSettingsPresenter(SubordinateSettingsView view){
        this.view=view;
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
    void onContactInfo(){
        view.contactInfo();
    }
    /**
     * logs user out,goes to login page
     */
    void onLogout(){
        view.logout();
    }
}
