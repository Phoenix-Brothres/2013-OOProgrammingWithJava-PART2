
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mika
 */
public class RingingCentre {

    private Map<Bird, List<String>> birds = new HashMap<Bird, List<String>>();

    public void observe(Bird bird, String place) {
        if (!birds.keySet().contains(bird)) {
            birds.put(bird, new ArrayList<String>());
        }
        birds.get(bird).add(place);
    }

    public void observations(Bird bird) {

        System.out.print(bird);
        System.out.print(" observations: ");
        if (birds.get(bird) == null) {
            System.out.println("0");
        } else {
            System.out.println(birds.get(bird).size());
            for (String s : birds.get(bird)) {
                System.out.println(s);
            }
        }
    }
}
