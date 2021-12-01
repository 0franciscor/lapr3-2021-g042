package lapr.project.data;

import lapr.project.controller.App;
import lapr.project.utils.WriteForAFile;
import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class US205 {

    private Connection databaseConnection;
    private String listOfContainers;
    private WriteForAFile writeForAFile;

    public US205(String mmsiCode) throws SQLException, IOException {
        databaseConnection = App.getInstance().getDatabaseConnection().getConnection();
        writeForAFile = new WriteForAFile();
        initialize(mmsiCode);
    }

    private void initialize(String mmsiCode) throws SQLException, IOException {
        CallableStatement statement = databaseConnection.prepareCall("{CALL US205(?, ?)}");
        statement.registerOutParameter(2, Types.INTEGER);

        statement.setString(1, mmsiCode);

        statement.execute();

        this.listOfContainers=statement.getString(2);

        writeForAFile.writeForAFile(toString(), "US205_" + mmsiCode, new File("target\\generated-sources\\annotations\\US205"));
        statement.close();
        databaseConnection.close();
    }

    @Override
    public String toString() {
        return "US205{" +
                "listOfContainers='" + listOfContainers + '\'' +
                '}';
    }
}
