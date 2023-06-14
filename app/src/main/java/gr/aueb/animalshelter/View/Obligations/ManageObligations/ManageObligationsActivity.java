package gr.aueb.animalshelter.View.Obligations.ManageObligations;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.animalshelter.MemoryDAO.ObligationDaoMemory;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.Utils.ObligationItem;
import gr.aueb.animalshelter.Utils.ObligationsRecyclerViewAdapter;
import gr.aueb.animalshelter.View.Animals.ManageAnimals.ManageAnimalsActivity;
import gr.aueb.animalshelter.View.Statistics.ManageStatistics.ManageStatisticsActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateHomePage.SubordinateHomePageActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateHomePage.SubordinateHomePagePresenter;
import gr.aueb.animalshelter.View.Subordinate.SubordinateSettings.SubordinateSettingsActivity;
import gr.aueb.animalshelter.domain.Obligation;

public class ManageObligationsActivity extends AppCompatActivity implements ManageObligationsView {

    BottomNavigationView bottomNavigationView;
    SubordinateHomePagePresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_obligations);

        RecyclerView recyclerView = findViewById(R.id.MyRecyclerViewManageObligations);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<ObligationItem> obligationItemList = createObligationItemList();


        recyclerView.setAdapter(new ObligationsRecyclerViewAdapter(getApplicationContext(),obligationItemList));


        final ManageObligationsPresenter presenter = new ManageObligationsPresenter(this);

        bottomNavigationView = findViewById(R.id.bottomNavigationView_subordinate);
        bottomNavigationView.setSelectedItemId(R.id.Home);

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

    List<ObligationItem> createObligationItemList(){
        int accountId = SubordinateHomePageActivity.accountID;
        List<Obligation> obligationList = new ObligationDaoMemory().findUnfulfilledObligations(accountId);
        List<ObligationItem> obligationItems = new ArrayList<ObligationItem>();

        for(Obligation obligation : obligationList){
            obligationItems.add(new ObligationItem(obligation.getAnimal().getName(),obligation.getDescription() , R.drawable.ic_obligation));
        }

        return obligationItems;
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
