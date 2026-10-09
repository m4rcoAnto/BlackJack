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
    } // This function only exixts here , since the dealer is the only one that "Creates" some pause while dealing the cards.

    public void myHit(Deck deck){
        deck.getDeck();
        myHand.add(deck.draw());
        System.out.println(myHand);
    }
    public void dealerHit(Deck deck){
        deck.getDeck();
        dealerHand.add(deck.draw());
        System.out.println(dealerHand);
    }

    public void removeHands(){
        myHand.clear();
        dealerHand.clear();
    } // clearly i remove either hands because if one of them loses , the hands have to be empty too. Further more i don't need to use a function to eliminate the cards that i'm not using beacuse deck.draw() already does that,


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

// SUummarising :
// An initial assigment method has been created -> I'll need it to check if the score is already 21 ( since it has only two cards it means that he has blackjack )
// a hit method has been used for both parties
// a remove method for noth parties has been implemented
// Now i have to create a check for the Ace -> is this a method or just a case ?
/* No , this is a method , i can recall the draw from the deck , when he draws me an Ace ( since it returns me the object then i can check if the score with the other card is already
10 , because if it is , then it means that it is blackjack , if it isn't then the Ace can act as a 1 or a 11 too. This pretty much depends also on the score
If the score is inferior to 10 , then the ace must be 11 if the player decides to stand , otherwise if he hits he's trating it as a 1 to not bust. The max number that he can get is a 10
if two aces are on the same hand oonly the first ( as a convention ) is considered as the double choice.
 */