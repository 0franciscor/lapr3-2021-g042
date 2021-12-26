package lapr.project.data;

import lapr.project.controller.App;
import lapr.project.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for converting the Database info into Java Domain Objects
 * Francisco Redol <1201239@isep.ipp.pt>
 */
public class TransferFromDataBase {

    /**
     * The database connection
     */
    DatabaseConnection databaseConnection;

    /**
     * The class Constructor
     */
    public TransferFromDataBase() {
        this.databaseConnection = App.getInstance().getDatabaseConnection();
    }

    /**
     * Invokes the methods responsible for the conversion of ships and ship Positions.
     */
    public void importShips() {
        try {
            importShipFromDatabase(databaseConnection);
        } catch (Exception e) {
            System.out.println("Error when importing data from the database.");
        }
    }

    /**
     * Invokes the methods responsible for the conversion of Ports.
     */
    public void importPorts() {
        try {
            importPortFromDatabase(databaseConnection);
        } catch (Exception e) {
            System.out.println("Error when importing data from the database.");
        }
    }

    /**
     * Fetches the existent seadists from the database
     *
     * @return a list of seadists from the database
     */
    public List<Seadist> importSeadist() {
        List<Seadist> seadistlst = new ArrayList<>();
        try {
            seadistlst = importSeadistsFromDataBase(databaseConnection);
        } catch (Exception e) {
            System.out.println("Error when importing data from the database.");
        }

        return seadistlst;
    }

    /**
     * Fetches the existent Borders from the database
     *
     * @return a list of borders from the database
     */
    public List<Border> importBorder(){
        List<Border> borderLst = new ArrayList<>();
        try {
            borderLst = importBordersFromDataBase(databaseConnection);
        } catch (Exception e) {
            System.out.println("Error when importing data from the database.");
        }

        return borderLst;
    }

    /**
     * Fetches the existent Capitals from the database
     *
     * @return a list of Capitals from the database
     */
    public List<Capital> importCapital(){
        List<Capital> capitalLst = new ArrayList<>();
        try {
            capitalLst = importCapitalsFromDataBase(databaseConnection);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error when importing data from the database.");
        }

        return capitalLst;
    }

    /**
     * Retrieves a ship from the database to the ship tree.
     *
     * @param databaseConnection to the database
     * @throws SQLException in case an error with the database occurs
     */
    private void importShipFromDatabase(DatabaseConnection databaseConnection)
            throws SQLException {

        Connection connection = databaseConnection.getConnection();

        boolean isShipOnDatabase;

        String sqlCommand = "select * from ship";

        PreparedStatement getShipsPreparedStatement =
                connection.prepareStatement(sqlCommand);

        try (ResultSet shipsResultSet = getShipsPreparedStatement.executeQuery()) {

            isShipOnDatabase = shipsResultSet.next();

            while (isShipOnDatabase) {
                Ship newShip = new Ship();

                newShip.setMMSI(shipsResultSet.getNString(1));
                newShip.setShipID(shipsResultSet.getNString(2));
                newShip.setNumberGenerators(shipsResultSet.getInt(3));
                newShip.setGeneratorOutput(shipsResultSet.getFloat(4));
                newShip.setCallSign(shipsResultSet.getNString(5));
                newShip.setDraft(shipsResultSet.getFloat(6));
                newShip.setName(shipsResultSet.getNString(7));
                newShip.setVesselType(shipsResultSet.getInt(8));
                newShip.setLength(shipsResultSet.getFloat(9));
                newShip.setWidth(shipsResultSet.getFloat(10));
                newShip.setCargo(shipsResultSet.getNString(11));
                newShip.setCapacity();

                importPositionFromDatabase(databaseConnection, newShip);

                App.getInstance().getCompany().getBstShip().insert(newShip);
                isShipOnDatabase = shipsResultSet.next();
            }
            shipsResultSet.close();

        } finally {
            getShipsPreparedStatement.close();
        }
    }

