package gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest.AdoptionRequestInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import gr.aueb.animalshelter.MemoryDAO.AdoptionRequestDAOMemory;
import gr.aueb.animalshelter.MemoryDAO.AnimalDAOMemory;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.Adopter.AdopterHome.AdopterHomeActivity;
import gr.aueb.animalshelter.View.Adopter.AdopterSettings.ManageProfileActivity;
import gr.aueb.animalshelter.View.Animals.ShowAnimals.SearchAnimalsActivity;

public class AdoptionRequestInfoActivity extends AppCompatActivity implements AdoptionRequestInfoView,BottomNavigationView .OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    Button submit;
    int animalId;
    AdoptionRequestInfoPresenter presenter = new AdoptionRequestInfoPresenter(this, new AdoptionRequestDAOMemory(), new AnimalDAOMemory());
    /**
     * Displays a layout with an application form
     * for an adoption request for animal chosen in
     * previous activity
     * @param savedInstanceState Instance State
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.animalId = getIntent().getIntExtra("animal",0);

        presenter = new AdoptionRequestInfoPresenter(this, new AdoptionRequestDAOMemory(), new AnimalDAOMemory());

        setContentView(R.layout.activity_adoption_request_info);



        submit = (Button) findViewById(R.id.buttonSubmit);


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.pet);

    }
    /**
     * listens to button to submit the adoption application
     * form
     */

    @Override
    protected void onStart() {
        super.onStart();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onSaveAdoptionRequest();

            }
        });
    }

    /**
     * getters for the information
     * inputted by the user
     */


    public int getAnimalId()
    {
        return animalId;
    }

    public String getName()
    {
        return ((EditText)findViewById(R.id.inputName)).getText().toString().trim();
    }

    public String getSurname()
    {
        return ((EditText)findViewById(R.id.inputLastName)).getText().toString().trim();
    }

    public String getEmail()
    {
        return ((EditText)findViewById(R.id.inputEmail)).getText().toString().trim();
    }

    public String getPhone()
    {
        return ((EditText)findViewById(R.id.inputnumber)).getText().toString().trim();
    }

    public String getStreet()
    {
        return ((EditText)findViewById(R.id.inputstreet)).getText().toString().trim();
    }

    public String getStreetNumber()
    {
        return ((EditText)findViewById(R.id.inputStrNo)).getText().toString().trim();
    }

    public String getTK()
    {
        return ((EditText)findViewById(R.id.inputTk)).getText().toString().trim();
    }

    public String getTown()
    {
        return ((EditText)findViewById(R.id.inputTown)).getText().toString().trim();
    }

    public String getComments()
    {
        return ((EditText)findViewById(R.id.inputComments)).getText().toString().trim();
    }

    /**
     * setters for the information
     * inputted by the tests
     */
    public void setAnimalId(int id)
    {
        animalId=id;
    }

    public void setName(String s)
    {
        ((EditText)findViewById(R.id.inputName)).setText(s);
    }

    public void setSurname(String s)
    {
        ((EditText)findViewById(R.id.inputLastName)).setText(s);
    }

    public void setEmail(String s)
    {
        ((EditText)findViewById(R.id.inputEmail)).setText(s);
    }

    public void setPhone(String s)
    {
        ((EditText)findViewById(R.id.inputnumber)).setText(s);
    }

    public void setStreet(String s)
    {
        ((EditText)findViewById(R.id.inputstreet)).setText(s);
    }

    public void setStreetNumber(String s)
    {
        ((EditText)findViewById(R.id.inputStrNo)).setText(s);
    }

    public void setTK(String s)
    {
       ((EditText)findViewById(R.id.inputTk)).setText(s);
    }

    public void setTown(String s)
    {
        ((EditText)findViewById(R.id.inputTown)).setText(s);
    }

    public void setComments(String s)
    {
        ((EditText)findViewById(R.id.inputComments)).setText(s);
    }

    /**
     * Shows message of type Alert
     * @param title The title of the alert
     * @param s The contents of the alert
     */

    public void showErrorMessage(String title,String s){
        new AlertDialog.Builder(AdoptionRequestInfoActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(s)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    /**
     * Message that shows up when the activity finishes succesfully
     * @param s The message which will be displayed
     */
    public void successfullyFinishActivity(String s){
        Toast.makeText(AdoptionRequestInfoActivity.this,s,Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }




    /**
     * Navigation menu on the bottom of the screen
     */


    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item) {

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
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * adopt a friend then the user goes to the Add Adoption Request page
     */

    @Override
    public void createAdoptionRequest() {
        //
    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * settings then the user goes to the Manage Profile Page
     */

    @Override
    public void manageProfile() {
        Intent intent = new Intent(this, ManageProfileActivity.class);
        startActivity(intent);
    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * home then the user goes to the HomePage
     */


    @Override
    public void viewHomePage() {
        Intent intent = new Intent(this, AdopterHomeActivity.class);
        startActivity(intent);

    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * search then the user goes to the Search Animals Page
     */
    public void search(){
        Intent intent = new Intent(AdoptionRequestInfoActivity.this, SearchAnimalsActivity.class);
        startActivity(intent);
    }
}