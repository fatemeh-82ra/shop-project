package View;

import Controller.ApplicationController;
import Controller.LoadController;
import Model.Application;
import Model.SystemInfo;
import Model.User;
import Utilitie.Records;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * our application menu to pass the request to our controller and print the result in the console
 */
public class ApplicationMenu {

    /**
     * initializing the objects that are needed
     */
    ApplicationController applicationController = new ApplicationController();
    LoadController loadController = new LoadController();

    /**
     * constructor of the class
     */
    public ApplicationMenu() {
    }

    /**
     * class that choose which use case is running by the parameters was defined
     * <p>
     * every use case has its different if in the while loop
     * by calling them the controller do the works and then it comes back here and show the result
     * int some use case we save the objects that was changed or added in the file
     * </p>
     *
     * @param which      whether It's for apps or downloaded apps
     * @param user       user/developer
     * @param scanner    our input
     * @param systemInfo our system
     */
    public void run(int which, User user, Scanner scanner, SystemInfo systemInfo) {
        while (true) {
            ArrayList<String> applicationNames = new ArrayList<>();
            boolean isEmpty = true;
            if (which == 1) {

                if (!user.getApplications().isEmpty()) {
                    System.out.println("Apps:");
                }
                ArrayList<Application> applications = new ArrayList<>(user.getApplications());
                applications = applicationController.downloadApplications(applications);
                for (Application application : applications) {
                    System.out.println(application.getName());
                    applicationNames.add(application.getName());
                    isEmpty = false;
                }
            } else if (which == 2) {
                if (!user.getApplications().isEmpty()) {
                    System.out.println("Apps:");
                }
                ArrayList<Application> applications = new ArrayList<>(user.getApplications());
                applications = applicationController.developerApplications(applications);
                for (Application application : applications) {
                    System.out.println(application.getName());
                    applicationNames.add(application.getName());
                    isEmpty = false;
                }

            } else {
                if (!systemInfo.getApplications().isEmpty()) {
                    System.out.println("Apps:");
                }
                ArrayList<Application> applications = new ArrayList<>(systemInfo.getApplications());
                applications = applicationController.allApplications(applications);
                for (Application application : applications) {
                    System.out.println(application.getName());
                    applicationNames.add(application.getName());
                    isEmpty = false;
                }
            }
            if (isEmpty) {
                System.out.println("No apps!");
            }
            String input = scanner.nextLine();
            if (input.equals("back")) {
                return;
            } else if (which == 2 && input.equals("create")) {
                String name = scanner.nextLine();
                String descriptions = scanner.nextLine();
                String price = scanner.nextLine();
                Application application = new Application(name, descriptions, Double.parseDouble(price));
                if (user.getAccountNumber().equals("0")) {
                    System.out.println("No account number :(");
                    continue;
                }
                user.addApplication(application);
                systemInfo.addApplication(application);
                application.setDeveloperName(user.getName());
                System.out.println("App added!");
                Records.save(user.getApplications(), "created-apps.txt");
                Records.save(systemInfo.getApplications(), "all-apps.txt");
            } else if (applicationNames.contains(input)) {
                Flag:
                for (Application application : systemInfo.getApplications()) {
                    if (application.getName().equals(input)) {
                        while (true) {
                            System.out.println(application.getName());
                            System.out.println(application.getDescriptions());
                            BigDecimal bdDown = BigDecimal.valueOf(application.getPrice()).setScale(2, RoundingMode.DOWN);
                            System.out.println("Price: " + bdDown);
                            if (which == 2) System.out.println("Downloads: " + application.getDownloadNumber());
                            else System.out.println("Developer: " + application.getDeveloperName());
                            input = scanner.nextLine();
                            while (true) {
                                if (input.equals("back")) {
                                    break Flag;
                                } else if (input.equals("download")) {
                                    if (user.getApplications().contains(application)) {
                                        System.out.println("Invalid command!");
                                        break;
                                    } else if (user.getBalance() < application.getPrice()) {
                                        System.out.println("Not enough balance :(");
                                        break;
                                    } else {
                                        System.out.println("Downloaded!");
                                        user.addApplication(application);
                                        user.setBalance(user.getBalance() - application.getPrice());
                                        application.setDownloadNumber(application.getDownloadNumber() + 1);
                                        Records.save(user.getApplications(), "download-apps.txt");
                                        systemInfo.setUsers(applicationController.setUser(systemInfo, user));
                                        Records.save(systemInfo.getUsers(), "user.txt");
                                        systemInfo.setUsers(loadController.loadUser(systemInfo));
                                        break;
                                    }
                                } else {
                                    System.out.println("Invalid command!");
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("Invalid command!");
            }
        }
    }
}
