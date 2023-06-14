package gr.aueb.animalshelter.MemoryDAO;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.animalshelter.DAO.ObligationDao;
import gr.aueb.animalshelter.domain.Obligation;

public class ObligationDaoMemory implements ObligationDao {

    protected static List<Obligation> entities = new ArrayList<>();

    @Override
    public void save(Obligation entity) {
        if (! entities.contains(entity)) {
            entities.add(entity);
        }
    }

    @Override
    public Obligation find(int id) {
        for (Obligation o : entities) {
            if (o.getID() == id) {
                return o;
            }
        }
        return null;
    }

    @Override
    public List<Obligation> findUnfulfilledObligations(int id) {
        List<Obligation> EmployeeObligations = new ArrayList<>();
        for (Obligation o : entities) {
            if (o.getEmployeeID() == id && !o.getFulfilled()) {
                EmployeeObligations.add(o);
            }
        }
        if (EmployeeObligations.isEmpty()) {
            return null;
        }
        return EmployeeObligations;
    }

    @Override
    public List<Obligation> findAll() {
        return new ArrayList<Obligation>(entities);
    }


    @Override
    public void delete(Obligation obligation) {
        entities.remove(obligation);
    }
}
