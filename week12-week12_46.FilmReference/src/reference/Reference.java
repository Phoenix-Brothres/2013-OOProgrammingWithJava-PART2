/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author Mika
 */
public class Reference {

    private RatingRegister ratings;

    public Reference(RatingRegister ratings) {
        this.ratings = ratings;
    }

    public Film recommendFilm(Person person) {
        if (ratings.getPersonalRatings(person).isEmpty()) {
            Map<Film, List<Rating>> filmRatings = ratings.filmRatings();
            List<Film> films = new ArrayList<Film>();
            for (Film f : filmRatings.keySet()) {
                films.add(f);
            }
            Collections.sort(films, new FilmComparator(filmRatings));
            return films.get(0);
        } else {
            Person mostSimilarPerson = findMostSimilarPerson(person);
            Film personalBestFilm = getUnwatchedPersonalBestFilm(mostSimilarPerson, person);
            if (ratings.getRating(mostSimilarPerson, personalBestFilm).getValue() > 1) {
                return personalBestFilm;
            } else {
                return null;
            }
        }
    }

    private Person findMostSimilarPerson(Person person) {
        List<Person> reviewers = ratings.reviewers();
        reviewers.remove(person);
        Person mostSimilarPerson = reviewers.get(0);
        for (Person p : reviewers) {
            if (getSimilarity(person, p) > getSimilarity(person, mostSimilarPerson)) {
                mostSimilarPerson = p;
            }
        }
        return mostSimilarPerson;
    }

    private int getSimilarity(Person p1, Person p2) {
        Map<Film, Rating> p1Review = ratings.getPersonalRatings(p1);
        Map<Film, Rating> p2Review = ratings.getPersonalRatings(p2);
        int totalSimilarity = 0;
        for (Film f : p1Review.keySet()) {
            if (p2Review.containsKey(f)) {
                totalSimilarity += p1Review.get(f).getValue() * p2Review.get(f).getValue();
            }
        }
        return totalSimilarity;
    }

    private Film getUnwatchedPersonalBestFilm(Person similarPerson, Person personToRecommend) {
        Map<Film, Rating> reviews = ratings.getPersonalRatings(similarPerson);
        List<Film> films = new ArrayList<Film>();
        for (Film f : reviews.keySet()) {
            films.add(f);
        }
        films = removeWatchedFilms(films, personToRecommend);
        if (!films.isEmpty()) {
            Film personalBestfilm = films.get(0);
            for (Film f : films) {
                if (reviews.get(f).getValue() > reviews.get(personalBestfilm).getValue()) {
                    personalBestfilm = f;
                }
            }
            return personalBestfilm;
        } else {
            return null;
        }
    }

    private List<Film> removeWatchedFilms(List<Film> films, Person person) {
        Map<Film, Rating> reviews = ratings.getPersonalRatings(person);
        Iterator<Film> iterator = films.iterator();

        while (iterator.hasNext()) {
            if (reviews.containsKey(iterator.next()) ) {
                // delete the object returned by the iterator with its previous method call
                iterator.remove();
            }
        }
        return films;
    }
}
