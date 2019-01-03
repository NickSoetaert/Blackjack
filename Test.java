public class Test{
    public static void main(String[] args){

        /*
        Current todo:
        * Implement GameController class

        */

        Card k = new Card(Suit.HEARTS, Value.TWO);
        Card q = new Card(Suit.CLUBS, Value.ACE);
        
        //Deck d = new Deck(k, q);

        Deck d = new Deck();

        Player p = new Player();
        Dealer dealer = new Dealer();

        p.bet(d);

        dealer.initHand(d);
        dealer.printHiddenHand();

        p.play(d);
        dealer.playHand(d);

        GameController g = new GameController();
        g.calcWinnings(p, dealer);


       }
}