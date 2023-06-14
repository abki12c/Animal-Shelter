package gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.animalshelter.MemoryDAO.AnimalDAOMemory;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.Utils.MyAdapter;
import gr.aueb.animalshelter.View.Adopter.AdopterHome.AdopterHomeActivity;
import gr.aueb.animalshelter.View.Adopter.AdopterSettings.ManageProfileActivity;
import gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest.AdoptionRequestInfo.AdoptionRequestInfoActivity;
import gr.aueb.animalshelter.View.Animals.AnimalDetails.AnimalDetailsActivity;
import gr.aueb.animalshelter.View.Animals.ShowAnimals.SearchAnimalsActivity;
import gr.aueb.animalshelter.domain.Animal;

public class AddAdoptionRequestActivity extends AppCompatActivity implements AddAdoptionRequestView, BottomNavigationView .OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    ArrayList<String> animaltypes =null ;
    ArrayList<String> animalbreeds =null ;
    private AutoCompleteTextView autoCompleteTextViewType,autoCompleteTextViewBreed;
    private ArrayAdapter<String> adapterTypes=null;
    private ArrayAdapter<String> adapterBreeds=null;
    Animal a;
    String category="All";
    String lookingfor="All";
    String lookingforType="All";
    GridView grid;
    MyAdapter adapter;
    AddAdoptionRequestPresenter presenter= new AddAdoptionRequestPresenter(this,new AnimalDAOMemory()) ;
    /**
     * Displays the animals in a layout with a search function
     * so that the user can choose the animal they want to adopt
     * @param savedInstanceState Instance State
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_adoption_request);
        animaltypes=new ArrayList<String>();
        animalbreeds=new ArrayList<String>();


        bottomNavigationView = findViewById(R.id.bottomNavigationViewPet);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.pet);



        presenter.onLoadBarTypes();

        //search bar types

        autoCompleteTextViewType=findViewById(R.id.auto_complete1);
        adapterTypes=new ArrayAdapter<String>(this,R.layout.type_item,animaltypes);
        autoCompleteTextViewType.setAdapter(adapterTypes);

        //search bar breeds
        presenter.onLoadBarBreeds();
        autoCompleteTextViewBreed=findViewById(R.id.auto_complete2);
        adapterBreeds=new ArrayAdapter<String>(this,R.layout.type_item,animalbreeds);
        autoCompleteTextViewBreed.setAdapter(adapterBreeds);


        //grid of animals
        grid = findViewById(R.id.grid_view);
        adapter=new MyAdapter(this,false);
        presenter.onLoadSource();

        grid.setAdapter(adapter);


        //listener for search bar

        //listener for search bar type
        autoCompleteTextViewType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String item= adapterView.getItemAtPosition(position).toString();

                setCategory("Type");
                setLookingFor(item);
                setLookingForType(item);
                presenter.onLoadSource();
            }
        });

        autoCompleteTextViewBreed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String item= adapterView.getItemAtPosition(position).toString();
                setCategory("Breed");
                setLookingFor(item);
                presenter.onLoadSource();
            }
        });

        //listener for choosing animal
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(view.getId() == R.id.buttonMoreInfo) {
                    presenter.onClickButton((Animal) parent.getItemAtPosition(position));
                }else {
                    presenter.onClickItem((Animal) parent.getItemAtPosition(position));
                }
            }
        });

    }


    /**
     * Getters
     */
    public Animal getAnimal() {
        return this.a;
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public String getLookingfor() {
        return this.lookingfor;
    }
    public String getLookingforType() {
        return this.lookingforType;
    }

    /**
     * Setters
     */
    public void setCategory(String category){
        this.category=category;
    }
    public void setLookingFor(String lookingfor){
        this.lookingfor=lookingfor;
    }
    public void setLookingForType(String lookingfor){
        this.lookingforType=lookingfor;
    }



    /**
     * Goes to Animal Details activity to display more
     * information for the chosen animal
     * @param a the animal chosen
     */
    public void moreInfo(Animal a)
    {
        Intent intent = new Intent(this, AnimalDetailsActivity.class);
        intent.putExtra("animal", a.getId());
        startActivity(intent);

    }
    /**
     * Goes to the application form page
     * to move to the next step of the adoption request
     * process
     * @param a the animal chosen for the adoption request
     */

    //on choose animal
    public void enterInfo(Animal a) {
        Intent intent = new Intent(this, AdoptionRequestInfoActivity.class);
        intent.putExtra("animal", a.getId());
        startActivity(intent);
    }


    /**
     * loads the grid with a given list of animals
     * @param input list of animals
     */
    @Override
    public void loadSource(List<Animal> input) {
        adapter.loadSource(input);
    }
    /**
     * loads the bar that contains the animal types with a given list of types
     * @param input list of types
     */
    public void loadTypes(List<String> input) {
        animaltypes.clear();
        animaltypes.add("All");
        animaltypes.addAll(input);

    }
    /**
     * loads the bar that contains the animal breeds with a given list of breeds
     * @param input list of types
     */

    public void loadBreeds(List<String> input) {
        animalbreeds.clear();
        animalbreeds.add("All");
        animalbreeds.addAll(input);

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
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * adopt a friend then the user goes to the Add Adoption Request page
     */
    public void createAdoptionRequest(){
        //do nothing, already in activity

    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * home then the user goes to the HomePage
     */

    public void viewHomePage(){
        Intent intent = new Intent(AddAdoptionRequestActivity.this, AdopterHomeActivity.class);
        startActivity(intent);
    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * settings then the user goes to the Manage Profile Page
     */
    public void manageProfile(){
        Intent intent = new Intent(AddAdoptionRequestActivity.this, ManageProfileActivity.class);
        startActivity(intent);
    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * search then the user goes to the Search Animals Page
     */
    public void search(){
        Intent intent = new Intent(AddAdoptionRequestActivity.this, SearchAnimalsActivity.class);
        startActivity(intent);
    }


}





