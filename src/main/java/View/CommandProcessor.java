package View;

import Controller.LoadController;
import Controller.RegisterController;
import Model.SystemInfo;
import Model.User;

import java.util.Scanner;

/**
 * this is where our program comes when it starts
 */
public class CommandProcessor {
    /**
     * constructor our class
     */
    public CommandProcessor() {
    }

    /**
     * initializing the objects that are needed
     */
    RegisterController registerController = new RegisterController();
    DeveloperMenu developerMenu = new DeveloperMenu();
    CustomerMenu customerMenu = new CustomerMenu();
    SystemInfo systemInfo = new SystemInfo();
    LoadController loadController = new LoadController();
    User user;

    /**
     * class that choose which use case is running by the input we enter
     * <p>
     * before all we load our system information from file
     * with every different use case controller do the works on objects we pass and then the result is printed in console
     * for login we first find out if its user/developer then will go the menu of them
     * </p>
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean mainMenu = true;
        String input;
        int whichMenu = 0;
        while (true) {
            systemInfo.setUsers(loadController.loadUser(systemInfo));
            systemInfo.setApplications(loadController.loadAllApps(systemInfo));
            if (mainMenu) {
                System.out.println("Welcome to the application!");
                input = scanner.nextLine();
                switch (input) {

                    case "login" -> {
                        String username = scanner.nextLine();
                        while (!registerController.isUserNameExist(systemInfo, username)) {
                            System.out.println("Username does not exist :(");
                            System.out.print("Please enter ur username again : ");
                            username = scanner.nextLine();
                        }
                        String password = scanner.nextLine();
                        while (!registerController.isPasswordCorrect(systemInfo, username, password)) {
                            System.out.println("Wrong password :(");
                            System.out.print("Please enter ur password again : ");
                            password = scanner.nextLine();
                        }
                        mainMenu = false;
                        for (User systemInfoUser : systemInfo.getUsers()) {
                            if (systemInfoUser.getUserName().equals(username)) user = systemInfoUser;
                        }
                        if (user.isDeveloper()) whichMenu = 2;
                        else whichMenu = 1;

                    }
                    case "signup" -> {
                        System.out.println("Enter user if you want to sign up as a user, and developer if you want to sign up as a developer:");
                        input = scanner.nextLine();
                        if (input.equals("user")) {
                            String name = scanner.nextLine();
                            String userName = scanner.nextLine();
                            while (registerController.isUserNameUnique(systemInfo, userName)) {
                                System.out.println("Username exists :(");
                                System.out.print("Enter again : ");
                                userName = scanner.nextLine();
                            }
                            String password = scanner.nextLine();
                            while (!registerController.matchPassword(password)) {
                                System.out.println("password is weak!");
                                System.out.print("Enter again : ");
                                password = scanner.nextLine();
                            }
                            if (registerController.signup(systemInfo, 1, name, userName, password) != null)
                                System.out.println("Signup successful!");

                        } else if (input.equals("developer")) {
                            String name = scanner.nextLine();
                            String userName = scanner.nextLine();
                            while (registerController.isUserNameUnique(systemInfo, userName)) {
                                System.out.println("Username exists :(");
                                System.out.print("Enter again : ");
                                userName = scanner.nextLine();
                            }
                            String password = scanner.nextLine();
                            while (!registerController.matchPassword(password)) {
                                System.out.println("password is weak!");
                                System.out.print("Enter again : ");
                                password = scanner.nextLine();
                            }
                            if (registerController.signup(systemInfo, 2, name, userName, password) != null)
                                System.out.println("Signup successful!");

                        } else System.out.println("Invalid command!");
                    }
                    case "exit" -> {
                        System.out.println("Have a good day :)");
                        return;
                    }
                    default -> {
                        System.out.println("Invalid command!");
                    }
                }
            } else {
                System.out.println("Welcome, " + user.getName() + "!");
                if (whichMenu == 2) {
                    user.setApplications(loadController.loadUserApps(user));
                    mainMenu = developerMenu.run(systemInfo, scanner, user);
                } else {
                    user.setApplications(loadController.loadDownloadApps(user));
                    mainMenu = customerMenu.run(systemInfo, scanner, user);
                }
            }
        }
    }
}
