/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thia
 */
public class ItemCategoryController {

    public static ArrayList<String> getAll() {
        try {
            return Model.ItemCategory.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(ItemCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Integer getId(String category) {
        try {
            return Model.ItemCategory.getCategoryId(category);
        } catch (SQLException ex) {
            Logger.getLogger(CurrencyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
