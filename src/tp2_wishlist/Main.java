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
import javax.swing.JScrollPane;

/**
 *
 * @author Thia
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
        
        LogInView logInPanel = new LogInView();
        AddItemView addItemPanel = new AddItemView();
        AddWishlistView addWishlistPanel = new AddWishlistView();
        AddCategoryView addCatWishlistPanel = new AddCategoryView();
        WishlistsView seeUserWishlists = new WishlistsView();
        WishlistView seeWishlist = new WishlistView();
        
        cards = new JPanel(new CardLayout());
        cards.add(logInPanel, "Login");
        cards.add(seeUserWishlists, "UsersWishlists");
        cards.add(addItemPanel, "AddItem");
        cards.add(addCatWishlistPanel, "AddCategory");
        cards.add(addWishlistPanel, "AddWishlist");
        cards.add(seeWishlist, "ViewWishlist");
        
        JFrame frame = new JFrame();
        frame.getContentPane().add(cards);
        frame.pack();
        frame.setVisible(true);
        
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        
        PropertyChangeListener loginChangeListener = (PropertyChangeEvent changeEvent) -> {
            if (changeEvent.getNewValue().toString() == "true") {
                cardLayout.show(cards, "UsersWishlists");
                seeUserWishlists.displayWishlists();
            }
        };
        
        PropertyChangeListener seeWishlistsListener = (PropertyChangeEvent changeEvent) -> {
            if (changeEvent.getPropertyName() == "btnAddItemClick") {
                cardLayout.show(cards, "AddItem");
                addItemPanel.setWishlistId((Integer) changeEvent.getNewValue());
            }
            else if(changeEvent.getPropertyName() == "btnView") {
                cardLayout.show(cards, "ViewWishlist");
                seeWishlist.setWishlistId((Integer) changeEvent.getNewValue());
                seeWishlist.displayItems();
            }
            else if(changeEvent.getPropertyName() == "btnAddCategory") {
                cardLayout.show(cards, "AddCategory");
            }
            else if(changeEvent.getPropertyName() == "btnAddWishlist") {
                addWishlistPanel.update();
                cardLayout.show(cards, "AddWishlist");
            }
            else if(changeEvent.getPropertyName() == "btnDeleteWishlistClick") {
                cardLayout.show(cards, "UsersWishlists");
            }
        };
        
        PropertyChangeListener addItemListener = (PropertyChangeEvent changeEvent) -> {
            cardLayout.show(cards, "UsersWishlists");
        };
        
        PropertyChangeListener addCategoryWishlistListener = (PropertyChangeEvent changeEvent) -> {
            cardLayout.show(cards, "UsersWishlists");
        };
        
        PropertyChangeListener addWishlistListener = (PropertyChangeEvent changeEvent) -> {
            cardLayout.show(cards, "UsersWishlists");
            seeUserWishlists.displayWishlists();
        };
        
        PropertyChangeListener wishlistViewListener = (PropertyChangeEvent changeEvent) -> {
            cardLayout.show(cards, "UsersWishlists");
        };
                
        logInPanel.addPropertyChangeListener(loginChangeListener);
        seeUserWishlists.addPropertyChangeListener(seeWishlistsListener);
        addItemPanel.addPropertyChangeListener(addItemListener);
        addCatWishlistPanel.addPropertyChangeListener(addCategoryWishlistListener);
        addWishlistPanel.addPropertyChangeListener(addWishlistListener);
        seeWishlist.addPropertyChangeListener(wishlistViewListener);
    }
}
