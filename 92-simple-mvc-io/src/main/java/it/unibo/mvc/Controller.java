package it.unibo.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {


    private File currentFile = new File(System.getProperty("user.home")
        + System.getProperty("file.separator")
        + "output.txt");

    /**
     * Set the file.
     *
     * @param nameFile name of the file
     */
    public void setCurrentFile(final File nameFile) {

        this.currentFile = nameFile;
    }

    /**
     * Get the currentFile.
     *
     * @return the current file
     */
    public File getCurrentFile() {

        return this.currentFile;

    }

    /**
     * Return the path.
     *
     * @return the path of the current file
     */
    public String getPath() {

        return this.currentFile.getAbsolutePath();

    }

    /**
     * Write the string in the current file.
     *
     * @param s a string 
     */
    public void writeString(final String s) throws FileNotFoundException {

        try (PrintStream print = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            print.print(s);
            print.close();
        } catch (IOException e1) {
                    e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }


    }


}
