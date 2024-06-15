package gr.aueb.animalshelter.DAO;

import java.util.List;
import gr.aueb.animalshelter.domain.Employee;

/**
 * Interface DAO for the class {@link Employee}.
 * @author Vasilis Stagakis
 */

public interface EmployeeDao {

     /**
     * Save Employee object.
     * @param entity is the Employees object that will be saved.
     */
     void save(Employee entity);

     /**
     * Search Employee by id.
     * @param id is the Employee's id.
     * @return the Employee object or {@code null} if the Employee isn't found.
     */
     Employee find(int id);

     /**
     * Search Employee by id.
     * @return a List with all the Employee objects that have been saved or {@code null} if no Employees are found.
     */
     List<Employee> findAll();

     /**
     * Delete Employee object.
     * @param entity is the Employee to be deleted.
     */
     void delete(Employee entity);

     boolean validate(String username,String password);

}
