package Model;

import tp2_wishlist.SimpleDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * An item the user wishes to get or wants to achieve. It has a name and can
 * have a price, an url and a description.
 */
public class Item {

    private String name;
    private Double price;
    private String url;
    private String description;

    /**
     * Creates an item.
     *
     * @param name The name of the item
     * @param price The price of the item
     * @param url The url where to get the item
     * @param description The description of the item
     */
    public Item(String name, Double price, String url, String description) {
        this.name = name;
        this.price = price;
        this.url = url;
        this.description = description;
    }
    
    /**
     *
     */
    public Item() {}
    
    /**
     * Inserts the item in the database.
     *
     * @param id_currency The price's currency
     * @param id_item_category The item category
     * @param wishlistId
     * @throws java.sql.SQLException
     */
    public void insert(Integer id_currency, Integer id_item_category, Integer wishlistId) throws SQLException {
        Connection conn = SimpleDataSource.getConnection();

        try {
            Integer itemId = null;
            
            PreparedStatement stat = conn.prepareStatement("INSERT INTO item(name, price, link, description, id_currency, id_item_category) VALUES(?,?,?,?,?,?);");
            stat.setString(1, name);
            stat.setDouble(2, price);
            stat.setString(3, url);
            stat.setString(4, description);
            stat.setInt(5, id_currency);
            stat.setInt(6, id_item_category);
            stat.executeUpdate();
                        
            String itemIdQuery = "SELECT LAST_INSERT_ID()";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(itemIdQuery);

            if (rs.next()) {
                itemId = rs.getInt(1);
            }
            
            PreparedStatement addItemToWishlist = conn.prepareStatement("INSERT INTO ta_wishlist_item(id_wishlist, id_item) VALUES(?,?);");
            addItemToWishlist.setInt(1, wishlistId);
            addItemToWishlist.setInt(2, itemId);
            addItemToWishlist.executeUpdate();
            
        } finally {
            conn.close();
        }
    }

    /**
     * Updates the information of the item.
     */
    public void update() {

    }

    /**
     * Gets the item's name.
     *
     * @return The name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the item's name.
     *
     * @param name The name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the item's price.
     *
     * @return The price of the item
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the item's price.
     *
     * @param price The price of the item
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets the url where to get the item.
     *
     * @return The url where to get the item
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url where to get the item.
     *
     * @param url The url where to get the item
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the description of the item.
     *
     * @return The description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the item.
     *
     * @param description The description of the item
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
