package gr.aueb.animalshelter.domain;


import androidx.annotation.NonNull;

/** Class for the Animals of the animal Shelter.
 * Animals can be adopted and each have different characteristics
 */
public class Animal  {

	private int id;
	private String name;
	private String type;
	private String breed;

	private int age;
	private boolean chipped;
	private String description;
	private String gender;
	private FeedingSchedule feedingSchedule;
	private static int lastAnimalId = 0;

	public Animal(){
		this.id = NextAnimalId();
	}

	public Animal(String type, String breed) {
		this.type = type;
		this.breed = breed;
		this.id = NextAnimalId();
	}

	public Animal(String name, String type, String breed, int age, boolean chipped, String description, String gender, FeedingSchedule feedingSchedule) {
		this.name = name;
		this.type = type;
		this.breed = breed;
		this.age = age;
		this.chipped = chipped;
		this.description = description;
		this.gender = gender;
		this.feedingSchedule = feedingSchedule;
		this.id = NextAnimalId();
	}


	public static int NextAnimalId(){
		return ++lastAnimalId;
	}

	public int getId(){return this.id;}
	public void setName(String name){
		this.name = name;
	}
	
	public  String getName(){
		return this.name;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
	
	public void setBreed(String breed){
		this.breed = breed;
	}
	
	public String getBreed(){
		return breed;
	}
	
	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return this.age;
	}



	public String getGender(){
		return this.gender;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	public Boolean getChipped() {
		return chipped;
	}


	public void setChipped(Boolean chipped) {
		this.chipped = chipped;
		
	}

	public void setGender(String gender) {
		this.gender = gender;
		
	}

	public void setFeedingSchedule(FeedingSchedule feedingSchedule) {
		this.feedingSchedule = feedingSchedule;
		
	}

	public FeedingSchedule getFeedingSchedule() {
		return feedingSchedule;
	}

	@NonNull
	public String toString() {
		return "\nName: "+name+"\nAge: "+age+"\nGender: "+gender+"\nType: "+type+"\nBreed: "+breed+"\nChipped: "+chipped+"\nTraits: "+description+"\n";
	}

}
