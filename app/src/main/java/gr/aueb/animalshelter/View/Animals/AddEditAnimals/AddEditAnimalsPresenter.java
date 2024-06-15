package gr.aueb.animalshelter.View.Animals.AddEditAnimals;

import java.util.List;
import gr.aueb.animalshelter.DAO.AnimalDao;
import gr.aueb.animalshelter.DAO.FeedingScheduleDao;
import gr.aueb.animalshelter.domain.Animal;
import gr.aueb.animalshelter.domain.FeedingSchedule;


/** Presenter for the addition and edit of an animal
 * @author Komnas Kafasis
 */
public class AddEditAnimalsPresenter {

    private AddEditAnimalsView view;
    private AnimalDao animals;
    private FeedingScheduleDao feedingSchedules;
    Animal attachedAnimal;

    public AddEditAnimalsPresenter(AddEditAnimalsView view, AnimalDao animals,FeedingScheduleDao feedingSchedules){
        this.view = view;
        this.animals = animals;
        this.feedingSchedules = feedingSchedules;

        Integer attachedAnimalID = view.getAttachedAnimalID();
        attachedAnimal = attachedAnimalID == null ? null : animals.find(attachedAnimalID);

        if(attachedAnimal != null)//edit mode
        {
            view.setPageName("Animal #" + attachedAnimal.getId());
            view.setName(attachedAnimal.getName());
            view.setType(attachedAnimal.getType());
            view.setAge(attachedAnimal.getAge());
            view.setBreed(attachedAnimal.getBreed());
            view.setGender(attachedAnimal.getGender());
            view.setDescription(attachedAnimal.getDescription());
            view.setChipped(attachedAnimal.getChipped());
            view.setFeedingSchedule(attachedAnimal.getFeedingSchedule());

        }

    }

    /**
     * loads a list with the items that will be displayed in
     * the feeding schedule search bar
     */
    void onLoadBarFeedingSchedules()
    {
        List<String> feedingSchedulesAllNames = feedingSchedules.findAllNamesPlusID();
        view.loadFeedingSchedules(feedingSchedulesAllNames);

    }

    public void onSaveAnimal(){
        String name = view.getName();
        String type = view.getType();
        String breed = view.getBreed();
        Integer age = view.getAge();
        String description = view.getDescription();
        Boolean chipped = view.getChipped();
        String gender = view.getGender();
        FeedingSchedule feedingSchedule = view.getFeedingSchedule();

        // check for correct input
        if(name.length()<2 || name.length()>15){
            view.showErrorMessage("Error","Name should have between 2 and 15 characters ");
        } else if (type.length()<2 || type.length()>15) {
            view.showErrorMessage("Error","Type should have between 2 and 15 characters ");
        } else if (breed.length()<2 || breed.length()>15) {
            view.showErrorMessage("Error", "Breed should have between 2 and 15 characters ");
        } else if (age<=0 || age>=30) {
            view.showErrorMessage("Error", "Age not valid");
        } else if (description.length()<10 || description.length()>45) {
            view.showErrorMessage("Error", "Description should have between 10 and 45 characters ");
        } else if (!gender.trim().toLowerCase().equals("male") || !gender.trim().toLowerCase().equals("female")) {
            view.showErrorMessage("Error", "Gender should be male or female ");
        } else if (age==null ) {
            view.showErrorMessage("Error", "Please enter the age ");
        } else if (feedingSchedule==null) {
            view.showErrorMessage("Error", "Please select the feeding schedule ");
        } else //no errors
        {
            if(attachedAnimal==null){
                //add
                animals.save(new Animal(name,type,breed,age,chipped,description,gender,feedingSchedule));
                view.successfullyFinishActivity("Animal added successfully");
            }else{
                //update
                attachedAnimal.setName(name);
                attachedAnimal.setAge(age);
                attachedAnimal.setBreed(breed);
                attachedAnimal.setType(type);
                attachedAnimal.setChipped(chipped);
                attachedAnimal.setDescription(description);
                attachedAnimal.setGender(gender);
                attachedAnimal.setFeedingSchedule(feedingSchedule);

                view.successfullyFinishActivity("Animal edited successfully");

            }
        }
    }
}
