package Model;

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
}
