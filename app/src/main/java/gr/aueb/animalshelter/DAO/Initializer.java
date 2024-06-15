package gr.aueb.animalshelter.DAO;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.animalshelter.domain.Account;
import gr.aueb.animalshelter.domain.Address;
import gr.aueb.animalshelter.domain.Adopter;
import gr.aueb.animalshelter.domain.Adoption;
import gr.aueb.animalshelter.domain.AdoptionRequest;
import gr.aueb.animalshelter.domain.Animal;
import gr.aueb.animalshelter.domain.Employee;
import gr.aueb.animalshelter.domain.FeedingSchedule;
import gr.aueb.animalshelter.domain.Obligation;
import gr.aueb.animalshelter.domain.Specialty;

/**
 * Class that is responsible for initializing the data of the database
 * @author Komnas Kafasis
 */

 public abstract class Initializer  {

    /** Deletes all Data from memory
    */
    protected abstract void eraseData();

    protected abstract Context getContext();


    /** Initializes the memory with data
     * there is a method for the initialization of each Dao that is called
     */
    public void prepareData() {
        // before we prepare the data we delete everything
        eraseData();

        // add all the necessary data
        List<Adopter> adopters = addAdopters();
        List<FeedingSchedule> feedingSchedules = addFeedingSchedules();
        List<Animal> animals = addAnimals(feedingSchedules);
        addAdoptionRequests(adopters.get(0),animals.get(1), adopters.get(1), animals.get(2) );
        addAdoptions(adopters);
        List<Account> accounts = addAccounts();
        List<Employee> subordinates = addEmployees(accounts);
        addObligations(subordinates, animals);

    }


    /** Initializes the {@link AdopterDao}
     * @return the list of adopters added to be used in another function
     */
    public List<Adopter> addAdopters(){
        Adopter adopterGeorge = new Adopter("Girogos","Papadopoulos","ppap@gamail.com","+30694097654",new Address("Pireos",80,"Attica",10435));
        Adopter adopterJohn = new Adopter("John","Popotas","popop@gamail.com","+30697896014",new Address("Ethnikis Antistaseos",91,"Attica",12134));

        // save data on DAO
        getAdopterDao().save(adopterGeorge);
        getAdopterDao().save(adopterJohn);

        // create and return a list that includes the adopters
        List<Adopter> adopters = new ArrayList<>();
        adopters.add(adopterGeorge);
        adopters.add(adopterJohn);
        return adopters;
    }


    /** Initializes the {@link AdoptionRequestDao}
     * @param adopterGeorge one of the two adopters added for initialization
     * @param adopterJohn one of the two adopters added for initialization
     * @param bird one of the three animals added for initialization
     * @param cat one of the three adopters added for initialization
     */
    public void addAdoptionRequests(Adopter adopterGeorge, Animal cat, Adopter adopterJohn, Animal bird){
        AdoptionRequest adoptionCat = new AdoptionRequest(adopterGeorge,cat,"Plz i really want this cat");
        AdoptionRequest adoptionBird = new AdoptionRequest(adopterJohn,bird,"Plz i really want this cat");

        // save data on DAO
        getAdoptionRequestDao().save(adoptionCat);
        getAdoptionRequestDao().save(adoptionBird);
    }


    /** Initializes the {@link AnimalDao}
     * @param feedingSchedules the feedingSchedules added for the initialization
     * @return the list of animals added to be used in another function
     */
    public List<Animal> addAnimals(List<FeedingSchedule> feedingSchedules){
        Animal dog = new Animal("Bully","dog","bulldog",5,true,"Bully is the sleeper in our shelter. He does nothing but sleep and eat food.","male",feedingSchedules.get(0),"bully.jpg");
        Animal cat = new Animal("Cracker","cat","sphynx",3,true,"Cracker is very energetic. She likes eating food and scaring our customers","female",feedingSchedules.get(1),"cracker.jpg");
        Animal bird = new Animal("Buddy","bird","cockatoo",3,true,"Buddy is very playful. He likes palying with our toys and eating snacks from the hands of our visitors","male", feedingSchedules.get(2),"buddy.jpg");
        Animal prairie_dog = new Animal("Poppy","prairie dog","Utah prairie dog",2,false,"Poppy likes snuggles and yahoos!!","female",feedingSchedules.get(3),"poppy.jpg");
        Animal marmot = new Animal("Marmoto","marmot","Himalayan marmot",2,false,"Marmot king likes baths","male",feedingSchedules.get(4),"marmot.jpg");
        Animal squirrel = new Animal("Thumbelina","squirrel","Western gray squirrel",2,false,"She is scared of frogs","female",feedingSchedules.get(5),"thumbelina.jpg");


        // create and return a list that includes the animals
        List<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(cat);
        animals.add(bird);
        animals.add(prairie_dog);
        animals.add(marmot);
        animals.add(squirrel);

        // save data on DAO
        for (Animal animal : animals) {
            getAnimalDao().save(animal);
        }

        saveAnimalImagesToInternalStorage(animals);

        return animals;

    }

    public void saveAnimalImagesToInternalStorage(List<Animal> animals) {
        Context context = getContext();
        for (Animal animal : animals) {
            String imageName = animal.getImageName().substring(0, animal.getImageName().lastIndexOf('.'));
            int resourceId = context.getResources().getIdentifier(imageName, "raw", context.getPackageName());
            if (resourceId != 0) {
                saveImageFromRawToInternal(context, resourceId, animal.getImageName());
            }
        }
    }

    private void saveImageFromRawToInternal(Context context, int resourceId, String outputFileName) {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = context.getResources().openRawResource(resourceId);
            outputStream = context.openFileOutput(outputFileName, Context.MODE_PRIVATE);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** Initializes the {@link FeedingScheduleDao}
     * @return the list of feeding schedules added to be used in another function
     */
    public List<FeedingSchedule> addFeedingSchedules(){
        FeedingSchedule feedingScheduleDog = new FeedingSchedule("basic feeding schedule for dog","dog","bulldog","dry dog food", "water", "250g","10:00, 15:00, 21:00");
        FeedingSchedule feedingScheduleCat = new FeedingSchedule("basic feeding schedule for cat","cat","sphynx","dry cat food", "water", "100g","9:00, 14:30, 21:00");
        FeedingSchedule feedingScheduleBird = new FeedingSchedule("basic feeding schedule for bird","bird","cockatoo","pellets", "water", "50g","9:30, 13:30, 20:00");
        FeedingSchedule feedingSchedulePrairieDog = new FeedingSchedule("basic feeding schedule for prairie dog","prairie dog","Utah prairie dog","carrots","water","20g","9:30, 13:30, 20:00");
        FeedingSchedule feedingScheduleMarmot = new FeedingSchedule("basic feeding schedule for marmot","marmot","Himalayan marmot","corn flakes","water","20g","9:30, 13:30, 20:00");
        FeedingSchedule feedingScheduleSquirrel = new FeedingSchedule("basic feeding schedule for squirrel","squirrel","Western gray squirrel","avocado","water","15g","9:30, 13:30, 20:00");


        // create and return a list that includes the feedingSchedules
        List<FeedingSchedule> feedingSchedules = new ArrayList<>();
        feedingSchedules.add(feedingScheduleDog);
        feedingSchedules.add(feedingScheduleCat);
        feedingSchedules.add(feedingScheduleBird);
        feedingSchedules.add(feedingSchedulePrairieDog);
        feedingSchedules.add(feedingScheduleMarmot);
        feedingSchedules.add(feedingScheduleSquirrel);


        // save data on DAO
        for (FeedingSchedule schedule : feedingSchedules) {
            getFeedingScheduleDao().save(schedule);
        }

        return feedingSchedules;
    }

    /** Initializes the {@link AdoptionDao}
     * @param adopters the adopters added for the initialization
     */

    public void addAdoptions(List<Adopter> adopters){
        FeedingSchedule feedingScheduleDog = new FeedingSchedule("basic feeding schedule for husky","dog","husky","dry dog food", "water", "250g","10:00, 15:00, 21:00");
        FeedingSchedule feedingScheduleCat = new FeedingSchedule("basic feeding schedule for bobtail","cat","American Bobtail","dry cat food", "water", "100g","9:00, 14:30, 21:00");
        Animal dog = new Animal("Billy","dog","husky",4,true,"Husky likes pets from our visitors an likes to play with his toys..He doesn't share!!","male",feedingScheduleDog);
        Animal cat = new Animal("Nancy","cat","American Bobtail",3,true,"Nancy is not really friendly but with time she can become very loving","female",feedingScheduleCat);
        AdoptionRequest adoptionRequestDog = new AdoptionRequest(adopters.get(0),dog,"My dream is to adopt a Husky...Plz make it come true!!!!");
        AdoptionRequest adoptionRequestCat = new AdoptionRequest(adopters.get(1),cat,"I like cats with no tails...Give me!!!!");

        Adoption adoption1 = new Adoption(adoptionRequestDog);
        Adoption adoption2 = new Adoption(adoptionRequestCat);

        // save data on DAO
        getAdoptionDao().save(adoption1);
        getAdoptionDao().save(adoption2);
    }

    /** Initializes the {@link EmployeeDao}
     * @param accounts the accounts added for the initialization
     * @return the list of employees added to be used in another function
     */
    public List<Employee> addEmployees(List<Account> accounts){
        Employee chief = new Employee(accounts.get(0),"Bob", "Bobster",Specialty.bureaucratic_tasks);
        Employee subordinate1 = new Employee(accounts.get(1), "Mark", "Zuckerberg",Specialty.nutrisionist);
        Employee subordinate2 = new Employee(accounts.get(2), "Johny", "Depp",Specialty.cleaning);
        Employee subordinate3 = new Employee(accounts.get(3), "Harry", "Potter", Specialty.vet);

        //create and return a list that includes the Employees
        List<Employee> subordinates = new ArrayList<>();
        subordinates.add(subordinate1);
        subordinates.add(subordinate2);
        subordinates.add(subordinate3);

        //save data on DAO
        getEmployeeDao().save(chief);
        for (Employee subordinate : subordinates) {
            getEmployeeDao().save(subordinate);
        }

        //save

        return subordinates;

    }

    /** Initializes the {@link ObligationDao}
     * @param subordinates the subordinates employees added for the initialization
     */

   public void addObligations(List<Employee> subordinates, List<Animal> animals){
        int year = LocalDateTime.now().getYear();
        int month = LocalDateTime.now().getMonthValue();
        int day = LocalDateTime.now().getDayOfMonth();
        Obligation obligation1 = new Obligation(animals.get(0),subordinates.get(0),"Feed Bully and give him water", LocalDateTime.of(LocalDate.of(year,month,day+1), LocalTime.of(18,30)));
        Obligation obligation2 = new Obligation(animals.get(1),subordinates.get(1),"Give  Cracker a bath",LocalDateTime.of(LocalDate.of(year,month,day), LocalTime.of(LocalTime.now().getHour(),0)));
        Obligation obligation3 = new Obligation(animals.get(2),subordinates.get(2),"Do a checkup for the health of Buddy",LocalDateTime.of(LocalDate.now(),LocalTime.of(LocalTime.now().getHour(),30)));

        // save data on DAO
        getObligationDao().save(obligation1);
        getObligationDao().save(obligation2);
        getObligationDao().save(obligation3);
    }



    /** Initializes the {@link AccountDao}
     * @return the list of accounts added to be used in another function
     */

    public List<Account> addAccounts(){
        Account accountChief = new Account("admin", "abc123");
        Account accountSubordinate1 = new Account("marco_polo","1234");
        Account accountSubordinate2 = new Account("Johny_Deep","No-caribbean");
        Account accountSubordinate3 = new Account("Harry_Potta22","expecto_patronum");


        //create and return a list that includes the Employees
        List<Account> accounts = new ArrayList<>();
        accounts.add(accountChief);
        accounts.add(accountSubordinate1);
        accounts.add(accountSubordinate2);
        accounts.add(accountSubordinate3);


        // save data on DAO
        for (Account account : accounts) {
            getAccountDao().save(account);
        }


        return accounts;

    }


    protected abstract AdoptionDao getAdoptionDao();
    protected abstract AdoptionRequestDao getAdoptionRequestDao();
    protected abstract AdopterDao getAdopterDao();
    protected abstract AnimalDao getAnimalDao();
    protected abstract FeedingScheduleDao getFeedingScheduleDao();
  /*  protected abstract ObligationDao getObligationDao();*/
    protected abstract EmployeeDao getEmployeeDao();
    protected abstract AccountDao getAccountDao();
    protected abstract ObligationDao getObligationDao();

}