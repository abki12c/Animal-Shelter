package gr.aueb.animalshelter.View.LoginPage.EmployeeLogin;

public interface EmployeeLoginView {



    public void subordinateLogin();

    public void bossLogin();
    public void setUsername(String s);
    public void setPassword(String s);
    public String getUsername();
    public String getPassword();
    void showErrorMessage(String title,String s);

}
