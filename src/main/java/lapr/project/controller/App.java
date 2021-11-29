package lapr.project.controller;

import lapr.project.data.ConnectionFactory;
import lapr.project.data.DatabaseConnection;
import lapr.project.model.Company;

import java.io.IOException;

/**
 * Class that represents a app.
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 * @author Francisco Redol <1201239@isep.ipp.pt>
 */
public class App {

    /**
     * Represents a instance of company.
     */
    private final Company company;

    /**
     * Represents the App's connection to the database
     */
    private final DatabaseConnection databaseConnection;

    private App(){
        company = new Company();
        this.databaseConnection = initializeConnection();
    }

    /**
     * Allows the user to get the instance of the running App's company.
     * @return the instance of the running App company
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

    /**
     * Method responsible for initializing the database connection.
     * @return the database connection
     */
    private DatabaseConnection initializeConnection(){
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = ConnectionFactory.getInstance()
                    .getDatabaseConnection();
        } catch (IOException exception) {
            System.out.println("There was an error when initializing the database connection.");
        }
        return databaseConnection;
    }

    /**
     * Allows the user to get the instance of the running App's database connection.
     * @return the App's database connection
     */
    public DatabaseConnection getDatabaseConnection(){
        return databaseConnection;
    }
}
