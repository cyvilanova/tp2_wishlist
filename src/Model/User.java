package Model;

/**
 * A user using the application and connecting to the database with an username
 * and a password to create, to edit or to see their wishlists.
 */
public class User {

    private String username;
    private String password;

    /**
     * Creates a user
     *
     * @param username The username of the user
     * @param password The password of the user
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Inserts the user in the database
     */
    public void insert() {

    }

    /**
     * Updates the current information of the user in the database.
     */
    public void update() {

    }

    /**
     * Checks if the user entered a password that matches with the one in the
     * database
     *
     * @return true if the password is valid for the username.
     */
    public boolean isPasswordValid() {

        return true;
    }

    /**
     * This function updates the userPassword in the database.
     */
    public void updatePassword() {

        if (!isPasswordValid()) {
        }
    }

    /**
     * Gets the username of the user
     *
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user
     *
     * @param username The username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user
     *
     * @return The password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user
     *
     * @param password The password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
