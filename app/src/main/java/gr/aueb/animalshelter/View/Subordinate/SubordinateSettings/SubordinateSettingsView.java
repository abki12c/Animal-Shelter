package gr.aueb.animalshelter.View.Subordinate.SubordinateSettings;

public interface SubordinateSettingsView {

    /**
     * When user clicks on adoption requests button on the menu
     * it loads the manageAdoptionRequestsActivity if not in activity already
     */
    void viewHomePage();

    /**
     * When user clicks on profile button on the menu
     * it loads the SubordinateSettingsActivity if not in activity already
     */
    void manageSettings();

    /**
     * When user clicks on search button on the menu
     * it loads the ManageAnimalsActivity if not in activity already
     */
    void manageAnimals();

    /**
     * When user clicks on search button on the menu
     * it loads the ManageAnimalsActivity if not in activity already
     */

    void manageStatistics();


    /**
     * When user clicks on search button on the menu
     * it loads the ManageObligations if not in activity already
     */
    void manageObligations();

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
