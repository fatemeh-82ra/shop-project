import Controller.StartProgram;

/**
 * this project is build on MVC structure (MODEL/VIEW/CONTROLLER).
 * our class to start our shop program
 *
 * @author Fatemeh
 * @version jdk:18.0.1.1
 */
class Main {

    /**
     * method to run our main class
     *
     * @param args not used
     */
    public static void main(String[] args) {

        /**
         * passing the request to Controller
         */
        StartProgram startProgram = new StartProgram();
        startProgram.run();
    }
}