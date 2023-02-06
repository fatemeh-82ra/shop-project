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
public class CustomerController {
    /**
     * constructor of our class
     */
    public CustomerController() {
    }

    /**
     * method to change the amount of money of our user in back
     * <p>
     * it also change the information of our user in system info and save it in the file
     * by finding the user in the system info and change the data of it the do the above process
     * </p>
     *
     * @param systemInfo our system information
     * @param scanner    the amount o money user want to put in his bank
     * @param user       the user that longed in
     * @return the list of all users in our system
     */
    public ArrayList<User> deposit(SystemInfo systemInfo, Scanner scanner, User user) {
        String amount = scanner.nextLine();
        user.setBalance(user.getBalance() + Double.parseDouble(amount));
        List<User> users = new ArrayList<>();
        users = (List<User>) Records.load("user.txt");
        // checking if the list is null or not
        if (users != null) {
            for (User user1 : users) {
                //finding the user by checking the usernames
                if (user1.getUserName().equals(user.getUserName())) {
                    user1.setBalance(user1.getBalance() + Double.parseDouble(amount));
                }
            }
        }
        systemInfo.setUsers((ArrayList<User>) users);
        //saving the users again in our file
        Records.save(systemInfo.getUsers(), "user.txt");
        return systemInfo.getUsers();
    }
}
