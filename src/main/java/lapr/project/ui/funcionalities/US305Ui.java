package lapr.project.ui.funcionalities;

import lapr.project.data.US305Handler;
import lapr.project.ui.Utils;

import java.io.IOException;

public class US305Ui implements Runnable {

    @Override
    public void run() {

        String registrationCode = Utils.readLineFromConsole("Type the registration code:\n->");
        try {
            new US305Handler(registrationCode);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
