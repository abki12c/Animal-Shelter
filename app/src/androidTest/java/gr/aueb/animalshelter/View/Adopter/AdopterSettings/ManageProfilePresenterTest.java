package gr.aueb.animalshelter.View.Adopter.AdopterSettings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.animalshelter.DAO.Initializer;
import gr.aueb.animalshelter.MemoryDAO.MemoryInitializer;

public class ManageProfilePresenterTest {

    private Initializer dataHelper;
    private ManageProfilePresenter presenter;
    private ManageProfileViewStub view;

    @Before
    public void setUp()
    {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new ManageProfileViewStub();
        presenter = new ManageProfilePresenter(view);
    }
    /**
     *  Checks if the logout button works
     */

    @Test
    public void goToLogout()
    {
        Assert.assertFalse(view.isLogout());
        presenter.onLogout();
        Assert.assertTrue(view.isLogout());
    }

    /**
     *  Checks if the go shelter info button  works
     */

    @Test
        public void goToContactInfo()
    {
        Assert.assertFalse(view.isCinfo());
        presenter.onContactInfo();
        Assert.assertTrue(view.isCinfo());
    }

    /**
     *  Checks if the go to add adoption request in the navigation menu works
     */
    @Test
    public void goToAdRequest()
    {
        Assert.assertFalse(view.isCreateAdRequest());
        presenter.onCreateAdoptionRequest();
        Assert.assertTrue(view.isCreateAdRequest());
    }
    /**
     *  Checks if the go homepage button in the navigation menu works
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
