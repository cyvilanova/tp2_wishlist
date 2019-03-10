package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tp2_wishlist.SimpleDataSource;

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
     *
     */
    public User() {
    }

    /**
     * Inserts the user in the database
     * @throws java.sql.SQLException
     */
    public void insert() throws SQLException {
        Connection conn = SimpleDataSource.getConnection();

        try {
            PreparedStatement stat = conn.prepareStatement("INSERT INTO user(username, password) VALUES(?,?);");
            stat.setString(1, username);
            stat.setString(2, password);
            stat.executeUpdate();
        } finally {
            conn.close();
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

    /**
     *
     * @return
     * @throws SQLException
     */
    public Integer getUserId() throws SQLException {
        Connection conn = SimpleDataSource.getConnection();

        Integer userId = null;
        try {
            String query = "SELECT id_user FROM user WHERE username = \"" + username + "\" AND password = \"" + password + "\";";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                userId = rs.getInt(1);
            }

        } finally {
            conn.close();
        }
        return userId;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public boolean usernameIsTaken() throws SQLException {
        Connection conn = SimpleDataSource.getConnection();

        try {
            String query = "SELECT id_user FROM user WHERE username = \"" + username + "\";";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            return rs.first();

        } finally {
            conn.close();
        }
    }

}
