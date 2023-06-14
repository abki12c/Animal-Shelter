package gr.aueb.animalshelter.View.Animals.AnimalDetails;

public class AnimalDetailsViewStub implements AnimalDetailsView{
    private boolean createAdRequest,manageProfile,viewHomePage,search;
    private String name,type,breed,age,gender,chipped,description;
    private int animalId;
    AnimalDetailsViewStub(){
        createAdRequest=manageProfile=viewHomePage=false;
        name=type=breed=age=gender=chipped=description="";
        animalId=-1;
    }
    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void setType(String type) {
        this.type=type;
    }

    @Override
    public void setBreed(String breed) {
        this.breed=breed;
    }

    @Override
    public void setAge(String age) {
        this.age=age;
    }

    @Override
    public void setGender(String gender) {
        this.gender=gender;
    }

    @Override
    public void setChipped(String chipped) {
        this.chipped=chipped;
    }

    @Override
    public void setDescription(String description) {
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

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getAge() {
        return age;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getChipped() {
        return chipped;
    }

    @Override
    public String getDescription() {
        return description;
    }


}
