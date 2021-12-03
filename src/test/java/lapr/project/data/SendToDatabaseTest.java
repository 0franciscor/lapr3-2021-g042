package lapr.project.data;

import lapr.project.controller.App;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

@ExtendWith(MockitoExtension.class)
class SendToDatabaseTest {

    @Mock
    DatabaseConnection databaseConnection;

    SendToDatabase sendToDatabase;

    @BeforeEach
    public void setUp() throws SQLException {
        databaseConnection = Mockito.mock(databaseConnection.getClass());
    }


    @Test
    void saveShip() {
        sendToDatabase = new SendToDatabase(databaseConnection);

    }

    @Test
    void savePosition() {
    }


    @Test
    void savePort() {
    }

    @Test
    void saveContainer() {
    }
}