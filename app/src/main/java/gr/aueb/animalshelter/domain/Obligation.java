package gr.aueb.animalshelter.domain;

import androidx.annotation.NonNull;

import java.time.LocalDateTime;

/** Class for the obligations of a subordinate staff which is an {@link Employee} of the Animal Shelter.
 * Obligations can be assigned to a subordinate staff employee by the chief employee
 */
public class Obligation {

	private int id;
	private String description;
	private LocalDateTime assignmentTime;
	private LocalDateTime completionTime;
	private boolean fulfilled;
	private String fulfillmentDetails;
	private static int lastObligationId = 0;
	private Employee employee;
	private Animal animal;

    public Obligation(Animal animal, Employee employee, String description, LocalDateTime assignmentTime) {
    	this.animal = animal;
    	this.employee = employee;
    	this.description = description;
    	this.assignmentTime = assignmentTime;
        this.id = NextObligationID();
    	
    }

	public int getID() {
        return id;
    }

    public static int NextObligationID(){
        return ++lastObligationId;
    }

    public String getDescription() {
        return description;
    }

    public void setAnimal(Animal a) {
    	this.animal = a;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getAssignmentTime() {
        return assignmentTime;
    }

    public void setAssignmentTime(LocalDateTime assignmentTime) {
        this.assignmentTime = assignmentTime;
    }

    public LocalDateTime getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(LocalDateTime completionTime) {
        this.completionTime = completionTime;
    }

    public boolean getFulfilled() {
        return fulfilled;
    }

    public void setFulfilled() {
        this.fulfilled = true;
    }
 
    public String getFulfillmentDetails() {
        return fulfillmentDetails;
    }

    public void setFulfillmentDetails(String fulfillmentDetails) {
        this.fulfillmentDetails = fulfillmentDetails;
    }

    @NonNull
    public String toString() {
    	return "\nObligationID: "+id+"\n\nEmployee\n\n"+employee.toString()+"\n\nAnimal\n"+animal.toString()+"\nDescription: "+description+"\nCompleted :"+fulfilled+"\nTime of Assignment: "+assignmentTime+"\nTime of Completion: "+completionTime+"\nDetails: "+fulfillmentDetails+"\n";
    }

	public int getEmployeeID() {
		return employee.getAccount().getAccountID();
	}

}
