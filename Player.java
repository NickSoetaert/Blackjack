import java.util.*;

public class Player{

//Also possible: Each hand has an associated bet


    protected ArrayList<Hand> hands = new ArrayList<Hand>();
    private int _chips;

    public Player(Deck d){
        this._chips = 1000;
        this.hands.add(new Hand(d));
    }

    public void playHand(Deck d){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        displayChips();
        bet();



        
    }

    private void displayChips(){
        System.out.println("You have " + _chips + " chips");
    }

    private int bet(){
        boolean badBet = true;
        int amnt = 0;
        Scanner sc = new Scanner(System.in);

        while(badBet){
            System.out.println("How many chips would you like to bet?");

            amnt = sc.nextInt();

            if(amnt > _chips){
                System.out.println("You only have " + _chips + " chips");
            }
            else if(amnt < 1){
                System.out.println("Must bet at least 1 chip");
            }
            else{
                hands.set(0, setBet(amnt));
                badBet = false;
            }
        }

        sc.close();
        //return amnt;
    
    }

    private void hit(Deck d, Hand h){
        h.addCard(d.drawCard());
    }

    protected void stay(){

    }


    private void doubleDown(Deck d){

    }


    private void split(Deck d){

    }






}