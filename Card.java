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

    public int getValue(){
        int v;
        if (value == Value.ACE) v = 1; //Hand will add 10 to Ace when applicable
        else if(value == Value.TWO) v = 2;
        else if (value == Value.THREE) v = 3;
        else if (value == Value.FOUR) v = 4;
        else if (value == Value.FIVE) v = 5;
        else if (value == Value.SIX) v = 6;
        else if (value == Value.SEVEN) v = 7;
        else if (value == Value.EIGHT) v = 8;
        else if (value == Value.NINE) v = 9;
        else v = 10;
        return v;
    }

    public Value getEnumValue(){
        return value;
    }
}