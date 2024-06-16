package gr.aueb.animalshelter.View.Adopter.AdopterSettings;

public interface ManageProfileView {

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
     * When user clicks on the contact info button
     * it loads the information page of the shelter
     */
    void contactInfo();

    /**
     * When user clicks on the logout button
     * it loads the login page
     */
    void logout();
}
