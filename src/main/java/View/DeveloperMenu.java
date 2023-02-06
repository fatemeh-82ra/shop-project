package View;

import Controller.DeveloperController;
import Controller.LoadController;
import Model.SystemInfo;
import Model.User;

import java.util.Scanner;

/**
 * when developer it comes here and do the works they want
 */

public class DeveloperMenu {
    /**
     * initializing the objects that are needed
     */
    DeveloperController developerController = new DeveloperController();
    ApplicationMenu applicationMenu = new ApplicationMenu();
    LoadController loadController = new LoadController();

    /**
     * constructor of the class
     */
    public DeveloperMenu() {
    }

    /**
     * method to do the use cases and return the boolean of it to the command processor
     * <p>
     * for every use case it goes to another menu and do the process there
     * </p>
     *
     * @param systemInfo our system
     * @param scanner    the input/command our developer has entered
     * @param user       our developer information
     * @return true or false
     */
    public boolean run(SystemInfo systemInfo, Scanner scanner, User user) {
        user.setApplications(loadController.loadUserApps(user));
        String input = scanner.nextLine();
        switch (input) {
            case "logout":
                return true;
            case "account":
                systemInfo.setUsers(developerController.setAccountNumber(systemInfo, user, scanner));
                return false;
            case "apps":
                user.setApplications(loadController.loadUserApps(user));
                applicationMenu.run(2, user, scanner, systemInfo);
                return false;
            default:
                System.out.println("Invalid command!");
                return false;
        }
    }
}
