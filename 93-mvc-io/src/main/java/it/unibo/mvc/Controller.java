package it.unibo.mvc;

import java.util.List;

public interface Controller {

    /**
     * Set the next string to be printed.
     * @param s
     */
    public void setNextString(final String s);


    /**
     * 
     * @return the next string to print.
     */
    public String getNextString();


    /**
     * @return A list with all the printed words.
     */
    public List<String> getHistory();

    /**
     * Print the current string.
     */
    public void printCurrentString();

}
