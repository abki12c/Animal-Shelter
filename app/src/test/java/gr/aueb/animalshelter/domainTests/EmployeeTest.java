package gr.aueb.animalshelter.domainTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.animalshelter.domain.*;

class EmployeeTest { 
/*
	Employee w3;

    Employee manager;
    SharedData data;
    Animal a1,a2;
	
	@BeforeEach
	public void setUp() {
		w3 = new Employee(new Account(new SharedData()));
		data = new SharedData();
        manager = new Employee(new Account(data));
        w3 = new Employee(new Account(data));

        data.e.add(w3);

        a1 = new Animal();
        a2 = new Animal();
        data.a.add(a1);
        data.a.add(a2);
        a1.setName("Dumb");
        a1.setGender("male");
        a1.setAge(4);
        a1.setBreed("pug");
        a1.setType("dog");
        a1.setChipped();
        a1.setDescription("practicly useless");

        a2.setName("Bella");
        a2.setGender("female");
        a2.setAge(9);
        a2.setBreed("ankara");
        a2.setType("cat");
        a2.setDescription("sleepy all day long");

        Adopter ad1= new Adopter(data);
        Adopter ad2= new Adopter(data);
        Adopter ad3= new Adopter(data);

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

        ad2.setName("Elon");
        ad2.setSurname("Musk");
        ad2.setEmail("x@gmail.com");
        ad2.setPhoneNumber("66-613454554");
        adress = new Address();
        adress.setStreet("street2");
        adress.setTown("New York");
        adress.setStreetNumber(12);
        adress.setZipCode(23423);
        ad2.setAddress(adress);

        ad3.setName("Maria");
        ad3.setSurname("Kallas");
        ad3.setEmail("maria@gmail.com");
        ad3.setPhoneNumber("210-613454554");
        adress = new Address();
        adress.setStreet("korai");
        adress.setTown("Athens");
        adress.setStreetNumber(1);
        adress.setZipCode(43266);
        ad3.setAddress(adress);

        ad1.createAddRequest(a1,"I've always wanted to be a cat dad");
        ad2.createAddRequest(a1,"i love this cat");
        ad3.createAddRequest(a1,"my kids will love her");
        ad1.createAddRequest(a2,"please");

	}
	
	 @Test
    void testGetFeedingSchedules() {

        // Add some feeding schedules to the Shared data
        manager.addFeedingSchedule("dog", "pug", "Food1", "Drink1", "FoodAmount1", "Hours1");
        manager.addFeedingSchedule("cat", "mixed", "Food2", "Drink2", "FoodAmount2", "Hours2");
        manager.addFeedingSchedule("dog", "pug", "Food3", "Drink3", "FoodAmount3", "Hours3");

        //get feeding schedules for pugs
        ArrayList<FeedingSchedule> schedules = manager.getFeedingSchedules("pug");

        //returned list is not null
        Assertions.assertNotNull(schedules);

        //size of the list is correct
        Assertions.assertEquals(2, schedules.size());

        //list contains the expected feeding schedules
        Assertions.assertTrue(schedules.get(0).getDrink().equals("Drink1"));
        Assertions.assertTrue(schedules.get(1).getHours().equals("Hours3"));
	    }
	
	@Test
	void testGetObligation() {
		//add obligation
		w3.getAccount().data.o.add(new Obligation(new Animal(), w3, null, null));
		//find obligation id
		int id = w3.getAccount().data.o.get(0).getID();
		//update employee obligations
		w3.getObligations();
		//check
		Obligation o = w3.getObligation(id);
		Assertions.assertEquals(id, o.getID());
	}
	
	@Test
	void testCheckOff() {
		Obligation o = new Obligation(new Animal(), w3, null, null);
		w3.checkOff(o, null, null);
		
		//the obligation should seize to exist from the employees list and the uncompleted data list
		
		Assertions.assertTrue(!w3.getAdRequests().contains(o));
		
		Assertions.assertTrue(!w3.getAccount().data.o.contains(o));
		
		//the obligation should be in the finished obligations list
		
		Assertions.assertTrue(w3.getAccount().data.f.contains(o));
		
		
	}
	
	@Test
    void setObligationTest() {
        int input = 0;                                                          //we choose the first employee
        Employee e = manager.getEmployees().get(input);

        // System.out.println(employeeBoss.getAnimals().toString());             //we print the animals
        input = 0;                                                          //we choose animal no1
        Animal a1 = manager.getAnimals().get(input);

        String description = "Clean the cage";

        manager.setObligation(a1,e,description, LocalDateTime.now());
        Assertions.assertTrue(data.o.stream().anyMatch(p -> p.getEmployeeID()==e.getAccount().getAccountID() && p.getDescription().equals(description)));  //checks if obligation in list of obligations


    }

    @Test
    void getAdRequestsTest() {
        Assertions.assertEquals(manager.getAdRequests().size(),manager.getAccount().data.aR.size());
        Assertions.assertEquals(data.aR,manager.getAdRequests());
    }


    @Test
    void approveAdRequestTest() {

        int input = 0;                                                          //we choose animal no2
        Animal animalss = manager.getAnimals().get(input);
        //System.out.println(animals);

        List<AdoptionRequest> adRe = manager.getAdRequests(animalss);                                //show requests for specific animal

        //user input again for which request needs to be approved
        input = 0;                                                              //we choose adRe no1
        AdoptionRequest a=adRe.get(input);
        manager.approveAdRequest(a,true);                             //this is if he decides to adopt an animal


        Assertions.assertTrue(manager.getAccount().data.aD.stream().anyMatch(p -> p.getAdoptionRequest().equals(a)));   //checks if adoption request is in adoption list
        Assertions.assertFalse(manager.getAccount().data.aR.contains(a));                                               //checks if adoption request is not still in adoption request list
        Assertions.assertFalse(manager.getAccount().data.aR.stream().anyMatch(p -> p.getAnimal().equals(animalss)));         //checks to make sure there are no adoption requests with that same animal in adoption request list
    }


    @Test
    void turnDownAdRequestsTest(){

        w3.turnDownAdRequests(a1);
        Assertions.assertFalse(data.aR.stream().anyMatch(p -> p.getAnimal().equals(a1)));

    }

    @Test
    void addFeedingScheduleTest(){
        w3.addFeedingSchedule("dog", "german shepard","royal canin","water","2 cups","3 times a day");
        FeedingSchedule f1 = new FeedingSchedule("dog", "german shepard","royal canin","water","2 cups","3 times a day");
        Assertions.assertTrue(data.fs.stream().anyMatch(p -> p.toString().equals(f1.toString())));
    }
	
	@AfterEach
	public void cleanUp() {
		w3 = null;
	}
*/
}
