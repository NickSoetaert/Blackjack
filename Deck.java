import java.util.*;

public class Deck {
    private Stack<Card> _deck = new Stack<Card>();

    public Deck(){
        for(Value v : Value.values()) {
            for(Suit s : Suit.values()) {
                Card c = new Card(s, v);
                _deck.add(c);
            }
        }
        this.shuffleDeck();
    }

    //For debug only
    /*
    public Deck(Card a, Card b){

        _deck.add(a);
        _deck.add(b);

        for(int i = 0; i < 3; i++) {
            for(Suit s : Suit.values()) {
                Card c = new Card(s, Value.KING);
                _deck.add(c);
            }
        }
    }
    */

    private void shuffleDeck(){
        Collections.shuffle(_deck);
    }

    public void printDeck(){
        for(Card c : _deck){
            c.getCardName();
        }
    }

    public Card drawCard(){
        return _deck.pop();
    }

}