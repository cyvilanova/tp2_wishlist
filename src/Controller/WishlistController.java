/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Wishlist;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thia
 */
public class WishlistController {
    Wishlist wishlistModel;

    /**
     *
     */
    public WishlistController() {
        this.wishlistModel = new Wishlist();
    }
    
    /**
     *
     * @param name
     * @param description
     * @param categories
     */
    public void newWishlist(String name, String description, List<String> categories) {
        Wishlist newWishlist = new Wishlist(name, description);
        try {
            newWishlist.insert(categories);
        } catch (SQLException ex) {
            Logger.getLogger(WishlistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Wishlist> getUsersWishlists() {
        ArrayList<Wishlist> wishlists = new ArrayList<>();
        
        try {
            wishlists = wishlistModel.getUsersWishlists();
            
        } catch (SQLException ex) {
            Logger.getLogger(WishlistController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return wishlists;
    }

    public boolean nameIsTaken(String name) {
        Wishlist newWishlist = new Wishlist(name);
        
        try {
            return newWishlist.nameIsTaken();
        } catch (SQLException ex) {
            Logger.getLogger(WishlistController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public void delete(Integer wishlistId) {
        try {
            wishlistModel.delete(wishlistId);
        } catch (SQLException ex) {
            Logger.getLogger(WishlistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
