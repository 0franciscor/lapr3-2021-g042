package lapr.project.data;

import lapr.project.controller.App;
import lapr.project.utils.WriteForAFile;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

public class US209Handler {

    private Connection databaseConnection;
    private float occupancyRate;


    private WriteForAFile writeForAFile;

    public US209Handler(int cargoManifestId, Date actualDate) throws SQLException, IOException {
        databaseConnection = App.getInstance().getDatabaseConnection().getConnection();
        writeForAFile = new WriteForAFile();
        initialize(cargoManifestId, actualDate);
    }

    private void initialize(int cargoManifestId, Date actualDate) throws SQLException, IOException {

        try {
            CallableStatement statement = databaseConnection.prepareCall("{call US208(?, ?, ?)}");
            statement.registerOutParameter(2, Types.FLOAT);

            statement.setInt(1, cargoManifestId);
            statement.setDate(2, (java.sql.Date) actualDate);

            statement.execute();

            this.occupancyRate = statement.getFloat(2);

            writeForAFile.writeForAFile(toString(), "US209_" + cargoManifestId, new File(".\\outputs\\US209"));
            statement.close();
        }catch (Exception e){
            writeForAFile.writeForAFile("Something went wrong", "US209_" + cargoManifestId, new File(".\\outputs\\US209"));
        }

    }

    public float getOccupancyRate() {
        return occupancyRate;
    }

    @Override
    public String toString() {
        return String.format("Occupancy Rate\n" +
                            "%.2f", occupancyRate);
    }
}
