import java.util.*;
import java.io.Console;


public class Player{

    private ArrayList<Hand> hands = new ArrayList<Hand>();
    private int _chips;
    private Scanner sc;

    public Player(){
        sc = new Scanner(System.in);

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
            getPlayerMove(h);
        }

    }


    private void betHelper(Deck d){
        boolean badBet = true;
        int amnt = 0;

        amnt = 5;

        while(badBet){
            System.out.println("How many chips would you like to bet?");

            String buffer = sc.nextLine();
            amnt = Integer.parseInt(buffer); 

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
    }

    //Plays for a single hand
    private int getPlayerMove(Hand h){     

        int choice = 1;

        h.printHand();

        //only stay(at 21)
        if(h.getHandValue() >= 21){
            choice = 1;
        }
        //stay, hit, DD and split
        else if(h.getBet() <= _chips/2 && h.canSplit()){
            System.out.printf("Would you like to: ");
            System.out.println("[1] Stay, or [2] Hit, [3] Double Down, or [4] Split?");
            String nextIntString = sc.nextLine(); //get the number as a single line
            int nextInt = Integer.parseInt(nextIntString);
        }
        //stay, hit, and DD
        else if(h.getBet() <= _chips/2){
            System.out.printf("Would you like to: ");
            System.out.println("[1] Stay, [2] Hit, or [3] Double Down");
            String nextIntString = sc.nextLine(); //get the number as a single line
            int nextInt = Integer.parseInt(nextIntString);
        }
        //only stay and hit 
        else{
            System.out.printf("Would you like to: ");
            System.out.println("[1] Stay, or [2] Hit");
            choice = sc.nextInt();
        }



        sc.close();

        return choice;

    }

    private void executePlayerMove(int choice){

    }

    private void hit(Deck d, Hand h){
        h.addCard(d.drawCard());
    }

    protected void stay(Hand h){

    }


    private void doubleDown(Deck d, Hand h){

    }


    private void split(Deck d, Hand h){

    }

    private void displayChips(){
        System.out.println("You have " + _chips + " chips");
    }




}