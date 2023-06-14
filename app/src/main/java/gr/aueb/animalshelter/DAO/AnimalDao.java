package gr.aueb.animalshelter.DAO;

import java.util.List;

import gr.aueb.animalshelter.domain.Animal;

/**
 * Interface DAO for the class {@link Animal}.
 * @author _Katerina_
 *
 */
public interface AnimalDao {

        /**
         * Deletes the object from the external database.
         * @param a the object to be deleted.
         */
         void delete(Animal a);
        /**
         * Returns all the objects form the external database.
         * @return the object catalog
         */

        List<Animal> findAll();

        /**
         * Returns all the animal types in the catalog
         * @return list with animal types
         */

        List<String> getTypes();

        /**
         * Returns all the animal breeds in the catalog
         * @return list with animal breeds
         */

        List<String> getBreeds();

         /**
         * Save an object to the external database
         * The object can be a new object that doesn't exist
         * in the database or one that already exists and
         * his state is being updated
         * @param a The object, the state of which
         * is being saved in the external database
         */
        void save(Animal a);

        /**
         * Finds an animal based on its id
         * @param aid Animal id
         * @return Animal found or null
         */
        Animal find(int aid);
        /**
         *The search of all Animals for a specific
         * @param characteristic (tyoe/breed) using
         * @param lookingfor (e.g cat,German Shepard)
         * @return the list of Animals or {@code null} if there are none.
         */
        //finds animals by characteristic (by type or breed)
        List<Animal> find(String characteristic,String lookingfor);

        /**
         * Returns all the animal breeds for a specific animal type
         * @param type type of animal
         * @return the list of breeds or {@code null} if there are none.
         */
        //finds animals by characteristic (by type or breed)
        List<String> findBreeds(String type);


}
