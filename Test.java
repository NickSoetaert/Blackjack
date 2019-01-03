public class Test{
    public static void main(String[] args){
        Deck d = new Deck();

        Player p = new Player();
        Dealer dealer = new Dealer();

        p.bet(d);

        dealer.initHand(d);
        dealer.printHiddenHand();

        p.play(d);
        dealer.playHand(d);
       
       }

}