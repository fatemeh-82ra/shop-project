package View;

import Controller.CustomerController;
import Controller.LoadController;
import Model.SystemInfo;
import Model.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * when user it comes here and do the works they want
 */
public class CustomerMenu {
    /**
     * initializing the objects that are needed
     */
    CustomerController customerController = new CustomerController();
    ApplicationMenu applicationMenu = new ApplicationMenu();
    LoadController loadController = new LoadController();

    /**
     * constructor of the class
     */
    public CustomerMenu() {
    }

    /**
     * method to do the use cases and return the boolean of it to the command processor
     * <p>
     * for every use case it goes to another menu and do the process there
     * </p>
     *
     * @param systemInfo our system
     * @param scanner    the input/command our user has entered
     * @param user       our user information
     * @return true or false
     */
    public boolean run(SystemInfo systemInfo, Scanner scanner, User user) {
        user.setApplications(loadController.loadDownloadApps(user));
        String input = scanner.nextLine();
        switch (input) {
            case "logout":
                return true;
            case "apps":
                systemInfo.setApplications(loadController.loadAllApps(systemInfo));
                applicationMenu.run(3, user, scanner, systemInfo);
                return false;
            case "downloads":
                user.setApplications(loadController.loadDownloadApps(user));
                applicationMenu.run(1, user, scanner, systemInfo);
                return false;
            case "balance":
                BigDecimal bdDown = BigDecimal.valueOf(user.getBalance()).setScale(2, RoundingMode.DOWN);
                System.out.println(bdDown);
                return false;
            case "deposit":
                systemInfo.setUsers(customerController.deposit(systemInfo, scanner, user));
                return false;
            default:
                System.out.println("Invalid command!");
                return false;
        }
    }
}
