package gr.aueb.animalshelter.View.Animals.AnimalDetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import gr.aueb.animalshelter.MemoryDAO.AnimalDAOMemory;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.Adopter.AdopterHome.AdopterHomeActivity;
import gr.aueb.animalshelter.View.Adopter.AdopterSettings.ManageProfileActivity;
import gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest.AddAdoptionRequestActivity;
import gr.aueb.animalshelter.View.Animals.ShowAnimals.SearchAnimalsActivity;


public class AnimalDetailsActivity extends AppCompatActivity implements  AnimalDetailsView, BottomNavigationView.OnNavigationItemSelectedListener {

    final AnimalDetailsPresenter presenter = new AnimalDetailsPresenter(this,new AnimalDAOMemory());;
    BottomNavigationView bottomNavigationView;
    private String name,type,breed,age,gender,chipped,description;
    Button back;
    int animalId;
    /**
     * Displays a layout with detailed information for chosen animal
     * @param savedInstanceState Instance State
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);
        this.animalId = getIntent().getIntExtra("animal",0);

        presenter.onLoadAnimal(animalId);


        ImageView imageView = findViewById(R.id.animalPic);
        imageView.setImageResource(R.drawable.ic_pets_foreground);
        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);



        back = findViewById(R.id.back_button);



    }
    /**
     * listens to button to move to previous page
     */

    @Override
    protected void onStart() {
        super.onStart();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
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

    @Override
    public void setName(String name) {
        this.name=name;
        ((TextView)findViewById(R.id.animalName)).setText(name);
    }

    @Override
    public void setType(String type) {
        this.type=type;
        ((TextView)findViewById(R.id.type)).setText(type);
    }

    @Override
    public void setBreed(String breed) {
        this.breed=breed;
        ((TextView)findViewById(R.id.breed)).setText(breed);
    }

    @Override
    public void setAge(String age) {
        this.age=age;
        ((TextView)findViewById(R.id.age)).setText(age);
    }

    @Override
    public void setGender(String gender) {
        this.gender=gender;
        ((TextView)findViewById(R.id.gender)).setText(gender);
    }

    @Override
    public void setChipped(String chipped) {
        this.chipped=chipped;
        ((TextView)findViewById(R.id.chipped)).setText(chipped);
    }

    @Override
    public void setDescription(String description) {
        this.description=description;
        ((TextView)findViewById(R.id.description)).setText(description);
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
     * adopt a friend then the user goes to the Add Adoption Request page
     */
    public void createAdoptionRequest(){
        Intent intent = new Intent(AnimalDetailsActivity.this, AddAdoptionRequestActivity.class);
        startActivity(intent);

    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * home then the user goes to the HomePage
     */

    public void viewHomePage(){
        Intent intent = new Intent(AnimalDetailsActivity.this, AdopterHomeActivity.class);
        startActivity(intent);
    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * settings then the user goes to the Manage Profile Page
     */
    public void manageProfile(){
        Intent intent = new Intent(AnimalDetailsActivity.this, ManageProfileActivity.class);
        startActivity(intent);
    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * search then the user goes to the Search Animals Page
     */
    public void search(){
        Intent intent = new Intent(AnimalDetailsActivity.this, SearchAnimalsActivity.class);
        startActivity(intent);
    }



}
