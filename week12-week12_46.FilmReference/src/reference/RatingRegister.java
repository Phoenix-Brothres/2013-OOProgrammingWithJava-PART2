/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author Mika
 */
public class RatingRegister {
    
    private Map<Film, List<Rating>> filmRatings;
    private Map<Person, HashMap<Film, Rating>> personalRatings;
    
    public RatingRegister() {
        filmRatings = new HashMap<Film, List<Rating>>();
        personalRatings = new HashMap<Person, HashMap<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating) {
        if (!filmRatings.containsKey(film)) {
            filmRatings.put(film, new ArrayList<Rating>());
        }
        
        filmRatings.get(film).add(rating);
    }
    
    public List<Rating> getRatings(Film film) {
        return filmRatings.get(film);
    }
    
    public Map<Film, List<Rating>> filmRatings() {
        return filmRatings;
    }
    
    public void addRating(Person person, Film film, Rating rating) {
        this.addRating(film, rating);
        if (!personalRatings.containsKey(person)) {
            personalRatings.put(person, new HashMap<Film, Rating>());
        }
        personalRatings.get(person).put(film, rating);
    }
    
    public Rating getRating(Person person, Film film) {
        if(!personalRatings.get(person).containsKey(film))
            return Rating.NOT_WATCHED;
        return personalRatings.get(person).get(film);
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (personalRatings.get(person) == null) {
            personalRatings.put(person, new HashMap<Film, Rating>());
        }
        return personalRatings.get(person);
    }
    
    public List<Person> reviewers(){
        List<Person> reviewers = new ArrayList<Person>();
        for (Person p : personalRatings.keySet()) {
            reviewers.add(p);
        }
        return reviewers;
    }
}
