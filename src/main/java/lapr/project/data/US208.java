package lapr.project.data;

import lapr.project.controller.App;
import lapr.project.utils.WriteForAFile;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;


public class US208 {

    private Connection databaseConnection;
    private float ratio;


    private WriteForAFile writeForAFile;

    public US208(int cargoManifestId) throws SQLException, IOException {
        databaseConnection = App.getInstance().getDatabaseConnection().getConnection();
        writeForAFile = new WriteForAFile();
        initialize(cargoManifestId);
    }

    private void initialize(int cargoManifestId) throws SQLException, IOException {
        CallableStatement statement = databaseConnection.prepareCall("{CALL US208(?, ?)}");
        statement.registerOutParameter(2, Types.FLOAT);

        statement.setInt(1, cargoManifestId);

        statement.execute();

        this.ratio = statement.getFloat(2);

        writeForAFile.writeForAFile(toString(), "US208_" + cargoManifestId, new File("target\\generated-sources\\annotations\\US208"));
        statement.close();
        databaseConnection.close();
    }

    public float getRatio() {
        return ratio;
    }

    @Override
    public String toString() {
        return String.format("ratio\n" +
                "%.2f\n", ratio);
    }
}
