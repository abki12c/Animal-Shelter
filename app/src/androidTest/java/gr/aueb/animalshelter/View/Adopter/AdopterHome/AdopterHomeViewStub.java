package gr.aueb.animalshelter.View.Adopter.AdopterHome;

public class AdopterHomeViewStub implements AdopterHomeView{
    private boolean createAdRequest,manageProfile,viewHomePage,search;
    private String name,type,breed,age,gender,chipped,description;

    public AdopterHomeViewStub(){
        createAdRequest=manageProfile=viewHomePage=search=false;
        name=type=breed=age=gender=chipped=description="";
    }
    @Override
    public void showAnimal(String name, String type, String breed, String age, String gender, String chipped, String description) {
        this.name=name;
        this.type=type;
        this.breed=breed;
        this.age=age;
        this.gender=gender;
        this.chipped=chipped;
        this.description=description;

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

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getChipped() {
        return chipped;
    }

    public void setChipped(String chipped) {
        this.chipped = chipped;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
