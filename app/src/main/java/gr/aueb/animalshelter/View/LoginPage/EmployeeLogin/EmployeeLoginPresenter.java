package gr.aueb.animalshelter.View.LoginPage.EmployeeLogin;

import gr.aueb.animalshelter.DAO.EmployeeDao;
public class EmployeeLoginPresenter {
    private EmployeeDao employees;
    private EmployeeLoginView view;



    public EmployeeLoginPresenter(EmployeeLoginView view, EmployeeDao employees) {
        this.view = view;
        this.employees=employees;


    }


    public void onClick(){
        String username = view.getUsername();
        String password = view.getPassword();

        if(username.equals("admin")&& employees.validate(username,password)){
            view.bossLogin();
        } else if (employees.validate(username,password)) {
            view.subordinateLogin();
        }else{
            view.showErrorMessage("Error","Wrong credentials");
        }
    }
}
