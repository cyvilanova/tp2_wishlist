package Controller;

import Model.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class UserController {
    User userModel;
    static Integer userId;

    /**
     *
     */
    public UserController() {
        this.userModel = new User();
    }
    
    /**
     * Check if the account the user is trying to log into exists 
     * in the database.
     * @param username The username of the account
     * @param password The password of the account
     * @return true if the login is successful, false if the username
     * or the password entered is wrong
     */
    public boolean userExists(String username, String password) {
        
        User newUser = new User(username, password);
        
            Integer userConnectedId;
        try {
            userConnectedId = newUser.getUserId();
            if(userConnectedId != null) {
                setUserId(userConnectedId);
                System.out.println(userConnectedId);
                return true;
            }
            else return false;
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Checks if there is already an account with that username.
     * @param username The username of the account
     * @return true if there is already an account with this username,
     * false if it's free.
     */
    public boolean usernameIsTaken(String username) {
        
        User newUser = new User(username, "");
        
        try {
            return newUser.usernameIsTaken();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    /**
     *
     * @param username
     * @param password
     */
    public void logIn(String username, String password) {
        
    }
    
    /**
     *
     * @param username
     * @param password
     */
    public void register(String username, String password) {
        User newUser = new User(username, password);
        try {
            newUser.insert();
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static Integer getUserId() {
        return userId;
    }

    public static void setUserId(Integer userId) {
        UserController.userId = userId;
    }
}
