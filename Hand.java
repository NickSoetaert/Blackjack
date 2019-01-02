import java.util.*;

public class Hand{
    protected ArrayList<Card> cards = new ArrayList<Card>();

    public Hand(Deck d){
        //Make sure every hand has 2 cards
        while(cards.size() < 2){
            this.cards.add(d.drawCard());
        }
    }

    //used when splitting a hand
    public Hand(Card c, Deck d){
        this.cards.add(c);
        this.cards.add(d.drawCard());
    }

    public void addCard(Card c){
        cards.add(c);
    }


    public void printHand(){
        System.out.println("Hand:");
        for(Card c : cards){
            c.getCardName();
        }
        System.out.println("");
    }


    protected int getHandValue(){
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