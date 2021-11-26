package lapr.project.data;

/**
 * @author Francisco Redol <1201239@isep.ipp.pt>
 */
public interface Persistable {
    /**
     * Save an objet to the database.
     *
     * @param databaseConnection the database connection
     * @param object the object that is going to be saved
     * @return the success of the operation
     */
    boolean saveShip(DatabaseConnection databaseConnection, Object object);

    /**
     * @param databaseConnection the database connection
     * @param object the object that is going to be saved
     * @return the success of the operation
     */
    boolean savePosition(DatabaseConnection databaseConnection, Object object);

    /**
     * @param databaseConnection the database connection
     * @param object the object that is going to be saved
     * @return the success of the operation
     */
    boolean savePort(DatabaseConnection databaseConnection, Object object);
}
