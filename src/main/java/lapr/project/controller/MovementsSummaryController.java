package lapr.project.controller;

import lapr.project.mapper.SummaryMapper;
import lapr.project.mapper.dto.SummaryDto;
import lapr.project.model.BstShip;
import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.Summary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The MovementsSummary Controller, the controller responsible for managing the Summary class, which allows the Traffic manager to create a summary of movements of a ship
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class MovementsSummaryController {

    /**
     * Represents an instance of BstShip
     */
    private BstShip bstShip;

    /**
     * Represents the company
     */
    private Company company;

    /**
     * Represents an instance of Summary Mapper Dto
     */
    private SummaryMapper summaryMapper;

    /**
     * The class constructor
     */
    public MovementsSummaryController(){
        company = App.getInstance().getCompany();
        bstShip = company.getBstShip();
        summaryMapper = new SummaryMapper();
    }

    /**
     * Search a ship by his MMSI code
     * @param mmsiCode the MMSI code of a ship
     * @return the ship that matched the MMSI code
     */
    public Ship getShipByMmsiCode(String mmsiCode){
        return bstShip.getShipByMmsiCode(mmsiCode);
    }

    /**
     * Create a summary for a ship
     * @param ship the ship we want to create a summary
     * @return the summary
     */
    public Summary createSummaryForShip(Ship ship){
        return new lapr.project.model.Summary(ship);
    }

    /**
     * Create an object of type data transfer
     * @param summary the summary we intend to transform in a data transfer
     * @return the data transfer object
     */
    public SummaryDto createSummaryDto(lapr.project.model.Summary summary){
        return summaryMapper.toDto(summary);
    }

    /**
     * Verification if a ship exists in the system through the MMSI code
     * @param mmsiCode Code of the ship that we want to know if it exists in the system
     * @return true if the ship exists, otherwise return false
     */
    public boolean shipExist(String mmsiCode){
        Ship ship = bstShip.getShipByMmsiCode(mmsiCode);
        return ship != null;
    }

    /**
     * Write the summary of a ship's movement in a file
     * @param string the text that will be written in the file
     * @param mmsiCode the mmsi code of the ship to identify the summary
     * @return false if the operation fail, true otherwise
     * @throws IOException if some exception occur
     */
    public boolean writeForAFile(String string, String mmsiCode) throws IOException {
        boolean flag = true;
        File archive = new File(".\\Summaries");

        if (!archive.exists()) {
            archive.mkdirs();
        }
        File arch = new File(".\\Summaries\\Summary_" + mmsiCode +".txt");

        FileWriter fw = new FileWriter(arch, true);

        try {
            if (arch.exists()) arch.delete();
            fw.write(string);
        } catch (IOException e){
            flag = false;
            e.printStackTrace();
        } finally {
            fw.close();
        }
        return flag;
    }

}
