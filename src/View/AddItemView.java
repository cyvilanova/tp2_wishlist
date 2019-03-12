/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ItemCategoryController;
import Controller.CurrencyController;
import Controller.ItemController;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.border.LineBorder;

/**
 *
 * @author Thia
 */
public class AddItemView extends javax.swing.JPanel {

    CurrencyController currencyController;
    ItemController itemController;
    ItemCategoryController itemCategoryController;
    Integer wishlistId;
    private final PropertyChangeSupport propChangeSupport = new PropertyChangeSupport(this);

    /**
     * Creates new form AddItem
     */
    public AddItemView() {
        this.itemCategoryController = new ItemCategoryController();
        this.currencyController = new CurrencyController();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        item_description = new javax.swing.JTextArea();
        add_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        item_price = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        item_currency = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        item_link = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        item_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        item_category = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(71, 85, 94));
        setForeground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        item_description.setColumns(20);
        item_description.setRows(5);
        item_description.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        item_description.setFocusCycleRoot(true);
        item_description.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                item_descriptionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                item_descriptionFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(item_description);

        add_button.setBackground(new java.awt.Color(131, 170, 211));
        add_button.setForeground(new java.awt.Color(255, 255, 255));
        add_button.setText("Add");
        add_button.setBorderPainted(false);
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });

        cancel_button.setBackground(new java.awt.Color(131, 170, 211));
        cancel_button.setForeground(new java.awt.Color(255, 255, 255));
        cancel_button.setText("Cancel");
        cancel_button.setBorderPainted(false);
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });

        item_price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        item_price.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                item_priceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                item_priceFocusLost(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Currency");

        item_currency.setModel(new javax.swing.DefaultComboBoxModel<>(currencyController.getAll().toArray(new String[currencyController.getAll().size()])));
        item_currency.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Link");

        item_link.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        item_link.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                item_linkFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                item_linkFocusLost(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name *");

        item_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        item_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                item_nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                item_nameFocusLost(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Category");

        item_category.setModel(new javax.swing.DefaultComboBoxModel<>(itemCategoryController.getAll().toArray(new String[itemCategoryController.getAll().size()])));
        item_category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Price");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Description");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(item_name)
                            .addComponent(item_category, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(item_price, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(item_currency, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(item_link)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(cancel_button)
                        .addGap(46, 46, 46)
                        .addComponent(add_button)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(item_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(item_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_currency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(item_link, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_button)
                    .addComponent(cancel_button))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void item_descriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_item_descriptionFocusGained
        item_description.setBorder(new LineBorder(Color.decode("#83AAD3"), 1));
    }//GEN-LAST:event_item_descriptionFocusGained

    private void item_descriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_item_descriptionFocusLost
        item_description.setBorder(new LineBorder(Color.white, 1));
    }//GEN-LAST:event_item_descriptionFocusLost

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
        String name = item_name.getText().trim();
        String priceStr = item_price.getText().trim();
        Double price = 0.0;

        try {
            if (!priceStr.equals("")) {
                price = Double.parseDouble(priceStr);
            }
            if (!name.equals("")) {
                Integer id_currency = currencyController.getId((String) item_currency.getSelectedItem());
                Integer id_item_category = itemCategoryController.getId((String) item_category.getSelectedItem());
                itemController.insertItem(name, price, item_link.getText().trim(), item_description.getText().trim(), id_currency, id_item_category, getWishlistId());
                propChangeSupport.firePropertyChange("itemAdded", false, true);
            } else {
                item_name.setBorder(new LineBorder(Color.red, 1));
            }
        } catch (NumberFormatException e) {
            item_price.setBorder(new LineBorder(Color.red, 1));
        }
    }//GEN-LAST:event_add_buttonActionPerformed

    private void item_priceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_item_priceFocusGained
        item_price.setBorder(new LineBorder(Color.decode("#83AAD3"), 1));
    }//GEN-LAST:event_item_priceFocusGained

    private void item_priceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_item_priceFocusLost
        item_price.setBorder(new LineBorder(Color.white, 1));
    }//GEN-LAST:event_item_priceFocusLost

    private void item_linkFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_item_linkFocusGained
        item_link.setBorder(new LineBorder(Color.decode("#83AAD3"), 1));
    }//GEN-LAST:event_item_linkFocusGained

    private void item_linkFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_item_linkFocusLost
        item_link.setBorder(new LineBorder(Color.white, 1));
    }//GEN-LAST:event_item_linkFocusLost

    private void item_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_item_nameFocusGained
        item_name.setBorder(new LineBorder(Color.decode("#83AAD3"), 1));
    }//GEN-LAST:event_item_nameFocusGained

    private void item_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_item_nameFocusLost
        item_name.setBorder(new LineBorder(Color.white, 1));
    }//GEN-LAST:event_item_nameFocusLost

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        propChangeSupport.firePropertyChange("cancel", false, true);
    }//GEN-LAST:event_cancel_buttonActionPerformed

    /**
     *
     * @return
     */
    public Integer getWishlistId() {
        return wishlistId;
    }

    /**
     *
     * @param wishlistId
     */
    public void setWishlistId(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_button;
    private javax.swing.JButton cancel_button;
    private javax.swing.JComboBox<String> item_category;
    private javax.swing.JComboBox<String> item_currency;
    private javax.swing.JTextArea item_description;
    private javax.swing.JTextField item_link;
    private javax.swing.JTextField item_name;
    private javax.swing.JTextField item_price;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
