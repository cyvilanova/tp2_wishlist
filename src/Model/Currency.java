package Model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp2_wishlist.SimpleDataSource;

/**
 *
 * @author Thia
 */
public class Currency {
    
    /**
     *
     */
    public Currency() {};

    /**
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<String> getAll() throws SQLException {
        ArrayList<String> currencies = new ArrayList<>();

        Connection conn = SimpleDataSource.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT symbol FROM currency");

            while (rs.next()) {
                currencies.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Currency.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }

        return currencies;
    }

    /**
     *
     * @param currency
     * @return
     * @throws SQLException
     */
    public Integer getCurrencyId(String currency) throws SQLException {
        Connection conn = SimpleDataSource.getConnection();
        try {
            String query = "SELECT id_currency FROM currency WHERE symbol = \"" + currency + "\";";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            int currencyId;
            if (rs.next()) {
                currencyId = rs.getInt(1);
                return currencyId;
            }

        } finally {
            conn.close();
        }
        return null;
    }
}
