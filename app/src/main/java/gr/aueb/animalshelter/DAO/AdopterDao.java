package gr.aueb.animalshelter.DAO;

import java.util.List;

import gr.aueb.animalshelter.domain.Adopter;

/**
 * Interface DAO for the class {@link Adopter}.
 * @author Komnas Kafasis
 *
 */
public interface AdopterDao {

    /**
     *The search of an Adopter based on his id.
     * @param id is the Adopter's id.
     * @return the adopter or {@code null} id he isn't found.
     */
    Adopter find(int id);


    /**
     * Save an object to the external database
     * The object can be a new object that doesn't exist
     * in the database or one that already exists and
     * his state is being updated
     * @param entity The object, the state of which
     * is being saved in the external database
     */
    void save(Adopter entity);

    /**
     * Deletes the object from the external database.
     * @param entity the object to be deleted.
     */
    void delete(Adopter entity);

    /**
     * Returns all the objects form the external database.
     * @return the object catalog
     */
    List<Adopter> findAll();
}
