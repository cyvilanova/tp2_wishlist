/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ItemCategory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thia
 */
public class ItemCategoryController {
    ItemCategory itemCategoryModel;
    
    /**
     *
     */
    public ItemCategoryController() {
        this.itemCategoryModel = new ItemCategory();
    }
    
    /**
     *
     * @return
     */
    public ArrayList<String> getAll() {
        try {
            return itemCategoryModel.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(ItemCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param category
     * @return
     */
    public Integer getId(String category) {
        try {
            return itemCategoryModel.getCategoryId(category);
        } catch (SQLException ex) {
            Logger.getLogger(CurrencyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getCategoryName(Integer categoryId) {
        try {
            return itemCategoryModel.getName(categoryId);
        } catch (SQLException ex) {
            Logger.getLogger(ItemCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
