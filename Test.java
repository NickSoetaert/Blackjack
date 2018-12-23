public class Test{
    public static void main(String[] args){
        Deck d = new Deck();

        Player p = new Player(d);
        Player q = new Player(d);


        //p.getHand().forEach((n) -> n.getCardName());
        p.printHand();
        q.printHand();

        p.hit(d);
        q.hit(d);

        p.printHand();
        q.printHand();
    }

}