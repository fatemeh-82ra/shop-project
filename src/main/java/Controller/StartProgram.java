package Controller;

import View.CommandProcessor;

/**
 * our controller that works with command line and call it.
 *
 * @author Fatemeh
 */
public class StartProgram {

    /**
     * making new object of our command menu to call its function
     */
    CommandProcessor commandProcessor = new CommandProcessor();

    /**
     * making constructor of our class to make object of it
     */
    public StartProgram() {
    }

    /**
     * method to call function of our command menu
     */
    public void run() {
        commandProcessor.run();
    }
}
