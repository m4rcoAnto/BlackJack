package LogicBehind;
import java.util.List;
import java.util.ArrayList;

public class Dealer {
    private List<Card> dealerHand;
    private List<Card> myHand;

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
            System.out.println("Dealer's hand : " + "[" +dealerHand.getFirst()+ ",    ?    ]");
            pause();
            System.out.println(("My hand : " + myHand + " -> " +calculateMyPoints()));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean Blackjack(List<Card> hand){
        boolean bool = false;
        if(hand.size() == 2 && calculatePoints(hand) == 21){
            bool = true;
        }
        return bool;
    }

    public static void pause(){
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

    public int calculatePoints(List<Card> hand) {
        int sum = 0;
        boolean hasAce = false;

        for (Card c : hand) {
            if (c.getName().equals("Ace")) {
                sum += 1;
                hasAce = true;
            } else {
                sum += c.getValue();
            }
        }

        if (hasAce && sum + 10 <= 21) {
            sum += 10;   // un asso vale 11
        }
        return sum;
    }

    public boolean isSoft(List<Card> hand){
        int sum = 0;
        boolean bool = false;
        for(Card c : hand){
            if(c.getName().equals("Ace")){
                sum += 1;
                bool = true;
            } else {
                sum += c.getValue();
            }
        }

        return bool && sum + 10 <= 21;
    }

    public int calculateMyPoints(){ return calculatePoints(myHand);}
    public int calculateHisPoints(){ return calculatePoints(dealerHand);}

    public List<Card> getDealerHand(){
        return dealerHand;
    }

    public List<Card> getMyHand(){
        return myHand;
    }

}
