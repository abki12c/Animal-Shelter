package gr.aueb.animalshelter.View.Adopter.AdopterSettings;

public class ManageProfileViewStub implements ManageProfileView{
    private boolean createAdRequest,manageProfile,viewHomePage,search,logout,cinfo;

    ManageProfileViewStub(){
        createAdRequest=manageProfile=viewHomePage=search=logout=cinfo=false;

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
    public void contactInfo() {
        cinfo=true;
    }

    @Override
    public void logout() {
        logout=true;
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
    public boolean isLogout() {
        return logout;
    }
    public boolean isCinfo() {
        return cinfo;
    }
}
