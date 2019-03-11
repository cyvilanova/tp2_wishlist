
package Controller;

import Model.WishlistCategory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thia
 */
public class WishlistCategoryController {
    WishlistCategory wishlistCategoryModel;

    /**
     *
     */
    public WishlistCategoryController() {
        this.wishlistCategoryModel = new WishlistCategory();
    }
        
    /**
     *
     * @return
     */
    public ArrayList<String> getAll() {
        try {
            return wishlistCategoryModel.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(WishlistCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param name
     */
    public void newCategory(String name) {
        try {
            if(wishlistCategoryModel.getCategoryId(name) == null)
                wishlistCategoryModel.insert(name);
        } catch (SQLException ex) { 
             Logger.getLogger(WishlistCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public String getCategoryName(Integer get) {
        try {
            return wishlistCategoryModel.getCategoryName(get);
        } catch (SQLException ex) {
            Logger.getLogger(WishlistCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
