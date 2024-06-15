package gr.aueb.animalshelter.MemoryDAO;

import android.content.Context;
import java.util.List;
import gr.aueb.animalshelter.DAO.AccountDao;
import gr.aueb.animalshelter.DAO.AdopterDao;
import gr.aueb.animalshelter.DAO.AdoptionDao;
import gr.aueb.animalshelter.DAO.AdoptionRequestDao;
import gr.aueb.animalshelter.DAO.AnimalDao;
import gr.aueb.animalshelter.DAO.EmployeeDao;
import gr.aueb.animalshelter.DAO.FeedingScheduleDao;
import gr.aueb.animalshelter.DAO.Initializer;
import gr.aueb.animalshelter.DAO.ObligationDao;
import gr.aueb.animalshelter.domain.Account;
import gr.aueb.animalshelter.domain.Adopter;
import gr.aueb.animalshelter.domain.Adoption;
import gr.aueb.animalshelter.domain.Animal;
import gr.aueb.animalshelter.domain.Employee;
import gr.aueb.animalshelter.domain.Obligation;

public class MemoryInitializer extends Initializer {

    private Context context;
    public MemoryInitializer(Context context){
        this.context = context;
    }

    @Override
    protected void eraseData() {

        List<Adoption> allAdoptions = getAdoptionDao().findAll();
        for(Adoption adoption : allAdoptions) {
            getAdoptionDao().delete(adoption);
        }

        List<Adopter> allAdopters = getAdopterDao().findAll();
        for(Adopter adopter : allAdopters) {
            getAdopterDao().delete(adopter);
        }

        List<Animal> allAnimals = getAnimalDao().findAll();
        for(Animal animal : allAnimals) {
            getAnimalDao().delete(animal);
        }

     List<Obligation> allObligations = getObligationDao().findAll();
        for(Obligation obligation : allObligations) {
            getObligationDao().delete(obligation);
        }

        List<Employee> allEmployees = getEmployeeDao().findAll();
        for(Employee employee : allEmployees) {
            getEmployeeDao().delete(employee);
        }

        List<Account> allAccounts = getAccountDao().findAll();
        for(Account account : allAccounts) {
            getAccountDao().delete(account);
        }
    }

    @Override
    protected AdoptionDao getAdoptionDao() {

        return new AdoptionDaoMemory();
    }

    @Override
    protected AdoptionRequestDao getAdoptionRequestDao(){
        return new AdoptionRequestDAOMemory(); }

    @Override
    protected AdopterDao getAdopterDao() {
        return new AdopterDaoMemory();
    }

    @Override
    protected AnimalDao getAnimalDao() {
        return new AnimalDAOMemory();
    }

    @Override
    protected FeedingScheduleDao getFeedingScheduleDao() {
        return new FeedingScheduleDAOMemory();
    }
    @Override
    protected ObligationDao getObligationDao(){
        return new ObligationDaoMemory();
    }

    @Override
    protected EmployeeDao getEmployeeDao(){
        return new EmployeeDaoMemory();
    }

    @Override
    protected AccountDao getAccountDao(){
        return new AccountDaoMemory();}

    public Context getContext() {
        return context;
    }
}