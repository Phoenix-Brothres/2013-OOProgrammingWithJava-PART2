
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WONSEOB
 */
public class ShoppingBasket {
    private Map<String, Purchase> purchases = new HashMap<String, Purchase>();
    
    public void add(String product, int price) {
        if (purchases.containsKey(product)) {
            purchases.get(product).increaseAmount();
        } else {
            purchases.put(product, new Purchase(product, 1, price));
        }
    }
    
    public int price() {
        int price = 0;
        for (Purchase p : purchases.values()) {
            price += p.price();
        }
        return price;
    }
    
    public void print() {
        for (String product : purchases.keySet()) {
            System.out.println(product+": "+purchases.get(product).amount());
        }
    }
}
