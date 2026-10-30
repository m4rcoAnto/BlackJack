package LogicBehind;

public class Card {
    private final int value;
    private final String name;
    private final Seeds seed;


    public Card(int value,String name, Seeds seed){
        this.value = value;
        this.name = name;
        this.seed = seed;
    }

    public Seeds getSeed(){
        return seed;
    }
    public String getName(){
        return name;
    }
    public int getValue(){
        return value;
    }


    @Override
    public String toString(){
        return getName() + " of " + getSeed();
    }
}

// so I face another problem which is the insert of the value of my card , I elided in my mind the idea that "Ace" ecc already had values in it.
