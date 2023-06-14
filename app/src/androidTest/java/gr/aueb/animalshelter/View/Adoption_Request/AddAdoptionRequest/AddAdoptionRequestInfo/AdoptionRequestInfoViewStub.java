package gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest.AddAdoptionRequestInfo;

import android.widget.EditText;

import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest.AdoptionRequestInfo.AdoptionRequestInfoView;

public class AdoptionRequestInfoViewStub implements AdoptionRequestInfoView {
    private String finishMessage,errorMessage,errorTitle,name,surname,street,streetNo,tk,town,comments,phone,email;
    private int animalId;
    private boolean createAdRequest,manageProfile,viewHomePage,search;



    public AdoptionRequestInfoViewStub(){
        finishMessage=errorMessage=errorTitle=name=surname=street=streetNo=tk=town=comments=phone=email="";
        createAdRequest=manageProfile=viewHomePage=search=false;
    }



    @Override
    public void createAdoptionRequest() {
        createAdRequest = true;
    }

    @Override
    public void manageProfile() {
        manageProfile=true;
    }

    @Override
    public void viewHomePage() {
        viewHomePage=true;
    }

    @Override
    public void search() {
        search=true;
    }

    @Override
    public void showErrorMessage(String title, String s) {
        errorMessage=s;
        errorTitle=title;
    }

    @Override
    public void successfullyFinishActivity(String s) {
        finishMessage= s;
    }
    /**
     * getters
     */

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getStreetNumber() {
        return streetNo;
    }

    @Override
    public String getTK() {
        return tk;
    }

    @Override
    public String getTown() {
        return town;
    }

    @Override
    public String getComments() {
        return comments;
    }

    @Override
    public int getAnimalId() {
        return animalId;
    }

    public String getFinishMessage() {
        return finishMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorTitle() {
        return errorTitle;
    }

    /**
     * setters
     */



    public void setAnimalId(int id)
    {
        animalId=id;
    }

    public void setName(String s)
    {
        name=s;
    }

    public void setSurname(String s)
    {
        surname=s;
    }

    public void setEmail(String s)
    {
        email=s;
    }

    public void setPhone(String s)
    {
        phone=s;
    }

    public void setStreet(String s)
    {
        street=s;
    }

    public void setStreetNumber(String s)
    {
        streetNo=s;
    }

    public void setTK(String s)
    {
       tk=s;
    }

    public void setTown(String s)
    {
        town=s;
    }

    public void setComments(String s)
    {
        comments=s;
    }




    public boolean isCreateAdRequest() {
        return createAdRequest;
    }

    public boolean isManageProfile() {
        return manageProfile;
    }

    public boolean isViewHomePage() {
        return viewHomePage;
    }

    public boolean isSearch() {
        return search;
    }
}
