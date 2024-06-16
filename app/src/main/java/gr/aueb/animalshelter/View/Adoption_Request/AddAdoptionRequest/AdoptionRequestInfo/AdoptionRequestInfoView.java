package gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest.AdoptionRequestInfo;

public interface AdoptionRequestInfoView {
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
     * Message that shows in case of error
     * @param title The title of the error
     * @param s message content
     */
    void showErrorMessage(String title,String s);

    /**
     * Message that shows when the user
     * successfully submitted an adoption request
     * @param s The message
     */
    void successfullyFinishActivity(String s);
    /**
     * getters
     */

    String getName();
    String getSurname();
    String getEmail();
    String getPhone();
    String getStreet();
    String getStreetNumber();
    String getTK();
    String getTown();
    String getComments();
    int getAnimalId();
    /**
     * setters
     */
    void setAnimalId(int id);
    void setName(String s);

    void setSurname(String s);

    void setEmail(String s);
     void setPhone(String s);

     void setStreet(String s);

     void setStreetNumber(String s);

     void setTK(String s);

     void setTown(String s);

     void setComments(String s);


}
