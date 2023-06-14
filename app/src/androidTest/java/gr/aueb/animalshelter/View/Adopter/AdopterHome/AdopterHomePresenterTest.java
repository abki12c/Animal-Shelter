package gr.aueb.animalshelter.View.Adopter.AdopterHome;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.animalshelter.DAO.Initializer;
import gr.aueb.animalshelter.MemoryDAO.AnimalDAOMemory;
import gr.aueb.animalshelter.MemoryDAO.MemoryInitializer;
public class AdopterHomePresenterTest {

    private Initializer dataHelper;
    private AdopterHomePresenter presenter;
    private AdopterHomeViewStub view;

    @Before
    public void setUp()
    {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new AdopterHomeViewStub();
        presenter = new AdopterHomePresenter(view,new AnimalDAOMemory());
    }
    /**
     * Checks if an animal is returned  successfully
     */

    @Test
    public void randomAnimal(){
        presenter.onRandom();
        Assert.assertTrue(view.getName()!="");
    }

    /**
     * checks if the number returned is within the limits given so that
     * it doesnt exceed the limits of the list
     */

    @Test
    public void randomNumber(){
        Assert.assertTrue(presenter.getRandomNumber(0,4)<=4 &&presenter.getRandomNumber(0,4)>=0);
    }

    /**
     *  Checks if the go to add request button in the navigation menu works
     *
     */

    @Test
    public void goToAdRequest()
    {
        Assert.assertFalse(view.isCreateAdRequest());
        presenter.onCreateAdoptionRequest();
        Assert.assertTrue(view.isCreateAdRequest());
    }
    /**
     *  Checks if the go to home page button in the navigation menu works
     */
    @Test
    public void goToHome()
    {
        Assert.assertFalse(view.isViewHomePage());
        presenter.onViewHomePage();
        Assert.assertTrue(view.isViewHomePage());
    }
    /**
     *  Checks if the go to search animal button in the navigation menu works
     */
    @Test
    public void goToSearch()
    {
        Assert.assertFalse(view.isSearch());
        presenter.onSearch();
        Assert.assertTrue(view.isSearch());
    }
    /**
     *  Checks if the go to settings button in the navigation menu works
     */


    @Test
    public void goToSettings()
    {
        Assert.assertFalse(view.isManageProfile());
        presenter.onManageProfile();
        Assert.assertTrue(view.isManageProfile());
    }
}
