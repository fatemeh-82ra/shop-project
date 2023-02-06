package Controller;

import Model.SystemInfo;
import Model.User;
import Utilitie.Records;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * class to do the works of on our objects and pass it back to view
 */

public class DeveloperController {
    /**
     * constructor of our class
     */
    public DeveloperController() {
    }

    /**
     * method to change the account number of the developer
     * <p>
     * after the account number changed we will find the developer in our list of users in our system
     * and change the date there too then will save the list of all users in our file
     * </p>
     *
     * @param systemInfo our system information
     * @param user       our developer
     * @param scanner    the account number developer has entered
     * @return the list of all users from our system
     */
    public ArrayList<User> setAccountNumber(SystemInfo systemInfo, User user, Scanner scanner) {
        String accountNumber = scanner.nextLine();
        user.setAccountNumber(accountNumber);
        List<User> users = new ArrayList<>();
        users = (List<User>) Records.load("user.txt");
        if (users != null) {
            for (User user1 : users) {
                if (user1.getUserName().equals(user.getUserName())) {
                    user1.setAccountNumber(accountNumber);
                }
            }
        }
        systemInfo.setUsers((ArrayList<User>) users);
        Records.save(systemInfo.getUsers(), "user.txt");
        return systemInfo.getUsers();
    }
}
