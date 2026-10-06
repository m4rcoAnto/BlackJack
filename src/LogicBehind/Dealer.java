package LogicBehind;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Dealer {
    private List<Card> dealerHand;
    private List<Card> myHand;
    Random random = new Random();

    public Dealer(){
        dealerHand = new ArrayList<>();
        myHand = new ArrayList<>();
    }

    public void assegnation(Deck deck){
        deck.getDeck();
        try {
            for(int i = 0; i <= 3; i++) {
                if (i % 2 == 0) {
                    myHand.add(deck.draw());
                } else {
                    dealerHand.add(deck.draw());
                }
            }
            System.out.println("Dealer's hand : " + dealerHand);
            pause();
            System.out.println(("My hand : " + myHand));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void pause(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void hit(){

    }
    // for the hit method I'm a little confused. Because only me should hit , so the dealer does it automatically if the total sum is less then 17.
    // So this one is dedicated to me. For the dealer I will try to automazite it.
}


    // so he was two cards in his hand , both are Card object of course.
    // Should I implement the possibility of the dealer to stay or hit ( forced from the system ) in this class or it must happen during the main?


// so now I have another doubt / problem -> should myhand be in the delaer class ?? Yes , it's true that the dealer should give the card to me
// But it's also true that now I don't have any control of my Hand , it is only found inside the Dealer Class. Then what should i do ?

// ok I might have found a solution : I could leave my hand as private so no one can catually touch it , but at the same time I can implement the method calculatePoints
// Where if my hand only contains two cards and the points are 21 , that means  that we have done blackjack -> thing is that it also depends on which card my dealer also has
// For example if the dealer has an ace in the open and the other card is ? then it is not said that i've won , it can also be a push.
// If he has a 10 , then it's the same because the other card could possibly be an ace.
// for every other card we win.

