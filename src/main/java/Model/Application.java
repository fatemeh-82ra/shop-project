/**
 * our Model package to holds the Application model
 */
package Model;

import java.io.Serializable;

/**
 * our class to save the data of our application
 *
 * @author Fatemeh
 * @see java.io.Serializable
 */
public class Application implements Serializable {
    /**
     * our attributes of this class
     * @serial Name
     * @serial DeveloperName
     * @serial descriptions
     * @serial download number
     * @serial price
     */
    String Name;
    String DeveloperName;
    String descriptions;
    int downloadNumber;
    double price;

    /**
     * our constructor to make new objects(name ,descriptions , price) of our Application class to add data
     *
     * @param name name of the app
     * @param descriptions details written about the app
     * @param price the price of the app
     */
    public Application(String name, String descriptions, double price) {
        Name = name;
        this.descriptions = descriptions;
        this.price = price;
        downloadNumber = 0;
    }

    /**
     * method tp get name
     *
     * @return name of the app
     */
    public String getName() {
        return Name;
    }

    /**
     * method to get the description of our app
     *
     * @return description of the app
     */
    public String getDescriptions() {
        return descriptions;
    }

    /**
     * method to get the price of our app
     *
     * @return price of the app
     */
    public double getPrice() {
        return price;
    }

    /**
     * method to see hpw many users had downloaded this app
     *
     * @return amount of being downloaded
     */
    public int getDownloadNumber() {
        return downloadNumber;
    }

    /**
     * method to change the amount of download number when a user download it
     *
     * @param downloadNumber download number of the app
     */
    public void setDownloadNumber(int downloadNumber) {
        this.downloadNumber = downloadNumber;
    }

    /**
     * method to see which developer created this app
     *
     * @return name of the developer
     */
    public String getDeveloperName() {
        return DeveloperName;
    }

    /**
     * method to set the developer name after it was created by them
     *
     * @param developerName name of the developer
     */
    public void setDeveloperName(String developerName) {
        DeveloperName = developerName;
    }
}
