package lapr.project.data;

import lapr.project.controller.App;
import lapr.project.utils.WriteForAFile;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class US307Handler {

    private Connection databaseConnection;
    private String informationOutput;
    private WriteForAFile writeForAFile;

    public US307Handler(int warehouseId) throws IOException {
        databaseConnection = App.getInstance().getDatabaseConnection().getConnection();
        writeForAFile = new WriteForAFile();
        initialize(warehouseId);
    }

    private void initialize(int warehouseId) throws IOException {

        try {
            CallableStatement statement = databaseConnection.prepareCall("{ ? = call displayWarning(?) }");
            statement.registerOutParameter(1, Types.LONGNVARCHAR);
            statement.setInt(warehouseId, 2);
            statement.execute();

            this.informationOutput = statement.getNString(1);

            writeForAFile.writeForAFile(informationOutput, "US307_Warning", new File(".\\outputs\\US307"));
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
            writeForAFile.writeForAFile("Something went wrong", "US307_Warning", new File(".\\outputs\\US307"));
        }

    }
}
