package gr.aueb.animalshelter.View.Obligations.ObligationDetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.Animals.AnimalDetailsFromObligation.AnimalDetailsFromObligationActivity;
import gr.aueb.animalshelter.View.Animals.ManageAnimals.ManageAnimalsActivity;
import gr.aueb.animalshelter.View.Statistics.ManageStatistics.ManageStatisticsActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateHomePage.SubordinateHomePageActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateSettings.SubordinateSettingsActivity;

public class ObligationDetailsActivity extends AppCompatActivity implements ObligationDetailsView {

    BottomNavigationView bottomNavigationView;
    Button fulfillBtn,showAnimalBtn;
    ObligationDetailsPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obligation_details);


        presenter = new ObligationDetailsPresenter(this);

        bottomNavigationView = findViewById(R.id.bottomNavigationView_subordinate);
        bottomNavigationView.setSelectedItemId(R.id.Obligations);

        fulfillBtn = findViewById(R.id.fulfillBtn);
        showAnimalBtn = findViewById(R.id.showAnimalBtn);

        fulfillBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onFulfillObligation(getAttachedObligationID());
            }
        });

        showAnimalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onStartShowAnimal(getAttachedAnimalID());
            }
        });

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
                        return true;
                    case R.id.Settings:
                        manageSettings();
                        return true;
                }
                return false;
            }
        });

    }

    /**
     * Returns the id of the animal.
     * @return the id of the animal
     */
    public int getAttachedAnimalID()
    {
        return this.getIntent().hasExtra("animal_id") ? this.getIntent().getExtras().getInt("animal_id") : null;
    }

    /**
     * Returns the id of the obligation.
     * @return the id of the obligation
     */
    public int getAttachedObligationID()
    {
        return this.getIntent().hasExtra("obligation_id") ? this.getIntent().getExtras().getInt("obligation_id") : null;
    }

    @Override
    public void startShowAnimal(int animalID) {
        Intent intent = new Intent(getApplicationContext(), AnimalDetailsFromObligationActivity.class);
        intent.putExtra("animalID",animalID);
        startActivity(intent);
    }


    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * home then the user goes to the HomePage
     */

    public void viewHomePage(){
        startActivity(new Intent(getApplicationContext(), SubordinateHomePageActivity.class));
        overridePendingTransition(0,0);
    }

    @Override
    public void manageSettings() {
        startActivity(new Intent(getApplicationContext(), SubordinateSettingsActivity.class));
        overridePendingTransition(0,0);
    }

    @Override
    public void manageStatistics() {
        startActivity(new Intent(getApplicationContext(), ManageStatisticsActivity.class));
        overridePendingTransition(0,0);
    }

    @Override
    public void manageObligations() {
        startActivity(new Intent(getApplicationContext(), ObligationDetailsActivity.class));
        overridePendingTransition(0,0);

    }

    @Override
    public void manageAnimals() {
        startActivity(new Intent(getApplicationContext(), ManageAnimalsActivity.class));
        overridePendingTransition(0,0);
    }
}
