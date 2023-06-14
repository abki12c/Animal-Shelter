package gr.aueb.animalshelter.View.Adopter.AdopterSettings.ContactInfo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.animalshelter.DAO.Initializer;
import gr.aueb.animalshelter.MemoryDAO.MemoryInitializer;

public class ContactInfoPresenterTest {
    private Initializer dataHelper;
    private ContactInfoPresenter presenter;
    private ContactInfoViewStub view;

    @Before
    public void setUp()
    {
        dataHelper = new MemoryInitializer();
        dataHelper.prepareData();
        view = new ContactInfoViewStub();
        presenter = new ContactInfoPresenter(view);
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
