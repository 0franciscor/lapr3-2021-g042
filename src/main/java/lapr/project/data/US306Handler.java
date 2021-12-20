package lapr.project.data;

import lapr.project.controller.App;
import lapr.project.utils.WriteForAFile;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class US306Handler {

    private Connection databaseConnection;
    private String informationOutput;
    private WriteForAFile writeForAFile;

    public US306Handler() throws IOException {
        databaseConnection = App.getInstance().getDatabaseConnection().getConnection();
        writeForAFile = new WriteForAFile();
        initialize();
    }

    private void initialize() throws IOException {

        try {
            CallableStatement statement = databaseConnection.prepareCall("{ ? = call getInformationAboutAuditTrails() }");
            statement.registerOutParameter(1, Types.LONGNVARCHAR);
            statement.execute();

            this.informationOutput = statement.getNString(1);

            writeForAFile.writeForAFile(informationOutput, "US306_Containers_Warehouses", new File(".\\outputs\\US306"));
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            writeForAFile.writeForAFile("Something went wrong", "US306_Containers_Warehouses", new File(".\\outputs\\US306"));
        }

    }
}
