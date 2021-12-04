package lapr.project.presentation;

import lapr.project.controller.FindContainerSituationController;
import lapr.project.data.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class ScenarioTestBDDADTest {

    private FindContainerSituationController findContainerSituationController;

    private US205Handler us205Handler;

    private US206Handler us206Handler;

    private US207Handler us207Handler;

    private US208Handler us208Handler;

    private US209Handler us209Handler;

    private US210Handler us210Handler;

    @Test
    public void presentationTest() throws SQLException, IOException {
        findContainerSituationController = new FindContainerSituationController();
        findContainerSituationController.getContainerLocation(987650321);
        findContainerSituationController.getContainerLocation(695421863);

        us205Handler = new US205Handler("210950000");
        us206Handler = new US206Handler("210950000");
        us207Handler = new US207Handler("210950000", 2020);
        us208Handler = new US208Handler(2);
        us209Handler = new US209Handler(2, new Date());
        us210Handler = new US210Handler();
    }
}
