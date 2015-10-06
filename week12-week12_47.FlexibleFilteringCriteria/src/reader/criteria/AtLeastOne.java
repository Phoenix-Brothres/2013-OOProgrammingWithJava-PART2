/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mika
 */
public class AtLeastOne implements Criterion {
    
    private List<Criterion> criteria;

    public AtLeastOne(Criterion... criterion) {
        criteria = new ArrayList<Criterion>();
        for (int i = 0; i < criterion.length ; i++) {
            criteria.add(criterion[i]);
        }
    }
    
    @Override
    public boolean complies(String line) {
        for (Criterion c : criteria) {
            if (c.complies(line)) {
                return true;
            }
        }
        return false;
    }
    
}
