package LogicBehind;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Deck{
    private final List<Card> deck;
    private final int numberOfDecks = 8;

    public Deck(){
        deck = new ArrayList<>();
    }


    private final String[] names = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    private final int[] values = {2,3,4,5,6,7,8,9,10,10,10,10,11};

    // so my cards have values between 1 and 11 , with aces that alterns between the 1 and the 11.
    // How do I actually understand how to initialize my cards with the correct values???
    // every card has 4 copies with 4 different seeds. Would here the setters be useful to say : this is my new Card object inside the list ?
    // Let's follow it step by step : My card has to be created before the insertion on the list. So i have to create 52 Cards.
    // Could I implement something that doesn't need to create 52 cards alone and just create it with a double for ?
    // The thing is that there is the possibility of the ace to be two different numbers, I have to be aware of that.


    Random random = new Random();

    public Card draw(){
        int i = random.nextInt(0, deck.size());
        Card object = deck.get(i);
        deck.remove(i);
        return object;
    }

    public List<Card> getDeck(){
        return deck;
    }
    // so there's a big problem now : Random is a class that only gives numbers ( or at least  indices of numbers )
    // The hashmap is a data structure without any indices , it's non sorted and not casual. So the only way that I can use the random class is to use a list

    public List<Card> initializeDeck(){
        for(int i = 0; i < numberOfDecks; i++){
            for(int j = 0; j < values.length;  j++){
                for(Seeds s : Seeds.values()){
                    deck.add(new Card(values[j], names[j], s));
                }
            }
        }
        return deck;
    }

    public boolean shuffle(){
        boolean bool = false;
        if(deck.size() <= 400){
            deck.clear();
            initializeDeck();
            bool = true;
        }
        return bool;
    }

}
