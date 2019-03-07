package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Calls the methods from the class Currency and the methods to access the
 * database.
 */
public class CurrencyController {

    public static ArrayList<String> getAll() {
        try {
            return Model.Currency.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(CurrencyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Integer getId(String currency) {
        
        try {
            return Model.Currency.getCurrencyId(currency);
        } catch (SQLException ex) {
            Logger.getLogger(CurrencyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
