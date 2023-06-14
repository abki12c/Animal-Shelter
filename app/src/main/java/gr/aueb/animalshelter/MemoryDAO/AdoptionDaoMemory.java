package gr.aueb.animalshelter.MemoryDAO;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.animalshelter.DAO.AdoptionDao;
import gr.aueb.animalshelter.domain.Adoption;

public class AdoptionDaoMemory implements AdoptionDao {

    protected static List<Adoption> entities = new ArrayList<Adoption>();



    public Adoption find(int id) {
        for(Adoption adoption : entities) {
            if (adoption.getID() == id ) {
                return adoption;
            }
        }
        return null;
    }


    public void save(Adoption entity) {
        if (! entities.contains(entity)) {
            entities.add(entity);
        }
    }


    public void delete(Adoption entity) {
        entities.remove(entity);
    }


    public List<Adoption> findAll() {
        return new ArrayList<Adoption>(entities);
    }
}
