package Model;

import java.util.ArrayList;

/**
 * A wishlist of items the user would like to get
 */
public class Wishlist {

    private String name;
    private String description;
    private ArrayList<Item> items;

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
     * Deletes the wishlist from the database
     */
    public void delete() {

    }

    /**
     * Inserts the wishlist in the database
     */
    public void insert() {

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
     * Gets the arraylist of items in the wishlist
     *
     * @return The arraylist of items in the wishlist
     */
    public ArrayList<Item> getListItems() {
        return items;
    }

    /**
     * Adds an item to the arraylist
     *
     * @param item The item to add to the wishlist
     */
    public void addItem(Item item) {
        this.items.add(item);
    }
}
