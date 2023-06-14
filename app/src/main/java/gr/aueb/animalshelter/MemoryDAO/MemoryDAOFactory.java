package gr.aueb.animalshelter.MemoryDAO;


import gr.aueb.animalshelter.DAO.*;

/**
 * Factory for Dao objects using the computer's memory
 * @author _Katerina_
 */
public class MemoryDAOFactory extends DAOFactory {

    private AdopterDao AdopterDaoMemory = new AdopterDaoMemory();
    private AdoptionDao AdoptionDaoMemory = new AdoptionDaoMemory();
    private AdoptionRequestDao AdoptionRequestDaoMemory = new AdoptionRequestDAOMemory();
    private AnimalDao animalDaoMemory = new AnimalDAOMemory();
    private FeedingScheduleDao feedingScheduleDaoMemory = new FeedingScheduleDAOMemory();
   /* private Obligation_fDao Obligation_fDaoMemory = new Obligation_fDAOMemory();
    private Obligation_oDao Obligation_oDaoMemory = new Obligation_oDAOMemory();
    private EmployeeDao EmployeeDaoMemory = new EmployeeDAOMemory();*/



    public AdopterDao getAdopterDAO() {
        return AdopterDaoMemory;
    }

    public AdoptionDao getAdoptionDAO() {
        return AdoptionDaoMemory;
    }

    public AdoptionRequestDao getAdoptionRequestDAO() {
        return AdoptionRequestDaoMemory;
    }

    public AnimalDao getAnimalDAO() {
        return animalDaoMemory;
    }

    public FeedingScheduleDao getFeedingScheduleDAO() {
        return feedingScheduleDaoMemory;
    }
/*
    public Obligation_fDao getObligation_fDAO() {
        return Obligation_fDaoMemory;
    }

    public Obligation_oDao getObligation_oDAO() {
        return Obligation_oDaoMemory;
    }

    public EmployeeDao getEmployeeDAO() {
        return EmployeeDaoMemory;
    }*/
}