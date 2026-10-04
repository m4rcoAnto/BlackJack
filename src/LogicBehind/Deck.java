package LogicBehind;
import java.util.List;
import java.util.ArrayList;

public class Deck{
    List<Card> deck;
    private String[] cardValues;

    public Deck(){
        deck = new ArrayList<>();
        cardValues = new String[]{"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    }

    public void initializedeck(){
        for(Seeds e : Seeds.values()) {
            for (String s : cardValues) {
                deck.add(new Card(e, s));
            }
        }
    }

    // so my cards have values between 1 and 11 , with aces that alterns between the 1 and the 11.
    // How do I actually understand how to initialize my cards with the correct values???
    // every card has 4 copies with 4 different seeds. Would here the setters be useful to say : this is my new Crad object inside the list ?
    // Let's follow it step by step : My card has to be created before the insertion on the list. So i have to create 52 Cards.
    // Could I implement something that doesn't need to create 52 cards alone and just create it with a double for ?
    // The thing is that there is the possibiluty of the ace to be two different numbers, I have to be aware of that.


}
