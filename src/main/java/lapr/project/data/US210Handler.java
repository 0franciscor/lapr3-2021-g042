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

public class US210Handler {

    private Connection databaseConnection;
    private String information;


    private WriteForAFile writeForAFile;

    public US210Handler() throws SQLException, IOException {
        databaseConnection = App.getInstance().getDatabaseConnection().getConnection();
        writeForAFile = new WriteForAFile();
        initialize();
    }

    private void initialize() throws SQLException, IOException {
        try {
            CallableStatement statement = databaseConnection.prepareCall("{CALL US210(?)}");
            statement.registerOutParameter(1, Types.LONGNVARCHAR);


            statement.execute();

            this.information= statement.getString(1);

            writeForAFile.writeForAFile(information, "US210" , new File(".\\outputs\\US210"));
            statement.close();
        }catch (Exception e){
            writeForAFile.writeForAFile("Something went wrong", "US210" , new File(".\\outputs\\US210"));
        }


    }


}
