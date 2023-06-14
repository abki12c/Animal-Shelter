package gr.aueb.animalshelter.View.Statistics.StatisticsBreeds;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.animalshelter.MemoryDAO.AnimalDAOMemory;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.Animals.ManageAnimals.ManageAnimalsActivity;
import gr.aueb.animalshelter.View.Obligations.ManageObligations.ManageObligationsActivity;
import gr.aueb.animalshelter.View.Statistics.ManageStatistics.ManageStatisticsActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateHomePage.SubordinateHomePageActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateSettings.SubordinateSettingsActivity;
import gr.aueb.animalshelter.domain.Employee;

public class StatisticsBreedsActivity extends AppCompatActivity implements StatisticsBreedsView {
    private AutoCompleteTextView autoCompleteTextViewBreed;
    private ArrayAdapter<String> adapterBreeds=null;
    TextView textView;
    BottomNavigationView bottomNavigationView;
    StatisticsBreedsPresenter presenter;
    ArrayList<String> animalbreeds =null ;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_breeds);

        animalbreeds=new ArrayList<String>();

        final StatisticsBreedsPresenter presenter = new StatisticsBreedsPresenter(this, new AnimalDAOMemory());

        textView = findViewById(R.id.animals_breeds_text_view);
        bottomNavigationView = findViewById(R.id.bottomNavigationView_subordinate);
        bottomNavigationView.setSelectedItemId(R.id.Stats);

        //search bar breeds
        presenter.onLoadBarBreeds();
        autoCompleteTextViewBreed=findViewById(R.id.auto_complete_view_breed);
        adapterBreeds=new ArrayAdapter<String>(this,R.layout.type_item,animalbreeds);
        autoCompleteTextViewBreed.setAdapter(adapterBreeds);



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

        // listener for breed bar
        autoCompleteTextViewBreed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String animalType= (String) adapterView.getItemAtPosition(position);
                String stats = Employee.statistics("animals-breed",animalType);
                textView.setText(stats);
                //presenter.updateStatistics(animalType);
            }
        });
    }

    /**
     * loads the bar that contains the animal breeds with a given list of breeds
     * @param input list of types
     */

    public void loadBreeds(List<String> input) {
        animalbreeds.clear();
        animalbreeds.addAll(input);

    }

    public TextView getTextView() {
        return textView;
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
