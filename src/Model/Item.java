package Model;

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
     * Inserts the item in the database.
     */
    public void insert() {

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
