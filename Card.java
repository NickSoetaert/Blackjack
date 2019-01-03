public class Card {
    private Suit _suit;
    private Value _value;

    public Card(Suit s, Value v){
        _suit = s;
        _value = v;
    }

    public void getCardName(){
        System.out.println(_value + " of " + _suit);
    }

    public void getCardNameWithPrefix(){
        if((_value == Value.EIGHT) || (_value == Value.ACE)){
            System.out.println("an " + _value + " of " + _suit);
        } else {
            System.out.println("a " + _value + " of " + _suit);
        }
    }

    public int getValue(){
        int v;
        if (_value == Value.ACE) v = 1; //Hand will add 10 to Ace when applicable
        else if(_value == Value.TWO) v = 2;
        else if (_value == Value.THREE) v = 3;
        else if (_value == Value.FOUR) v = 4;
        else if (_value == Value.FIVE) v = 5;
        else if (_value == Value.SIX) v = 6;
        else if (_value == Value.SEVEN) v = 7;
        else if (_value == Value.EIGHT) v = 8;
        else if (_value == Value.NINE) v = 9;
        else v = 10;
        return v;
    }

    public Value getEnumValue(){
        return _value;
    }
}