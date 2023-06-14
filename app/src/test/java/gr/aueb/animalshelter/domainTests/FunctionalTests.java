package gr.aueb.animalshelter.domainTests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.animalshelter.DAO.Initializer;
import gr.aueb.animalshelter.MemoryDAO.MemoryInitializer;
import gr.aueb.animalshelter.SharedData;
import gr.aueb.animalshelter.domain.Account;
import gr.aueb.animalshelter.domain.Address;
import gr.aueb.animalshelter.domain.Adopter;
import gr.aueb.animalshelter.domain.AdoptionRequest;
import gr.aueb.animalshelter.domain.Animal;
import gr.aueb.animalshelter.domain.Employee;
import gr.aueb.animalshelter.domain.FeedingSchedule;
import gr.aueb.animalshelter.domain.Obligation;
import gr.aueb.animalshelter.domain.Specialty;

public class FunctionalTests {
	//setup
	/*
	SharedData d;
	Account manager;
	Account worker1;
	Account worker2;
	Employee m;
	Employee w1;
	Employee w2;
	Adopter adopter;
	Animal a1;
	Animal a2;
	Animal a3;
	Animal a4;
	Animal a5;
	Animal a6;
	Animal a7;
	Animal a8;
	boolean check = false;
	
	
	@BeforeEach
	void setUp(){ 
		
		d = new SharedData();
		
		manager = new Account(d);
		manager.setUsername("admin");
		manager.setPassword("0123456789");
	
		worker1 = new Account(d);
		worker1.setUsername("worker1");
		worker1.setPassword("0000");
		
		worker2 = new Account(d);
		worker2.setUsername("worker2");
		worker2.setPassword("123456");
		
		m = new Employee(manager);
		m.setName("Michael");
		m.setSurname("Scott");
		m.setSpecialty(Specialty.bureaucratic_tasks);
		
		w1 = new Employee(worker1);
		w1.setName("Harry");
		w1.setSurname("Potter");
		w1.setSpecialty(Specialty.cleaning);
		
		w2 = new Employee(worker2);
		w2.setName("John");
		w2.setSurname("Wick");
		w2.setSpecialty(Specialty.vet);
		
		a1 = new Animal();
	    a1.setName("Dumb");
	    a1.setGender("male");
	    a1.setAge(4);
	    a1.setBreed("pug");
	    a1.setType("dog");
	    a1.setChipped();
	    a1.setDescription("practicly useless");
	    d.a.add(a1);
	    
	    a8 = new Animal();
	    a8.setName("Dumber");
	    a8.setGender("male");
	    a8.setAge(2);
	    a8.setBreed("pug");
	    a8.setType("dog");
	    a8.setChipped();
	    a8.setDescription("friends with Dumb/equally useless");
	    d.a.add(a8);
	    
	    a2 = new Animal();
	    a2.setName("Blue");
	    a2.setGender("female");
	    a2.setAge(2);
	    a2.setBreed("husky");
	    a2.setType("dog");
	    a2.setDescription("great guard");
	    d.a.add(a2);
	    
	    a3 = new Animal();
	    a3.setName("Bella");
	    a3.setGender("female");
	    a3.setAge(9);
	    a3.setBreed("ankara");
	    a3.setType("cat");
	    a3.setDescription("sleepy all day long");
	    d.a.add(a3);
	    
	    a4 = new Animal();
	    a4.setName("Fluffy");
	    a4.setGender("male");
	    a4.setAge(7);
	    a4.setBreed("mixed");
	    a4.setType("cat");
	    a4.setChipped();
	    a4.setDescription("hates baths");
	    d.a.add(a4);
	    
	    a5 = new Animal();
	    a5.setName("Edith");
	    a5.setGender("female");
	    a5.setAge(33);
	    a5.setBreed("African Grey Parrot");
	    a5.setType("bird");
	    a5.setDescription("likes to sing");
	    d.a.add(a5);
	    
	    a6 = new Animal();
	    a6.setName("Luna");
	    a6.setGender("female");
	    a6.setAge(3);
	    a6.setBreed("tarantula spider");
	    a6.setType("insect");
	    a6.setDescription("knitts a lot");
	    d.a.add(a6);
	    
	    a7 = new Animal();
	    a7.setName("George");
	    a7.setGender("male");
	    a7.setAge(1);
	    a7.setBreed("canary");
	    a7.setType("bird");
	    a7.setDescription("in need for a mate");
	    d.a.add(a7);
	    
	    LocalDateTime now = LocalDateTime.now(); 
		m.setObligation(a1, w1, "Clean the dog Potter.", now);
		m.setObligation(a1, w1, "Feed the dog Potter.", now);
		m.setObligation(a3, w2, "No more dogs for you Wick.", now);
		m.setObligation(a6, w1, "play with the spider.", now);
	    
		m.getAccount().data.e.add(w1);
		m.getAccount().data.e.add(w2);
		
		Adopter ad1= new Adopter(d);
        Adopter ad2= new Adopter(d);
        Adopter ad3= new Adopter(d);
        
        ad1.setName("Mark");
        ad1.setSurname("zuckerberg");
        ad1.setEmail("facebook@gmail.com");
        ad1.setPhoneNumber("66-611939483");
        Address adress = new Address();
        adress.setStreet("street1");
        adress.setTown("Liverpool");
        adress.setStreetNumber(23);
        adress.setZipCode(2324);
        ad1.setAddress(adress);
		
		ad1.createAddRequest(a8,"I've always wanted to be a cat dad");
        ad2.createAddRequest(a8,"i love this cat");
        ad3.createAddRequest(a8,"my kids will love her");
        ad1.createAddRequest(a5,"please");
        
        m.approveAdRequest(m.getAdRequests(a5).get(0),true);
		
	}
	
	@Test
	void uc1createEmployee() { 
		// create new Employee
		Employee newEmployee = m.createEmployee("user_1","abc123","George","Papadopoulos", Specialty.nutrisionist);
		//System.out.println(m.getAccount().data.e);
		// check if the employee exists
		Assertions.assertTrue(m.getAccount().data.e.stream().anyMatch(p -> p.toString().equals(newEmployee.toString())));
	}

	@Test
	void uc1removeEmployee(){
		//System.out.println("Employees before removal");
		//System.out.println(m.getAccount().data.e);
		//remove Employee John Wick
		m.deleteEmployee(w2);
		//System.out.println("Employees after removal of employee John Wick");
		//System.out.println(m.getAccount().data.e);
		m.getAccount().data.e.forEach(employee -> {
			if(w2.getAccount().getAccountID() == employee.getAccount().getAccountID()) {
				fail("Employee wasnt deleted.");
			}
		});
	}
	
	@Test
	public void uc2() {

        m.addFeedingSchedule("dog", "german shepard","royal canin","water","2 cups","3 times a day");


        FeedingSchedule f1 = new FeedingSchedule("dog", "german shepard","royal canin","water","2 cups","3 times a day");
        Assertions.assertTrue(m.getAccount().data.fs.stream().anyMatch(p -> p.toString().equals(f1.toString())));
    }
	
	@Test
    void uc3ApproveOne(){ 

        //System.out.println(m.getAnimals().toString());             //we print the animals
        int input = 1;                                                          //we choose animal no2
        Animal animalss = m.getAnimals().get(input);
        //System.out.println(animalss);

        List<AdoptionRequest> adRe = m.getAdRequests(animalss);                                //show requests for specific animal

                                                                                //user input again for which request needs to be approved
        input = 0;                                                              //we choose adRe no1
        AdoptionRequest a=adRe.get(input);
        m.approveAdRequest(a,true);                             //this is if he decides to adopt an animal


        Assertions.assertTrue(m.getAccount().data.aD.stream().anyMatch(p -> p.getAdoptionRequest().equals(a)));   //checks if adoption request is in adoption list
        Assertions.assertFalse(m.getAccount().data.aR.contains(a));                                               //checks if adoption request is not still in adoption request list
        Assertions.assertFalse(m.getAccount().data.aR.stream().anyMatch(p -> p.getAnimal().equals(animalss)));         //checks to make sure there are no adoption requests with that same animal in adoption request list
    }

    @Test
    void uc3TurnThemAllDown(){

        // System.out.println(m.getAnimals().toString());             //we print the animals
        int input = 1;                                                          //we choose animal no2
        Animal an = m.getAnimals().get(input);


        List<AdoptionRequest> adRe = m.getAdRequests(an);

        //System.out.println(adRe.toString());                                  //show requests for specific animal

        //user chooses none of the adoption requests
        m.approveAdRequest(adRe.get(0),false);                   //this is if he decides to adopt an animal, he gets the ad request for the first animal
        Assertions.assertFalse(m.getAccount().data.aR.stream().anyMatch(p -> p.getAnimal().equals(an)));  //checks to make sure there are no adoption requests with that same animal in adoption request list
    }

   @Test
   public void uc4(){
	    //System.out.println("\nUSE CASE 4\n");

	    adopter = new Adopter(d);
	    
	    //filtering of shelter animals
	    ArrayList<Animal> animals = adopter.data.a;
	    //all animals
	    //System.out.println("Unfiltered Animals of Shelter\n\n"+animals+"\n");
	    
	    
	    
	    //animal types
	    ArrayList<String> types = adopter.getAnimalTypes();
	    types = adopter.getAnimalTypes();
	    //System.out.println("Types of Animals in the Shelter\n\n"+types+"\n");
	    //select type
	    String input_type = "dog";
		animals = adopter.getAnimalsBy("type",input_type,null);
		//System.out.println("Animals of Shelter by Type: "+input_type+"\n\n"+animals+"\n");
		//get animal breeds for the animals of the type selected
		String input_breed = "pug";
		animals = adopter.getAnimalsBy("breed",input_breed,animals);
		//System.out.println("Animals of Shelter by Breed: "+input_breed+"\n\n"+animals+"\n");
		//select animal
		Animal input_adoptee = animals.get(1);
		//get adopter info
		adopter.setName("John");
		adopter.setSurname("Doe");
		Address ad = new Address();
		ad.setStreet("Panepistimiou");
		ad.setStreetNumber(25);
		ad.setTown("Athens"); 
		ad.setZipCode(11427);
		adopter.setAddress(ad);
		adopter.setEmail("adopter@gmail.com");
		adopter.setPhoneNumber("6987591233");;
		String comments = "I want this animal for my kids.";
		//create Adoption Request
		AdoptionRequest ar = adopter.createAddRequest(input_adoptee, comments);
		//print add request
		//System.out.println("Result:\n"+adopter.adReqs.get(0).toString()+"\n");
	   	
		//Check if the AdoptionRequest is created successfully
		Assertions.assertTrue(adopter.getAdReqs().contains(ar), "The AdoptionRequest should be added successfully in the adopters List");
		Assertions.assertTrue(adopter.data.aR.contains(ar), "The AdoptionRequest should be added successfully in the shared data");
   }
   
   @Test
   public void uc5(){

       //System.out.println(employeeBoss.getEmployees().toString());             //we print the employees
       int input = 1;                                                          //we choose employee no2
       Employee e = m.getEmployees().get(input);
       //System.out.println(e.getEmployees());

       // System.out.println(employeeBoss.getAnimals().toString());             //we print the animals
       input = 1;                                                          //we choose animal no2
       Animal a1 = m.getAnimals().get(input);
       //System.out.println(a1);
       String description = "Clean the cage";

       //user chooses none of the adoption requests
       m.setObligation(a1,e,description, LocalDateTime.now());
       Assertions.assertTrue(m.getAccount().data.o.stream().anyMatch(p -> p.getEmployeeID()==e.getAccount().getAccountID() && p.getDescription().equals(description)));  //checks if obligation in list of obligations

   }
   
   @Test
   public void uc6Type() {
		//animals 3 dogs , 2 cats , 1 birds , 1 insect
		//System.out.println(m.statistics("animals-type",null));
		//statistics
		String result = m.statistics("animals-type",null);
		Assertions.assertEquals(result, 
				"--Statistics for Animal Types--\n"
				+ "cat: 28.571428571428573%\n"
				+ "bird: 14.285714285714286%\n"
				+ "insect: 14.285714285714286%\n"
				+ "dog: 42.857142857142854%\n");
   }
   
   @Test
   public void uc6Breed() {
	   //2 pugs , 1 husky
	   //System.out.println(m.statistics("animals-breed","dog"));
	   //statistics
	   String result = m.statistics("animals-breed","cat");
	   Assertions.assertEquals(result, 
			   "--Statistics for CAT Breeds--\n"
			  +"ankara: 50.0%\n"
			  +"mixed: 50.0%\n" 
			   );
   }
   
   @Test
   public void uc6Adopted() {
		//8 animals existed , 1 animal adopted(now 7 animals exist)
		//System.out.println(m.statistics("animals-adopted",null));
		//statistics
		String result = m.statistics("animals-adopted",null);
		Assertions.assertEquals(result, 
				 "--Statistics for Animal Adoptions--\n"
				+"12.5 % of animals has been adopted\n");
   }
   
   @Test
   public void uc7(){
	   //System.out.println("\nUSE CASE 7\n");
	   //all obligations
	   //System.out.println("\nAll Obligations\n\n"+w1.getAccount().data.o.toString());
	   //update employee obligations
	   w1.getObligations();
	   //employee obligations
	   //System.out.println("\nEmployee obligations\n\n"+w1.getObligations().toString());
	   int input_obligationID = w1.getObligations().get(0).getID();
	   String input_details = "If you can do it tomorrow , dont do it today. -James Bond";
	   //select an obligation
	   Obligation ob = w1.getObligation(input_obligationID);
	   LocalDateTime now = LocalDateTime.now(); 
	   w1.checkOff(ob,input_details,now);
	   
	   //check if obligation was deleted for uncompleted obligations list in data
	   w1.getAccount().data.o.forEach(obligation -> {
		   if(obligation.getID() == input_obligationID) {
			   fail("The obligation should be deleted from the uncompleted list in data.");
		   }
	   });
	   //check if obligation is inside finished obligations list in data
	   w1.getAccount().data.f.forEach(obligation -> {
		   if(obligation.getID() == input_obligationID) {
			   this.check = true;
		   }
	   });
	   Assertions.assertTrue(check,"The obligation should be inside the finished obligations list.");
	   //check if obligation was deleted from the employees obligations list and is not available anymore
	   w1.getObligations().forEach(obligation -> {
		   if(obligation.getID() == input_obligationID) {
			   fail("The obligation should be deleted from the employee obligations list.");
		   }
	   });
	   /*
	    * w1.getAccount().data.f.forEach(obligation -> {
		   if(obligation.getID() == input_obligationID) {
		   	   //print completed obligation
			   System.out.println("\n\nCompleted Obligation\n\n"+obligation.toString());
		   }
	   });*/
	   //System.out.println("\nUpdated Employee obligations\n\n"+w1.getObligations().toString());
   }
/*
   @Test
   public void uc8(){
	   //System.out.println("\nUSE CASE 8\n");
	   //w2 adds new animal
	   //new animal
	   Animal a9 = new Animal();
	   a9 = new Animal();
	   String input_name = "Professor Minerva McGonagall";
	   String input_gender = "female";
	   int input_age = 16;
       String input_breed = "British Short Hair";
       String input_type = "cat";
       String input_description = "excellent ,marvelous ,absolutely fabulous";
	   a9.setName(input_name);
	   a9.setGender(input_gender); 
	   a9.setAge(input_age);
	   a9.setBreed(input_breed);
	   a9.setType(input_type);
	   a9.setDescription(input_description);
	   //no feeding schedules added so it must return null
	   Assertions.assertNull(w2.getFeedingSchedules(input_breed));
	   w2.addAnimal(a9);
	   
	   //Check if the animal is added successfully
	   List<Animal> animals = w2.getAnimals();
	   Assertions.assertTrue(animals.contains(a9), "The animal should be added successfully");
   }
   
   @AfterEach
   public void cleanUp() {
	   d = null;
	   manager = null;
	   worker1 = null;
	   worker2 = null;
	   m = null;
	   w1 = null;
	   w2 = null;
	   adopter = null;
   }

}*/
