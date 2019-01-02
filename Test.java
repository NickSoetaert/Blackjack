public class Test{
    public static void main(String[] args){
        Deck d = new Deck();

        Player p = new Player(d);
        Player q = new Player(d);

        Hand h = new Hand(d);

        h.printHand();

        p.displayChips();

        Dealer dealer = new Dealer(d);
       // dealer.displayChips();


       System.out.println(h.getHandValue());
       
       }

}