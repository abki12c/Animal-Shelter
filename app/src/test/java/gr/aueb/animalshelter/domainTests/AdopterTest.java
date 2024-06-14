package gr.aueb.animalshelter.domainTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;


import gr.aueb.animalshelter.domain.Adopter;
import gr.aueb.animalshelter.domain.AdoptionRequest;
import gr.aueb.animalshelter.domain.Animal;

public class AdopterTest {
/*
	 Animal animal;
     Adopter adopter;
     String comments;
     ArrayList<Animal> animals;
     SharedData data;
	
	@BeforeEach
	public void setUp() {
		// Create a mock Adopter and Animal objects
        animal = new Animal();
        data = new SharedData();
        adopter = new Adopter(data);
        comments = null;
        // Create mock animals , 3 dogs and a cat , add them to Shared data
    	data.a.add(new Animal("dog","pug"));
    	data.a.add(new Animal("dog","pug"));
    	data.a.add(new Animal("dog","mixed"));
    	data.a.add(new Animal("cat","mixed"));
    	//mock arrayList to hold animals
    	animals = new ArrayList<Animal>();
    	animals.add(new Animal("dog","pug"));
    	animals.add(new Animal("dog","pug"));
    	animals.add(new Animal("dog","mixed"));
    	animals.add(new Animal("cat","mixed"));
	}

    @Test
    public void testCreateAddRequest() {
    	//create Adoption Request
        AdoptionRequest request = adopter.createAddRequest(animal, comments);

        // Verify that the request is created and added to the appropriate lists
        assertNotNull(request);
        assertTrue(adopter.getAdReqs().contains(request));
        assertEquals(adopter, request.getAdopter());
        assertEquals(animal, request.getAdoptee());
        assertEquals(comments, request.getComments());
    }
    
    @Test
    public void testAnimalsByType() {
        // Create a mock filter and input
        String filter = "type";
        String input = "dog";

        // Call the getAnimalsBy method
        ArrayList<Animal> result = adopter.getAnimalsBy(filter, input, null);

        // Verify that all animals added in list are of type dog
        assertEquals(3, result.size());
        result.forEach(animal -> {
        	String type = animal.getType();
        	Assertions.assertEquals("dog",type);
        });
        
    }
    
    @Test
    public void testAnimalsByBreed() {
    	// Create a mock filter and input
        String filter = "breed";
        String input = "pug";

        // Call the getAnimalsBy method
        ArrayList<Animal> result = adopter.getAnimalsBy(filter, input, animals);

        // Verify that all animals added in list are of type dog
        assertEquals(2, result.size());
        result.forEach(animal -> {
        	String breed = animal.getBreed();
        	Assertions.assertEquals("pug",breed);
        });
    }
    
    @Test
    public void testAnimalTypes() {
    	//get animal types cat and dog from mock data
    	ArrayList<String> types = adopter.getAnimalTypes();
    	// Assert that the returned animal types are correct
        ArrayList<String> expectedTypes = new ArrayList<>();
        expectedTypes.add("cat");
        expectedTypes.add("dog");
        
        //sort lists so same objects are positioned in the same indexes in order to compare
        Collections.sort(types);
        Collections.sort(expectedTypes);

        Assertions.assertEquals(expectedTypes, types);
    }
    
    @AfterEach
    public void cleanUp() {
    	adopter = null;
    	data = null;
    }*/
}

