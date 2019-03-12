package Model;

import Controller.CurrencyController;
import tp2_wishlist.SimpleDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * An item the user wishes to get or wants to achieve. It has a name and can
 * have a price, an url and a description.
 */
public class Item {

    private Integer id;
    private String name;
    private Double price;
    private String link;
    private String description;
    private Integer currencyId;
    private Integer categoryId;

    /**
     * Creates an item.
     *
     * @param name The name of the item
     * @param price The price of the item
     * @param url The link where to get the item
     * @param description The description of the item
     */
    public Item(String name, Double price, String url, String description) {
        this.name = name;
        this.price = price;
        this.link = url;
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
            stat.setString(3, link);
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
     * Gets the link where to get the item.
     *
     * @return The link where to get the item
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the link where to get the item.
     *
     * @param link The link where to get the item
     */
    public void setLink(String link) {
        this.link = link;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    
    public ArrayList<Item> getWishlistItems(Integer wishlistId) throws SQLException {
        Connection conn = SimpleDataSource.getConnection();
        ArrayList<Item> items = new ArrayList<>();

        String queryWishlist = "SELECT * FROM item "
                + "JOIN ta_wishlist_item ON item.id_item = ta_wishlist_item.id_item "
                + "WHERE id_wishlist = " + wishlistId + ";";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(queryWishlist);

        while (rs.next()) {
            Item item = new Item();
            item.setId(rs.getInt("id_item"));
            item.setName(rs.getString("name"));
            item.setPrice(rs.getDouble("price"));
            item.setLink(rs.getString("link"));
            item.setDescription(rs.getString("description"));
            item.setCurrencyId(rs.getInt("id_currency"));
            item.setCategoryId(rs.getInt("id_item_category"));

            items.add(item);
        }

        return items;
    }

    public Integer getId() {
        return id;
    }

    public void deleteFromWishlist(Integer wishlistId, Integer itemId) throws SQLException {
        Connection conn = SimpleDataSource.getConnection();

        try {
            PreparedStatement deleteTAItemWishlist = conn.prepareStatement(
                    "DELETE FROM ta_wishlist_item WHERE id_wishlist = " + wishlistId + " AND id_item = " + itemId + ";"
            );
            deleteTAItemWishlist.executeUpdate();

        } finally {
            conn.close();
        }
    }

    public String getCurrency() {
        CurrencyController currencyController = new CurrencyController();
        return currencyController.getSymbol(this.currencyId);
    }
}
