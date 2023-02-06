package Controller;

import Model.Application;
import Model.SystemInfo;
import Model.User;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * class to do the works of on our objects and pass it back to view
 */
public class ApplicationController {

    /**
     * constructor of our class
     */

    public ApplicationController() {
    }

    /**
     * method to sort all of our applications
     *
     * @param applications all applications
     * @return list of all applications
     */
    public ArrayList<Application> allApplications(ArrayList<Application> applications) {
        applications.sort(new Sort());
        return applications;
    }

    /**
     * method to sort the list of application that our user downloaded
     *
     * @param applications list of downloaded application
     * @return sorted downloaded applications
     */
    public ArrayList<Application> downloadApplications(ArrayList<Application> applications) {
        applications.sort(new Sort());
        return applications;
    }

    /**
     * method to sort the list of applications were created by developer
     *
     * @param applications list of created applications
     * @return sorted created applications
     */
    public ArrayList<Application> developerApplications(ArrayList<Application> applications) {
        applications.sort(new Sort());
        return applications;
    }

    /**
     * method to change information of our user in system after downloading an application
     * and changing the amount of user money in bank
     * and changing list of pur application data in our user model
     *
     * @param systemInfo system of our program
     * @param user       user that was passed to our function from one of view classes
     * @return list of all users
     */
    public ArrayList<User> setUser(SystemInfo systemInfo, User user) {
        for (User systemInfoUser : systemInfo.getUsers()) {
            if (systemInfoUser.getUserName().equals(user.getUserName())) {
                systemInfoUser.setBalance(user.getBalance());
                systemInfoUser.setApplications(user.getApplications());
            }
        }
        return systemInfo.getUsers();
    }

    /**
     * class to sort our application base on names
     *
     * @see java.util.Comparator
     */
    static class Sort implements Comparator<Application> {
        /**
         * method for comparing names of our apps
         *
         * @param application1 first app
         * @param application2 second app
         * @return a number (-1,0,1) and base on the number it sorts the apps.
         */
        public int compare(Application application1, Application application2) {
            return application1.getName().compareTo(application2.getName());
        }
    }
}

