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
    private WriteForAFile writeForAFile;

    public US307Handler() throws IOException {
        try{
            databaseConnection = App.getInstance().getDatabaseConnection().getConnection();
        }
        catch(Exception e){
            writeForAFile = new WriteForAFile();
            writeForAFile.writeForAFile(e.getMessage(), "US307_Warning", new File(".\\outputs\\US307"));
        }
    }

}
