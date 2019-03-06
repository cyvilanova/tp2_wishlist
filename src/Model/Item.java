package Model;

/**
 *
 * @author Thia
 */
public class Item {

    private String name;
    private Double price;
    private String url;
    private String description;

    /**
     *
     * @param name
     * @param price
     * @param url
     * @param description
     */
    public Item(String name, Double price, String url, String description) {
        this.name = name;
        this.price = price;
        this.url = url;
        this.description = description;
    }

    /**
     * Create a new Item in the database
     */
    public void createItem() {

    }

    /**
     * Updates EntityPirce, EntityUrl and EntityDescription in the database
     */
    public void updateListEntity() {

    }

    /**
     *
     * @return
     */
    public String getListEntityName() {
        return name;
    }

    /**
     *
     * @param listEntityName
     */
    public void setListEntityName(String listEntityName) {
        this.name = listEntityName;
    }

    /**
     *
     * @return
     */
    public Double getListEntityPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setListEntityPrice(Double price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
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
}
