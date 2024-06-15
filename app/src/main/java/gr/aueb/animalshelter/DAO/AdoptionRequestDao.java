package gr.aueb.animalshelter.DAO;



import gr.aueb.animalshelter.domain.AdoptionRequest;
import gr.aueb.animalshelter.domain.Animal;
import java.util.List;

/**
 * Interface DAO for the class {@link AdoptionRequest}.
 * @author _Katerina_
 *
 */
public interface AdoptionRequestDao {
    /**
     *The search of all AdoptionRequests
     * @return the list of AdoptionRequest or {@code null} if there are none.
     */
    List<AdoptionRequest> returnAll();
    /**
     *The search of all AdoptionRequests for a specific {@link Animal}
     * @return the list of AdoptionRequest or {@code null} if there are none.
     */
    //return adoption requests for specific animal
    List<AdoptionRequest> returnAdoptions(Animal animal);
    /**
     * Save an object to the external database
     * The object can be a new object that doesn't exist
     * in the database or one that already exists and
     * its state is being updated
     * @param fr The object, the state of which
     * is being saved in the external database
     */
    //saves new adoption request
    void save(AdoptionRequest fr);
    /**
     * Deletes the object from the external database.
     * @param ar the object to be deleted.
     */
    void delete(AdoptionRequest ar);
    /**
     * Deletes the all AdoptionRequest objects for property
     * @param animal .
     */
    //delete all adoption requests for given animal
    void delete(Animal animal);
}
