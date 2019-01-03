import java.util.*;

public class Player{

//Also possible: Each hand has an associated bet


    private ArrayList<Hand> hands = new ArrayList<Hand>();
    private int _chips;

    public Player(){
        this._chips = 1000;
    }

    public void bet(Deck d){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        displayChips();
        betHelper(d);

        System.out.println("Your bet: " + hands.get(0).getBet());

    }

    //Calls playHelper on all hands
    public void play(Deck d){
        for(Hand h : hands){
            playHelper(d, h);
        }
    }


    private void betHelper(Deck d){
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

    //Plays for a single hand
    private void playHelper(Deck d, Hand h){
        Scanner sc = new Scanner(System.in);

        h.printHand();

        //only stay(at 21)
        if(h.getHandValue() >= 21){
            stay();
        }
        //stay, hit, DD and split
        else if((_chips >= h.getBet()) && h.canSplit()){
            System.out.printf("Would you like to: ");
            System.out.println("[1] Stay, or [2] Hit, [3] Double Down, or [4] Split?");
        }
        //stay, hit, and DD
        else if(_chips >= h.getBet()){
            System.out.printf("Would you like to: ");
            System.out.println("[1] Stay, [2] Hit, or [3] Double Down");
        }
        //only stay and hit 
        else{
            System.out.printf("Would you like to: ");
            System.out.println("[1] Stay, or [2] Hit");
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

    private void displayChips(){
        System.out.println("You have " + _chips + " chips");
    }




}