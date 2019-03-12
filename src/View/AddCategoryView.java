/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.WishlistCategoryController;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.border.LineBorder;

/**
 *
 * @author Thia
 */
public class AddCategoryView extends javax.swing.JPanel {
    WishlistCategoryController wishlistCategoryController;
    private final PropertyChangeSupport propChangeSupport = new PropertyChangeSupport(this);
    
    /**
     * Creates new form AddCategory
     */
    public AddCategoryView() {
        this.wishlistCategoryController = new WishlistCategoryController();
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

        new_category = new javax.swing.JTextField();
        button_add = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        button_cancel = new javax.swing.JButton();

        setBackground(new java.awt.Color(71, 85, 94));

        new_category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        new_category.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                new_categoryFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                new_categoryFocusLost(evt);
            }
        });

        button_add.setBackground(new java.awt.Color(131, 170, 211));
        button_add.setForeground(new java.awt.Color(255, 255, 255));
        button_add.setText("Add");
        button_add.setBorderPainted(false);
        button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Add category");

        button_cancel.setBackground(new java.awt.Color(131, 170, 211));
        button_cancel.setForeground(new java.awt.Color(255, 255, 255));
        button_cancel.setText("Cancel");
        button_cancel.setBorderPainted(false);
        button_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(new_category, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(button_cancel)
                        .addGap(18, 18, 18)
                        .addComponent(button_add)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(new_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_add)
                    .addComponent(button_cancel))
                .addGap(115, 115, 115))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addActionPerformed
        String name = new_category.getText().trim();

        if (!name.equals("")) {
            wishlistCategoryController.newCategory(name);
            propChangeSupport.firePropertyChange("btnCategoryAdded", false, true);
        }
        else
            new_category.setBorder(new LineBorder(Color.red, 1));
    }//GEN-LAST:event_button_addActionPerformed

    private void new_categoryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_new_categoryFocusGained
        new_category.setBorder(new LineBorder(Color.decode("#83AAD3"), 1));
    }//GEN-LAST:event_new_categoryFocusGained

    private void new_categoryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_new_categoryFocusLost
        new_category.setBorder(new LineBorder(Color.white, 1));
    }//GEN-LAST:event_new_categoryFocusLost

    private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed
        propChangeSupport.firePropertyChange("btnCategoryCancel", false, true);
    }//GEN-LAST:event_button_cancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_cancel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField new_category;
    // End of variables declaration//GEN-END:variables
}
