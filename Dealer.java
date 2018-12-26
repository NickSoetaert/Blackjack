public class Dealer extends Player {

    public Dealer(Deck d){
        super(d);
        this.hand.add(d.drawCard());
        this.hand.add(d.drawCard());
    }

    public void hit(){
        
    }

}