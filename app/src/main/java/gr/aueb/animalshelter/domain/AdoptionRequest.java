package gr.aueb.animalshelter.domain;


import androidx.annotation.NonNull;

/** Class for the Adoption request submitted by an {@link Adopter} for a specific {@link Animal} from the animal Shelter. <p>
 * An Adoption request can be approved by the chief and lead to a new {@link Adoption}
 */
public class AdoptionRequest {
	Adopter adopter;
	Animal adoptee;
	String comments;

	public AdoptionRequest(Adopter adopter, Animal adoptee, String comments) {
		this.adopter = adopter;
		this.adoptee = adoptee;
		this.comments = comments;
	}

	public Adopter getAdopter() {
		return adopter;
	}

	public void setAdopter(Adopter adopter) {
		this.adopter = adopter;
	}

	public Animal getAdoptee() {
		return adoptee;
	}

	public void setAdoptee(Animal adoptee) {
		this.adoptee = adoptee;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@NonNull
	public String toString() {
		return "\nADOPTION REQUEST\n================\n\n"+"Adopter:\n\n"+adopter.toString()+"\n\nAnimal:\n"+adoptee.toString()+"\nComments:\n\n"+comments+"\n";
	}
	
	public Animal getAnimal() {
		return this.adoptee;
	}

}
