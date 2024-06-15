package gr.aueb.animalshelter.MemoryDAO;

import gr.aueb.animalshelter.DAO.AdoptionRequestDao;
import gr.aueb.animalshelter.domain.AdoptionRequest;
import gr.aueb.animalshelter.domain.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AdoptionRequestDAOMemory implements AdoptionRequestDao {
    protected static ArrayList<AdoptionRequest> entities = new ArrayList<AdoptionRequest>();
    public List<AdoptionRequest> returnAll(){
        return new ArrayList<AdoptionRequest>(entities);
    }

    //return adoption requests for specific animal
    public List<AdoptionRequest> returnAdoptions(Animal animal){
        List<AdoptionRequest> requests = new ArrayList<AdoptionRequest>();
        for(AdoptionRequest ar:entities){
            if(ar.getAnimal().equals(animal))
                requests.add(ar);
        }
        return requests;
    }

    //saves new adoption request
    public void save(AdoptionRequest ar){
        if (! entities.contains(ar))
            entities.add(ar);;
    }

    public void delete(AdoptionRequest ar){
        entities.remove(ar);
    }

    //delete all adoption requests for given animal
    public void delete(Animal animal){
        ListIterator<AdoptionRequest> iter = entities.listIterator();
        while(iter.hasNext()){
            if(iter.next().getAnimal().equals(animal)){
                iter.remove();
            }
        }
    }

}
