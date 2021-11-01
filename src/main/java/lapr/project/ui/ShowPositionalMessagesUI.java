package lapr.project.ui;

import lapr.project.controller.ShowPositionalMessagesController;

/**
 * Represents an interface with the Traffic Manager to view the positional messages temporarily organized and associated with each of the ships
 *
 * @author Rita Ariana Sobral <1201386@isep.ipp.pt>
 */
public class ShowPositionalMessagesUI {

    /**
     * Represents a instance of Show Positional Messages Controller.
     */
    private ShowPositionalMessagesController showPositionalMessagesctrl;

    /**
     * Initializes the controller.
     */
    public ShowPositionalMessagesUI(){
        showPositionalMessagesctrl = new ShowPositionalMessagesController();
    }

}
