package gr.aueb.animalshelter.View.LoginPage.EmployeeLogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import gr.aueb.animalshelter.MemoryDAO.AccountDaoMemory;
import gr.aueb.animalshelter.MemoryDAO.EmployeeDaoMemory;
import gr.aueb.animalshelter.R;
import gr.aueb.animalshelter.View.Employer.Home.EmployerHomePageActivity;
import gr.aueb.animalshelter.View.Subordinate.SubordinateHomePage.SubordinateHomePageActivity;

public class EmployeeLoginActivity extends AppCompatActivity implements EmployeeLoginView{
    Button btn;

   EmployeeLoginPresenter presenter = new EmployeeLoginPresenter(this, new EmployeeDaoMemory());;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);
        btn = (Button) findViewById(R.id.button);

    }
    @Override
    protected void onStart() {
        super.onStart();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClick();
            }
        });
    }

    public void subordinateLogin()
    {
        // find account id
        int accountId =new AccountDaoMemory().findID(getUsername(),getPassword());

        Intent intent = new Intent(getApplicationContext() , SubordinateHomePageActivity.class);
        intent.putExtra("Account_id",Integer.toString(accountId));
        startActivity(intent);

    }
    public void bossLogin()
    {
        Intent intent = new Intent(getApplicationContext() , EmployerHomePageActivity.class);
        startActivity(intent);

    }

    public void setUsername(String s)
    {
        ((EditText)findViewById(R.id.username)).setText(s);
    }

    public void setPassword(String s)
    {
        ((EditText)findViewById(R.id.password)).setText(s);
    }

    public String getUsername()
    {
        return ((EditText)findViewById(R.id.username)).getText().toString().trim();
    }

    public String getPassword()
    {
        return ((EditText)findViewById(R.id.password)).getText().toString().trim();
    }


    public void showErrorMessage(String title,String s){
        new AlertDialog.Builder(EmployeeLoginActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(s)
                .setPositiveButton(R.string.ok, null).create().show();
    }
}
