/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Thia
 */
public class ItemCategory {
    
    private String name;

    /**
     *
     * @param listCategoryName
     * @param listCategoryDescription
     */
    public ItemCategory(String listCategoryName, String listCategoryDescription) {
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
