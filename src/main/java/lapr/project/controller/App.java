package lapr.project.controller;
import lapr.project.model.Company;


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

    private App(){
        company = new Company();
    }

    /**
     * Allows the user to get the instance of the running App.
     * @return the instance of the running App
     */

    public Company getCompany(){
        return company;
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
