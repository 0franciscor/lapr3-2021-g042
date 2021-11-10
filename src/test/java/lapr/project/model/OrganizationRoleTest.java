package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationRoleTest {

    @Test
    void getDesignation() {
        OrganizationRole organizationRole = new OrganizationRole("Traffic Manager");
        assertEquals("Traffic Manager", organizationRole.getDesignation());
    }

    @Test
    void testEquals() {
        OrganizationRole organizationRole = new OrganizationRole("Traffic Manager");
        OrganizationRole organizationRole2 = new OrganizationRole("Traffic Manager");
        assertEquals(organizationRole, organizationRole2);
    }
}