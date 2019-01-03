import java.util.concurrent.CopyOnWriteArrayList; 
import java.util.*; 

public class Player {

    private CopyOnWriteArrayList<Hand> hands = new CopyOnWriteArrayList<Hand>();
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
        _chips -= hands.get(0).getBet();

        System.out.println("Your bet: " + hands.get(0).getBet());
        printChips();

    }

    public void play(Deck d){
        System.out.println("\nIt is your turn to play.\n");

        playHelper(d, hands.get(0));
        

        //POSSIBLE BUGS IN THE FUTURE HERE. What if we want to play multiple rounds?
    }


    private void betHelper(Deck d){
        boolean badBet = true;
        int amnt = 0;

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

    //Plays a single hand for a player, called by play() for each hand a player has.
    private void playHelper(Deck d, Hand h){     
        int choice = 0;

        System.out.println("Your current hand: ");
        h.printHand();

        if(h.getHandValue() <= 21){
            System.out.println("Your hand's sum is " + h.getHandValue());
        }

        //only stay(at or above 21)
        if(h.getHandValue() >= 21){
            choice = 1;
        }
        //stay, hit, DD and split
        else if(h.getBet() <= _chips && h.canSplit()){
            while(choice != 1 && choice != 2 && choice != 3 && choice != 4){
                System.out.printf("Would you like to: ");
                System.out.println("[1] Stay, or [2] Hit, [3] Double Down, or [4] Split?");

                String buffer = sc.nextLine();
                choice = Integer.parseInt(buffer);
            }
        }
        //stay, hit, and DD
        else if(h.getBet() <= _chips){
            while(choice != 1 && choice != 2 && choice != 3){
                System.out.printf("Would you like to: ");
                System.out.println("[1] Stay, [2] Hit, or [3] Double Down");

                String buffer = sc.nextLine();
                choice = Integer.parseInt(buffer);
            }
        }
        //only stay and hit 
        else{
            while(choice != 1 && choice != 2){
                System.out.printf("Would you like to: ");
                System.out.println("[1] Stay, or [2] Hit");

                String buffer = sc.nextLine();
                choice = Integer.parseInt(buffer);
            }
        }

        if(choice == 1){
            stay(h);
        }
        else if(choice == 2){
            hit(d, h);
        }
        else if(choice == 3){
            doubleDown(d, h);
        }
        else if(choice == 4){
            split(d, h);
        }
        else{
            System.out.println("\n\n\nERROR: Reached what should be impossible else statement in Player.java\n\n\n");
        }
    }

    private void stay(Hand h){
        if(h.getHandValue() > 21){
            System.out.println("You bust at " + h.getHandValue());
        } else {
            System.out.println("You stay at " + h.getHandValue());
        }
    }

    private void hit(Deck d, Hand h){
        h.addCard(d.drawCard());
        playHelper(d, h);
    }

    private void doubleDown(Deck d, Hand h){
        h.addCard(d.drawCard());
        _chips -= h.getBet();
        h.setBet(h.getBet() * 2);
        System.out.println("\nYour bet has been doubled to " + h.getBet() + " chips.");
        printChips();
        h.printHand();
        stay(h);
    }

    private void split(Deck d, Hand h){
        System.out.println("You split your hand!");
        _chips -= h.getBet();
        printChips();

        hands.remove(h);

        Hand a = new Hand(d, h.getCardAt(0), h.getBet());
        hands.add(a);

        Hand b = new Hand(d, h.getCardAt(1), h.getBet());
        hands.add(b);

        System.out.println("\nNew Hand 'A': ");
        a.printHand();

        System.out.println("\nNew Hand 'B': ");
        b.printHand();
        System.out.println("");

        playHelper(d, a);
        System.out.println("\nNumber of hands: " + hands.size());

        playHelper(d, b);
        System.out.println("\nNumber of hands: " + hands.size());

    }

    private void displayChips(){
        System.out.println("You have " + _chips + " chips");
    }

    private void printChips(){
        System.out.println("You have " + _chips + " left in your stack.");
    }

    public CopyOnWriteArrayList<Hand> getHands(){
        return hands;
    }

    public void awardWinnings(int w){
        _chips += w;
    }

    public int getChips(){
        return _chips;
    }

    public void clearHands(){
        hands.clear();
    }

    public void closeScanner(){
        sc.close();
    }

}