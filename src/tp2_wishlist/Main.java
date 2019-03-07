package tp2_wishlist;

import View.AddItem;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: tp2_wishlist database.properties");
        } else {
            try {
                SimpleDataSource.init(args[0]);
                createWindow();
                
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    private static void createWindow() {
        JFrame window = new JFrame();
        
        JPanel fixedPanel = new JPanel(new GridBagLayout());
        fixedPanel.setPreferredSize(window.getSize());
        
        AddItem addItemPage = new AddItem();
        
        window.setBounds(0,0,1280,720);
        window.setTitle("Wishlist");
        fixedPanel.add(addItemPage);
        window.add(fixedPanel);
        window.setVisible(true); 
    }
    
    
    private static void logIn() {
        
    }
    
}
