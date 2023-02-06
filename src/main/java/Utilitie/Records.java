package Utilitie;

import java.io.*;

/**
 * a class to save and load our serializable object, so we can use them later after rerunning our program.
 *
 * @see Exception
 */
public class Records {

    /**
     * method to save the serializable objects in a file
     *
     * @param serializable an object to be serialized
     * @param file         the name of the file where want to save it
     */
    public static void save(Object serializable, String file) {

        /**
         * using try catch in case an exception accused so our program won't stop working
         * @throws IOException
         * @serialData out
         */
        try {

            FileOutputStream fOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fOut);
            out.writeObject(serializable);
            out.flush();
            out.close();
            fOut.close();
        } catch (Exception e) {
            System.out.println("IOException is caught");
        }
    }

    /**
     * method to load our objects' data from a file to use them in our program
     *
     * @param file name of our file
     * @return the objects we need to use/ it can be null too.
     */
    public static Object load(String file) {
        /**
         * using try catch in case an exception accused so our program won't stop working
         * @throws IOException
         * @serialData in
         */
        try {
            Object s = null;
            File file1 = new File(file);
            if (file1.exists()) {
                FileInputStream file2 = new FileInputStream(file1);
                ObjectInputStream in = new ObjectInputStream(file2);
                s = in.readObject();
                in.close();
                file2.close();
            }
            return s;
        } catch (Exception e) {
            System.out.println("IOException is caught");
        }
        return null;
    }
}
