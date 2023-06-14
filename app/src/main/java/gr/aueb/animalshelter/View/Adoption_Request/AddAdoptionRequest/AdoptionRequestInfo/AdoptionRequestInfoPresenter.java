package gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest.AdoptionRequestInfo;

import gr.aueb.animalshelter.DAO.AdoptionRequestDao;
import gr.aueb.animalshelter.DAO.AnimalDao;
import gr.aueb.animalshelter.domain.Address;
import gr.aueb.animalshelter.domain.Adopter;
import gr.aueb.animalshelter.domain.AdoptionRequest;
import gr.aueb.animalshelter.domain.Animal;

public class AdoptionRequestInfoPresenter {

    private AdoptionRequestInfoView view;
    private AdoptionRequestDao requests;
    private AnimalDao animals;

    private Animal attachedAnimal;

    /**
     * Initializes Presenter.
     * @param view Instance of AdoptionRequestInfoView
     * @param requests Instance of AdoptionRequestDao
     * @param animals Instance of AnimalDao
     */

    public AdoptionRequestInfoPresenter(AdoptionRequestInfoView view, AdoptionRequestDao requests, AnimalDao animals) {
        this.view = view;
        this.requests=requests;
        this.animals=animals;

    }
    /**
     * To go to Adoption request Page
     */
    public void onCreateAdoptionRequest(){
        view.createAdoptionRequest();
    }
    /**
     * To go to Home Page
     */
    public void onViewHomePage(){
        view.viewHomePage();
    }
    /**
     * To go to Settings Page
     */
    public void onManageProfile(){
        view.manageProfile();
    }

    /**
     * To go to Search Animals Page
     */

   public void onSearch(){
        view.search();
    }
    /**
     * Saves the adoption request in the AdoptionRequestDao
     */
    public void onSaveAdoptionRequest()
    {

        attachedAnimal= animals.find(view.getAnimalId());

        int strNo=-1;
        int tk = -1;
        boolean acceptableInput=true;
        try{
            tk=Integer.parseInt(view.getTK());
            strNo=Integer.parseInt(view.getStreetNumber());

        }catch (NumberFormatException e){
            acceptableInput=false;
        }

        //checks for correct input
        if (view.getName().length() < 2)
            view.showErrorMessage("Error!","Please provide your full name.");
        else if (view.getSurname().length() < 2)
            view.showErrorMessage("Error!","Please provide your full last name.");
        else if (view.getTown().length()==0||view.getPhone().length()==0||view.getEmail().length()==0||view.getStreet().length()==0 )
            view.showErrorMessage("Error!","Please fill in all the fields.");
       else if(!acceptableInput)
            view.showErrorMessage("Error! ","Please make sure to enter only numbers in TK and Street Number fields.");
       else if (tk <0 )
            view.showErrorMessage("Error!", "Please provide valid zipcode.");
        else if (strNo <0 )
                view.showErrorMessage("Error!","Please provide valid street Number.");
        else if(view.getComments().length() < 2)
            view.showErrorMessage("Error!","Please provide a brief paragraph on why you would like to adopt this animal.");
        else{
            Address a = new Address(view.getStreet(),strNo, view.getTown(),tk);
            Adopter adopter = new Adopter(view.getName(), view.getSurname(), view.getEmail(), view.getPhone(),a );
            AdoptionRequest ar = new AdoptionRequest(adopter,attachedAnimal, view.getComments());

            requests.save(ar);
            view.successfullyFinishActivity("You have successfully submitted your adoption request!");

        }

    }
}
