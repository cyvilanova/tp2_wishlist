package Controller;
import Model.Item;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Calls the methods from the class Item 
 * and the methods to access the database.
 */
public class ItemController {
    Item itemModel;
    WishlistController wishlistController;

    /**
     *
     */
    public ItemController() {
        this.wishlistController = new WishlistController();
        this.itemModel = new Item();
    }

    /**
     *
     * @param name
     * @param price
     * @param link
     * @param description
     * @param id_currency
     * @param id_item_category
     * @param getWishlistId
     */
    public void insertItem(String name, Double price, String link, String description, Integer id_currency, Integer id_item_category, Integer wishlistId) {
            Item newItem = new Item(name, price, link, description);
            try {
                newItem.insert(id_currency, id_item_category, wishlistId);
            } catch (SQLException ex) {
                Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
