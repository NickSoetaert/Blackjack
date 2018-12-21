import java.util.*;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck(){
        for(Value v : Value.values()) {
            for(Suit s : Suit.values()) {
                Card c = new Card(s, v);
                deck.add(c);
            }
        }
    }

    public void printDeck(){
        for(Card c : deck){
            System.out.println(c.value + " of " + c.suit);
        }
    }

}