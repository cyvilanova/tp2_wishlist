package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp2_wishlist.SimpleDataSource;

/**
 * A category of wishlist
 */
public class WishlistCategory {

    private String name;

    /**
     * Creates a category of wishlist
     *
     * @param name The name of the wishlist category
     */
    public WishlistCategory(String name) {
        this.name = name;
    }

    /**
     *
     */
    public WishlistCategory() {
    }

    /**
     * Gets the wishlist category's name
     *
     * @return name The name of the category
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the wishlist category's name
     *
     * @param name The name of the category
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return @throws SQLException
     */
    public ArrayList<String> getAll() throws SQLException {

        ArrayList<String> categories = new ArrayList<>();

        Connection conn = SimpleDataSource.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT name FROM wishlist_category;");

            while (rs.next()) {
                categories.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WishlistCategory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
        return categories;
    }

    /**
     *
     * @param category
     * @return
     * @throws SQLException
     */
    public Integer getCategoryId(String category) throws SQLException {
        Connection conn = SimpleDataSource.getConnection();

        Integer categoryId = null;
        try {
            String query = "SELECT id_wishlist_category FROM wishlist_category WHERE name = \"" + category + "\";";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                categoryId = rs.getInt(1);
            }

        } finally {
            conn.close();
        }
        return categoryId;
    }

    public String getCategoryName(Integer id) throws SQLException {
        Connection conn = SimpleDataSource.getConnection();

        String categoryName = "";
        
        try {
            String query = "SELECT name FROM wishlist_category WHERE id_wishlist_category = " + id + ";";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                categoryName = rs.getString(1);
            }
        } finally {
            conn.close();
        }

        return categoryName;
    }

    /**
     * Creates the category in the database if it doesn't already exist
     *
     * @param name
     * @throws java.sql.SQLException
     */
    public void insert(String name) throws SQLException {
        Connection conn = SimpleDataSource.getConnection();

        try {
            PreparedStatement stat = conn.prepareStatement("INSERT INTO wishlist_category(name) VALUES(?);");
            stat.setString(1, name);
            stat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(WishlistCategory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }
}
