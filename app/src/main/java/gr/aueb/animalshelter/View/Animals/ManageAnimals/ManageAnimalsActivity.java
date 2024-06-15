package gr.aueb.animalshelter.View.Animals.ManageAnimals;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.Animals.AddEditAnimals.AddEditAnimalsActivity;
import gr.aueb.animalshelter.View.Obligations.ManageObligations.ManageObligationsActivity;
import gr.aueb.animalshelter.View.Statistics.ManageStatistics.ManageStatisticsActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateHomePage.SubordinateHomePageActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateHomePage.SubordinateHomePagePresenter;
import gr.aueb.animalshelter.View.Subordinate.SubordinateSettings.SubordinateSettingsActivity;

public class ManageAnimalsActivity extends AppCompatActivity implements ManageAnimalsView {
    BottomNavigationView bottomNavigationView;
    FloatingActionButton actionBtn;
    ManageAnimalsPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_animals);

        final ManageAnimalsPresenter presenter = new ManageAnimalsPresenter(this);

        bottomNavigationView = findViewById(R.id.bottomNavigationView_subordinate);
        bottomNavigationView.setSelectedItemId(R.id.Animals);
        actionBtn = findViewById(R.id.floatingActionButton5);


        actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddEditAnimalsActivity.class);
                startActivity(intent);
            }
        });






        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Animals:
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
