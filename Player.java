import java.util.*;

public class Player{
    private ArrayList<Card> hand = new ArrayList<Card>();
    private int chips;

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

    public void bet(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("How many chips would you like to bet?");
    }

    public void displayChips(){
        System.out.println("You have " + chips + " chips");
    }


}