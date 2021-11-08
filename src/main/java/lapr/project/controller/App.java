package lapr.project.controller;

import auth.AuthFacade;
import auth.UserSession;
import lapr.project.model.Company;
import lapr.project.shared.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a app.
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class App {

    /**
     * Represents a instance of company.
     */
    private Company company;
    private AuthFacade authFacade;

    private App(){
        company = new Company();
        this.authFacade = this.company.getAuthFacade();
        bootstrap();
    }

    /**
     * Allows the user to get the instance of the running App.
     * @return the instance of the running App
     */

    public Company getCompany(){
        return company;
    }


    private void bootstrap()
    {
        this.authFacade.addUserRole(Constants.ROLE_HR,Constants.ROLE_HR);
        this.authFacade.addUserRole(Constants.ROLE_TM, Constants.ROLE_TM);

        this.authFacade.addUserWithRole("Human Resources", "hr@ships.pt", "123456", Constants.ROLE_HR);
        this.authFacade.addUserWithRole("Traffic Manager", "tm@ships.pt", "654321",Constants.ROLE_TM);

    }
    public boolean doLogin(String email, String pwd)
    {
        return this.authFacade.doLogin(email,pwd).isLoggedIn();
    }

    public void doLogout()
    {
        this.authFacade.doLogout();
    }

    public UserSession getCurrentUserSession()
    {
        return this.authFacade.getCurrentUserSession();
    }

    //############# Singleton #############
    private static App singleton = null;

    public static App getInstance() {
        if (singleton == null) {
            synchronized (App.class) {
                singleton = new App();
            }
        }

        return singleton;
    }
}
