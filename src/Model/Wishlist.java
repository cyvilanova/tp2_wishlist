package Model;

import Controller.UserController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp2_wishlist.SimpleDataSource;

/**
 * A wishlist of items the user would like to get
 */
public class Wishlist {

    private String name;
    private String description;
    private Integer id;
    private ArrayList<Integer> categoryIds;
    
    /**
     * Creates a wishlist
     *
     * @param name The name of the wishlist
     * @param description The description of the wishlist
     */
    public Wishlist(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     *
     */
    public Wishlist() {
    }

    /**
     *
     * @param name
     */
    public Wishlist(String name) {
        this.name = name;
    }

    /**
     * Deletes the wishlist from the database
     */
    public void delete() {

    }

    /**
     * Inserts the wishlist in the database
     *
     * @param categories
     * @throws java.sql.SQLException
     */
    public void insert(List<String> categories) throws SQLException {
        Connection conn = SimpleDataSource.getConnection();
        WishlistCategory wishlistCategory = new WishlistCategory();
        
        Integer wishlistId = null;
        
        try {
            PreparedStatement addWishlist = conn.prepareStatement("INSERT INTO wishlist(name, description, id_user) VALUES(?,?,?);");
            addWishlist.setString(1, name);
            addWishlist.setString(2, description);
            addWishlist.setInt(3, UserController.userId);
            addWishlist.executeUpdate();
            
            String itemIdQuery = "SELECT LAST_INSERT_ID()";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(itemIdQuery);

            if (rs.next()) {
                wishlistId = rs.getInt(1);
            }
            
            for(int i = 0; i < categories.size(); i++) {
                Integer categoryId = wishlistCategory.getCategoryId(categories.get(i));
                System.out.println(categories.get(i));
                PreparedStatement stat = conn.prepareStatement("INSERT INTO ta_category_wishlist(id_wishlist_category, id_wishlist) VALUES(?,?);");
                stat.setInt(1, categoryId);
                stat.setInt(2, wishlistId);
                stat.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Wishlist.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }

    /**
     * Gets the name of the wishlist
     *
     * @return The name of the wishlist
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the wishlist
     *
     * @param name The name of the wishlist
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the wishlist
     *
     * @return The description of the wishlist
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the wishlist
     *
     * @param description The description of the wishlist
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getCategoryIds() {
        return categoryIds;
    }

    /**
     *
     * @param categoryIds
     */
    public void setCategoryIds(ArrayList<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return The id of the wishlist in the database
     * @throws SQLException
     */
    public Integer getWishlistId() throws SQLException {
        Connection conn = SimpleDataSource.getConnection();

        Integer wishlistId = null;

        try {
            String query = "SELECT id_wishlist FROM wishlist WHERE name = \"" + name + "\" AND description = \"" + description + "\" AND id_user = " + UserController.userId + ";";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                wishlistId = rs.getInt(1);
            }

        } finally {
            conn.close();
        }
        return wishlistId;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Wishlist> getUsersWishlists() throws SQLException {
        Connection conn = SimpleDataSource.getConnection();
        ArrayList<Wishlist> wishlists = new ArrayList<>();

        String queryWishlist = "SELECT * FROM wishlist WHERE id_user = \"" + UserController.userId + "\";";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(queryWishlist);

        while (rs.next()) {
            Wishlist wishlist = new Wishlist();
            wishlist.setId(rs.getInt("id_wishlist"));
            wishlist.setName(rs.getString("name"));
            wishlist.setDescription(rs.getString("description"));

            ArrayList<Integer> wishlistCategoryIds = new ArrayList<>();
            String queryCategories = "SELECT id_wishlist_category FROM ta_category_wishlist WHERE id_wishlist = " + rs.getInt("id_wishlist") + ";";
            st = conn.createStatement();
            ResultSet rsCategories = st.executeQuery(queryCategories);

            while (rsCategories.next()) {
                wishlistCategoryIds.add(rsCategories.getInt(1));
            }
            wishlist.setCategoryIds(wishlistCategoryIds);
            wishlists.add(wishlist);
        }

        return wishlists;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public boolean nameIsTaken() throws SQLException {
        Connection conn = SimpleDataSource.getConnection();

        try {
            String query = "SELECT id_wishlist FROM wishlist WHERE name = \"" + name + "\";";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs.first();

        } finally {
            conn.close();
        }
    }

    /**
     *
     * @param wishlistId
     * @throws SQLException
     */
    public void delete(Integer wishlistId) throws SQLException {
        Connection conn = SimpleDataSource.getConnection();

        try {
            PreparedStatement deleteTAItem = conn.prepareStatement("DELETE FROM ta_wishlist_item WHERE id_wishlist = " + wishlistId + ";");
            deleteTAItem.executeUpdate();

            PreparedStatement deleteTACategory = conn.prepareStatement("DELETE FROM ta_category_wishlist WHERE id_wishlist = " + wishlistId + ";");
            deleteTACategory.executeUpdate();

            PreparedStatement deleteWishlist = conn.prepareStatement("DELETE FROM wishlist WHERE id_wishlist = " + wishlistId + ";");
            deleteWishlist.executeUpdate();

        } finally {
            conn.close();
        }
    }

    public String getName(Integer wishlistId) throws SQLException {
        Connection conn = SimpleDataSource.getConnection();

        try {
            String query = "SELECT name FROM wishlist WHERE id_wishlist = \"" + wishlistId + "\";";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            if (rs.next()) {
                return rs.getString(1);
            }

        } finally {
            conn.close();
        }
        return null;
    }

    public String getDescription(Integer wishlistId) throws SQLException {
        Connection conn = SimpleDataSource.getConnection();

        try {
            String query = "SELECT description FROM wishlist WHERE id_wishlist = \"" + wishlistId + "\";";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            if (rs.next()) {
                return rs.getString(1);
            }

        } finally {
            conn.close();
        }
        return null;
    }
}
