public class Dealer extends Player {
    
    Hand hand;

    public Dealer(){
        //No default values
    }

    public void initHand(Deck d){
        hand = new Hand(d, 0);
    }

    public void playHand(Deck d){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("Dealer's ");
        hand.printHand();

        while(hand.getHandValue() <= 16){
            Card c = d.drawCard();
            System.out.println(" ");

            System.out.printf("The dealer hits, and draws ");

            c.getCardNameWithPrefix();
            
            hand.addCard(c);
        }
        System.out.println("\nDealer's final hand is worth: " + hand.getHandValue());
    }

    public void printHiddenHand(){
        Card c = hand.getFirstCard();
        System.out.printf("The dealer is showing " );
        c.getCardNameWithPrefix();
    }

}