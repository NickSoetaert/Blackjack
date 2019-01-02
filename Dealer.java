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
        System.out.println("Dealer's hand is worth: " + h.getHandValue());
        while(h.getHandValue() <= 16){
            System.out.println(" ");
            System.out.println("Hitting");
            
            Card c = d.drawCard();
            System.out.printf("Deader drew a ");
            c.getCardName();
            
            h.addCard(c);
            System.out.println("Dealer's hand is now worth: " + h.getHandValue());
        }
    }
}