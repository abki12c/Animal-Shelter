package gr.aueb.animalshelter.View.Adopter.AdopterSettings.ContactInfo;

public class ContactInfoViewStub implements ContactInfoView{
    private boolean createAdRequest,manageProfile,viewHomePage,search;
    ContactInfoViewStub(){
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
