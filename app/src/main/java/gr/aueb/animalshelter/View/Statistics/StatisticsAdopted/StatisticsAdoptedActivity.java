package gr.aueb.animalshelter.View.Statistics.StatisticsAdopted;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.Animals.ManageAnimals.ManageAnimalsActivity;
import gr.aueb.animalshelter.View.Obligations.ManageObligations.ManageObligationsActivity;
import gr.aueb.animalshelter.View.Statistics.ManageStatistics.ManageStatisticsActivity;
import gr.aueb.animalshelter.View.Statistics.StatisticsBreeds.StatisticsBreedsPresenter;
import gr.aueb.animalshelter.View.Subordinate.SubordinateHomePage.SubordinateHomePageActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateSettings.SubordinateSettingsActivity;
import gr.aueb.animalshelter.domain.Employee;

public class StatisticsAdoptedActivity extends AppCompatActivity implements StatisticsAdoptedView {
    TextView textView;
    BottomNavigationView bottomNavigationView;
    StatisticsAdoptedPresenter presenter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_adopted);

        final StatisticsAdoptedPresenter presenter = new StatisticsAdoptedPresenter(this);

        bottomNavigationView = findViewById(R.id.bottomNavigationView_subordinate);
        bottomNavigationView.setSelectedItemId(R.id.Stats);
        textView = findViewById(R.id.animals_adopted_text_view);


        String stats = Employee.statistics("animals-adopted",null);
        // set statistics to textview
        textView.setText(stats);

        // to perform the movement action
        // Moves the cursor or scrolls to the
        // top or bottom of the document
        textView.setMovementMethod(new ScrollingMovementMethod());


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
