import java.util.*;

public class Deck {
    private Stack<Card> deck = new Stack<Card>();

    private void shuffleDeck(){
        Collections.shuffle(deck);
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
            System.out.println(c.getCardName());
        }
    }

    public Card drawCard(){
        return deck.pop();
    }

}