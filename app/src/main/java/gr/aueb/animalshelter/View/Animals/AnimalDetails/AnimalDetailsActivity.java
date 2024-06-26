package gr.aueb.animalshelter.View.Animals.AnimalDetails;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import gr.aueb.animalshelter.MemoryDAO.AnimalDAOMemory;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.Adopter.AdopterHome.AdopterHomeActivity;
import gr.aueb.animalshelter.View.Adopter.AdopterSettings.ManageProfileActivity;
import gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest.AddAdoptionRequestActivity;
import gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest.AdoptionRequestInfo.AdoptionRequestInfoActivity;


public class AnimalDetailsActivity extends AppCompatActivity implements  AnimalDetailsView, BottomNavigationView.OnNavigationItemSelectedListener {

    final AnimalDetailsPresenter presenter = new AnimalDetailsPresenter(this,new AnimalDAOMemory());;
    BottomNavigationView bottomNavigationView;
    ImageView imageView;
    Button adoptBtn;
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

        adoptBtn = findViewById(R.id.adopt_btn);
        imageView = findViewById(R.id.animalPic);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        presenter.onLoadAnimal(animalId);

        adoptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClickBtn(getIntent().getIntExtra("animal",0));
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
     * adopt a friend then the user goes to the Add Adoption Request page
     */
    public void createAdoptionRequest(){
        Intent intent = new Intent(AnimalDetailsActivity.this, AddAdoptionRequestActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);

    }

    /**
     * Goes to the application form page
     * to move to the next step of the adoption request
     * process
     * @param animalId the id of the animal chosen for the adoption request
     */

    @Override
    public void enterInfo(int animalId) {
        Intent intent = new Intent(this, AdoptionRequestInfoActivity.class);
        intent.putExtra("animal",animalId);
        startActivity(intent);
        overridePendingTransition(0,0);
    }

    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * home then the user goes to the HomePage
     */

    public void viewHomePage(){
        Intent intent = new Intent(AnimalDetailsActivity.this, AdopterHomeActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * settings then the user goes to the Manage Profile Page
     */
    public void manageProfile(){
        Intent intent = new Intent(AnimalDetailsActivity.this, ManageProfileActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }


}
