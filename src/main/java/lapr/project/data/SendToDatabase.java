package lapr.project.data;

import lapr.project.controller.App;
import lapr.project.model.Ship;
import lapr.project.model.ShipLocation;
import lapr.project.model.Ports;

import java.sql.*;

public class SendToDatabase implements Persistable {

    DatabaseConnection databaseConnection;

    public SendToDatabase(){
        this.databaseConnection = App.getInstance().initializeConnection();
    }


    //################################# DATABASE RELATED #####################################

    /**
     * Method responsible for sending the Ship and its locations to the database
     */
    public void sendShipsAndLocationsToDatabase() {

        for (Object objectShip : App.getInstance().getCompany().getBstShip().inOrder()) {
            Ship ship = (Ship) objectShip;
            saveShip(databaseConnection, ship);

            for (Object objectLocation : ship.getShipPosition().inOrder()) {
                ShipLocation shipLocation = (ShipLocation) objectLocation;
                savePosition(databaseConnection, shipLocation);
            }
        }
    }

    public void sendPortsToDatabase(){

    }

    //################################# SHIP RELATED #####################################

    /**
     * Method responsible for saving an object to the database.
     *
     * @param databaseConnection to the database
     * @param object that is going to be saved
     * @return success of the operation
     */
    @Override
    public boolean saveShip(DatabaseConnection databaseConnection, Object object){
        Ship ship = (Ship) object;
        boolean returnValue;

        try {
            saveShipToDatabase(databaseConnection, ship);
            returnValue = true;

        } catch (SQLException ex) {
            System.out.println("There was an error when importing a ship to the database.");
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }

    /**
     * Checks is a Ship is already registered on the database. If the Ship
     * is registered, it updates it. If it is not, it inserts a new one.
     *
     * @param databaseConnection to the database
     * @param ship that is related to the database
     * @throws SQLException in case an error with the database occurs
     */
    private void saveShipToDatabase(DatabaseConnection databaseConnection, Ship ship)
            throws SQLException {
        if (isShipOnDatabase(databaseConnection, ship))
            updateShipOnDatabase(databaseConnection, ship);
        else
            insertShipOnDatabase(databaseConnection, ship);
    }

    /**
     * Checks if a ship is registered on the Database by its ID.
     *
     * @param databaseConnection to the database
     * @param ship that is related to the database
     * @return True if the ship is registered, False if otherwise.
     * @throws SQLException in case an error with the database occurs
     */
    private boolean isShipOnDatabase(DatabaseConnection databaseConnection, Ship ship)
            throws SQLException {

        Connection connection = databaseConnection.getConnection();

        boolean isShipOnDatabase;

        String sqlCommand = "select * from ship where mmsiCode = ?";

        PreparedStatement getShipsPreparedStatement =
                connection.prepareStatement(sqlCommand);

        getShipsPreparedStatement.setString(1, ship.getMMSI());

        try (ResultSet shipsResultSet = getShipsPreparedStatement.executeQuery()) {

            isShipOnDatabase = shipsResultSet.next();
            shipsResultSet.close();

        } finally {
            getShipsPreparedStatement.close();
        }
        return isShipOnDatabase;
    }

    /**
     * Updates an existing ship record on the database.
     *
     * @param databaseConnection to the database
     * @param ship that is related to the database
     * @throws SQLException in case an error with the database occurs
     */
    private void updateShipOnDatabase(DatabaseConnection databaseConnection, Ship ship)
            throws SQLException {
        String sqlCommand =
                "update ship set imoCode = ?, numberOfEnergyGenerators = ?, generatorOutput = ?, callSign = ?, draft = ?, shipName = ?, vesselTypeId = ?, shipLength = ?, width = ?, cargo = ? where mmsiCode = " + ship.getMMSI();

        executeShipStatementOnDatabase(databaseConnection, ship, sqlCommand);
    }


    /**
     * Adds a new ship record to the database.
     *
     * @param databaseConnection to the database
     * @param ship that is related to the database
     * @throws SQLException in case an error with the database occurs
     */
    private void insertShipOnDatabase(DatabaseConnection databaseConnection, Ship ship)
            throws SQLException {
        String sqlCommand =
                "insert into ship(mmsiCode, imoCode, numberOfEnergyGenerators, generatorOutput, callSign, draft, shipName, vesselTypeId, shipLength, width, cargo) values (" + ship.getMMSI() +", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        executeShipStatementOnDatabase(databaseConnection, ship, sqlCommand);
    }


    /**
     * Executes the save Ship Statement.
     *
     * @param databaseConnection to the database
     * @param ship that is related to the database
     * @throws SQLException in case an error with the database occurs
     */
    private void executeShipStatementOnDatabase(DatabaseConnection databaseConnection, Ship ship, String sqlCommand)
            throws SQLException {

        Connection connection = databaseConnection.getConnection();

        PreparedStatement saveShipPreparedStatement = connection.prepareStatement(sqlCommand);

        saveShipPreparedStatement.setString(1, ship.getShipID());
        saveShipPreparedStatement.setInt(2, ship.getEnergyGenerators());
        saveShipPreparedStatement.setFloat(3, ship.getGeneratorOutput());
        saveShipPreparedStatement.setString(4, ship.getCallSign());
        saveShipPreparedStatement.setFloat(5, ship.getDraft());
        saveShipPreparedStatement.setString(6, ship.getName());
        saveShipPreparedStatement.setInt(7, ship.getVesselType());
        saveShipPreparedStatement.setFloat(8, ship.getLength());
        saveShipPreparedStatement.setFloat(9, ship.getWidth());
        saveShipPreparedStatement.setString(10, ship.getCargo());

        try{
            saveShipPreparedStatement.executeUpdate();
        } catch (Exception e){
            System.out.println("There was an error when importing the Ship with the " + ship.getMMSI() + " MMSI code.");
        } finally {
            saveShipPreparedStatement.close();
        }
    }

    //################################# POSITION RELATED #####################################

    /**
     * Method responsible for saving an object to the database.
     *
     * @param databaseConnection to the database
     * @param object that is going to be saved
     * @return success of the operation
     */
    @Override
    public boolean savePosition(DatabaseConnection databaseConnection, Object object){
        ShipLocation shipLocation = (ShipLocation) object;
        boolean returnValue;

        try {
            saveLocationToDatabase(databaseConnection, shipLocation);
            returnValue = true;

        } catch (SQLException ex) {
            returnValue = false;
            System.out.println("There was an error when importing a Ship Location to the database.");
        }
        return returnValue;
    }

    /**
     * Checks is a ShipLocation is already registered on the database. If the ShipLocation
     * is registered, it updates it. If it is not, it inserts a new one.
     *
     * @param databaseConnection to the database
     * @param shipLocation that contains the location of a ship
     * @throws SQLException in case an error with the database occurs
     */
    private void saveLocationToDatabase(DatabaseConnection databaseConnection, ShipLocation shipLocation)
            throws SQLException {
        if (!isLocationOnDatabase(databaseConnection, shipLocation))
            insertLocationOnDatabase(databaseConnection, shipLocation);
    }

    /**
     * Method responsible for verifying if a certain Location exists on the database
     *
     * @param databaseConnection to the database
     * @param shipLocation that is related to the database
     * @return if a location exists on the database
     * @throws SQLException in case an error with the database occurs
     */
    private boolean isLocationOnDatabase(DatabaseConnection databaseConnection, ShipLocation shipLocation)
            throws SQLException {

        Connection connection = databaseConnection.getConnection();

        boolean isShipOnDatabase;

        String sqlCommand = "select * from ShipPosition where shipMmsiCode = ? and baseDateTime = ?";

        PreparedStatement getShipLocationPreparedStatement = connection.prepareStatement(sqlCommand);

        getShipLocationPreparedStatement.setString(1, shipLocation.getMMSI());
        getShipLocationPreparedStatement.setTimestamp(2, new Timestamp(shipLocation.getMessageTime().getTime()));

        try (ResultSet shipLocationResultSet = getShipLocationPreparedStatement.executeQuery()) {

            isShipOnDatabase = shipLocationResultSet.next();
            shipLocationResultSet.close();

        } finally {
            getShipLocationPreparedStatement.close();
        }
        return isShipOnDatabase;
    }

    /**
     * Adds a new shipLocation record to the database.
     *
     * @param databaseConnection to the database
     * @param shipLocation that is related to the database
     * @throws SQLException in case an error with the database occurs
     */
    private void insertLocationOnDatabase(DatabaseConnection databaseConnection, ShipLocation shipLocation)
            throws SQLException {

        String sqlCommand = "insert into ShipPosition(shipMmsiCode, baseDateTime, latitude, longitude, sog, cog, heading, position, transceiver) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        executeShipLocationStatementOnDatabase(databaseConnection, shipLocation, sqlCommand);
    }

    /**
     * Executes the save ShipLocation Statement.
     *
     * @param shipLocation that is related to the database
     * @throws SQLException in case an error with the database occurs
     */
    private void executeShipLocationStatementOnDatabase(DatabaseConnection databaseConnection, ShipLocation shipLocation, String sqlCommand)
            throws SQLException {

        Connection connection = databaseConnection.getConnection();
        PreparedStatement getShipLocationPreparedStatement = connection.prepareStatement(sqlCommand);

        getShipLocationPreparedStatement.setString(1, shipLocation.getMMSI());
        getShipLocationPreparedStatement.setTimestamp(2, new Timestamp(shipLocation.getMessageTime().getTime()));
        getShipLocationPreparedStatement.setString(3, shipLocation.getLatitude());
        getShipLocationPreparedStatement.setString(4, shipLocation.getLongitude());
        getShipLocationPreparedStatement.setFloat(5, shipLocation.getSOG());
        getShipLocationPreparedStatement.setString(7, shipLocation.getHeading());
        getShipLocationPreparedStatement.setFloat(6, shipLocation.getCOG());
        getShipLocationPreparedStatement.setString(8, shipLocation.getPosition());
        getShipLocationPreparedStatement.setString(9, shipLocation.getTransceiverClass());

        try {
            getShipLocationPreparedStatement.executeUpdate();
        } catch (Exception e){
            System.out.println("There was an error when importing the ShipLocation with " + shipLocation.getMMSI() + " code.");
        }finally {
            getShipLocationPreparedStatement.close();
        }
    }

    /**
     * Method responsible for saving an object to the database.
     *
     * @param databaseConnection to the database
     * @param object that is going to be saved
     * @return success of the operation
     */
    @Override
    public boolean savePort(DatabaseConnection databaseConnection, Object object){
        Ports port = (Ports) object;
        boolean returnValue;

        try {
            savePortToDatabase(databaseConnection, port);
            returnValue = true;

        } catch (SQLException ex) {
            System.out.println("There was an error when importing a port to the database.");
            databaseConnection.registerError(ex);
            returnValue = false;
        }
        return returnValue;
    }

    /**
     * Checks is a Port is already registered on the database. If the Port
     * is registered, it updates it. If it is not, it inserts a new one.
     *
     * @param databaseConnection to the database
     * @param port that is related to the database
     * @throws SQLException in case an error with the database occurs
     */
    private void savePortToDatabase(DatabaseConnection databaseConnection, Ports port)
            throws SQLException {
        if (isPortOnDatabase(databaseConnection, port))
            updatePortOnDatabase(databaseConnection, port);
        else
            insertPortOnDatabase(databaseConnection, port);
    }

    /**
     * Checks if a port is registered on the Database by its ID.
     *
     * @param databaseConnection to the database
     * @param port that is related to the database
     * @return True if the ship is registered, False if otherwise.
     * @throws SQLException in case an error with the database occurs
     */
    private boolean isPortOnDatabase(DatabaseConnection databaseConnection, Ports port)
            throws SQLException {

        Connection connection = databaseConnection.getConnection();

        boolean isPortOnDatabase;

        String sqlCommand = "select * from port where id = ?";

        PreparedStatement getPortsPreparedStatement =
                connection.prepareStatement(sqlCommand);

        getPortsPreparedStatement.setInt(1, port.getCode());

        try (ResultSet portsResultSet = getPortsPreparedStatement.executeQuery()) {

            isPortOnDatabase = portsResultSet.next();
            portsResultSet.close();

        } finally {
            getPortsPreparedStatement.close();
        }
        return isPortOnDatabase;
    }

    /**
     * Updates an existing port record on the database.
     *
     * @param databaseConnection to the database
     * @param port that is related to the database
     * @throws SQLException in case an error with the database occurs
     */
    private void updatePortOnDatabase(DatabaseConnection databaseConnection, Ports port)
            throws SQLException {
        String sqlCommand =
                "update port set name = ?, placeLocationLatitude = ?, placeLocationLongitude = ? where id = " + port.getCode();

        executePortStatementOnDatabase(databaseConnection, port, sqlCommand);
    }


    /**
     * Adds a new port record to the database.
     *
     * @param databaseConnection to the database
     * @param port that is related to the database
     * @throws SQLException in case an error with the database occurs
     */
    private void insertPortOnDatabase(DatabaseConnection databaseConnection, Ports port)
            throws SQLException {
        String sqlCommand =
                "insert into port(id, name, placeLocationLatitude, placeLocationLongitude) values (" + port.getCode() + ", ?, ?, ?)";

        executePortStatementOnDatabase(databaseConnection, port, sqlCommand);
    }


    /**
     * Executes the save Port Statement.
     *
     * @param databaseConnection to the database
     * @param port that is related to the database
     * @throws SQLException in case an error with the database occurs
     */
    private void executePortStatementOnDatabase(DatabaseConnection databaseConnection, Ports port, String sqlCommand)
            throws SQLException {

        Connection connection = databaseConnection.getConnection();

        PreparedStatement savePortPreparedStatement = connection.prepareStatement(sqlCommand);

        savePortPreparedStatement.setString(1, port.getPortName());
        savePortPreparedStatement.setDouble(2, port.getLatitude());
        savePortPreparedStatement.setDouble(3, port.getLongitude());

        try{
            savePortPreparedStatement.executeUpdate();
        } catch (Exception e){
            System.out.println("There was an error when importing the Port with the " + port.getCode() + " code.");
        } finally {
            savePortPreparedStatement.close();
        }
    }
}
