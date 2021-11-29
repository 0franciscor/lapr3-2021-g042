package lapr.project.data;

import lapr.project.controller.App;
import lapr.project.utils.WriteForAFile;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class US207 {

    private Connection databaseConnection;
    private int totalCargoManifestsPerYear;
    private float meanContainerPerCargoManifest;
    private WriteForAFile writeForAFile;

    public US207(String mmsiCode, int year) throws SQLException, IOException {
        databaseConnection = App.getInstance().getDatabaseConnection().getConnection();
        writeForAFile = new WriteForAFile();
        initialize(mmsiCode, year);
    }

    private void initialize(String mmsiCode, int year) throws SQLException, IOException {
        CallableStatement statement = databaseConnection.prepareCall("{CALL US207(?, ?, ?, ?)}");
        statement.registerOutParameter(3, Types.INTEGER);
        statement.registerOutParameter(4, Types.FLOAT);

        statement.setInt(1, year);
        statement.setString(2, mmsiCode);

        statement.execute();

        this.totalCargoManifestsPerYear = statement.getInt(3);
        this.meanContainerPerCargoManifest = statement.getFloat(4);

        writeForAFile.writeForAFile(toString(), "US207_" + mmsiCode, new File("target\\generated-sources\\annotations\\US207"));
        statement.close();
        databaseConnection.close();
    }

    public int getTotalCargoManifestsPerYear() {
        return totalCargoManifestsPerYear;
    }

    public float getMeanContainerPerCargoManifest() {
        return meanContainerPerCargoManifest;
    }

    @Override
    public String toString() {
        return String.format("totalCargoManifestPerYear, meanContainerPerCargoManifest\n" +
                "%d, %.2f\n", totalCargoManifestsPerYear, meanContainerPerCargoManifest);
    }
}
