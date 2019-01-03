public class Dealer {
    
    private Hand _hand;

    public Dealer(){
        //No default values
    }

    public void initHand(Deck d){
        _hand = new Hand(d, 0);
    }

    public void playHand(Deck d){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("Dealer's Hand: \n");
        _hand.printHand();

        while(_hand.getHandValue() <= 16){
            Card c = d.drawCard();

            System.out.printf("\nThe dealer hits, and draws ");
            c.getCardNameWithPrefix();
            
            _hand.addCard(c);
        }
        System.out.println("\nDealer's final hand is worth " + _hand.getHandValue());
    }

    public void printHiddenHand(){
        Card c = _hand.getCardAt(0);
        System.out.printf("The dealer is showing " );
        c.getCardNameWithPrefix();
    }

}