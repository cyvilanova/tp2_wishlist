/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UserController;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Thia
 */
public class LogInView extends JPanel {
    UserController userController;
    boolean hasUserLoggedIn = false;
    private final PropertyChangeSupport propChangeSupport = new PropertyChangeSupport(this);

    /**
     * Creates new form LogIn
     */
    public LogInView() {
        this.userController = new UserController();
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

        jLabel1 = new javax.swing.JLabel();
        user_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        user_password = new javax.swing.JTextField();
        btn_login = new javax.swing.JButton();
        btn_signin = new javax.swing.JButton();
        error_mess = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(71, 85, 94));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username");

        user_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        user_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                user_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                user_usernameFocusLost(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");

        user_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        user_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                user_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                user_passwordFocusLost(evt);
            }
        });

        btn_login.setBackground(new java.awt.Color(131, 171, 212));
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("Log In");
        btn_login.setBorderPainted(false);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        btn_signin.setBackground(new java.awt.Color(131, 171, 212));
        btn_signin.setForeground(new java.awt.Color(255, 255, 255));
        btn_signin.setText("Sign In");
        btn_signin.setBorderPainted(false);
        btn_signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signinActionPerformed(evt);
            }
        });

        error_mess.setBackground(new java.awt.Color(71, 85, 94));
        error_mess.setForeground(new java.awt.Color(255, 255, 255));
        error_mess.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        error_mess.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setBackground(new java.awt.Color(71, 85, 94));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logow.png"))); // NOI18N
        jLabel3.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(error_mess, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(user_username, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btn_signin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_login))
                        .addComponent(user_password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(error_mess, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(user_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(user_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_login)
                            .addComponent(btn_signin)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        String username = user_username.getText().trim();
        String password = user_password.getText().trim();
        
        if (!username.equals("") && !password.equals("")) {
            if(!userController.userExists(username, password)) {
                error_mess.setText("Wrong username or password, try again.");
            }
            else {
                error_mess.setText("");
                hasUserLoggedIn = true;
                propChangeSupport.firePropertyChange("hasUserLoggedIn", false, true);
            }
        } else if(username.equals("") && password.equals("")) {
            user_password.setBorder(new LineBorder(Color.red, 1));
            user_username.setBorder(new LineBorder(Color.red, 1));
        } else if(username.equals("")) {
            user_username.setBorder(new LineBorder(Color.red, 1));
        } else if(password.equals("")) {
            user_password.setBorder(new LineBorder(Color.red, 1));
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void user_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_usernameFocusGained
        user_username.setBorder(new LineBorder(Color.decode("#83AAD3"), 1));
    }//GEN-LAST:event_user_usernameFocusGained

    private void user_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_usernameFocusLost
        user_username.setBorder(new LineBorder(Color.white, 1));
    }//GEN-LAST:event_user_usernameFocusLost

    private void user_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_passwordFocusGained
        user_password.setBorder(new LineBorder(Color.decode("#83AAD3"), 1));
    }//GEN-LAST:event_user_passwordFocusGained

    private void user_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_user_passwordFocusLost
        user_password.setBorder(new LineBorder(Color.white, 1));
    }//GEN-LAST:event_user_passwordFocusLost

    private void btn_signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signinActionPerformed
        String username = user_username.getText().trim();
        String password = user_password.getText().trim();
        
        if (!username.equals("") && !password.equals("")) {
            if(userController.usernameIsTaken(username)) {
                error_mess.setText("User already exists.");
            }
            else {
                userController.register(username, password);
                error_mess.setText("The account " + username + " has been created.");
            }
        } else if(username.equals("") && password.equals("")) {
            user_password.setBorder(new LineBorder(Color.red, 1));
            user_username.setBorder(new LineBorder(Color.red, 1));
        } else if(username.equals("")) {
            user_username.setBorder(new LineBorder(Color.red, 1));
        } else if(password.equals("")) {
            user_password.setBorder(new LineBorder(Color.red, 1));
        }
    }//GEN-LAST:event_btn_signinActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_signin;
    private javax.swing.JLabel error_mess;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField user_password;
    private javax.swing.JTextField user_username;
    // End of variables declaration//GEN-END:variables
}
