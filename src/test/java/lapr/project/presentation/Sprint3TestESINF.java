package lapr.project.presentation;

import lapr.project.controller.ClosenessLocalsController;
import lapr.project.controller.ColorFreightNetworkController;
import lapr.project.controller.CreateFreightNetworkController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Sprint3TestESINF {

    private CreateFreightNetworkController createFreightNetworkController;

    private ColorFreightNetworkController colorFreightNetworkController;

    private ClosenessLocalsController closenessLocalsController;

    public Sprint3TestESINF(){
        createFreightNetworkController = new CreateFreightNetworkController();
        colorFreightNetworkController = new ColorFreightNetworkController();
        closenessLocalsController = new ClosenessLocalsController();
    }

    @Test
    public void presentation() throws IOException {
        createFreightNetworkController.createFreightNetwork(5);
        colorFreightNetworkController.colorNetwork();
        closenessLocalsController.closenessLocals(5);
    }
}
