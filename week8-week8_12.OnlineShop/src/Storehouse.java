
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WONSEOB
 */

public class Storehouse {
    private Map<String, Integer> stocks = new HashMap<String, Integer>();
    private Map<String, Integer> prices = new HashMap<String, Integer>();
    
    public void addProduct(String product, int price, int stock) {
        stocks.put(product, stock);
        prices.put(product, price);
    }
    
    public boolean take(String product) {
        if (stocks.get(product) == null) {
            return false;
        }
        if (stocks.get(product) > 0) {
            stocks.put(product, stocks.get(product) - 1);
            return true;
        }
        return false;
    }
    
    public int stock(String product) {
        if (stocks.get(product) == null) {
            return 0;
        }
        return stocks.get(product);
    }
    
    public int price(String product) {
        if (prices.get(product) == null)
            return -99;
        return prices.get(product);
    }
    
    public Set<String> products() {
        return stocks.keySet();
    }
}
