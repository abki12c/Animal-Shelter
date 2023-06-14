package gr.aueb.animalshelter.View.Animals.ShowAnimals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.animalshelter.DAO.Initializer;
import gr.aueb.animalshelter.MemoryDAO.AnimalDAOMemory;
import gr.aueb.animalshelter.MemoryDAO.MemoryInitializer;

public class SearchAnimalsPresenterTest {
    private Initializer dataHelper;
    private SearchAnimalsPresenter presenter;
    private SearchAnimalsViewStub view;

    @Before
    public void setUp()
    {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new SearchAnimalsViewStub();
        presenter = new SearchAnimalsPresenter(view, new AnimalDAOMemory());
    }
    /**
     *  Checks if the animal breeds search bar is appropriately loaded with the
     *  right amount of choices
     */
    @Test
    public void loadBarBreeds(){

        presenter.onLoadBarBreeds();
        Assert.assertEquals(view.getBreedsSize(),3);

    }
    /**
     *  Checks if the animal types search bar is appropriately loaded with the
     *  right amount of choices
     */
    @Test
    public void loadBarTypes(){
        presenter.onLoadBarTypes();
        Assert.assertEquals(view.getTypesSize(),3);

    }

    /**
     *  Checks if it loads the screen with the appropriate animals given the input
     *  from the search bars
     */
    @Test
    public void loadGrid(){
        //type=all breed=all
        presenter.onLoadSource();
        Assert.assertEquals(view.getSourceSize(),3);

        //type=all breed=bulldog lookingfor=bulldog
        view.setCategory("Breed");
        view.setLookingFor("bulldog");
        presenter.onLoadSource();
        Assert.assertEquals(view.getSourceSize(),1);

        //type=dog breed=all lookingfor=dog
        view.setCategory("Type");
        view.setLookingFor("dog");
        presenter.onLoadSource();
        Assert.assertEquals(view.getSourceSize(),1);
        Assert.assertEquals(view.getBreedsSize(),1);

        //type=dog breed=bulldog lookingfor=bulldog
        view.setCategory("Breed");
        view.setLookingFor("bulldog");
        presenter.onLoadSource();
        Assert.assertEquals(view.getSourceSize(),1);
        //type=dog breed=all lookingfor=all
        view.setLookingFor("Dog");
        view.setCategory("Breed");
        view.setLookingForType("dog");
        view.setLookingFor("All");
        presenter.onLoadSource();
        Assert.assertEquals(view.getSourceSize(),1);


    }

    /**
     *  Checks if the go to add adoption requesr page button in the navigation menu works
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
