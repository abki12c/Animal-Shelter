package gr.aueb.animalshelter.DAO;

import java.util.List;
import gr.aueb.animalshelter.domain.Adoption;

/**
 * Interface DAO for the class {@link Adoption}.
 * @author Komnas Kafasis
 *
 */
public interface AdoptionDao {

    /**
     *The search of an Adoption based on the id.
     * @param id is the Adoption's id.
     * @return the adoption or {@code null} id it isn't found.
     */
    Adoption find(int id);


    /**
     * Save an object to the external database
     * The object can be a new object that doesn't exist
     * in the database or one that already exists and
     * his state is being updated
     * @param entity The object, the state of which
     * is being saved in the external database
     */
    void save(Adoption entity);

    /**
     * Deletes the object from the external database.
     * @param entity the object to be deleted.
     */
    void delete(Adoption entity);

    /**
     * Returns all the objects from the external database.
     * @return the object catalog
     */
    List<Adoption> findAll();
}
