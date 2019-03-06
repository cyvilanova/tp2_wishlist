package Model;

/**
 *
 * @author Thia
 */
public class WishlistCategory {

    private String name;

    /**
     *
     * @param listCategoryName
     * @param listCategoryDescription
     */
    public WishlistCategory(String listCategoryName, String listCategoryDescription) {
        this.name = listCategoryName;
    }
    
    /**
     * Creates the category in the database if it doesn't already exist
     */
    public void createCategory() {

    }
    
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
