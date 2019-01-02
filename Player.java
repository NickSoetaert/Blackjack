import java.util.*;

public class Player{

//To consider: Does each player actually have an array of hands and bets, because you can split hands infinite times?
//Also possible: Each hand has an associated bet


    protected ArrayList<Hand> hands = new ArrayList<Hand>();
    private int chips;

    public Player(Deck d){
        this.chips = 1000;
        //Hand h = new Hand(d);
        this.hands.add(new Hand(d));
    }



/*
    public void hit(Deck d){
        hand.add(d.drawCard());
    }
*/
    public void bet(){
        Scanner sc = new Scanner(System.in); 
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("How many chips would you like to bet?");
        int b = sc.nextInt();
    }

    public void displayChips(){
        System.out.println("You have " + chips + " chips");
    }




}