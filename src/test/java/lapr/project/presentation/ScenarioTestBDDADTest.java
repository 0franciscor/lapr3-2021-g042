package lapr.project.presentation;

import lapr.project.controller.FindContainerSituationController;
import lapr.project.data.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ScenarioTestBDDADTest {

    private FindContainerSituationController findContainerSituationController;

    private US205Handler us205Handler;

    private US206Handler us206Handler;

    private US207Handler us207Handler;

    private US208Handler us208Handler;

    private US209Handler us209Handler;

    private US210Handler us210Handler;

    private US305Handler us305Handler;

    private US304Handler us304Handler;

    private US306Handler us306Handler;

    private US307Handler us307Handler;

    private US312Handler us312Handler;

    private US310Handler us310Handler;

    @Test
    public void presentationTest1() throws SQLException, IOException, ParseException {
        findContainerSituationController = new FindContainerSituationController();
        findContainerSituationController.getContainerLocation(987650321);
        findContainerSituationController.getContainerLocation(695421863);

        us205Handler = new US205Handler("210950000");
        us206Handler = new US206Handler("636092932");
        us207Handler = new US207Handler("212180000", 2004);
        us208Handler = new US208Handler(3);
        String date ="14.10.21 18:44:33";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy hh:mm:ss");
        Date parsedDate = dateFormat.parse(date);
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
        us209Handler = new US209Handler("210950000", timestamp);
        us210Handler = new US210Handler();

    }

    @Test
    public void presentationTest2() throws IOException {
        new UpdateCargoManifest(456789423, 33.4f, "manuela_1200720");
        new UpdateCargoManifest(456789423, 15.2f, "francisco2");
        us304Handler = new US304Handler(1, 456789423);
        us305Handler = new US305Handler(1, 987650321);
        us306Handler = new US306Handler();
        us307Handler = new US307Handler();
        us312Handler = new US312Handler();
        us310Handler = new US310Handler(12, 2021);

        us312Handler.getContainerLocation(987650321, 1);


        us312Handler.getContainerLocation(695421863, 2);



    }
}
