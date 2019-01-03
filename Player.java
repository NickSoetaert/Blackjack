import java.util.*;

public class Player{

//Also possible: Each hand has an associated bet


    protected ArrayList<Hand> hands = new ArrayList<Hand>();
    private int _chips;

    public Player(){
        this._chips = 1000;
    }

    public void playHand(Deck d){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        displayChips();
        bet(d);

        System.out.println("Your bet: " + hands.get(0).getBet());

        
    }

    private void displayChips(){
        System.out.println("You have " + _chips + " chips");
    }

    private void bet(Deck d){
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
                //Initialize player's initial hand of two cards
                this.hands.add(new Hand(d, amnt));
                badBet = false;
            }
        }

        sc.close();    
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