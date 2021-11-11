package lapr.project.utils;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WriteForAFileTest {

    private WriteForAFile writeForAFile;


    @Test
    void writeForAFile() throws IOException {
        writeForAFile = new WriteForAFile();
        File file = new File("Summaries");
        assertTrue(writeForAFile.writeForAFile("testing\n", "Summary_211331640",file));
    }

    @Test
    void WriteForAFileTestingAppending() throws IOException {
        writeForAFile = new WriteForAFile();
        File file = new File("Summaries");
        assertTrue(writeForAFile.writeForAFile("testing\n", "Summary_211331640", file));
    }

    @Test
    void WriteForAFilePassingANullStringByReference() throws IOException {
        writeForAFile = new WriteForAFile();
        File file = new File("Summaries");
        assertFalse(writeForAFile.writeForAFile(null, "Summary_211331640", file));
    }

    @Test
    void WriteForAFileThatExist() throws IOException {
        writeForAFile = new WriteForAFile();
        File file = new File("Summaries");
        writeForAFile.writeForAFile(null, "Summary_211331640", file);
        assertTrue(writeForAFile.writeForAFile("testing\n", "Summary_211331640",file));
    }


}