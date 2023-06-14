package gr.aueb.animalshelter;

import java.util.ArrayList;

import gr.aueb.animalshelter.domain.Adoption;
import gr.aueb.animalshelter.domain.AdoptionRequest;
import gr.aueb.animalshelter.domain.Animal;
import gr.aueb.animalshelter.domain.Employee;
import gr.aueb.animalshelter.domain.FeedingSchedule;
import gr.aueb.animalshelter.domain.Obligation;

//common object that all accounts have in their constructor , simulating a database
public class SharedData {

	//list that contains the feeding schedules
	public ArrayList<FeedingSchedule> fs = new ArrayList<FeedingSchedule>();
	//list that contains the employees
	public ArrayList<Employee> e = new ArrayList<Employee>();
	//list that contains the uncompleted obligations
	public ArrayList<Obligation> o = new ArrayList<Obligation>();
	//list that contains the animals
	public ArrayList<Animal> a = new ArrayList<Animal>();
	//list that contains the adoption requests
	public ArrayList<AdoptionRequest> aR = new ArrayList<AdoptionRequest>();
	//list that contains the adoptions
	public ArrayList<Adoption> aD = new ArrayList<Adoption>();
	//list that contains the completed obligations
	public ArrayList<Obligation> f = new ArrayList<Obligation>();
	
}
