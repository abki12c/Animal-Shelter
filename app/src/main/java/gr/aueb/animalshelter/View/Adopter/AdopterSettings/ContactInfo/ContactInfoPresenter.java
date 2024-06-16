package gr.aueb.animalshelter.View.Adopter.AdopterSettings.ContactInfo;

public class ContactInfoPresenter {

    private  ContactInfoView view;
    /**
     * Initializes presenter
     * @param view instance of ContactInfoView
     */
    public ContactInfoPresenter(ContactInfoView view)
    {
        this.view = view;
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

}
