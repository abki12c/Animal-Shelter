package gr.aueb.animalshelter.View.Adopter.AdopterHome;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
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
import java.util.ArrayList;
import gr.aueb.animalshelter.MemoryDAO.AnimalDAOMemory;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.Adopter.AdopterSettings.ManageProfileActivity;
import gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest.AddAdoptionRequestActivity;
public class AdopterHomeActivity extends AppCompatActivity implements AdopterHomeView, BottomNavigationView .OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    Button go;

    private ArrayList<String> animals;
    AdopterHomePresenter presenter;

    /**
     * Creates layout
     * @param savedInstanceState Instance State
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        presenter = new AdopterHomePresenter(this, new AnimalDAOMemory());;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopter_home);



        go = findViewById(R.id.buttonRandom);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

    }
    /**
     * listens to button to display
     * new random animal
     */
    @Override
    protected void onStart() {
        super.onStart();
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onRandom();

            }
        });
    }


    /**
     * displays random animal
     * chosen by the presenter
     * from animals in animalDao
     */

    @Override
    public void showAnimal(String name,String type,String breed,String age,String gender,String chipped,String description,String imageName) {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.animal_details, null);

        ImageView imageView = findViewById(R.id.animalPic);
        Bitmap bitmap = null;
        try {
            FileInputStream fis = getApplicationContext().openFileInput(imageName);
            bitmap = BitmapFactory.decodeStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }


        ((TextView) findViewById(R.id.animalName)).setText(name);
        ((TextView)findViewById(R.id.type)).setText(type);
        ((TextView) findViewById(R.id.breed)).setText(breed);
        ((TextView) findViewById(R.id.age)).setText(age);
        ((TextView) findViewById(R.id.gender)).setText(gender);
        ((TextView) findViewById(R.id.chipped)).setText(chipped);
        ((TextView) findViewById(R.id.description)).setText(description);

    }

    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * adopt a friend then the user goes to the Add Adoption Request page
     */

    public void createAdoptionRequest(){
        Intent intent = new Intent(AdopterHomeActivity.this, AddAdoptionRequestActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);

    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * home then the user goes to the HomePage
     */

    public void viewHomePage(){
        //do nothing already in activity

    }

    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * settings then the user goes to the Manage Profile Page
     */

    public void manageProfile(){
        Intent intent = new Intent(AdopterHomeActivity.this, ManageProfileActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
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

}