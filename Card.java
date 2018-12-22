public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit s, Value v){
        suit = s;
        value = v;
    }

    public String getCardName(){
        return(value + " of " + suit);
    }
}