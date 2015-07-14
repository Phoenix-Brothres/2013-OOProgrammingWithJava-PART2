import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WONSEOB
 */
public class Hand implements Comparable<Hand> {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }
    
    public void add(Card card) {
        cards.add(card);
    }
    
    public void print() {
        for (Card c : this.cards) {
            System.out.println(c);
        }
    }

    public void sort() {
        Collections.sort(this.cards);
    }
    
    @Override
    public int compareTo(Hand h) {
        int thisHand=0, otherHand=0;
        for (Card c : this.cards) {
            thisHand += c.getValue();
        }
        for (Card c : h.cards) {
            otherHand += c.getValue();
        }
        return thisHand - otherHand;
    }
    
    public void sortAgainstSuit() {
        SortAgainstSuitAndValue cardsSorter = new SortAgainstSuitAndValue();
        Collections.sort(this.cards, cardsSorter);
    }
}
