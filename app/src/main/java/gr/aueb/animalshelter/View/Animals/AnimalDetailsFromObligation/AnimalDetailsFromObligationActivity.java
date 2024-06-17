package gr.aueb.animalshelter.View.Animals.AnimalDetailsFromObligation;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import gr.aueb.animalshelter.MemoryDAO.AnimalDAOMemory;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.Animals.ManageAnimals.ManageAnimalsActivity;
import gr.aueb.animalshelter.View.Obligations.ManageObligations.ManageObligationsActivity;
import gr.aueb.animalshelter.View.Statistics.ManageStatistics.ManageStatisticsActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateHomePage.SubordinateHomePageActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateSettings.SubordinateSettingsActivity;


public class AnimalDetailsFromObligationActivity extends AppCompatActivity implements  AnimalDetailsFromObligationView, BottomNavigationView.OnNavigationItemSelectedListener {

    final AnimalDetailsFromObligationPresenter presenter = new AnimalDetailsFromObligationPresenter(this,new AnimalDAOMemory());;
    BottomNavigationView bottomNavigationView;
    ImageView imageView;
    private String name,type,breed,age,gender,chipped,description;
    int animalId;
    /**
     * Displays a layout with detailed information for chosen animal
     * @param savedInstanceState Instance State
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obligation_animal_details);
        this.animalId = getIntent().getIntExtra("animal",0);

        imageView = findViewById(R.id.animalPicDetails);
        bottomNavigationView = findViewById(R.id.bottomNavigationView_subordinate);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        presenter.onLoadAnimal(animalId);

    }



    /**
     * Navigation menu on the bottom of the screen
     */

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

    @Override
    public void setName(String name) {
        this.name=name;
        ((TextView)findViewById(R.id.animalNameDetails)).setText(name);
    }

    @Override
    public void setType(String type) {
        this.type=type;
        ((TextView)findViewById(R.id.typeDetails)).setText(type);
    }

    @Override
    public void setBreed(String breed) {
        this.breed=breed;
        ((TextView)findViewById(R.id.breedDetails)).setText(breed);
    }

    @Override
    public void setAge(String age) {
        this.age=age;
        ((TextView)findViewById(R.id.ageDetails)).setText(age);
    }

    @Override
    public void setGender(String gender) {
        this.gender=gender;
        ((TextView)findViewById(R.id.genderDetails)).setText(gender);
    }

    @Override
    public void setChipped(String chipped) {
        this.chipped=chipped;
        ((TextView)findViewById(R.id.chippedDetails)).setText(chipped);
    }

    @Override
    public void setDescription(String description) {
        this.description=description;
        ((TextView)findViewById(R.id.descriptionDetails)).setText(description);
    }

    @Override
    public void setImage(String image) {

        Bitmap bitmap = null;
        try {
            FileInputStream fis = openFileInput(image);
            bitmap = BitmapFactory.decodeStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }

    }

    @Override
    public void setAnimalId(int i) {
        animalId=i;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getAge() {
        return age;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getChipped() {
        return chipped;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getAnimalId() {
        return animalId;
    }

    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * home then the user goes to the HomePage
     */

    public void viewHomePage(){
        Intent intent = new Intent(getApplicationContext(), SubordinateHomePageActivity.class);
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
