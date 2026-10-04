package LogicBehind;

public class Card {
    private Seeds seed;
    private String value;

    public Card(Seeds seed, String value){
        this.value = value;
        this.seed = seed;

    }

    // The problem is that I actually need a way to understand what im gonna return to my console
    // Because my game actually needs to be played there
    // so do I actually need a getter for every instance ? or just a toString() that gets me both of the properties?

    // Let's just imagine the game right : I'm from the console looking at the cards , and then I see something like :
    // Dealer has : J of Diamonds , ?
    // You have : 10 of Hearts, 10 of Diamonds -> total score = 20.
    // What do you want to do? ( then I want to fisically write down hit or stay , or maybe I don't know if I can implement something with a button on the console )
    // then if I choose hit it's gonna become something like : [10 of Hearts, 10 of Diamonds, 4 of Clubs] -> total score = 24 , after few seconds , I think I can do a time function where I can put busted , hand lost
    // I will try to time the distribution of the cards.
    // so this actually solved another doubt : The dealer hands and mine is actually a list of object too.
    // since I've created an enum of seeds , I have to actually call it in my method

    public Seeds getSeed(){
        return seed;
    }
    public String getValue(){
        return value;
    }

    // Wouldn't this be redundant ?? My values are a number between 1 and 11 depending on the aces.
    // so maybe it would be more logical put a range of values as a property.

    // I don't that I need any setters , because the cards are just like that. I take it and see it , they don't overwrite each-others.
    @Override
    public String toString(){
        return getValue() + " of " + getSeed();
    }
}
