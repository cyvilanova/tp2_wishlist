/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ItemController;
import Controller.WishlistCategoryController;
import Controller.WishlistController;
import Model.Wishlist;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Thia
 */
public class WishlistsView extends javax.swing.JPanel {

    WishlistCategoryController wishlistCategoryController;
    WishlistController wishlistController;
    ItemController itemController;
    private final PropertyChangeSupport propChangeSupport = new PropertyChangeSupport(this);

    /**
     * Creates new form SeeWishlists
     */
    public WishlistsView() {
        this.wishlistController = new WishlistController();
        this.wishlistCategoryController = new WishlistCategoryController();
        this.itemController = new ItemController();
        initComponents();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(71, 85, 94));
        setAutoscrolls(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 969, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     */
    public void displayWishlists() {
        
        Integer leftPadding = 300;
        Integer topPadding = 40;
        
        ArrayList<Wishlist> usersWishlists = wishlistController.getUsersWishlists();

        setLayout(null);

        for (int i = 0; i < usersWishlists.size(); i++) {

            final Integer wishlistId = usersWishlists.get(i).getId();
            ArrayList<Integer> wishlistCategoryIds = usersWishlists.get(i).getCategoryIds();

            JLabel wishlistName = new JLabel(usersWishlists.get(i).getName());
            wishlistName.setBounds(leftPadding, 150 + (i * 70), 200, 30);
            wishlistName.setOpaque(true);
            wishlistName.setFont(wishlistName.getFont().deriveFont(16.0f));
            wishlistName.setBackground(Color.decode("#47555E"));
            wishlistName.setForeground(Color.white);
            add(wishlistName);

            for (int j = 0; j < wishlistCategoryIds.size(); j++) {

                JLabel categoryName = new JLabel(wishlistCategoryController.getCategoryName(wishlistCategoryIds.get(j)));
                categoryName.setBounds(leftPadding + 20 + (j * 100), 180 + (i * 70), 100, 30);
                categoryName.setOpaque(true);
                categoryName.setBackground(Color.decode("#47555E"));
                categoryName.setForeground(Color.white);
                add(categoryName);
            }
            
            JButton btnView = new JButton();
            btnView.setText("View");
            btnView.setSize(70, 25);
            btnView.setLocation(leftPadding + 375, 165 + (i * 70));
            btnView.setBackground(Color.decode("#83AAD3"));
            btnView.setForeground(Color.white);
            btnView.setBorderPainted(false);
            add(btnView);
            
            btnView.addActionListener((ActionEvent e) -> {
                propChangeSupport.firePropertyChange("btnView", null, wishlistId);
            });
            
            JButton btnAddItem = new JButton();
            btnAddItem.setText("Add item");
            btnAddItem.setSize(100, 25);
            btnAddItem.setLocation(leftPadding + 450, 165 + (i * 70));
            btnAddItem.setBackground(Color.decode("#83AAD3"));
            btnAddItem.setForeground(Color.white);
            btnAddItem.setBorderPainted(false);
            add(btnAddItem);

            btnAddItem.addActionListener((ActionEvent e) -> {
                propChangeSupport.firePropertyChange("btnAddItemClick", null, wishlistId);
            });

            JButton btnDelete = new JButton();
            btnDelete.setText("X");
            btnDelete.setBackground(Color.decode("#83AAD3"));
            btnDelete.setForeground(Color.white);
            btnDelete.setBorderPainted(false);
            btnDelete.setSize(50, 25);
            btnDelete.setLocation(leftPadding + 555, 165 + (i * 70));
            add(btnDelete);

            btnDelete.addActionListener((ActionEvent e) -> {
                wishlistController.delete(wishlistId);
                propChangeSupport.firePropertyChange("btnDeleteWishlistClick", false, true);
                removeAll();
                initComponents();
                displayWishlists();
            });
        }

        JButton btnAddCat = new JButton();
        btnAddCat.setText("Add category");
        btnAddCat.setBackground(Color.decode("#83AAD3"));
        btnAddCat.setForeground(Color.white);
        btnAddCat.setBorderPainted(false);
        btnAddCat.setSize(150, 25);
        btnAddCat.setLocation(leftPadding+125, 81);
        add(btnAddCat);

        btnAddCat.addActionListener((ActionEvent e) -> {
            propChangeSupport.firePropertyChange("btnAddCategory", false, true);
        });

        JButton btnAddWishlist = new JButton();
        btnAddWishlist.setText("Create wishlist");
        btnAddWishlist.setBackground(Color.decode("#83AAD3"));
        btnAddWishlist.setForeground(Color.white);
        btnAddWishlist.setBorderPainted(false);
        btnAddWishlist.setSize(180, 25);
        btnAddWishlist.setLocation(leftPadding + 325, 81);
        add(btnAddWishlist);

        btnAddWishlist.addActionListener((ActionEvent e) -> {
            propChangeSupport.firePropertyChange("btnAddWishlist", false, true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
