public class Test{
    public static void main(String[] args){
        Deck d = new Deck();

        Player p = new Player();
        Dealer dealer = new Dealer();

        dealer.initHand(d);
        dealer.printHiddenHand();

        p.playHand(d);



        dealer.playHand(d);

       
       }

}