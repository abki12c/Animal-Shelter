package gr.aueb.animalshelter.View.Adopter.AdopterSettings;

public class ManageProfilePresenter {
    private ManageProfileView view;

    /**
     * Initializes Presenter.
     * @param view Instance of ManageProfileView
     */
    public ManageProfilePresenter(ManageProfileView view){
        this.view=view;
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
