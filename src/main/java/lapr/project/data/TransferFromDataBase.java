package lapr.project.data;

import lapr.project.controller.App;
import lapr.project.model.*;
import lapr.project.model.store.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class responsible for converting the Database info into Java Domain Objects
 * @author Francisco Redol <1201239@isep.ipp.pt>
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
            importShipsFromDatabase(databaseConnection);
        } catch (Exception e) {
            System.out.println("Error when importing Ships from the database.");
        }
    }

    /**
     * Invokes the methods responsible for the conversion of Ports.
     */
    public void importPorts() {
        try {
            importPortsFromDatabase(databaseConnection);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error when importing Ports from the database.");
        }
    }

    /**
     * Fetches the existent seadists from the database to the SeadistStore
     */
    public void importSeadists() {
        try{
            importSeadistsFromDataBase(databaseConnection);
        } catch (Exception e) {
            System.out.println("Error when importing Seadists from the database.");
        }
    }

    /**
     * Fetches the existent Borders from the database to the BorderStore
     */
    public void importBorders(){
        try {
            importBordersFromDataBase(databaseConnection);
        } catch (Exception e) {
            System.out.println("Error when importing Borders from the database.");
        }
    }

    /**
     * Fetches the existent Capitals from the database to the CapitalStore
     */
    public void importCapitals(){
        try{
            importCapitalsFromDataBase(databaseConnection);
        } catch (Exception e){
            System.out.println("Error when importing Capitals from the database.");
        }
    }

    /**
     * Fetches the existent Countries from the database to the CountryStore
     */
    public void importCountries(){
        try{
            importCountriesFromDatabase(databaseConnection);
        } catch (Exception e) {
            System.out.println("Error when importing Countries from the database.");
        }
    }

    /**
     * Retrieves a ship from the database to the ship tree.
     *
     * @param databaseConnection to the database
     * @throws SQLException in case an error with the database occurs
     */
    private void importShipsFromDatabase(DatabaseConnection databaseConnection)
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
    private void importPortsFromDatabase(DatabaseConnection databaseConnection) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        boolean isPortOnDatabase;

        PortStore portStore = App.getInstance().getCompany().getPortStr();

        String sqlCommand = "select * from ports";

        PreparedStatement getPortsPreparedStatement =
                connection.prepareStatement(sqlCommand);

        Country country = null;

        try (ResultSet shipsResultSet = getPortsPreparedStatement.executeQuery()) {

            isPortOnDatabase = shipsResultSet.next();

            while (isPortOnDatabase) {
                int code = shipsResultSet.getInt(1);
                String portName = shipsResultSet.getNString(2);

                String latitudeString = shipsResultSet.getNString(3);
                String longitudeString = shipsResultSet.getNString(4);
                double latitude = Double.parseDouble(latitudeString.replace(",", "."));
                double longitude = Double.parseDouble(longitudeString.replace(",", "."));

                PlaceLocation placeLocation = new PlaceLocation(latitude, longitude);

                country = importCountryForPort(databaseConnection, latitudeString, longitudeString);

                Ports port = portStore.createPort(country, code, portName, placeLocation);

                portStore.savePort(port);
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
     * @param latitude of a port
     * @param longitude of a port
     * @return country that identifies a port
     * @throws SQLException that may occur within the database
     */
    private Country importCountryForPort(DatabaseConnection databaseConnection, String latitude, String longitude) throws SQLException {
        Connection connection = databaseConnection.getConnection();

        Country country = null;

        CountryStore countryStore = App.getInstance().getCompany().getCountryStr();

        String sqlCommand = "select countryName from PlaceLocation where latitude = ? and longitude = ?";

        PreparedStatement getCountriesPreparedStatement =
                connection.prepareStatement(sqlCommand);

        getCountriesPreparedStatement.setString(1, latitude);
        getCountriesPreparedStatement.setString(2, longitude);

        try (ResultSet countriesResultSet = getCountriesPreparedStatement.executeQuery()) {
            boolean existsCountry = countriesResultSet.next();
            if(existsCountry) {
                String countryName = countriesResultSet.getNString(1);

                sqlCommand = "select * from Country where countryName = ?";
                getCountriesPreparedStatement = connection.prepareStatement(sqlCommand);
                getCountriesPreparedStatement.setString(1, countryName);

                try (ResultSet countryResultSet = getCountriesPreparedStatement.executeQuery()) {
                    countryResultSet.next();
                    String continent = countryResultSet.getNString(2);
                    country = countryStore.createCountry(countryName,continent);
                    countryStore.saveCountry(country);
                    countryResultSet.close();
                }
                countriesResultSet.close();
            }

        } finally {
            getCountriesPreparedStatement.close();
        }
        return country;
    }

    /**
     * Method which has the responsibility of retrieving the matching Country of a Capital.
     *
     * @param databaseConnection to the database
     * @param countryName of a country
     * @return country that identifies a Capital
     * @throws SQLException that may occur within the database
     */
    private Country importCountryForCapital(DatabaseConnection databaseConnection, String countryName)
            throws SQLException {

        Country country;

        PreparedStatement getCountryPreparedStatement =
                databaseConnection.getConnection().prepareStatement("select * from Country where countryName = ?");

        getCountryPreparedStatement.setString(1, countryName);

        try (ResultSet countryResultSet = getCountryPreparedStatement.executeQuery()) {
            countryResultSet.next();

            String name = countryResultSet.getNString(1);
            String continent = countryResultSet.getNString(2);
            country = new Country(continent, name);

            App.getInstance().getCompany().getCountryStr().saveCountry(country);

            countryResultSet.close();
        } finally {
            getCountryPreparedStatement.close();
        }
        return country;
    }

    /**
     * Method which has the responsibility of retrieving all the countries available on the database.
     *
     * @param databaseConnection to the database
     * @throws SQLException that may occur within the database
     */
    private void importCountriesFromDatabase(DatabaseConnection databaseConnection)
            throws SQLException {
        CountryStore countryStr = App.getInstance().getCompany().getCountryStr();

        boolean isCountryOnDatabase;

        String sqlCommand = "select * from Country";

        PreparedStatement getCountriesPreparedStatement = databaseConnection.getConnection().prepareStatement(sqlCommand);

        try (ResultSet countriesResultSet = getCountriesPreparedStatement.executeQuery()) {
            isCountryOnDatabase = countriesResultSet.next();

            while (isCountryOnDatabase) {
                String countryName = countriesResultSet.getNString(1);
                String continentName = countriesResultSet.getNString(2);

                Country country = countryStr.createCountry(continentName, countryName);
                countryStr.saveCountry(country);

                isCountryOnDatabase = countriesResultSet.next();
            }
            countriesResultSet.close();
        } finally {
            getCountriesPreparedStatement.close();
        }
    }

    /**
     * Method responsible for filling the SeadistStore with seadists from the database.
     *
     * @param databaseConnection to the database
     * @throws SQLException that may occur within the connection to the database
     */
    private void importSeadistsFromDataBase(DatabaseConnection databaseConnection)
            throws SQLException {
        SeadistStore seadistStr = App.getInstance().getCompany().getSeadistStr();

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

                Seadist seadist = seadistStr.createSeadist(portsid1, portsid2, seaDistance, portName1, portName2, countryName1, countryName2);
                seadistStr.saveSeadist(seadist);

                isThereSeadistonDataBase = seadistResultSet.next();
            }
            seadistResultSet.close();
        } finally {
            getSeadistPreparedStatement.close();
        }
    }

    /**
     * Method responsible for filling the Stores with Borders
     *
     * @param databaseConnection to the database
     * @throws SQLException that may occur within the connection to the database
     */
    private void importBordersFromDataBase(DatabaseConnection databaseConnection)
            throws SQLException {
        BorderStore borderStr = App.getInstance().getCompany().getBorderStr();

        boolean isThereBorderOnDataBase;

        String sqlCommand = "select * from Border";

        PreparedStatement getBorderPreparedStatement = databaseConnection.getConnection().prepareStatement(sqlCommand);

        try (ResultSet borderResultSet = getBorderPreparedStatement.executeQuery()) {
            isThereBorderOnDataBase = borderResultSet.next();

            while (isThereBorderOnDataBase) {
                String countryName1 = borderResultSet.getNString(1);
                String countryName2 = borderResultSet.getNString(2);

                Border border = borderStr.createBorder(countryName1, countryName2);
                borderStr.saveBorder(border);

                isThereBorderOnDataBase = borderResultSet.next();
            }
            borderResultSet.close();
        } finally {
            getBorderPreparedStatement.close();
        }
    }

    /**
     * Method responsible for returning a list of Capitals from the database.
     *
     * @param databaseConnection to the database
     * @throws SQLException that may occur within the connection to the database
     */
    private void importCapitalsFromDataBase(DatabaseConnection databaseConnection)
            throws SQLException {
        CapitalStore capitalStr = App.getInstance().getCompany().getCapitalStr();

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
                Country country = importCountryForCapital(databaseConnection, countryName);

                Capital capital = capitalStr.createCapital(name, country, latitude, longitude);
                capitalStr.saveCapital(capital);

                isThereCapitalonDataBase = capitalResultSet.next();
            }
            capitalResultSet.close();
        } finally {
            getCapitalPreparedStatement.close();
        }
    }
}