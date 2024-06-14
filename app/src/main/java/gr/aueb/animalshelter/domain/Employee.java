package gr.aueb.animalshelter.domain;

import android.annotation.SuppressLint;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gr.aueb.animalshelter.MemoryDAO.AdoptionDaoMemory;
import gr.aueb.animalshelter.MemoryDAO.AnimalDAOMemory;

/** Class for the Employee of the animal Shelter. <p>
* It can represent a chief or a subordinate staff
*/
public class Employee {
	
    private String name;
    private String surname;
    private int ObligationsNumber;
    private Specialty specialty;
    private Account a;
    private ArrayList<Obligation> obs;

    public Employee(Account a) {
    	this.a = a;
    	this.obs = new ArrayList<Obligation>();
    }
    
    public Employee(Account account, String name, String surname, Specialty specialty) {
    	this.a = account;
        this.name = name;
        this.surname = surname;
        this.specialty = specialty;
    }

	public Account getAccount() {
    	return a;
    }
    
    public String getName() {
        return name;
    }
        
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getObligationsNumber() {
        return ObligationsNumber;
    }

    public void setObligationsNumber(int obligationsNumber) {
        ObligationsNumber = obligationsNumber;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Employee createEmployee(String username, String password, String name,String surname, Specialty specialty){
        Account newAccount = new Account(username,password);
        Employee employee = new Employee(newAccount,name,surname,specialty);
        //this.a.data.e.add(employee);   //save it on dao
        return employee;

    }

    /**
     * Returns the appropriate statistic for the animals of the shelter, in string format based on the parameters given
     * @param filter is the type of statistic to return which can be animals-type, animals-breed or animals-adopted
     * <p>
     * Bellow the types of filter values(statistics) are explained
     * <p> animals-type : the percentage of each animal type in the animal shelter (ex. 50% dogs, 50% cats)
     * <p> animals-breed :  the percentage of the breed of a specific animal type (ex. the statistics for the breeds of the cats)
     * <p> animals-adopted :  the percentage of the animals of the shelter that have been adopted overall
     * @param animalType is the animal type for the animal used to produce the breed statistic. If another statistic is asked then it's null
     * @return the result of the statistic in string format
     * @author Komnas Kafasis
     */
    public static String statistics(String filter, String animalType){
        List<Animal> animals = new AnimalDAOMemory().findAll();
        String statistics = null;
        double numberOfBreeds = 0.0;
        switch(filter){
            case "animals-type":
                // HashMap with key=type of the animal and value=the number of the animals with that type
                HashMap<String, Double> types = new HashMap<String, Double>();
                for(Animal animal : animals){
                    if(types.containsKey(animal.getType())){
                    	types.put(animal.getType(), types.get(animal.getType()) + 1.0);
                    }else{
                        types.put(animal.getType(), 1.0);
                    }
                }
                double numberOfAnimals = animals.size();
                statistics = "--Statistics for Animal Types--\n";
                for(Map.Entry<String, Double> animalsType: types.entrySet()){
                    double percentage = (animalsType.getValue()*100.0)/numberOfAnimals;
                   statistics += animalsType.getKey()+": "+ String.format("%.2f",percentage) +"%"+"\n";
                }
                break;
            case "animals-breed":
                // HashMap with key=breed of the animal and value=the number of the animals with that breed
                HashMap<String, Double> breeds = new HashMap<>();
                for(Animal animal : animals){
                	if(animal.getType().equals(animalType)) {
                		if(breeds.containsKey(animal.getBreed())){
                            breeds.put(animal.getBreed(), breeds.get(animal.getBreed()) + 1.0);
                        }else{
                            breeds.put(animal.getBreed(), 1.0);
                        }
                		numberOfBreeds++;
                	}
                }
                statistics = "--Statistics for "+animalType.toUpperCase()+" Breeds--\n";
                for( Map.Entry<String, Double> animalsBreed: breeds.entrySet()){
                    double percentage = animalsBreed.getValue()*100.0/numberOfBreeds;
                    statistics += animalsBreed.getKey()+": "+ String.format("%.2f",percentage) +"%"+"\n";
                }
                break;
            case "animals-adopted":
                List<Adoption> adoptions = new AdoptionDaoMemory().findAll();
                double result = (adoptions.size()*100.0)/(animals.size()+adoptions.size());
                statistics = "--Statistics for Animal Adoptions--\n";
                statistics += result + " % of animals have been adopted\n";
                break;


        }
        return statistics;
    }
/*

     public void deleteEmployee(Employee employee){
        this.a.data.e.remove(employee);
    }

    public List<Employee> getEmployees(){
        List<Employee> employees = a.data.e;
        return employees;
    }

    //create a new obligation object and save it in the shared data obligations list
    public void setObligation(Animal animal , Employee employee, String description, LocalDateTime assignmentTime ){
    	Obligation ob = new Obligation(animal,employee,description,assignmentTime);
    	a.data.o.add(ob);

    }




    public void addFeedingSchedule(String type,String breed, String food, String drink,String foodAmount, String hours){
        FeedingSchedule fs = new FeedingSchedule(type,breed,food,drink,foodAmount,hours);
        //adds it to file
        a.data.fs.add(fs);
    }
    
    public ArrayList<FeedingSchedule> getFeedingSchedules(String breed){
       ArrayList<FeedingSchedule> f = new ArrayList<>();
       for(FeedingSchedule fs : a.data.fs) {
    	   if(fs.getBreed().equals(breed)) {
    		   f.add(fs);
    	   } 
       }
       if(f.isEmpty()) {
    	   return null;
       }
       return f;
    }
    
    public void setFeedingSchedule(Animal a,FeedingSchedule f) {
    	a.setFeedingSchedule(f);
    }


    public List<AdoptionRequest> getAdRequests(Animal animal){

        List<AdoptionRequest> adRe = a.data.aR;
        List<AdoptionRequest> requestsForThisAnimal =  new ArrayList<>();
        for(AdoptionRequest ad:adRe){
            if(ad.getAnimal().equals(animal)){
                requestsForThisAnimal.add(ad);
            }
        }

        return requestsForThisAnimal;
    }
    
    public ArrayList<AdoptionRequest> getAdRequests() {
		ArrayList<AdoptionRequest> adreqs = new ArrayList<>();
		adreqs = a.data.aR;
		return adreqs;
	}
    
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void approveAdRequest(AdoptionRequest adoptionRequest, boolean yes){
        if(yes) {
            Adoption ad = new Adoption(adoptionRequest);
            a.data.aD.add(ad);
            a.data.a.remove(adoptionRequest.adoptee);
        }

        turnDownAdRequests(adoptionRequest.getAnimal());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void turnDownAdRequests(Animal animal){
        //deletes all adoption requests from list,maybe sets them in different list?
        //System.out.println(a.data.aR.toString());
        a.data.aR.removeIf(n -> (n.getAnimal().equals(animal)));
        //System.out.println(a.data.aR.toString());

    }

    public void addAnimal(Animal animal){
    	a.data.a.add(animal);
    }

    
    public List<Obligation> getObligations(){
        for(Obligation ob : a.data.o) {
        	if(ob.getEmployeeID() == a.getAccountID() && obs.contains(ob)!=true) {
        		//get all obligations from shared data regarding this employee 
        		obs.add(ob);
        	}
        }
        if(obs.isEmpty()) {
        	return null;
        }
        return obs;

    }
    
    public Obligation getObligation(int obid) {
    	Obligation result = null;
    	for(Obligation obligation : obs) {
        	if(obid == obligation.getID()) {
        		//search the employee obligations list for the input obligation and return the corresponding object 
        		result = obligation;
        	}
    	}
    	return result;
    }

    public void checkOff(Obligation obligation , String fullfillmentDetails , LocalDateTime completionTime ){
    	//fill the completion forms
    	Obligation ob = obligation;
    	ob.setCompletionTime(completionTime);
    	ob.setFulfillmentDetails(fullfillmentDetails);
    	ob.setFulfilled();
    	//add to completed obligations list
    	a.data.f.add(ob);
    	//remove from shared obligation list
    	a.data.o.remove(ob);
    	//remove from employee obligations list
    	obs.remove(ob);
    	
    }

*/
    @NonNull
    public String toString() {
    	return "Name: "+name+" "+surname+" , "+specialty;
    }

}