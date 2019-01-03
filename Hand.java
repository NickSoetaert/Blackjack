import java.util.*;

public class Hand{
    protected ArrayList<Card> cards = new ArrayList<Card>();
    private int _bet;

    public Hand(Deck d, int bet){
        //Make sure every hand has 2 cards
        while(cards.size() < 2){
            this.cards.add(d.drawCard());
        }
        _bet = bet;
    }

    //used when splitting a hand
    public Hand(Deck d, Card c, int bet){
        this.cards.add(c);
        this.cards.add(d.drawCard());
        _bet = bet;
    }

    public void addCard(Card c){
        cards.add(c);
    }

    public void setBet(int b){
        _bet = b;
    }

    public int getBet(){
        return _bet;
    }


    public void printHand(){
        System.out.println("Hand:");
        for(Card c : cards){
            c.getCardName();
        }
    }

    public Card getCardAt(int i){
        return cards.get(i);
    }

    public boolean canSplit(){
        boolean isSizeTwo = (cards.size() == 2);
        boolean sameCards = (cards.get(0).getEnumValue() == cards.get(1).getEnumValue());

        return (isSizeTwo && sameCards);
    }


    public int getHandValue(){
        //only one ace in a hand can count as 11

        int sum = 0;
        boolean hasAce = false;

        for(Card c : cards){
            sum += c.getValue();
            if(c.getValue() == 1){
                hasAce = true;
            }
        }

        if((sum <= 11) && hasAce){
            sum += 10;
        }

        return sum;
    }
}