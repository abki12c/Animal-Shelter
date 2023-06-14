package gr.aueb.animalshelter.domainTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

import gr.aueb.animalshelter.DAO.AnimalDao;
import gr.aueb.animalshelter.MemoryDAO.AnimalDAOMemory;
import gr.aueb.animalshelter.MemoryDAO.MemoryInitializer;

public class InitializerTest {

    @Test
    public void testCreateAnimal() {
        new MemoryInitializer().prepareData();
        AnimalDao am = new AnimalDAOMemory();
        assertEquals(am.getTypes().size(), 3);
    }
}
