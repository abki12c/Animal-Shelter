package gr.aueb.animalshelter.View.Subordinate.SubordinateSettings;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.Animals.ManageAnimals.ManageAnimalsActivity;
import gr.aueb.animalshelter.View.LoginPage.LoginPageActivity;
import gr.aueb.animalshelter.View.Obligations.ManageObligations.ManageObligationsActivity;
import gr.aueb.animalshelter.View.Statistics.ManageStatistics.ManageStatisticsActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateHomePage.SubordinateHomePageActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateSettings.ContactInfo.ContactInfoActivity;

public class SubordinateSettingsActivity extends AppCompatActivity implements SubordinateSettingsView {
    BottomNavigationView bottomNavigationView;
    Button logout;
    Button info;
    SubordinateSettingsPresenter presenter = new SubordinateSettingsPresenter(this);

    /**
     * Displays a layout with the user settings
     * @param savedInstanceState Instance State
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subordinate_settings);

        bottomNavigationView = findViewById(R.id.bottomNavigationView_subordinate);
        bottomNavigationView.setSelectedItemId(R.id.Settings);

        logout = findViewById(R.id.logoutButton);
        info = findViewById(R.id.contact_info);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Animals:
                        manageAnimals();
                        return true;
                    case R.id.Stats:
                        manageStatistics();
                        return true;
                    case R.id.Home:
                        viewHomePage();
                        return true;
                    case R.id.Obligations:
                        manageObligations();
                        return true;
                    case R.id.Settings:
                        return true;
                }
                return false;
            }
        });


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
        overridePendingTransition(0,0);
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
     * home then the user goes to the HomePage
     */

    public void viewHomePage(){
        Intent intent = new Intent(SubordinateSettingsActivity.this, SubordinateHomePageActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * settings then the user goes to the Settings Page
     */

    @Override
    public void manageSettings() {
        startActivity(new Intent(getApplicationContext(), SubordinateSettingsActivity.class));
        overridePendingTransition(0,0);
    }

    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * statistics then the user goes to the Statistics Page
     */
    @Override
    public void manageStatistics() {
        startActivity(new Intent(getApplicationContext(), ManageStatisticsActivity.class));
        overridePendingTransition(0,0);
    }

    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * obligations then the user goes to the Manage Obligations Page
     */
    @Override
    public void manageObligations() {
        startActivity(new Intent(getApplicationContext(), ManageObligationsActivity.class));
        overridePendingTransition(0,0);

    }

    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * search then the user goes to the Manage Animals Page
     */
    @Override
    public void manageAnimals() {
        startActivity(new Intent(getApplicationContext(), ManageAnimalsActivity.class));
        overridePendingTransition(0,0);
    }
}
