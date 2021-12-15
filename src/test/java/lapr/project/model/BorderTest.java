package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BorderTest {

    @Test
    void getCountryName() {
        Border border = new Border("Portugal", "Espanha");
        String result = border.getCountryName();
        assertEquals("Portugal", result);
    }

    @Test
    void getCountryName2() {
        Border border = new Border("Portugal", "Espanha");
        String result = border.getCountryName2();
        assertEquals("Espanha", result);
    }
}