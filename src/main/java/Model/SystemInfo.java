package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * where we keep data of all users and applications that was made by Developers
 * also we implement Serializable to save the information we want in our file to have them even after rerunning our program.
 * all the fields need to be saved in files
 *
 * @author Fatemeh
 * @see java.io.Serializable Serialization is a mechanism of converting the state of an object into a byte stream
 */
public class SystemInfo implements Serializable {

    /**
     * our attributes
     *
     * @serial users
     * @serial applications
     */
    private ArrayList<User> users;
    private ArrayList<Application> applications;

    /**
     * constructor to make new object of our system
     */
    public SystemInfo() {
        users = new ArrayList<>();
        applications = new ArrayList<>();
    }

    /**
     * method to get list of all users
     *
     * @return list of users
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * adding new user to ur system
     *
     * @param user when there is a new user after signup
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * method to get list of applications
     *
     * @return list of application was created
     */
    public ArrayList<Application> getApplications() {
        return applications;
    }

    /**
     * adding new application that was created to our system
     *
     * @param application mew application was created by developer
     */
    public void addApplication(Application application) {
        applications.add(application);
    }

    /**
     * changing list of users if any data of users changed during the program
     *
     * @param users list of users
     */
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * changign list of applications if any data has been changed
     *
     * @param applications list of applications
     */

    public void setApplications(ArrayList<Application> applications) {
        this.applications = applications;
    }
}
