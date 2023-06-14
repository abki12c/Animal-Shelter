package gr.aueb.animalshelter.MemoryDAO;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.animalshelter.DAO.AnimalDao;
import gr.aueb.animalshelter.domain.Animal;

public class AnimalDAOMemory implements AnimalDao {
    protected static ArrayList<Animal> entities = new ArrayList<Animal>();

    public void delete(Animal a) {
        entities.remove(a);
    }


    public List<Animal> findAll() {
        return new ArrayList<Animal>(entities);
    }


    public void save(Animal entity) {
        if (! entities.contains(entity))
            entities.add(entity);
    }

    public List<String> getTypes(){
        List<String> types =new ArrayList<String>();

        for(Animal a : entities){
            if (!types.contains(a.getType()) )
                types.add(a.getType());

        }
        return types;

    }

    public List<String> getBreeds(){
        List<String> breeds =new ArrayList<String>();

        for(Animal a : entities){
            if (!breeds.contains(a.getBreed()) )
                    breeds.add(a.getBreed());

        }

        return breeds;

    }

    public Animal find(int aid){
        for(Animal a : entities)
            if(a.getId() == aid)
                return a;

        return null;
    }


    public List<Animal> find(String characteristic,String lookingfor)
    {
        List<Animal> animals =new ArrayList<Animal>();
        //find animal
        for(Animal a : entities){
            if(characteristic.equals("Type")) {
                if (a.getType() == lookingfor)
                    animals.add(a);
            } else if (characteristic.equals("Breed")) {
                if (a.getBreed() == lookingfor)
                    animals.add(a);
            }
        }

        return animals;
    }

    @Override
    public List<String> findBreeds(String type) {
        List<String> breeds =new ArrayList<String>();
        for(Animal a : entities){
            if(a.getType().equals(type)) {
                if (!breeds.contains(a.getBreed()))
                    breeds.add(a.getBreed());
            }
        }
        return breeds;
    }


}
