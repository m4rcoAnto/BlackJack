package LogicBehind;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class TestBlackJack {
    public static void main(String[] args){

        Deck deck1 = new Deck();
        deck1.initializeDeck();
        Dealer dealer = new Dealer();
        Scanner scanner = new Scanner(System.in);
        String word = "";
        int wins = 0;
        int losses = 0;

        do {
            System.out.println("Hi and welcome , care to play ? Y / N");
            word = scanner.next();
            while(word.equalsIgnoreCase("y")){
                System.out.println("Here are the cards that are being dealt : ");
                System.out.println("------------------------------------------------------");
                dealer.assegnation(deck1);
                int dealerScore = dealer.calculateHisPoints();
                int myScore = dealer.calculateMyPoints();

                if(myScore == 21 && dealerScore < 21){
                    System.out.println("You win! BlackJack!");
                } else {
                    do {
                        System.out.println("What's your choice now ? : ");
                        word = scanner.next();
                        switch (word) {
                            case "Hit" :
                                while(word.equals("Hit") && myScore < 21) {
                                    dealer.myHit(deck1);
                                    myScore = dealer.calculateMyPoints();
                                    if(myScore < 21){
                                        System.out.println("What's your decision ?");
                                        word = scanner.next();
                                    }
                                }
                                if (myScore > 21) {
                                    System.out.println("You busted , dealer wins");
                                    word = "Out";
                                    break;
                                } else if (myScore == 21) {
                                    break;
                                }
                            case "Stand" :
                                while (dealerScore < 17) {
                                    System.out.println();
                                    dealer.dealerHit(deck1);
                                    dealerScore = dealer.calculateHisPoints();
                                }
                                if (dealerScore > 21) {
                                    System.out.println("Dealer busted , all player that have not busted win");
                                    word = "Out";
                                    break;
                                }
                                System.out.println("Dealer has to stand with : " + dealerScore);
                                if(myScore > dealerScore){
                                    System.out.println("You win! You beat the delaer with : "+ myScore + ", against " + dealerScore + ".");
                                    break;
                                } else if(myScore == dealerScore){
                                    System.out.println("Your score is the same as the dealer , bets are pushed.");
                                    break;
                                } else {
                                    System.out.println("You lose! The dealer has higher points.");
                                    break;
                                }

                        }
                    } while (word.equalsIgnoreCase("Hit"));

                }

                System.out.println("Would like to play again?");
                word = scanner.next();
                dealer.removeHands();
            }
        } while(word.equalsIgnoreCase("y"));
    }
}

// so now I have to think a way of actually playing
// Either I decide to implement functions inside my main ( it should be my player , so me ) or another class
// to do that I wanted to create an introduction and then I have two options based on the cards on the table: hit or stand
//


// ok , so I actually can see the cards being dealt with a little latency so it does feel more
// Now I have to fix the dealing cards , because the hand only exists if I'm playing that hand
// Before doing that i have to create function -> Hit , beacause it is used both by me and the dealer.
// It is important because it is the only way to actually give a meaning to the game
// I'm also curious if I can add the card directly onto the line in the terminal that i want to put in

// if(!(dealer.myHand.contains(Card(11, "", )) && dealer.myHand.contains(Card(10, "", )))
// This type of check is actually very hard , and creates problems with contains because it uses equals , but it only confronts the indices of the Cards , not the argument
// And not only that but it would make my code a lot harder :
// The real question that I want to answer is : is my hand equal or inferior to 21 points ?

// So I inserted a lot of function which i will add in the Dealer menu. But the thing is that i have to consider first a check
// Whenever myhand is composed of an Ace and card that has 10 as a value, then it means that my Phase has to stop
/*
try { // I also have to consider the idea of the Ace and the other cards which values are 10
                    while(myScore < 21){ // Here's another problem : Checking which type of cards my hand actually contains.
                        System.out.println("What's your move? Hit or Stand");
                        if(scanner.next().equalsIgnoreCase("Hit")){
                            dealer.Hit();
                            myScore = dealer.calculatePoints();
                            if(myScore == 21){

                            }
                        } else {
                            break;
                        }
                    }
 */

// so this could be a potential loop for my hand , i have to consider the delaer hand now
// but before doing that i have to find a way to say that i've done blackjack and how to use the ace if it is not a blackjack.

// Let's analyze it.

// All right so i made it officially playable , the only thing that i gotta understand now is how to treat the ace
// I have to play to actually see if it works properly.

// Also i thought about it : in the casino it not a list od fecks , or separeted decks , but just a big container of cards where every card is random.
// so i could simply put in the constructor of deck the number of deck that i want to play with , in my case 8.
// Bu tthat does not work clearly because the constructor only tells me how much the number of decks are , it does not create 8 decks.