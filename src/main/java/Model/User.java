package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * our model class is for saving information of our users like name , username,... .
 * also we implement Serializable to save the information we want in our file to have them even after rerunning our program.
 * all the fields need to be saved in files
 *
 * @author Fatemeh
 * @see java.io.Serializable
 */

public class User implements Serializable {
    /**
     * our attributes of our class
     *
     * @serial name
     * @serial username
     * @serial password
     * @serial applications
     * @serial balance
     * @serial account number
     * @serial isDeveloper
     */
    private final String name;
    private final String userName;
    private final String password;
    private ArrayList<Application> applications;
    private double balance;
    private String accountNumber;
    boolean isDeveloper;

    /**
     * constructor to make new object(name , username , password , isDeveloper) of our class
     *
     * @param name        name of the user
     * @param userName    unique
     * @param password    password of the user
     * @param isDeveloper showing if the user is simple User or Developer
     */
    public User(String name, String userName, String password, boolean isDeveloper) {
        applications = new ArrayList<>();
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.isDeveloper = isDeveloper;
        accountNumber = "0";
    }

    /**
     * method to get the name of our user
     *
     * @return getting our name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * method to get the username of our user
     *
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * method to get the password of our user/developer
     *
     * @return password of the user/developer
     */
    public String getPassword() {
        return password;
    }

    /**
     * method to detect either its simple User or Developer
     *
     * @return false for User and true for Developer
     */
    public boolean isDeveloper() {
        return isDeveloper;
    }

    /**
     * method to get the account number of Developer
     *
     * @return account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * method to change the account number of our Developer
     *
     * @param accountNumber developer account number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * method to get balance of our User
     *
     * @return the amount of money that User has in their bank
     */
    public double getBalance() {
        return balance;
    }

    /**
     * changing the amount of the money of the User in their bank
     *
     * @param balance User money
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * method to return the list of applications that user has created or downloaded
     *
     * @return list of applications
     */
    public ArrayList<Application> getApplications() {
        return applications;
    }

    /**
     * adding new application to list of Application of the user
     *
     * @param application the application that was created or downloaded
     */
    public void addApplication(Application application) {
        applications.add(application);
    }

    /**
     * changing the list of our user application
     *
     * @param applications when new application is added
     */
    public void setApplications(ArrayList<Application> applications) {
        this.applications = applications;
    }
}
