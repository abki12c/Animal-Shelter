package gr.aueb.animalshelter.View.Adopter.AdopterSettings.ContactInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.Adopter.AdopterHome.AdopterHomeActivity;
import gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest.AddAdoptionRequestActivity;

public class ContactInfoActivity  extends AppCompatActivity implements ContactInfoView,BottomNavigationView .OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationView;
    /**
     * Displays a layout with the shelter contact info
     * @param savedInstanceState Instance State
     */
    final ContactInfoPresenter presenter = new ContactInfoPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.settings);


    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * adopt a friend then the user goes to the Add Adoption Request page
     */


    public void createAdoptionRequest(){
        Intent intent = new Intent(ContactInfoActivity.this, AddAdoptionRequestActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);

    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * home then the user goes to the HomePage
     */
    public void viewHomePage(){
        Intent intent = new Intent(ContactInfoActivity.this, AdopterHomeActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * settings then the user goes to the Manage Profile Page
     */
    public void manageProfile(){
        //do nothing
    }

    /**
     * Navigation menu on the bottom of the screen
     */


    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {

        switch (item.getItemId()) {
            case R.id.pet:
                presenter.onCreateAdoptionRequest();
                return true;

            case R.id.home:
                presenter.onViewHomePage();
                return true;

            case R.id.settings:
                presenter.onManageProfile();
                return true;
        }
        return false;
    }

}
