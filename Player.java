import java.util.*;

public class Player{
    private ArrayList<Card> hand = new ArrayList<Card>();
    private int chips;
    private String name;

    public Player(Deck d){
        chips = 1000;
        hand.add(d.drawCard());
        hand.add(d.drawCard());
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public void printHand(){
        System.out.println("Hand:");
        hand.forEach((n) -> n.getCardName());
        System.out.println("");
    }

    public void hit(Deck d){
        hand.add(d.drawCard());
    }



}