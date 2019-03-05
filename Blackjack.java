public class Blackjack{
    public static void main(String[] args){

        Player p = new Player();
        Dealer dealer = new Dealer();

        while(p.getChips() > 0){
        
            Deck d = new Deck();
            p.bet(d);

            dealer.initHand(d);
            dealer.printHiddenHand();

            p.play(d);
            dealer.playHand(d);

            GameController g = new GameController();
            g.calcWinnings(p, dealer);
        }

        System.out.println("Thank you for playing. The house always wins.");
        p.closeScanner();

    }
}
