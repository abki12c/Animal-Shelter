package gr.aueb.animalshelter.View.Adopter.AdopterSettings.ContactInfo;

public interface ContactInfoView {

    /**
     * When user clicks on Add Request button on the menu
     * it loads the AddAdoptionRequestActivity if not in activity already
     */
    void createAdoptionRequest();

    /**
     * When user clicks on profile button on the menu
     * it loads the manageProfileActivity if not in activity already
     */
    void manageProfile();

    /**
     * When user clicks on adoption requests button on the menu
     * it loads the manageAdoptionRequestsActivity if not in activity already
     */
    void viewHomePage();
    /**
     * When user clicks on search button on the menu
     * it loads the searchAnimalsActivity if not in activity already
     */

    void search();
}
