package gr.aueb.animalshelter.DAO;

import java.util.List;

import gr.aueb.animalshelter.domain.Account;

/**
 * Interface DAO for the class {@link Account}.
 * @author Komnas Kafasis
 *
 */
public interface AccountDao {

    /**
     *The search of an Account based on his id.
     * @param id is the Account's id.
     * @return the account or {@code null} id it isn't found.
     */
    Account find(int id);

    /**
     *The search of an Account based on username and password.
     * @param username is the Account's username.
     * @param password is the Account's password.
     * @return the account id or -1 if it isn't found.
     */

    int findID(String username, String password);


    /**
     * Save an object to the external database
     * The object can be a new object that doesn't exist
     * in the database or one that already exists and
     * his state is being updated
     * @param entity The object, the state of which
     * is being saved in the external database
     */
    void save(Account entity);

    /**
     * Deletes the object from the external database.
     * @param entity the object to be deleted.
     */
    void delete(Account entity);

    /**
     * Returns all the objects form the external database.
     * @return the object catalog
     */
    List<Account> findAll();
}
