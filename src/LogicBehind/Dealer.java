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
            System.out.println("Dealer's hand : " + dealerHand + " -> " +calculateHisPoints());
            pause();
            System.out.println(("My hand : " + myHand + " -> " +calculateMyPoints()));
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
        pause();
        myHand.add(deck.draw());
        System.out.println(myHand + " -> " + calculateMyPoints());
    }
    public void dealerHit(Deck deck){
        deck.getDeck();
        pause();
        dealerHand.add(deck.draw());
        System.out.println(dealerHand + " -> " + calculateHisPoints());
    }

    public void removeHands(){
        myHand.clear();
        dealerHand.clear();
    } // clearly i remove either hands because if one of them loses , the hands have to be empty too. Further more i don't need to use a function to eliminate the cards that i'm not using beacuse deck.draw() already does that,

    public int calculateMyPoints(){
        int sum = 0;
        for(Card c : myHand){
            sum += c.getValue();
        }

        return sum;
    }

    public int calculateHisPoints(){
        int sum = 0;
        for(Card c : dealerHand){
            sum += c.getValue();
        }

        return sum;
    }

    public boolean caseAceMyHand() {
        boolean bool = false;
        for (Card c : myHand) {
            if (c.getName().equals("Ace")) {
                bool = true;
            }
        }

        return bool;
    }

    public boolean caseAceDealerHand() {
        boolean bool = false;
        for (Card c : dealerHand) {
            if (c.getName().equals("Ace")) {
                bool = true;
            }
        }

        return bool;
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


/*
public void setAceValue(){
        if(caseAce()){
            if(calculateMyPoints() < 21 && calculateMyPoints() > 10){
                for(Card c : myHand){
                    if(c.getName().equals("Ace")){
                        c.setValue(1);
                        break;
                    }
                }
            }
        }
    }
 */

// im thinking that this method right here is wrong
// Even tho the implementation is right , the problem is that it pretty much depens on whether the player chooses ti hor or stand
// And it depends by the points , so how do I experiment with it??
// I added the caseAce so if there is even a single ace then it must go into the multpli choice bewtween 1 and 11
// I already know that the ace has 11 has a value , but here we want it to 1 if the points are higher than 10
// if it were 10 then it would have mean that I had 21 as a total
/* But the thing is : 1. The ace MAYBE should be calculated after , because since it depends on the player,
if I had any number bewtween 2 and 9 and an Ace , It could mean 12 to 20 has total points
so then I decide to call , and when it draws -> if the card goes over the points of 21 then my ace has to become 1 to save the player+
Otherwise it just adds up
If I have a hand that does not contain an ace , then it means that if the points are higher than , 10
the ace must be valued has a 1.
so yeah , the best solution here is to actually assign the value to the ace as a last option, so that I can already set it up , instead of changing it while inside myHand
I pretty much have to recall the myHit and delaerHit methods, since I used draw for the deck has a normal assignment.

So do i really need caseAce as a method ?
well if myhand in the first 2 cards contains an Ace then yes, otherwise no
 */