package lapr.project.data;

import lapr.project.controller.App;
import lapr.project.utils.WriteForAFile;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class US304Handler {

    private Connection databaseConnection;
    private String informationOutput;
    private WriteForAFile writeForAFile;

    public US304Handler(int cargoManifestId, int containerId) throws IOException {
        databaseConnection = App.getInstance().getDatabaseConnection().getConnection();
        writeForAFile = new WriteForAFile();
        initialize(cargoManifestId, containerId);
    }

    private void initialize(int cargoManifestId, int containerId) throws IOException {

        try {
            CallableStatement statement = databaseConnection.prepareCall("{ ? = call getInformationAboutAuditTrails(?,?) }");
            statement.registerOutParameter(1, Types.LONGNVARCHAR);
            statement.setInt(2, cargoManifestId);
            statement.setInt(3, containerId);
            statement.execute();

            this.informationOutput = statement.getNString(1);

            writeForAFile.writeForAFile(informationOutput, "US304_" + containerId, new File(".\\outputs\\US304"));
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            writeForAFile.writeForAFile("Something went wrong", "US304_" + containerId, new File(".\\outputs\\US304"));
        }

    }
}
