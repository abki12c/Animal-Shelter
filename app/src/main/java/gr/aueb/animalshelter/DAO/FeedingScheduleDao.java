package gr.aueb.animalshelter.DAO;

import java.util.List;
import gr.aueb.animalshelter.domain.FeedingSchedule;
/**
 * Interface DAO for the class {@link FeedingSchedule}.
 * @author _Katerina_
 *
 */
public interface FeedingScheduleDao {
    /**
     * Returns all the names of the feeding schedules from the external database including the id.
     * @return the object catalog
     */
    public List<String> findAllNamesPlusID();
    /**
     * Returns all the objects from the external database.
     * @return the object catalog
     */
    List<FeedingSchedule> findAll();

    /**
     * Save an object to the external database
     * The object can be a new object that doesn't exist
     * in the database or one that already exists and
     * his state is being updated
     * @param fs The object, the state of which
     * is being saved in the external database
     */
    void save(FeedingSchedule fs);


    /**
     *The search of an Adopter based on his id.
     * @param id is the Feeding Schedule's id.
     * @return the adopter or {@code null} id he isn't found.
     */
    FeedingSchedule find(int id);

    /**
     * Deletes the object from the external database.
     * @param entity the object to be deleted.
     */
    void delete(FeedingSchedule entity);
}
