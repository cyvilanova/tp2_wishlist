package Model;

/**
 *
 * @author Thia
 */
public class User {

    private String username;
    private String password;
    
    /**
     *
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    /**
     * Inserts the user in the database
     */
    public void createUser() {

    }

    
    /**
     * Updates the current info of the user inside the database.
     */
    public void updateUser() {

    }

    /**
     * Check if the user entered a password that matches with the one in the db
     * @return true if the password is valid for the username.
     */
    public boolean testPassword() {

        return true;
    }

    /**
     * This function updates the userPassword in the database. Performs a testPassword before updating it.
     */
    public void updatePassword() {

        if (!this.testPassword()) {
        }
    }
    
    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param userName
     */
    public void setUsername(String userName) {
        this.username = userName;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }


}
