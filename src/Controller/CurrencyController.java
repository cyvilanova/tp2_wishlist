package Controller;

import Model.Currency;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Calls the methods from the class Currency and the methods to access the
 * database.
 */
public class CurrencyController {
    Currency currencyModel;
    
    /**
     *
     */
    public CurrencyController() {
        this.currencyModel = new Currency();
    }
    
    /**
     *
     * @return
     */
    public ArrayList<String> getAll() {
        try {
            return currencyModel.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(CurrencyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param currency
     * @return
     */
    public Integer getId(String currency) {
        
        try {
            return currencyModel.getCurrencyId(currency);
        } catch (SQLException ex) {
            Logger.getLogger(CurrencyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getSymbol(Integer currencyId) {
        try {
            return currencyModel.getSymbol(currencyId);
        } catch (SQLException ex) {
            Logger.getLogger(CurrencyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
