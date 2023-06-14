package gr.aueb.animalshelter.View.Animals.AddEditAnimals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.animalshelter.MemoryDAO.AnimalDAOMemory;
import gr.aueb.animalshelter.MemoryDAO.FeedingScheduleDAOMemory;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.domain.FeedingSchedule;

/** Activity for the addition and edit of an animal
 * @author Komnas Kafasis
 */

public class AddEditAnimalsActivity extends AppCompatActivity implements AddEditAnimalsView {
    ArrayList<String> feedingSchedules =null ;
    private ArrayAdapter<String> adapterFeedingSchedules=null;
    private AutoCompleteTextView autoCompleteTextViewFeedingSchedules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_animals);

        setPageName("Add/Edit animals");

        final AddEditAnimalsPresenter presenter = new AddEditAnimalsPresenter(this, new AnimalDAOMemory(),new FeedingScheduleDAOMemory());

        //search bar feeding schedules
        presenter.onLoadBarFeedingSchedules();
        autoCompleteTextViewFeedingSchedules=findViewById(R.id.autoCompleteTextViewSelectFeedingSchedule);
        adapterFeedingSchedules=new ArrayAdapter<String>(this,R.layout.type_item,feedingSchedules);
        autoCompleteTextViewFeedingSchedules.setAdapter(adapterFeedingSchedules);

        // listener for submit button
        findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                presenter.onSaveAnimal();
            }
        });

    }

    @Override
    public void loadFeedingSchedules(List<String> input) {

        feedingSchedules.clear();
        feedingSchedules.addAll(input);


    }

    @Override
    public Integer getAttachedAnimalID() {
        return this.getIntent().hasExtra("animal_id") ? this.getIntent().getExtras().getInt("animal_id") : null;
    }

    @Override
    public String getName() {
        return ((EditText)findViewById(R.id.editName)).getText().toString().trim();
    }

    @Override
    public String getType() {

        return ((EditText)findViewById(R.id.editType)).getText().toString().trim();
    }

    @Override
    public String getBreed() {
        return ((EditText)findViewById(R.id.editBreed)).getText().toString().trim();
    }

    @Override
    public Integer getAge() {
        return Integer.parseInt(((EditText)findViewById(R.id.editAge)).getText().toString());
    }

    @Override
    public boolean getChipped() {
        return ((CheckBox)findViewById(R.id.chipped)).isChecked();
    }

    @Override
    public String getDescription() {
        return ((EditText)findViewById(R.id.editDescription)).getText().toString();
    }

    @Override
    public String getGender() {
        return ((EditText)findViewById(R.id.editGender)).getText().toString().trim();
    }



    @Override
    public void setName(String name) {
        ((EditText)findViewById(R.id.editName)).setText(name);
    }

    @Override
    public void setType(String type) {
        ((EditText)findViewById(R.id.editType)).setText(type);
    }

    @Override
    public void setBreed(String breed) {
        ((EditText)findViewById(R.id.editBreed)).setText(breed);
    }

    @Override
    public void setAge(int age) {
        ((EditText)findViewById(R.id.editAge)).setText(age);
    }

    @Override
    public void setDescription(String description) {
        ((EditText)findViewById(R.id.editDescription)).setText(description);
    }

    @Override
    public void setChipped(Boolean chipped) {
        ((CheckBox)findViewById(R.id.chipped)).setChecked(chipped);
    }

    @Override
    public void setGender(String gender) {
        ((EditText)findViewById(R.id.editGender)).setText(gender);
    }

    @Override
    public FeedingSchedule getFeedingSchedule() {
        String namePlusID = ((AutoCompleteTextView)findViewById(R.id.autoCompleteTextViewSelectFeedingSchedule)).getText().toString().trim();
        int id = Integer.parseInt(namePlusID.substring(namePlusID.indexOf("#")+1));
        FeedingSchedule feedingSchedule = new FeedingScheduleDAOMemory().find(id);
        return feedingSchedule;
    }
    @Override
    public void setFeedingSchedule(FeedingSchedule feedingSchedule) {
        ((AutoCompleteTextView)findViewById(R.id.autoCompleteTextViewSelectFeedingSchedule)).setText(feedingSchedule.getName()+feedingSchedule.getID());
    }

    public void setPageName(String value)
    {
        getSupportActionBar().setTitle(value);
    }

    @Override
    public void successfullyFinishActivity(String message)
    {
        Intent retData = new Intent();
        retData.putExtra("message_to_toast", message);
        setResult(RESULT_OK, retData);
        finish();
    }


    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(AddEditAnimalsActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }
}