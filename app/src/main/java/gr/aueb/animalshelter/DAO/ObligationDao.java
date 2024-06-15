package gr.aueb.animalshelter.DAO;

import java.util.List;
import gr.aueb.animalshelter.domain.Obligation;

/**
 * Interface DAO for the class {@link Obligation}.
 * @author Vasilis Stagakis
 */

public interface ObligationDao {

    /**
    * Save Obligation object.
    * @param entity is the Obligation object that will be saved.
    */
    void save(Obligation entity);

    /**
    * Search Obligation by id.
    * @param id is the Obligation's id.
    * @return the Obligation object or {@code null} if the Obligation isn't found.
    */
    Obligation find(int id);

    /**
    * Search Obligation by Employee id.
    * @param id is the Employee's id.
    * @return a List with all the Obligation objects that have been assigned to the specific Employee
    * and haven't been fulfilled yet or {@code null} if no Obligation for the Employee are found.
    */
    List<Obligation> findUnfulfilledObligations(int id);


    /**
     * Returns all the objects form the external database.
     * @return the object catalog
     */
    List<Obligation> findAll();



    /**
    * Delete Obligation object.
    * @param obligation is the Obligation to be deleted.
    */
    void delete(Obligation obligation);

}
