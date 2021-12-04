package lapr.project.data;

import lapr.project.controller.App;
import lapr.project.utils.WriteForAFile;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class US206Handler {

    private Connection databaseConnection;
    private String listOfContainers;
    private WriteForAFile writeForAFile;

    public US206Handler(String mmsiCode) throws SQLException, IOException {
        databaseConnection = App.getInstance().getDatabaseConnection().getConnection();
        writeForAFile = new WriteForAFile();
        initialize(mmsiCode);
    }

    private void initialize(String mmsiCode) throws IOException {

        try{
            CallableStatement statement = databaseConnection.prepareCall("{call US206(?, ?)}");

            statement.registerOutParameter(2, Types.VARCHAR);

            statement.setString(1, mmsiCode);


            statement.execute();

            this.listOfContainers=statement.getString(2);

            writeForAFile.writeForAFile(toString(), "US206_" + mmsiCode, new File(".\\outputs\\US206"));
            statement.close();

        }catch (Exception e){
            writeForAFile.writeForAFile("Something went wrong", "US206_" + mmsiCode, new File(".\\outputs\\US206"));
        }


    }

    @Override
    public String toString() {
        return String.format("CargoManifest, Type, Load\n%s", listOfContainers);
    }
}
