package lapr.project.data;

import lapr.project.controller.App;
import lapr.project.utils.WriteForAFile;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class US310Handler {

    private final Connection databaseConnection;
    private String information;
    private final WriteForAFile writeForAFile;


    public US310Handler() throws IOException {
        databaseConnection = App.getInstance().getDatabaseConnection().getConnection();
        writeForAFile = new WriteForAFile();
        try {
            initialize();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initialize() throws IOException, SQLException {
        CallableStatement statement = null;
        try {
            statement = databaseConnection.prepareCall("{call PortsInformation(?)}");
            statement.registerOutParameter(1, Types.LONGNVARCHAR);


            statement.execute();

            this.information= statement.getString(1);

            writeForAFile.writeForAFile(information, "US310" , new File(".\\outputs\\US310"));

        }catch (Exception e){
            e.printStackTrace();
            writeForAFile.writeForAFile("Something went wrong", "US310" , new File(".\\outputs\\US310"));
        }finally {
            assert statement != null;
            statement.close();
        }

    }

}
