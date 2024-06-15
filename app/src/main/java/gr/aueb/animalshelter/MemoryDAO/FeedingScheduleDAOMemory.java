package gr.aueb.animalshelter.MemoryDAO;

import java.util.ArrayList;
import java.util.List;
import gr.aueb.animalshelter.DAO.FeedingScheduleDao;
import gr.aueb.animalshelter.domain.FeedingSchedule;

public class FeedingScheduleDAOMemory implements FeedingScheduleDao {

    protected static ArrayList<FeedingSchedule> entities = new ArrayList<FeedingSchedule>();
    public List<FeedingSchedule> findAll(){
        return new ArrayList<>(entities);
    }

    public List<String> findAllNamesPlusID(){
        List<FeedingSchedule> feedingSchedules = findAll();
        List<String> names = new ArrayList<>();
        for(FeedingSchedule feedingSchedule : feedingSchedules){
            names.add(feedingSchedule.getName()+"#"+ feedingSchedule.getID());
        }
        return names;
    }

    public void save(FeedingSchedule fs){
        if (! entities.contains(fs))
            entities.add(fs);

    }

    public FeedingSchedule find(int id) {
        for(FeedingSchedule feedingSchedule : entities) {
            if (feedingSchedule.getID() == id ) {
                return feedingSchedule;
            }
        }
        return null;
    }

    public void delete(FeedingSchedule entity) {
        entities.remove(entity);
    }
}
