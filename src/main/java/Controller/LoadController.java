package Controller;

import Model.Application;
import Model.SystemInfo;
import Model.User;
import Utilitie.Records;

import java.util.ArrayList;
import java.util.List;

/**
 * a class to load the objects from our file to use them in program.
 */
public class LoadController {
    /**
     * constructor of our class
     */
    public LoadController() {
    }

    /**
     * method to get all of our users from our system
     *
     * @param systemInfo our system
     * @return th list of all users
     */
    public ArrayList<User> loadUser(SystemInfo systemInfo) {
        List<User> users = new ArrayList<>();
        users = (List<User>) Records.load("user.txt");
        if (users != null) {
            systemInfo.setUsers((ArrayList<User>) users);
        }
        return systemInfo.getUsers();
    }

    /**
     * method to load all apps from our system
     *
     * @param systemInfo our system
     * @return list of all apps
     */
    public ArrayList<Application> loadAllApps(SystemInfo systemInfo) {
        List<Application> applications = new ArrayList<>();
        applications = (List<Application>) Records.load("all-apps.txt");
        if (applications != null) {
            systemInfo.setApplications((ArrayList<Application>) applications);
        }
        return systemInfo.getApplications();
    }

    /**
     * method to get list of all applications that our developer had created
     *
     * @param user the user that has logged in
     * @return list of developer applications
     */
    public ArrayList<Application> loadUserApps(User user) {
        List<Application> apps = new ArrayList<>();
        apps = (List<Application>) Records.load("created-apps.txt");
        ArrayList<Application> applications = new ArrayList<>();
        if (apps != null) {
            for (Application app : apps) {
                if (app.getDeveloperName().equals(user.getName())) {
                    applications.add(app);
                }
            }
            user.setApplications(applications);
        }
        return user.getApplications();
    }

    /**
     * method to get list of all applications that our user had downloaded
     *
     * @param user the user that has logged in
     * @return list of user applications
     */
    public ArrayList<Application> loadDownloadApps(User user) {
        List<Application> applications = new ArrayList<>();
        applications = (List<Application>) Records.load("download-apps.txt");
        ArrayList<Application> apps = new ArrayList<>();
        if (applications != null) {
            for (Application application : user.getApplications()) {
                for (Application application1 : applications) {
                    if (application.getName().equals(application1.getName()) && application.getDeveloperName().equals(application1.getDeveloperName())) {
                        apps.add(application1);
                    }
                }
            }
            user.setApplications(apps);
        }
        return user.getApplications();
    }
}

