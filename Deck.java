import java.util.*;

public class Deck {
    private Stack<Card> deck = new Stack<Card>();

    private void shuffleDeck(){
        Collections.shuffle(deck);
    }

    //For debug only
    public Deck(Card a, Card b){
        deck.add(a);
        deck.add(b);
    }

    public Deck(){
        for(Value v : Value.values()) {
            for(Suit s : Suit.values()) {
                Card c = new Card(s, v);
                deck.add(c);
            }
        }
        this.shuffleDeck();
    }

    public void printDeck(){
        for(Card c : deck){
            c.getCardName();
        }
    }

    public Card drawCard(){
        return deck.pop();
    }

}