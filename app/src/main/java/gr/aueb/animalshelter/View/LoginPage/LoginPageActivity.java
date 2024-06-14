package gr.aueb.animalshelter.View.LoginPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import gr.aueb.animalshelter.MemoryDAO.MemoryInitializer;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.Adopter.AdopterHome.AdopterHomeActivity;
import gr.aueb.animalshelter.View.LoginPage.EmployeeLogin.EmployeeLoginActivity;

public class LoginPageActivity extends AppCompatActivity {
    Button btn;
    Button ebtn;

    Button ebtn_2;

    private static boolean initialized = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        btn = (Button) findViewById(R.id.loginBtn);
        ebtn = (Button) findViewById(R.id.employeeLogin);


        if(!initialized)
        {
            new MemoryInitializer(getApplicationContext()).prepareData();
            initialized = true;
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , AdopterHomeActivity.class);
                startActivity(intent);
            }
        });

        ebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //change to send to employee login activity
                Intent intent = new Intent(getApplicationContext() , EmployeeLoginActivity.class);
                startActivity(intent);
            }
        });



    }
}