    /**
     * Imports all the positions from a certain ship from the database.
     *
     * @param databaseConnection connection to the database
     * @param ship               which contains the MMSI code which matches the Locations
     * @throws SQLException that may occur from the database
     */
    private void importPositionFromDatabase(DatabaseConnection databaseConnection, Ship ship)
            throws SQLException {

        Connection connection = databaseConnection.getConnection();

        boolean isPositionOnDatabase;

        String sqlCommand = "select * from shipLocation where shipMmsiCode = ?";

        PreparedStatement getPositionPreparedStatement =
                connection.prepareStatement(sqlCommand);

        getPositionPreparedStatement.setString(1, ship.getMMSI());

        try (ResultSet positionResultSet = getPositionPreparedStatement.executeQuery()) {
            isPositionOnDatabase = positionResultSet.next();
            while (isPositionOnDatabase) {
                ShipLocation shipLocation = new ShipLocation();

                shipLocation.setMMSI(positionResultSet.getNString(1));
                shipLocation.setMessageTime(positionResultSet.getDate(2));
                shipLocation.setLatitude(positionResultSet.getNString(3));
                shipLocation.setLongitude(positionResultSet.getNString(4));
                shipLocation.setSOG(positionResultSet.getFloat(5));
                shipLocation.setCOG(positionResultSet.getFloat(6));
                shipLocation.setHeading(positionResultSet.getNString(7));
                shipLocation.setPosition(positionResultSet.getNString(8));
                shipLocation.setTransceiverClass(positionResultSet.getNString(9));

                ship.getShipPosition().insert(shipLocation);
                isPositionOnDatabase = positionResultSet.next();
            }

            positionResultSet.close();
        } finally {
            getPositionPreparedStatement.close();
        }
    }

    /**
     * Imports all rows within the Port table on the database
     *
     * @param databaseConnection to the database
     * @throws SQLException that may occur within the database communication
     */
    private void importPortFromDatabase(DatabaseConnection databaseConnection) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        boolean isPortOnDatabase;

        String sqlCommand = "select * from ports";

        PreparedStatement getPortsPreparedStatement =
                connection.prepareStatement(sqlCommand);

