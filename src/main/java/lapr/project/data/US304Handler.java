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

    private final Connection databaseConnection;
    private String informationOutput;
    private final WriteForAFile writeForAFile;

    public US304Handler(int cargoManifestId, int containerId) throws IOException {
        databaseConnection = App.getInstance().getDatabaseConnection().getConnection();
        writeForAFile = new WriteForAFile();
        try {
            initialize(cargoManifestId, containerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initialize(int cargoManifestId, int containerId) throws IOException, SQLException {
        CallableStatement statement = null;
        try {
            statement = databaseConnection.prepareCall("{ ? = call getInformationAboutAuditTrails(?,?) }");
            statement.registerOutParameter(1, Types.LONGNVARCHAR);
            statement.setInt(2, cargoManifestId);
            statement.setInt(3, containerId);
            statement.execute();

            this.informationOutput = statement.getNString(1);

            writeForAFile.writeForAFile(informationOutput, "US304_" + containerId, new File(".\\outputs\\US304"));

        }catch (SQLException e){
            e.printStackTrace();
            writeForAFile.writeForAFile("Something went wrong", "US304_" + containerId, new File(".\\outputs\\US304"));
        }finally {
            statement.close();
        }

    }
}
