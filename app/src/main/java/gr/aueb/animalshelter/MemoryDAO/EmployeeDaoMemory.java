package gr.aueb.animalshelter.MemoryDAO;

import java.util.ArrayList;
import java.util.List;
import gr.aueb.animalshelter.DAO.EmployeeDao;
import gr.aueb.animalshelter.domain.Employee;

public class EmployeeDaoMemory implements EmployeeDao {

    protected static List<Employee> entities = new ArrayList<>();

    @Override
    public void save(Employee entity) {
        if (! entities.contains(entity)) {
            entities.add(entity);
        }
    }

    @Override
    public Employee find(int id) {
        for (Employee e : entities) {
            if (e.getAccount().getAccountID() == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<Employee>(entities);
    }

    @Override
    public void delete(Employee entity) {
        entities.remove(entity);
    }

    @Override
    public boolean validate(String username, String password) {
        boolean valid=false;
        for( Employee e:entities){
            if(e.getAccount().getUsername().equals(username) && e.getAccount().getPassword().equals(password)){
                valid=true;
                break;
            }
        }
        return valid;
    }
}
