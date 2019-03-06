package Model;

import java.util.ArrayList;

/**
 *
 * @author Thia
 */
public class Wishlist {

    private String name;
    private String description;
    private ArrayList<Item> items;

    /**
     *
     * @param wishlistName
     * @param wishlistDescription
     */
    public Wishlist(String wishlistName, String wishlistDescription) {
        this.name = wishlistName;
        this.description = wishlistDescription;
    }
    /**
     * Remove all the entities from the list and
     * completely removes the list from the database.
     */
    public void removeList() {

    }

    /**
     * This method loads all the info of a list and all it's
     * Entities.
     */
    public void loadList() {

    }

    /**
     * Create a new list in the database
     * This method will NOT add items in the list
     */
    public void createWishlist() {

    }

    /**
     *
     * @return
     */
    public String getListName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @param index
     * @return
     */
    public Item getItem(int index) {
        return this.items.get(index);
    }

    /**
     *
     * @return
     */
    public ArrayList<Item> getListItems() {
        return items;
    }

    /**
     *
     * @param item
     */
    public void addItem(Item item) {
        this.items.add(item);
    }
}
