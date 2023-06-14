package gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest.AddAdoptionRequestInfo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.animalshelter.DAO.Initializer;
import gr.aueb.animalshelter.MemoryDAO.AdoptionRequestDAOMemory;
import gr.aueb.animalshelter.MemoryDAO.AnimalDAOMemory;
import gr.aueb.animalshelter.MemoryDAO.MemoryInitializer;
import gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest.AdoptionRequestInfo.AdoptionRequestInfoPresenter;

public class AdoptionRequestInfoPresenterTest {

    private Initializer dataHelper;
    private AdoptionRequestInfoPresenter presenter;
    private AdoptionRequestInfoViewStub view;

    @Before
    public void setUp()
    {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new AdoptionRequestInfoViewStub();
        presenter = new AdoptionRequestInfoPresenter(view, new AdoptionRequestDAOMemory(),new AnimalDAOMemory());
    }

    /**
     *  Checks if it shows the appropriate errors when given the wrong input in the
     *  application form .Also checks if the add adoption request is successful when the
     *  right information is inputted
     */

    @Test
    public void testAddRequest()
    {

        view.setAnimalId(2);
        presenter.onSaveAdoptionRequest();

        Assert.assertEquals(view.getErrorTitle(), "Error!");
        Assert.assertEquals(view.getErrorMessage(), "Please provide your full name.");

        view.setName("Mark");
        view.setSurname("k");
        presenter.onSaveAdoptionRequest();
        Assert.assertEquals(view.getErrorTitle(), "Error!");
        Assert.assertEquals(view.getErrorMessage(), "Please provide your full last name.");

        view.setSurname("smith");
        presenter.onSaveAdoptionRequest();

        Assert.assertEquals(view.getErrorTitle(), "Error!");
        Assert.assertEquals(view.getErrorMessage(), "Please fill in all the fields.");


        view.setStreet("Maria Avenue");
        view.setStreetNumber("234B");
        view.setTown("London");
        view.setTK("1234");
        view.setEmail("aklsf@gmail.com");
        view.setPhone("+2345687654");
        presenter.onSaveAdoptionRequest();

        Assert.assertEquals(view.getErrorTitle(), "Error! ");
        Assert.assertEquals(view.getErrorMessage(), "Please make sure to enter only numbers in TK and Street Number fields.");

        view.setStreetNumber("34");
        view.setTK("-2");
        presenter.onSaveAdoptionRequest();
        Assert.assertEquals(view.getErrorTitle(), "Error!");
        Assert.assertEquals(view.getErrorMessage(), "Please provide valid zipcode.");

        view.setStreetNumber("-2");
        view.setTK("2345");
        presenter.onSaveAdoptionRequest();
        Assert.assertEquals(view.getErrorTitle(), "Error!");
        Assert.assertEquals(view.getErrorMessage(), "Please provide valid street Number.");

        view.setStreetNumber("123");
        presenter.onSaveAdoptionRequest();
        Assert.assertEquals(view.getErrorTitle(), "Error!");
        Assert.assertEquals(view.getErrorMessage(), "Please provide a brief paragraph on why you would like to adopt this animal.");

        view.setComments("I love birds and he looks funny");
        presenter.onSaveAdoptionRequest();

        Assert.assertEquals(view.getFinishMessage(), "You have successfully submitted your adoption request!");


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
     *  Checks if the go the search animals page button in the navigation menu works
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
