package lapr.project.model;


/**
 * Represents a role in organization
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class OrganizationRole {

    /**
     * The designation of a role in organization.
     */
    String designation;

    /**
     * Constructs an instance of {@code OrganizationRole} receiving the designation.
     * @param designation characterizes the role in the organization.
     */
    public OrganizationRole(String designation){
        this.designation = designation;
    }

    /**
     * Get the designation.
     * @return The designation of an Organization Role.
     */
    public String getDesignation() {
        return designation;
    }


}
