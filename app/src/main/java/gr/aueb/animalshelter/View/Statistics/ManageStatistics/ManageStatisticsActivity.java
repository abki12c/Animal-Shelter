package gr.aueb.animalshelter.View.Statistics.ManageStatistics;

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
import gr.aueb.animalshelter.View.Obligations.ManageObligations.ManageObligationsActivity;
import gr.aueb.animalshelter.View.Statistics.StatisticsAdopted.StatisticsAdoptedActivity;
import gr.aueb.animalshelter.View.Statistics.StatisticsBreeds.StatisticsBreedsActivity;
import gr.aueb.animalshelter.View.Statistics.StatisticsTypes.StatisticsTypesActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateHomePage.SubordinateHomePageActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateHomePage.SubordinateHomePagePresenter;
import gr.aueb.animalshelter.View.Subordinate.SubordinateSettings.SubordinateSettingsActivity;

public class ManageStatisticsActivity extends AppCompatActivity implements ManageStatisticsView{

    BottomNavigationView bottomNavigationView;
    ManageStatisticsPresenter presenter;
    Button breedsBtn;
    Button typesBtn;
    Button adoptedBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_statistics);

        final ManageStatisticsPresenter presenter = new ManageStatisticsPresenter(this);

        breedsBtn = findViewById(R.id.animals_breeds);
        typesBtn = findViewById(R.id.animals_types);
        adoptedBtn = findViewById(R.id.animals_adopted);


        // set button listeners
        breedsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StatisticsBreedsActivity.class);
                startActivity(intent);
            }
        });

        typesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StatisticsTypesActivity.class);
                startActivity(intent);
            }
        });

        adoptedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StatisticsAdoptedActivity.class);
                startActivity(intent);
            }
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView_subordinate);
        bottomNavigationView.setSelectedItemId(R.id.Stats);


        // set navigation menu listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Animals:
                        manageAnimals();
                        return true;
                    case R.id.Stats:
                        return true;
                    case R.id.Home:
                        viewHomePage();
                        return true;
                    case R.id.Obligations:
                        manageObligations();
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
        startActivity(new Intent(getApplicationContext(), ManageObligationsActivity.class));
        overridePendingTransition(0,0);

    }

    @Override
    public void manageAnimals() {
        startActivity(new Intent(getApplicationContext(), ManageAnimalsActivity.class));
        overridePendingTransition(0,0);
    }
}
