package gr.aueb.animalshelter.View.Animals.AnimalDetails;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.animalshelter.DAO.Initializer;
import gr.aueb.animalshelter.MemoryDAO.AnimalDAOMemory;
import gr.aueb.animalshelter.MemoryDAO.MemoryInitializer;
import gr.aueb.animalshelter.domain.Animal;

public class AnimalDetailsPresenterTest {
    private Initializer dataHelper;
    private AnimalDetailsPresenter presenter;
    private AnimalDetailsViewStub view;

    @Before
    public void setUp()
    {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new AnimalDetailsViewStub();
        presenter = new AnimalDetailsPresenter(view,new AnimalDAOMemory());
    }



    /**
     *  Checks if it shows the animal successfully in the screen
     */
    @Test
    public void loadAnimal()
    {
        System.out.println();
        presenter.onLoadAnimal(2);
        Assert.assertEquals("Cracker",view.getName());
    }
    /**
     *  Checks if the go to add adoption request page button in the navigation menu works
     */



    @Test
    public void goToAdRequest()
    {
        Assert.assertFalse(view.isCreateAdRequest());
        presenter.onCreateAdoptionRequest();
        Assert.assertTrue(view.isCreateAdRequest());
    }
    /**
     *  Checks if the go to homepage button in the navigation menu works
     */

    @Test
    public void goToHome()
    {
        Assert.assertFalse(view.isViewHomePage());
        presenter.onViewHomePage();
        Assert.assertTrue(view.isViewHomePage());
    }

    /**
     *  Checks if the go to search page button in the navigation menu works
     */

    @Test
    public void goToSearch()
    {
        Assert.assertFalse(view.isSearch());
        presenter.onSearch();
        Assert.assertTrue(view.isSearch());
    }

    /**
     *  Checks if the go to settings page button in the navigation menu works
     */
    @Test
    public void goToSettings()
    {
        Assert.assertFalse(view.isManageProfile());
        presenter.onManageProfile();
        Assert.assertTrue(view.isManageProfile());
    }




}
