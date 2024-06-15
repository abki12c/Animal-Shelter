package gr.aueb.animalshelter.View.WelcomePage;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gr.aueb.animalshelter.MemoryDAO.FeedingScheduleDAOMemory;
import gr.aueb.animalshelter.MemoryDAO.MemoryInitializer;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.LoginPage.LoginPageActivity;

public class WelcomePageActivity extends AppCompatActivity {


    Button wbtn;
    private static boolean initialized = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        wbtn = (Button) findViewById(R.id.welcomeBtn);
        if(!initialized)
        {
            new MemoryInitializer(getApplicationContext()).prepareData();
            initialized = true;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        wbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //change to login activity
                Intent intent = new Intent(getApplicationContext() , LoginPageActivity.class);
                startActivity(intent);
            }
        });
    }
}