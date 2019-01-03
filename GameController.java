
public class GameController {

    public GameController(){
        //No args
    }

    public void calcWinnings(Player p, Dealer d){
        int winnings = 0;
        for(Hand h : p.getHands()){
            winnings += decideWinner(h, d.getHand());
        }
        p.awardWinnings(winnings);
        System.out.println("You now have " + p.getChips() + " chips.");
    }

    //Decides winner for each individual hand. Returns an int representing player's winnings.

    private int decideWinner(Hand playerHand, Hand dealerHand){
        int winnings = 0;
        if(playerHand.getHandValue() > 21){
            winnings = 0;
            System.out.printf("You bust on this hand, so you lose the bet.");
            System.out.println(" (-" + playerHand.getBet() + " chips)");
        }
        else if(playerHand.getHandValue() == dealerHand.getHandValue()){
            winnings = playerHand.getBet();
            System.out.println("You tied on this hand, so your bet is refunded.");
        }
        else if(playerHand.isBlackjack() && !dealerHand.isBlackjack()){
            winnings += playerHand.getBet();
            winnings += winnings * 1.5;
            System.out.printf("Congratulations on your blackjack! You profit 1.5x your bet.");
            System.out.printf(" (+" + winnings + " chips)");
        }
        else if(playerHand.getHandValue() > dealerHand.getHandValue()){
            winnings = playerHand.getBet() * 2;
            System.out.println("Congratulations on your win! You profit 1x your bet.");
            System.out.printf(" (+" + winnings + " chips)");
        }
        else{ //playerHand.getHandValue() < dealerHand.getHandValue()
            winnings = 0;
            System.out.printf("Tough luck, the dealer's " + dealerHand.getHandValue() + " beat your " 
                                + playerHand.getHandValue());
            System.out.println(" (-" + playerHand.getBet() + " chips)");
        }

        return winnings;
    }

}