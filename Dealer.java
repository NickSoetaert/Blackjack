public class Dealer extends Player {
    Hand h;

    public Dealer(Deck d){
        super(d);
        h = new Hand(d);
    }

    public void playHand(Deck d){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("Dealer's ");
        h.printHand();

        while(h.getHandValue() <= 16){
            Card c = d.drawCard();
            System.out.println(" ");

            if((c.getEnumValue() == Value.EIGHT) || (c.getEnumValue() == Value.ACE)){
                System.out.printf("The dealer hits, and draws an ");
            } else {
                System.out.printf("The dealer hits, and draws a ");
            }
            
            c.getCardName();
            
            h.addCard(c);
        }
        System.out.println("\nDealer's final hand is worth: " + h.getHandValue());
    }
}