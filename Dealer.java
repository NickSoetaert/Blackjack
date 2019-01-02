public class Dealer extends Player {
    Hand h;

    public Dealer(Deck d){
        super(d);
        h = new Hand(d);
    }

    public void hit(){
        
    }

}