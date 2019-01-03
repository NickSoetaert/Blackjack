public class Test{
    public static void main(String[] args){

        Card k = new Card(Suit.HEARTS, Value.KING);
        Card q = new Card(Suit.CLUBS, Value.QUEEN);
        
        Deck d = new Deck(k, q);

        Player p = new Player();
        //Dealer dealer = new Dealer();

        p.bet(d);

        //dealer.initHand(d);
        //dealer.printHiddenHand();

        p.play(d);
        //dealer.playHand(d);

        /*
        Card k = new Card(Suit.HEARTS, Value.JACK);
        Card q = new Card(Suit.CLUBS, Value.QUEEN);
        System.out.println(k.getEnumValue() == q.getEnumValue());
        */
       }
}