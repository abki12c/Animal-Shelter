package gr.aueb.animalshelter.MemoryDAO;

import java.util.ArrayList;
import java.util.List;
import gr.aueb.animalshelter.DAO.AccountDao;
import gr.aueb.animalshelter.domain.Account;

public class AccountDaoMemory implements AccountDao {
    protected static List<Account> entities = new ArrayList<Account>();


    public Account find(int id) {
        for(Account account : entities) {
            if (account.getAccountID() == id ) {
                return account;
            }
        }
        return null;
    }

    public int findID(String username, String password){
        for(Account account : entities) {
            if (account.getUsername() == username && account.getPassword() == password ) {
                return account.getAccountID();
            }
        }
        return -1;
    }


    public void save(Account entity) {
        if (! entities.contains(entity)) {
            entities.add(entity);
        }
    }


    public void delete(Account entity) {
        entities.remove(entity);
    }


    public List<Account> findAll() {
        return new ArrayList<Account>(entities);
    }
}
