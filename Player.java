import java.util.*;

public class Player{
    protected ArrayList<Card> hand = new ArrayList<Card>();
    private int chips;

    public Player(Deck d){
        this.chips = 1000;
        this.hand.add(d.drawCard());
        this.hand.add(d.drawCard());
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
        Scanner sc = new Scanner(System.in); 
        int name = sc.nextInt();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("How many chips would you like to bet?");
    }

    public void displayChips(){
        System.out.println("You have " + chips + " chips");
    }

    protected int getHandValue(){
        //only one ace in a hand can count as 11

        int sum = 0;
        boolean hasAce = false;

        for(Card c : hand){
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