public class Blackjack{
    public static void main(String[] args){

        //Todo: 
        //Insurance
        //try-catch blocks for bad input
        //ascii-art cards?

        //For debug/showing off split abilities. Make sure to uncomment special Deck constructor
        /*
        Card k = new Card(Suit.HEARTS, Value.TWO);
        Card q = new Card(Suit.CLUBS, Value.ACE);
        Deck d = new Deck(k, q);
        */

        Player p = new Player();
        Dealer dealer = new Dealer();

        while(p.getChips() > 0){
        
            Deck d = new Deck();

            p.bet(d);

            dealer.initHand(d);
            dealer.printHiddenHand();

            //if hiddenhand == ace
            //player.promptInsurance()

            p.play(d);
            dealer.playHand(d);

            GameController g = new GameController();
            g.calcWinnings(p, dealer);
        }

        System.out.println("Thank you for playing. The house always wins.");
        p.closeScanner();

    }
}