        try (ResultSet shipsResultSet = getPortsPreparedStatement.executeQuery()) {

            isPortOnDatabase = shipsResultSet.next();

            while (isPortOnDatabase) {
                int code = shipsResultSet.getInt(1);
                String portName = shipsResultSet.getNString(2);
                double latitude = Double.parseDouble(shipsResultSet.getNString(3));
                double longitude = Double.parseDouble(shipsResultSet.getNString(4));
                PlaceLocation placeLocation = new PlaceLocation(latitude, longitude);

                Country country = importCountryFromDatabase(databaseConnection, placeLocation);

                Ports port = new Ports(country, code, portName, placeLocation);

                App.getInstance().getCompany().getPortStr().getPortsLst().add(port);
                isPortOnDatabase = shipsResultSet.next();
            }
            shipsResultSet.close();

        } finally {
            getPortsPreparedStatement.close();
        }
    }

    /**
     * Method which has the responsibility of retrieving the matching Country of a port.
     *
     * @param databaseConnection to the database
     * @param placeLocation      of a port
     * @return the country correspondent to a certain Port
     * @throws SQLException that may occur within the database
     */
    private Country importCountryFromDatabase(DatabaseConnection databaseConnection, PlaceLocation placeLocation) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        Country country;

        String sqlCommand = "select countryName from PlaceLocation where latitude = ? and longitude = ?";

        PreparedStatement getCountriesPreparedStatement =
                connection.prepareStatement(sqlCommand);

        getCountriesPreparedStatement.setString(1, String.format("%.2f", placeLocation.getLatitude()));
        getCountriesPreparedStatement.setString(2, String.format("%.2f", placeLocation.getLongitude()));

        try (ResultSet shipsResultSet = getCountriesPreparedStatement.executeQuery()) {

            String countryName = shipsResultSet.getNString(1);

            sqlCommand = "select * from Country where countryName = ?";
            getCountriesPreparedStatement = connection.prepareStatement(sqlCommand);
            getCountriesPreparedStatement.setString(1, countryName);


            try (ResultSet countryResultSet = getCountriesPreparedStatement.executeQuery()) {
                countryResultSet.next();
                String continent = countryResultSet.getNString(2);
                country = new Country(continent, countryName);
                countryResultSet.close();
            }
            shipsResultSet.close();

        } finally {
            getCountriesPreparedStatement.close();
        }
        return country;
    }

    /**
     * Method responsible for returning a list of seadists from the database.
     *
     * @param databaseConnection to the database
     * @return a list of seadists to be used on US301
     * @throws SQLException that may occur within the connection to the database
     */
    private List<Seadist> importSeadistsFromDataBase(DatabaseConnection databaseConnection)
            throws SQLException {
        List<Seadist> seadistsLst = new ArrayList<>();

        boolean isThereSeadistonDataBase;

        String sqlCommand = "select * from Seadist";

        PreparedStatement getSeadistPreparedStatement = databaseConnection.getConnection().prepareStatement(sqlCommand);

        try (ResultSet seadistResultSet = getSeadistPreparedStatement.executeQuery()) {
            isThereSeadistonDataBase = seadistResultSet.next();

            while (isThereSeadistonDataBase) {
                int portsid1 = seadistResultSet.getInt(1);
                int portsid2 = seadistResultSet.getInt(2);
                float seaDistance = seadistResultSet.getFloat(3);
                String portName1 = seadistResultSet.getNString(4);
                String portName2 = seadistResultSet.getNString(5);
                String countryName1 = seadistResultSet.getNString(6);
                String countryName2 = seadistResultSet.getNString(7);

                Seadist seadist = new Seadist(portsid1, portsid2, seaDistance, portName1, portName2, countryName1, countryName2);
                seadistsLst.add(seadist);

                isThereSeadistonDataBase = seadistResultSet.next();
            }
            seadistResultSet.close();
        } finally {
            getSeadistPreparedStatement.close();
        }
        return seadistsLst;
    }

    /**
     * Method responsible for returning a list of Borders from the database.
     *
     * @param databaseConnection to the database
     * @return a list of Borders to be used on US301
     * @throws SQLException that may occur within the connection to the database
     */
    private List<Border> importBordersFromDataBase(DatabaseConnection databaseConnection)
            throws SQLException {
        List<Border> bordersLst = new ArrayList<>();

        boolean isThereBorderonDataBase;

        String sqlCommand = "select * from Border";

        PreparedStatement getBorderPreparedStatement = databaseConnection.getConnection().prepareStatement(sqlCommand);

        try (ResultSet borderResultSet = getBorderPreparedStatement.executeQuery()) {
            isThereBorderonDataBase = borderResultSet.next();

            while (isThereBorderonDataBase) {
                String countryName1 = borderResultSet.getNString(1);
                String countryName2 = borderResultSet.getNString(2);

                bordersLst.add(new Border(countryName1, countryName2));

                isThereBorderonDataBase = borderResultSet.next();
            }
            borderResultSet.close();
        } finally {
            getBorderPreparedStatement.close();
        }
        return bordersLst;
    }

    /**
     * Method responsible for returning a list of Capitals from the database.
     *
     * @param databaseConnection to the database
     * @return a list of Capitals to be used on US301
     * @throws SQLException that may occur within the connection to the database
     */
    private List<Capital> importCapitalsFromDataBase(DatabaseConnection databaseConnection)
            throws SQLException {
        List<Capital> capitalLst = new ArrayList<>();

        boolean isThereCapitalonDataBase;

        String sqlCommand = "select * from Capital";

        PreparedStatement getCapitalPreparedStatement = databaseConnection.getConnection().prepareStatement(sqlCommand);

        try (ResultSet capitalResultSet = getCapitalPreparedStatement.executeQuery()) {
            isThereCapitalonDataBase = capitalResultSet.next();

            while (isThereCapitalonDataBase) {
                String name = capitalResultSet.getNString(1);
                String countryName = capitalResultSet.getNString(2);
                String latitude = capitalResultSet.getNString(3).replace(",", ".");
                String longitude = capitalResultSet.getNString(4).replace(",", ".");

                capitalLst.add(new Capital(name, countryName, latitude, longitude));

                isThereCapitalonDataBase = capitalResultSet.next();
            }
            capitalResultSet.close();
        } finally {

            getCapitalPreparedStatement.close();
        }
        return capitalLst;
    }

}