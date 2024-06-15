package gr.aueb.animalshelter.View.Animals.ShowAnimals;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
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
import gr.aueb.animalshelter.View.Adoption_Request.AddAdoptionRequest.AddAdoptionRequestActivity;
import gr.aueb.animalshelter.domain.Animal;


public class SearchAnimalsActivity extends AppCompatActivity implements SearchAnimalsView, BottomNavigationView.OnNavigationItemSelectedListener {

    private SearchAnimalsPresenter presenter ;
    private ArrayAdapter<String> adapterTypes=null;
    private ArrayAdapter<String> adapterBreeds=null;
    private MyAdapter adapter;
    private GridView grid;
    private ArrayList<String> animaltypes;
    private ArrayList<String> animalbreeds;
    private AutoCompleteTextView autoCompleteTextViewType,autoCompleteTextViewBreed;
    private BottomNavigationView bottomNavigationView;

    private String category="All";
    private String lookingfor="All";

    String lookingforType="All";


    /**
     * Displays a layout with search animal function.
     * The animals are displayed with all their information included
     * @param savedInstanceState Instance State
     */

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        animaltypes=new ArrayList<String>();
        animalbreeds=new ArrayList<String>();
        presenter = new SearchAnimalsPresenter(this, new AnimalDAOMemory());;


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.search);


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
        adapter=new MyAdapter(this,true);
        presenter.onLoadSource();
        grid.setAdapter(adapter);


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

    }





    /**
     * setters
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
     * getters
     */
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
        Intent intent = new Intent(SearchAnimalsActivity.this, AddAdoptionRequestActivity.class);
        startActivity(intent);
    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * home then the user goes to the HomePage
     */
    public void viewHomePage(){
        Intent intent = new Intent(SearchAnimalsActivity.this, AdopterHomeActivity.class);
        startActivity(intent);
    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * settings then the user goes to the Manage Profile Page
     */

    public void manageProfile(){
        Intent intent = new Intent(SearchAnimalsActivity.this, ManageProfileActivity.class);
        startActivity(intent);
    }
    /**
     * when navigation menu on the bottom
     * of the screen is clicked and the choice is
     * search then the user goes to the Search Animals Page
     */
    public void search(){
        //do nothing
    }



}
