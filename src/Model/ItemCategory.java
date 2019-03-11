package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp2_wishlist.SimpleDataSource;

/**
 * A category of item
 */
public class ItemCategory {

    private String name;

    /**
     * Creates an item category.
     *
     * @param name The name of the item category
     */
    public ItemCategory(String name) {
        this.name = name;
    }

    /**
     *
     */
    public ItemCategory() {}
        
    /**
     * Inserts the category of item in the database.
     */
    public void insert() {

    }

    /**
     * Gets the name of the item category.
     *
     * @return The name of the item category
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the item category.
     *
     * @param name The name of the item category
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return An arraylist of all the item categories
     * @throws SQLException
     */
    public ArrayList<String> getAll() throws SQLException {
        ArrayList<String> categories = new ArrayList<>();

        Connection conn = SimpleDataSource.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT name FROM item_category");

            while (rs.next()) {
                categories.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemCategory.class.getName()).log(Level.SEVERE, null, ex);
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
            String query = "SELECT id_item_category FROM item_category WHERE name = \"" + category + "\";";
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

}
