package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.ImportPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImportPortControllerTest {

    ImportPortController controller;

    Company company;

    @BeforeEach
    public void setUp(){
        company = new Company();
        controller = new ImportPortController(company);
    }

    @Test
    void importFile() {
        String fileName = "bports.csv";
        boolean result = controller.importFile(fileName);
        assertTrue(result);
    }

    @Test
    public void importFileInsuccess() {
        String fileName = "bports.csa";
        boolean result = controller.importFile(fileName);
        assertFalse(result);
    }

    @Test
    void importPorts() {
        String fileName = "bports.csv";
        controller.importFile(fileName);
        controller.importPorts();
    }
}