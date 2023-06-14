package gr.aueb.animalshelter.domain;

import java.util.ArrayList;
import java.util.List;


/** Class for the Adopter of the animal Shelter.
 */
public class Adopter {

	private String name;
	private String surname;
	private String email; 
	private String phoneNumber;
	private Address address;

	private int id;
	private static int lastAdopterId = 0;
	private List<AdoptionRequest> adReqs = new ArrayList<>();


	public Adopter(String name, String surname, String email, String phoneNumber,Address address){
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.id = NextAdopterID();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public int getID() {
		return id;
	}

	public static int NextAdopterID(){

		return ++lastAdopterId;
	}

	public List<AdoptionRequest> getAdReqs() {
		return adReqs;
	}

	public void setAdReqs(List<AdoptionRequest> adReqs) {
		this.adReqs = adReqs;
	}

	public String toString() {
		return name+" "+surname+"\n"+email+"\n"+phoneNumber+"\n"+address.toString();
	}
	
	/*public ArrayList<String> getAnimalTypes() {
		ArrayList<String> types = new ArrayList<>();
		for(Animal animal : data.a) {
			if(!types.contains(animal.getType())) {
				types.add(animal.getType());
			}
		}
		return types;
	}
	
	public ArrayList<Animal> getAnimalsBy(String filter, String input,ArrayList<Animal> animals){
		
		ArrayList<Animal> result = new ArrayList<>();
		
		switch(filter) {
			
			case "type":
				if(!data.a.isEmpty()) {
					for(Animal animal : data.a) {
						if(animal.getType().equals(input)) {
							result.add(animal);
						}
					}
				}else {
					System.out.println("No Animals in the system yet.");
				}
				break;
				
			case "breed":
				for(Animal animal : animals) {
					if(animal.getBreed().equals(input)) {
						result.add(animal);
					}
				}
				break;
		
		}
		return result;
	}
	
	public AdoptionRequest createAddRequest(Animal animal,String comments) {
		//create database entry for the AdoptionRequest
		AdoptionRequest x = new AdoptionRequest(this,animal,comments);
		adReqs.add(x);
		data.aR.add(x);
		return x;
	}*/

	


	
	
}
