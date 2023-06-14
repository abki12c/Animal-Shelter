package gr.aueb.animalshelter.MemoryDAO;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.animalshelter.DAO.AdopterDao;
import gr.aueb.animalshelter.domain.Adopter;

public class AdopterDaoMemory implements AdopterDao {

    protected static List<Adopter> entities = new ArrayList<Adopter>();



    public Adopter find(int id) {
        for(Adopter adopter : entities) {
            if (adopter.getID() == id ) {
                return adopter;
            }
        }
        return null;
    }


    public void save(Adopter entity) {
        if (! entities.contains(entity)) {
            entities.add(entity);
        }
    }


    public void delete(Adopter entity) {
        entities.remove(entity);
    }


    public List<Adopter> findAll() {
        return new ArrayList<Adopter>(entities);
    }
}
