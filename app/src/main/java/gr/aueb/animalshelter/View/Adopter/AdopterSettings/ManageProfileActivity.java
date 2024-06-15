package gr.aueb.animalshelter.View.Adopter.AdopterSettings;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.Adopter.AdopterHome.AdopterHomeActivity;
import gr.aueb.animalshelter.View.Adopter.AdopterSettings.ContactInfo.ContactInfoActivity;
import gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest.AddAdoptionRequestActivity;
import gr.aueb.animalshelter.View.Animals.ShowAnimals.SearchAnimalsActivity;
import gr.aueb.animalshelter.View.LoginPage.LoginPageActivity;

public class ManageProfileActivity  extends AppCompatActivity implements ManageProfileView,BottomNavigationView .OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationView;
    Button logout;
    Button info;
    ManageProfilePresenter  presenter = new ManageProfilePresenter(this);

    /**
     * Displays a layout with the user settings
     * @param savedInstanceState Instance State
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_profile);

        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.settings);

        logout = (Button) findViewById(R.id.logoutButton);
        info = (Button) findViewById(R.id.contact_info);


    }
    /**
     * listens the buttons to move to the appropriate
     * page when clicked
     */
    @Override
    protected void onStart() {
        super.onStart();
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onContactInfo();

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onLogout();

            }
        });

    }
    /**
     * When user clicks on the contact info button
     * it loads the information page of the shelter
     */
    public void contactInfo(){
        Intent intent = new Intent(getApplicationContext() , ContactInfoActivity.class);
        startActivity(intent);

    }

    /**
     * When user clicks on the logout button
     * it loads the login page
     */
    public void logout(){
        Intent intent = new Intent(getApplicationContext() , LoginPageActivity.class);
        startActivity(intent);
    }

    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * adopt a friend then the user goes to the Add Adoption Request page
     */

    public void createAdoptionRequest(){
        Intent intent = new Intent(ManageProfileActivity.this, AddAdoptionRequestActivity.class);
        startActivity(intent);

    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * home then the user goes to the HomePage
     */

    public void viewHomePage(){
        Intent intent = new Intent(ManageProfileActivity.this, AdopterHomeActivity.class);
        startActivity(intent);
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
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * search then the user goes to the Search Animals Page
     */
    public void search(){
        Intent intent = new Intent(ManageProfileActivity.this, SearchAnimalsActivity.class);
        startActivity(intent);
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
            case R.id.search:
                presenter.onSearch();
                return true;
        }
        return false;
    }

}
