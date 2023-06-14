package gr.aueb.animalshelter.View.Animals.ShowAnimals;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.animalshelter.domain.Animal;

public class SearchAnimalsViewStub implements SearchAnimalsView{
    private boolean createAdRequest,manageProfile,viewHomePage,search,info,choose;
    private List<String> types;
    private List<String> breeds;
    private List<Animal> animals;

    private Animal a;
    private String category,lookingfor,lookingforType;

    public SearchAnimalsViewStub(){
        types=new ArrayList<>();
        breeds=new ArrayList<>();
        animals=new ArrayList<Animal>();
        a=null;
        category=lookingfor=lookingforType="All";
        createAdRequest=manageProfile=viewHomePage=search=info=choose=false;
    }

    public int getTypesSize(){
        return types.size();
    }

    public int getBreedsSize(){
        return breeds.size();
    }

    public int getSourceSize(){
        return animals.size();
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getLookingfor() {
        return lookingfor;
    }

    @Override
    public String getLookingforType() {
        return lookingforType;
    }

    public void setCategory(String s){
        category=s;
    }

    public void setLookingFor(String s){
        lookingfor=s;
    }

    public void setLookingForType(String s){
        lookingforType=s;
    }






    @Override
    public void loadSource(List<Animal> input) {
        animals=input;
    }

    @Override
    public void loadTypes(List<String> input) {
        types=input;
    }

    @Override
    public void loadBreeds(List<String> input) {
        breeds=input;
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
