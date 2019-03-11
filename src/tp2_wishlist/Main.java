package tp2_wishlist;

import View.*;
import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
                openApp();
                
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }         
        }
    }
    
    private static void openApp() {
        JPanel cards;
        
        LogIn logInPanel = new LogIn();
        AddItem addItemPanel = new AddItem();
        AddWishlist addWishlistPanel = new AddWishlist();
        AddCategory addCatWishlistPanel = new AddCategory();
        SeeWishlists seeUserWishlist = new SeeWishlists();
        
        cards = new JPanel(new CardLayout());
        cards.add(logInPanel, "Login");
        cards.add(seeUserWishlist, "UsersWishlists");
        cards.add(addItemPanel, "AddItem");
        cards.add(addCatWishlistPanel, "AddCategory");
        cards.add(addWishlistPanel, "AddWishlist");
        
        JFrame frame = new JFrame();
        frame.getContentPane().add(cards);
        frame.pack();
        frame.setVisible(true);
        
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        
        PropertyChangeListener loginChangeListener = (PropertyChangeEvent changeEvent) -> {
            if (changeEvent.getNewValue().toString() == "true") {
                cardLayout.show(cards, "UsersWishlists");
                seeUserWishlist.displayWishlists();
            }
        };
        
        PropertyChangeListener seeWishlistListener = (PropertyChangeEvent changeEvent) -> {
            if (changeEvent.getPropertyName() == "btnAddItemClick") {
                cardLayout.show(cards, "AddItem");
                addItemPanel.setWishlistId((Integer) changeEvent.getNewValue());
            }
            else if(changeEvent.getPropertyName() == "btnAddCategory") {
                cardLayout.show(cards, "AddCategory");
            }
            else if(changeEvent.getPropertyName() == "btnAddWishlist") {
                cardLayout.show(cards, "AddWishlist");
            }
            else if(changeEvent.getPropertyName() == "btnDeleteWishlistClick") {
                cardLayout.show(cards, "UsersWishlists");
            }
        };
        
        PropertyChangeListener addItemListener = (PropertyChangeEvent changeEvent) -> {
            cardLayout.show(cards, "addCatWishlistPanel");
        };
        
        PropertyChangeListener addCategoryWishlistListener = (PropertyChangeEvent changeEvent) -> {
            cardLayout.show(cards, "UsersWishlists");
        };
        
        PropertyChangeListener addWishlistListener = (PropertyChangeEvent changeEvent) -> {
            cardLayout.show(cards, "UsersWishlists");
            seeUserWishlist.displayWishlists();
        };
                
        logInPanel.addPropertyChangeListener(loginChangeListener);
        seeUserWishlist.addPropertyChangeListener(seeWishlistListener);
        addItemPanel.addPropertyChangeListener(addItemListener);
        addCatWishlistPanel.addPropertyChangeListener(addCategoryWishlistListener);
        addWishlistPanel.addPropertyChangeListener(addWishlistListener);
    }
}
