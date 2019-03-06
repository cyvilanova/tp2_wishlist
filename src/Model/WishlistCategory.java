package Model;

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
     * Creates the category in the database if it doesn't already exist
     */
    public void createCategory() {

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
}
