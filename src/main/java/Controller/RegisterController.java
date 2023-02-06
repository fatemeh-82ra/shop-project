package Controller;

import Model.SystemInfo;
import Model.User;
import Utilitie.Records;

/**
 * class to do the signup and login process of user or developer
 *
 * @author Fatemeh
 */
public class RegisterController {

    /**
     * constructor of the class
     */
    public RegisterController() {
    }

    /**
     * method to save the data(name , username,...) was entered by the user/developer in system-info
     * and saving the in the file to use this dat later after rerunning the program
     *
     * @param systemInfo our system
     * @param which      a number that define whether it's a user or developer
     * @param name       name of the user/developer
     * @param username   username of the user/developer
     * @param password   password of the user/developer
     * @return our user
     */
    public User signup(SystemInfo systemInfo, int which, String name, String username, String password) {
        User user;
        if (which == 1) {
            user = new User(name, username, password, false);
            systemInfo.addUser(user);
            Records.save(systemInfo.getUsers(), "user.txt");
        } else {
            user = new User(name, username, password, true);
            systemInfo.addUser(user);
            Records.save(systemInfo.getUsers(), "user.txt");
        }
        return user;
    }

    /**
     * method to check the quality of the password was entered using regex
     *
     * @param password our user/developer password
     * @return whether it is strong or weak
     */
    public boolean matchPassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])+(?=.*[A-Z])([0-9]*[a-zA-Z]){5,}[0-9]*");
    }

    /**
     * checking if the username that user using to log in exist in the dat of the user or not
     *
     * @param systemInfo our system
     * @param username   username of our user/developer
     * @return whether the username was entered is wrong or correct
     */
    public boolean isUserNameExist(SystemInfo systemInfo, String username) {
        for (User user : systemInfo.getUsers()) {
            if (user.getUserName().equals(username)) return true;
        }
        return false;
    }

    /**
     * checking if the user want to log in is correct
     *
     * @param systemInfo our system
     * @param username   username of our user/developer
     * @param password   password of our user/developer
     * @return whether the password is correct or not
     */
    public boolean isPasswordCorrect(SystemInfo systemInfo, String username, String password) {
        for (User user : systemInfo.getUsers()) {
            if (user.getUserName().equals(username))
                if (user.getPassword().equals(password)) return true;
        }
        return false;
    }

    /**
     * checking if the username was entered is unique or not
     *
     * @param systemInfo our system
     * @param userName   username of our user/developer
     * @return whether the username has been used before or not
     */
    public boolean isUserNameUnique(SystemInfo systemInfo, String userName) {
        for (User user : systemInfo.getUsers()) {
            if (user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
}
