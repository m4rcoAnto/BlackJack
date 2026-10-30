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
        if(deck.size() <= 30){
            deck.clear();
            initializeDeck();
            bool = true;
        }
        return bool;
    }

}
