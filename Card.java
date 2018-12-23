public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit s, Value v){
        suit = s;
        value = v;
    }

    public void getCardName(){
        System.out.println(value + " of " + suit);
    }
}